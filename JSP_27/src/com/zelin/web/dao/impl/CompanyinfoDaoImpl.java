package com.zelin.web.dao.impl;

import com.zelin.web.dao.CompanyinfoDao;
import com.zelin.web.pojo.Companyinfo;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CompanyinfoDaoImpl implements CompanyinfoDao {
    private QueryRunner qr;
    public CompanyinfoDaoImpl(){
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }
    @Override
    public List<Companyinfo> findAll() {
        try {
            return qr.query("select * from companyinfo", new BeanListHandler<>(Companyinfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Companyinfo> findByName(String cname, String fname) {
        StringBuilder sql = new StringBuilder("select * from companyinfo where 1=1 ");
        if(null != cname && !"".equals(cname)){
            sql.append(" and cname like '%"+cname+"%'");
        }
        if(null != fname && !"".equals(fname)){
            sql.append(" and fname like '%"+fname+"%'");
        }
        System.out.println("sql = " + sql);
        try {
            return qr.query(sql.toString(), new BeanListHandler<>(Companyinfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
