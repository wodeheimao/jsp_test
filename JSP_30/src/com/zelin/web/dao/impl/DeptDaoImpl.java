package com.zelin.web.dao.impl;

import com.zelin.web.pojo.Dept;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DeptDaoImpl implements com.zelin.web.dao.DeptDao {
    private QueryRunner qr;

    public DeptDaoImpl() {
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }

    @Override
    public List<Dept> findAllDept() {
        try {
            return qr.query("select * from dept",new BeanListHandler<>(Dept.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
