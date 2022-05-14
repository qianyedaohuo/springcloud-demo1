package com.swpu.goodsui.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.swpu.goodscommons.pojo.Book;
import com.swpu.goodsui.service.GoodsUIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsUIServiceImpl implements GoodsUIService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void testGoodsProvider() {
        //1.调用服务的地址，应用名和对应的映射Url
        String forObject = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println("goodsProvider返回的结果-->" + forObject);
    }

    @Override
    public List<Book> getBookList() {
        Book[] bookList = restTemplate.getForObject("http://goods-provider/provider/list", Book[].class);
        return Arrays.asList(bookList);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackBookDetail",
            commandProperties = {
                    //降级相应设置的时间
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
            }
    )
    public Book getBookDetail(Integer id) {
        Book book = restTemplate.getForObject("http://goods-provider/provider/detail/" + id, Book.class);
        return book;
    }


    public Book fallBackBookDetail(Integer id){
        return new Book();
    }

    @Override
    public String add(Book book) {
        String msg = restTemplate.postForObject("http://goods-provider/provider/add", book, String.class);
        return msg;
    }
}
