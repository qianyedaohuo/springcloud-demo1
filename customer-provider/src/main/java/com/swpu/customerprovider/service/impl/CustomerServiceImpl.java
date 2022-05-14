package com.swpu.customerprovider.service.impl;


import com.swpu.customerprovider.dao.CustomerDao;
import com.swpu.customerprovider.service.CustomerService;
import com.swpu.goodscommons.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getList() {
        return customerDao.getCustomerList();
    }

    @Override
    public void add(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public void del(Integer[] ids) {
        customerDao.delCustomer(ids);
    }

    @Override
    public Customer getById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public void delById(Integer id) {
        customerDao.delCustomerById(id);
    }

    @Override
    public void update(Customer customer) {
        customerDao.updateCustomer(customer);
    }
}
