package com.zelin.web.dao.impl;

import com.zelin.web.dao.EmpDao;
import com.zelin.web.pojo.Emp;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoIpm implements EmpDao {
    private QueryRunner qr;

    public EmpDaoIpm() {
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }

    //查询所有员工
    @Override
    public List<Emp> findAll() {
        try {
            return qr.query("select * from emp",new BeanListHandler<>(Emp.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Emp> findAllByDno(String did) {
        try {
            return qr.query("select * from emp where did = ?",new BeanListHandler<>(Emp.class),did);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addEmp(Emp emp) {
        try {
            qr.update("insert into emp (eid,ename,username,phone,eamil,status,did) values(?,?,?,?,?,?,?)",
                    emp.getEid(),emp.getEname(),emp.getUsername(),emp.getPhone(),emp.getEamil(),emp.getStatus(),emp.getDid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Emp> search(String ename, String dname, String sdate, String edate) {
        String sql  =  "SELECT e.* FROM emp e, dept d WHERE e.`did` = d.`did` ";
        if(ename!=null && !"".equals(ename)){
            sql+=" and e.ename like '%"+ename+"%'";
        }
        if(dname!=null && !"".equals(dname)){
            sql+=" and d.dname like '%"+dname+"%'";
        }
        if(sdate!=null && !"".equals(sdate)){
            sql+=" and e.bdate >= '"+sdate+"'";
        }
        if(edate!=null && !"".equals(edate)){
            sql+=" and e.bdate <= '"+edate+"'";
        }
        try {
            return qr.query(sql,new BeanListHandler<>(Emp.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
