package com.hu.bms.dao.impl;

import com.hu.bms.dao.CommentDao;
import com.hu.bms.pojo.Commentb;
import com.hu.bms.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
   private  QueryRunner qr;

    public CommentDaoImpl() {
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }

    @Override
    public List<Commentb> finAll(String bno) {
        String sql = "select * from commentb where bno = ?";
        try {
            return qr.query(sql,bno,new BeanListHandler<>(Commentb.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addComment(Commentb commentb) {
        String sql = "insert into commentb values(null,?,?,?,now(),?)";
        System.out.println("sql = " + sql);
        try {
            qr.update(sql,commentb.getCtitle(),commentb.getIsre(),commentb.getContent(),commentb.getBno());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
