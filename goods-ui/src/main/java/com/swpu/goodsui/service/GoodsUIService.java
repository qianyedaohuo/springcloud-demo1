package com.swpu.goodsui.service;

import com.swpu.goodscommons.pojo.Book;

import java.util.List;

public interface GoodsUIService {
    void testGoodsProvider();

    List<Book> getBookList();

    Book getBookDetail(Integer id);

    String add(Book book);
}
