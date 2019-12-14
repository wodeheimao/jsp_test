package com.hu.bms.dao;
import com.hu.bms.pojo.Book;
import com.hu.bms.utils.PageResult;

public interface BookDao {
    PageResult<Book> findAllPage(int page, int pageSize,String bname,String publisher);
}
