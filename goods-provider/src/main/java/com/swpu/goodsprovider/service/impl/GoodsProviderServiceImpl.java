package com.swpu.goodsprovider.service.impl;

import com.swpu.goodscommons.pojo.Book;
import com.swpu.goodsprovider.dao.GoodsDao;
import com.swpu.goodsprovider.service.GoodsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsProviderServiceImpl implements GoodsProviderService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Book> getBookList() {
        return goodsDao.getBookList();
    }

    @Override
    public Book getDetail(Integer id) {
        return goodsDao.getDetail(id);
    }

    @Override
    public void add(Book book) {
        goodsDao.add(book);
    }
}
