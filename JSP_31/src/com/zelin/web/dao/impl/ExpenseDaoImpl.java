package com.zelin.web.dao.impl;

import com.zelin.web.dao.ExpenseDao;
import com.zelin.web.pojo.Expense;
import com.zelin.web.pojo.Expensetype;
import com.zelin.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ExpenseDaoImpl implements ExpenseDao {
    private QueryRunner qr;
    public ExpenseDaoImpl(){
        qr = new QueryRunner(JdbcUtils.getDataSource());
    }
    @Override
    public List<Expense> findAll() {
        String sql = "select ex.*,et.tname from expense ex, expensetype et where ex.tid = et.tid ";
        try {
            return qr.query(sql,new BeanListHandler<>(Expense.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Expensetype> findAllType() {
        String sql = "select et.* from expensetype et ";
        try {
            return qr.query(sql,new BeanListHandler<>(Expensetype.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addOne(Expense expense) {
        String sql = "insert into expense values(null,?,?,?,?,0,?,?)";
        try {
            return qr.update(sql,expense.getEname(),expense.getAreasion(),
                    expense.getAdate(),expense.getAmoney(),expense.getAstatus(),expense.getTid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Test
    public void demo(){
        List<Expensetype> all = findAllType();
        System.out.println("all = " + all);
    }
}
