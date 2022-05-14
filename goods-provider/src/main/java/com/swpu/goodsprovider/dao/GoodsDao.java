package com.swpu.goodsprovider.dao;

import com.swpu.goodscommons.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {
    List<Book> getBookList();

    Book getDetail(Integer id);

    void add(Book book);
}
