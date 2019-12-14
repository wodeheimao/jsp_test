package com.zelin.web.dao;

import com.zelin.web.pojo.Customers;

import java.sql.SQLException;
import java.util.List;

public interface Customerao {
    List<Customers> findAllTie() throws SQLException;

    int addOne(Customers customers);

    int deleteById(String cid);
}
