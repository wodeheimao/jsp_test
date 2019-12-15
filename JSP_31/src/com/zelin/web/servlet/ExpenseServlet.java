package com.zelin.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zelin.web.dao.ExpenseDao;
import com.zelin.web.dao.impl.ExpenseDaoImpl;
import com.zelin.web.pojo.Expense;
import com.zelin.web.pojo.Expensetype;
import com.zelin.web.utils.ResultMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/expense")
public class ExpenseServlet extends HttpServlet {
    private ExpenseDao expenseDao;

    @Override
    public void init() throws ServletException {
        expenseDao = new ExpenseDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String cmd = req.getParameter("cmd");
        if (null != cmd && !"".equals(cmd)) {
            if ("list".equals(cmd)) {
                list(req, resp);
            } else if ("typeList".equals(cmd)) {
                typeList(req, resp);
            } else if ("add".equals(cmd)) {
                add(req, resp);
            }
        } else {
            list(req, resp);
        }
    }

    //添加一个报销单
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ename = req.getParameter("ename");
        String areasion = req.getParameter("areasion");
        String tname = req.getParameter("tname");
        String amoney = req.getParameter("amoney");
        String tid = req.getParameter("tid");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String adate = dateFormat.format(new Date());
        String astatus = "N";
        Expense expense = new Expense(ename,areasion,tname,amoney,adate,tid,astatus);
        int n = expenseDao.addOne(expense);
        ResultMsg rm = new ResultMsg();
        if (n <= 0) {
            rm.setSuccess(0);
            rm.setMessage("添加失败");
        }else{
            rm.setSuccess(1);
            rm.setMessage("添加成功");
        }
        String s = JSON.toJSONString(rm);
        System.out.println("s = " + s);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.flush();

    }

    //获取所有报销类型
    private void typeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Expensetype> typeList = expenseDao.findAllType();
        String s = JSON.toJSONString(typeList);
        System.out.println("s = " + s);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.flush();
    }

    //获取所有报销信息
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Expense> expenseList = expenseDao.findAll();
        String s = JSON.toJSONString(expenseList);
        System.out.println("s = " + s);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.flush();
    }
}
