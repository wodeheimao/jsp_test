package com.hu.bms.dao.impl;


import com.hu.bms.dao.BookDao;
import com.hu.bms.pojo.Book;
import com.hu.bms.utils.JdbcUtils;
import com.hu.bms.utils.PageResult;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private QueryRunner qr;

    public BookDaoImpl() {
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }

    //分页查询
    @Override
    public PageResult<Book> findAllPage(int page, int pageSize,String bname,String publisher) {

        //获取当前页面集合
        List<Book> list = findPage(page, pageSize,bname,publisher);
        //获取页面总数
        long totalCount = findCount(bname,publisher);
        //获取页面总页数
        long totalPages = (long) Math.ceil(totalCount / (double) pageSize);
        return new PageResult<Book>(list, page, totalPages, totalCount);
    }

    //获取总数
    private long findCount(String bname, String publisher) {
        String sql = "select count(*) from Book where 1=1  ";
        if(null != bname && !"".equals(bname)){
            sql += " and bname like '%"+bname+"%'";
        }
        if(null != publisher && !"".equals(publisher)){
            sql += " and publisher like '%"+publisher+"%'";
        }
        System.out.println("sql(总数) = " + sql);
        try {
            return (long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //获取页面总数
    private List<Book> findPage(int page, int pageSize, String bname, String publisher) {
        String sql  = "select * from Book where 1=1";
        if(null != bname && !"".equals(bname)){
            sql += " and bname like '%"+bname+"%'";
        }
        if(null != publisher && !"".equals(publisher)){
            sql += " and publisher like '%"+publisher+"%'";
        }
        System.out.println("sql = " + sql);
        sql += " limit ?,? ";
        try {
            return qr.query(sql,new BeanListHandler<>(Book.class),(page-1)*pageSize,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
