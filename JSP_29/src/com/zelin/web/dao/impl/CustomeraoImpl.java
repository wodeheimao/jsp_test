package com.zelin.web.dao.impl;

import com.zelin.web.pojo.Customers;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CustomeraoImpl implements com.zelin.web.dao.Customerao {
    private QueryRunner qr;
    public CustomeraoImpl(){
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }
    @Override
    public List<Customers> findAllTie() throws SQLException {
        return qr.query("select * from customers",new BeanListHandler<>(Customers.class));
    }

    @Override
    public int addOne(Customers customers) {
        try {
            return qr.update("INSERT  INTO customers VALUES (NULL,?,?,?,?,?,?,?);",
                                    customers.getCname(),customers.getUsername(),customers.getAddr(),
                    customers.getPhone(),customers.getLevel(),customers.getIsEnabled(),customers.getScore());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(String cid) {
        try {
            return qr.update("delete from customers where cid = ?",cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
