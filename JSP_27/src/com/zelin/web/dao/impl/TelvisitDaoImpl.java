package com.zelin.web.dao.impl;

import com.zelin.web.dao.TelvisitDao;
import com.zelin.web.pojo.Telvisit;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TelvisitDaoImpl implements TelvisitDao {
    private QueryRunner qr;
    public TelvisitDaoImpl(){
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }
    @Override
    public List<Telvisit> findByCno(String cno) {
        try {
            return qr.query("select * from telvisit where tcno = ? order by tno desc",new BeanListHandler<>(Telvisit.class),cno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addTel(Telvisit telvisit) {
        try {
            qr.update("insert into telvisit values(null,?,?,?,?,?,?)",telvisit.getTname(),telvisit.getTtime(),
                    telvisit.getTclass(), telvisit.getTresult(),telvisit.getTway(),telvisit.getTcno());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
