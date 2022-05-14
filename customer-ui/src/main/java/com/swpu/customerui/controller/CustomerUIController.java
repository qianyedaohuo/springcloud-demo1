package com.swpu.customerui.controller;

import com.swpu.customerui.feign.CustomerUIFeign;
import com.swpu.goodscommons.common.Result;
import com.swpu.goodscommons.pojo.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerUIController {

    @Resource
    private CustomerUIFeign customerUIFeign;

    /**
     * 查询所有顾客
     */
    @GetMapping("list")
    public List<Customer> list(){
        return customerUIFeign.getCustomerList();
    }

    /**
     * 根据Id查询顾客
     */
    @GetMapping("detail/{id}")
    public Result<?> detail(@PathVariable Integer id){
        Result<?> detail = customerUIFeign.getDetail(id);
        return Result.success(detail);
    }
}
