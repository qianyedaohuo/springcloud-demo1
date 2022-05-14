package com.swpu.goodsprovider.service;

import com.swpu.goodscommons.pojo.Book;

import java.util.List;

public interface GoodsProviderService {
    List<Book> getBookList();

    Book getDetail(Integer id);

    void add(Book book);
}
