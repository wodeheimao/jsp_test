package com.zelin.web.servlet;


import com.alibaba.fastjson.JSON;
import com.zelin.web.dao.BookDao;
import com.zelin.web.dao.CategoryDao;
import com.zelin.web.dao.impl.BookDaoImpl;
import com.zelin.web.dao.impl.CategoryDaoImpl;
import com.zelin.web.pojo.Book;
import com.zelin.web.pojo.Category;
import com.zelin.web.utils.ResultMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    CategoryDao categoryDao = null;

    @Override
    public void init() throws ServletException {
        categoryDao = new CategoryDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if (null != cmd && !"".equals(cmd)) {
            if ("list".equals(cmd)) {
                list(req, resp);
            }
        } else {
            list(req, resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cno = req.getParameter("cno");
        List<Category> Categorys = categoryDao.findAll(cno);

        String s = JSON.toJSONString(Categorys);
        System.out.println("s = " + s);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }

}
