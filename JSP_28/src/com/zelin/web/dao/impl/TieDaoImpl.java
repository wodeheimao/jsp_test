package com.zelin.web.dao.impl;

import com.zelin.web.dao.TieDao;
import com.zelin.web.pojo.Fatie;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TieDaoImpl implements TieDao {
    private QueryRunner qr;
    public TieDaoImpl(){
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }
    @Override
    public List<Fatie> findAllTie() {
        String sql = "SELECT f.*,p.`pname` FROM fatie f, bankuai p WHERE f.`pid` = p.`pid`  ORDER BY pubdate DESC";
        try {
            return qr.query(sql,new BeanListHandler<>(Fatie.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Fatie finOneByTid(String tid) {
        String sql = "SELECT f.*,p.`pname` FROM fatie f, bankuai p WHERE f.`pid` = p.`pid` AND f.`tid` = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Fatie.class),tid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Fatie fatie) {
        String sql = "UPDATE fatie f SET f.`title` = ?,  f.`msgcontent` =?, f.`pid` =? WHERE f.`tid`=? ";
        try {
            qr.update(sql,fatie.getTitle(),fatie.getMsgcontent(),fatie.getPid(),fatie.getTid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
