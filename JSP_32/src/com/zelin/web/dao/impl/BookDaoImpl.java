package com.zelin.web.dao.impl;


import com.zelin.web.dao.BookDao;
import com.zelin.web.pojo.Book;
import com.zelin.web.utils.JdbcUtils;
import com.zelin.web.utils.PageResult;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private QueryRunner qr;

    public BookDaoImpl() {
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }


    @Override
    public List<Book> findAll() {
        try {
            return qr.query("select b.*,c.cname from book b, category c where b.cno = c.cno", new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteById(String bno) {
        try {
            return qr.update("delete from book where bno =?", bno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addOne(Book book) {
        String sql = "insert into book value (null,?,?,?,?,?,?,?)";
        int n = 0;
        try {
            n = qr.update(sql, book.getBname(), book.getAuthor(), book.getPublisher(), book.getYprice(),
                    book.getZprice(), book.getDiscount(), book.getCno());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Book> searchBooks(String bno, String bname, String cno) {
        String sql = "select b.*,c.cname from book b, category c where b.cno = c.cno ";
        if (null != bno && !"".equals(bno)) {
            sql += "and bno like '%" + bno + "%'";
        }
        if (null != bname && !"".equals(bname)) {
            sql += "and bname like '%" + bname + "%'";
        }
        if (null != cno && !"".equals(cno)) {
            sql += "and b.cno = " + cno + "";
        }
        try {
            return qr.query(sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void demo() {
        List<Book> all = findAll();
        System.out.println("all = " + all);
    }
}
