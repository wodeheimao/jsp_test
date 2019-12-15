package com.zelin.web.dao;

import com.zelin.web.pojo.Expense;
import com.zelin.web.pojo.Expensetype;

import java.util.List;

public interface ExpenseDao {
    List<Expense> findAll();

    List<Expensetype> findAllType();

    int addOne(Expense expense);
}
