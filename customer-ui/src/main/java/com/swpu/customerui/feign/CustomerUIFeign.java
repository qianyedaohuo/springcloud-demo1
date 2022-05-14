package com.swpu.customerui.feign;

import com.swpu.customerui.feign.impl.CustomerUIFeignImpl;
import com.swpu.goodscommons.common.Result;
import com.swpu.goodscommons.pojo.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "customer-provider",fallback = CustomerUIFeignImpl.class)
public interface CustomerUIFeign {

    @GetMapping("customer/list")
    List<Customer> getCustomerList();

    @GetMapping("customer/detail/{id}")
    Result<?> getDetail(@PathVariable("id") Integer id);
}
