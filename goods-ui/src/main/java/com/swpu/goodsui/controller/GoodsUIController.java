package com.swpu.goodsui.controller;

import com.swpu.goodscommons.pojo.Book;
import com.swpu.goodsui.service.impl.GoodsUIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("ui")
public class GoodsUIController {

    @Autowired
    private GoodsUIServiceImpl goodsUIService;

    /**
     * 测试goods-ui是否能够调用
     */
    @GetMapping("test")
    @ResponseBody
    public String test() {
        goodsUIService.testGoodsProvider();
        return "success";
    }

    /**
     * 查询所有图书
     */
    @GetMapping("list")
    @ResponseBody
    public List<Book> getBookList() {
        return goodsUIService.getBookList();
    }

    /**
     * 根据id查询图书
     *
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    @ResponseBody
    public Book detail(@PathVariable("id") Integer id) {
        return goodsUIService.getBookDetail(id);
    }

    /**
     * 添加图书
     */
    @PostMapping("add")
    @ResponseBody
    public String add(@RequestBody Book book) {
        return goodsUIService.add(book);
    }

}
