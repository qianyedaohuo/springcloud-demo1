package com.swpu.goodsprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.swpu.goodscommons.pojo.Book;
import com.swpu.goodsprovider.service.impl.GoodsProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("provider")
public class GoodsProviderController {

    @Autowired
    private GoodsProviderServiceImpl goodsProviderService;

    /**
     * 测试goods-ui调用是否成功
     */
    @RequestMapping("test")
    public String test() {
        System.out.println("进入了goods-provider");
        return "调用成功";
    }

    /**
     * 返回所有图书
     */
    @GetMapping("list")
    @ResponseBody
    public List<Book> getBookList() {
        return goodsProviderService.getBookList();
    }

    /**
     * 根据id删除图书
     *
     * @param id
     * @return
     * @throws InterruptedException
     */
    @GetMapping("detail/{id}")
    @ResponseBody
    public Book getDetail(@PathVariable("id") Integer id) throws InterruptedException {
        Thread.sleep(3000);
        return goodsProviderService.getDetail(id);
    }

    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public String add(@RequestBody Book book) {
        goodsProviderService.add(book);
        return "success";
    }

    @RequestMapping("test_hystrix")
    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //开启熔断器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),  //时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50") //服务错误率
    })
    public String testHystrix(@RequestParam("num") Integer num) {
        int n = (int) Math.floor(Math.random() * 100);
        int result = n / num;
        return "服务正常返回结果：" + num;
    }

    public String fallBack(@RequestParam("num") Integer num) {
        return "服务降级响应：num =" + num;
    }
}
