package com.zelin.web.dao.impl;

import com.zelin.web.dao.BankuaiDao;
import com.zelin.web.pojo.Bankuai;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BankuaiDaoImpl implements BankuaiDao {
    private QueryRunner qr;
    public BankuaiDaoImpl(){
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }
    @Override
    public List<Bankuai> findAllBankuai() {
        String sql = "select * from bankuai";
        try {
            return qr.query(sql,new BeanListHandler<>(Bankuai.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
