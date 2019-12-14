package com.hu.addrlist.dao.impl;

import com.hu.addrlist.dao.AddrbookDao;
import com.hu.addrlist.pojo.Addrbook;
import com.hu.addrlist.utils.JdbcUtils;
import com.hu.addrlist.utils.PageResult;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class AddrbookDaoImpl implements AddrbookDao {
    private QueryRunner qr;

    public AddrbookDaoImpl() {
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }

    //分页查询
    @Override
    public PageResult<Addrbook> findAllPage(int page, int pageSize) {

        //获取当前页面集合
        List<Addrbook> list = findPage(page, pageSize);
        //获取页面总数
        long totalCount = findCount();
        //获取页面总页数
        long totalPages = (long) Math.ceil(totalCount / (double) pageSize);
        return new PageResult<Addrbook>(list, page, totalPages, totalCount);
    }

    //获取总数
    private long findCount() {
        String sql = "select count(*) from addrbook ";
        try {
            return (long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //获取页面总数
    private List<Addrbook> findPage(int page, int pageSize) {
        String sql  = "select * from addrbook limit ?,?";
        try {
            return qr.query(sql,new BeanListHandler<>(Addrbook.class),(page-1)*pageSize,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
