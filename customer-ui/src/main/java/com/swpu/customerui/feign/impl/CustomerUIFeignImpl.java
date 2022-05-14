package com.swpu.customerui.feign.impl;

import com.swpu.customerui.feign.CustomerUIFeign;
import com.swpu.goodscommons.common.Result;
import com.swpu.goodscommons.pojo.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUIFeignImpl implements CustomerUIFeign {
    @Override
    public List<Customer> getCustomerList() {
        return null;
    }

    @Override
    public Result<?> getDetail(Integer id) {
        System.out.println("服务降级");
        return Result.error("500","服务降级");
    }
}
