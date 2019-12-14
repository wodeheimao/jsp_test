package com.zelin.web.dao;

import com.zelin.web.pojo.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> findAll();

    List<Emp> findAllByDno(String did);

    void addEmp(Emp emp);

    List<Emp> search(String ename, String dname, String sdate, String edate);
}
