package com.zelin.web.dao.impl;

import com.zelin.web.dao.CategoryDao;
import com.zelin.web.pojo.Category;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
   private  QueryRunner qr;

    public CategoryDaoImpl() {
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }

    @Override
    public List<Category> findAll(String bno) {
        String sql = "select * from category";
        try {
            return qr.query(sql,new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
