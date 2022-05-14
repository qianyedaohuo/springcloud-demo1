package com.swpu.customerprovider.dao;

import com.swpu.goodscommons.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CustomerDao {

    List<Customer> getCustomerList();

    void addCustomer(Customer customer);

    void delCustomer(Integer[] ids);

    Customer getCustomerById(Integer id);

    void delCustomerById(Integer id);

    void updateCustomer(Customer customer);
}
