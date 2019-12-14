package com.zelin.web.dao;

import com.zelin.web.pojo.Companyinfo;

import java.util.List;

public interface CompanyinfoDao {
    List<Companyinfo> findAll();

    List<Companyinfo> findByName(String cname, String fname);
}
