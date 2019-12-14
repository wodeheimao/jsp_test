package com.hu.addrlist.servlet;

import com.hu.addrlist.dao.AddrbookDao;
import com.hu.addrlist.dao.impl.AddrbookDaoImpl;
import com.hu.addrlist.pojo.Addrbook;
import com.hu.addrlist.utils.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addrbook")
public class AddrbookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //使用dao层
        AddrbookDao addrbookDao = new AddrbookDaoImpl();
        String pageStr = req.getParameter("page");
        //当前页面赋值
        int page = new Integer( (null== pageStr || "".equals(pageStr)) ? "1" : pageStr);
        int pageSize = 3;
        PageResult<Addrbook> pageResult = addrbookDao.findAllPage(page, pageSize);
        System.out.println("pageResult = " + pageResult);
        req.setAttribute("pageResult", pageResult);
        req.getRequestDispatcher("/addrlist.jsp").forward(req, resp);

    }
}
