package com.swpu.customerprovider.controller;

import com.swpu.customerprovider.service.impl.CustomerServiceImpl;
import com.swpu.goodscommons.pojo.Customer;
import com.swpu.goodscommons.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    /**
     * 查询所有顾客
     */
    @GetMapping("list")
    @ResponseBody
    public List<Customer> get() {
        return customerService.getList();
    }

    @GetMapping("detail/{id}")
    @ResponseBody
    public Result<?> getDetail(@PathVariable("id") Integer id) throws InterruptedException {
        Thread.sleep(3000);
        Customer customer = customerService.getById(id);
        return Result.success(customer);
    }

    /**
     * 添加顾客
     */
    @PostMapping("add")
    @ResponseBody
    public Result<?> add(@RequestBody Customer customer) {
        customerService.add(customer);
        return Result.success(customer);
    }

    /**
     * 批量删除顾客
     */
    @DeleteMapping("del")
    @ResponseBody
    public Result<?> del(@RequestBody Integer[] ids) {
        customerService.del(ids);
        return Result.success();
    }
}
