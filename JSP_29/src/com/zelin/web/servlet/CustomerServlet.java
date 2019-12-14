package com.zelin.web.servlet;


import com.alibaba.fastjson.JSON;
import com.zelin.web.dao.Customerao;
import com.zelin.web.dao.impl.CustomeraoImpl;
import com.zelin.web.pojo.Customers;
import com.zelin.web.utils.ResultMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    Customerao customerao = null;

    @Override
    public void init() throws ServletException {
        customerao = new CustomeraoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if(null!=cmd && !"".equals(cmd)){
            if("list".equals(cmd)){
                list(req,resp);
            }if("add".equals(cmd)){
                add(req,resp);
            }if("delete".equals(cmd)){
                delete(req,resp);
            }
        }else{
            list(req,resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customers> customers = null;
        try {
            customers = customerao.findAllTie();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String s = JSON.toJSONString(customers);
        System.out.println("s = " + s);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String cname = req.getParameter("cname");
        String username = req.getParameter("username");
        String addr = req.getParameter("addr");
        String phone = req.getParameter("phone");
        String level = req.getParameter("level");
        String isEnabled = req.getParameter("isEnabled");
        String score = req.getParameter("score");
        Customers customers = new Customers(cname,username,addr,phone,level,isEnabled,score);
        System.out.println("customers = " + customers);
        int n = customerao.addOne(customers);
        ResultMsg resultMsg = new ResultMsg();
        if(n!=0){
            resultMsg.setSuccess(1);
            resultMsg.setMessage("成功添加");
        }else{
            resultMsg.setSuccess(0);
            resultMsg.setMessage("添加失败");
        }
        String s = JSON.toJSONString(resultMsg);
        System.out.println("s = " + s);
        resp.getWriter().println(s);
        resp.getWriter().flush();

    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String cid = req.getParameter("cid");

        int n = customerao.deleteById(cid);
        ResultMsg resultMsg = new ResultMsg();
        if(n!=0){
            resultMsg.setSuccess(1);
            resultMsg.setMessage("成功删除");
        }else{
            resultMsg.setSuccess(0);
            resultMsg.setMessage("删除失败");
        }
        String s = JSON.toJSONString(resultMsg);
        System.out.println("s = " + s);
        resp.getWriter().println(s);
        resp.getWriter().flush();

    }
}
