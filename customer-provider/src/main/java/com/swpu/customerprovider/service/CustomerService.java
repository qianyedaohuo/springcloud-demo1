package com.swpu.customerprovider.service;


import com.swpu.goodscommons.pojo.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getList();

    void add(Customer customer);

    void del(Integer[] ids);

    Customer getById(Integer id);

    void delById(Integer id);

    void update(Customer customer);
}
