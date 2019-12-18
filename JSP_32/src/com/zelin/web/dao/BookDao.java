package com.zelin.web.dao;


import com.zelin.web.pojo.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    int deleteById(String bno);

    int addOne(Book book);

    List<Book> searchBooks(String bno, String bname,String cno);
}
