package com.zelin.web.servlet;


import com.alibaba.fastjson.JSON;
import com.zelin.web.dao.BookDao;
import com.zelin.web.dao.impl.BookDaoImpl;
import com.zelin.web.pojo.Book;
import com.zelin.web.utils.ResultMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    BookDao bookDao;

    @Override
    public void init() throws ServletException {
        bookDao = new BookDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if (null != cmd && !"".equals(cmd)) {
            if ("list".equals(cmd)) {
                list(req, resp);
            } else if ("add".equals(cmd)) {
                add(req, resp);
            } else if ("delete".equals(cmd)) {
                delete(req, resp);
            }else if ("search".equals(cmd)) {
                search(req, resp);
            }
        } else {
            list(req, resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = null;
        books = bookDao.findAll();

        String s = JSON.toJSONString(books);
        System.out.println("s = " + s);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String bname = req.getParameter("bname");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String yprice = req.getParameter("yprice");
        String zprice = req.getParameter("zprice");
        String discount = req.getParameter("discount");
        String cno = req.getParameter("cno");
        Book book = new Book(null, bname, author, publisher,yprice,zprice,discount,cno);
        int n = bookDao.addOne(book);
        ResultMsg resultMsg = new ResultMsg();
        if (n != 0) {
            resultMsg.setSuccess(1);
            resultMsg.setMessage("成功 添加");
        } else {
            resultMsg.setSuccess(0);
            resultMsg.setMessage("添加 失败");
        }
        String s = JSON.toJSONString(resultMsg);
        System.out.println("s = " + s);
        resp.getWriter().println(s);
        resp.getWriter().flush();

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String bno = req.getParameter("bno");

        int n = bookDao.deleteById(bno);
        ResultMsg resultMsg = new ResultMsg();
        if (n != 0) {
            resultMsg.setSuccess(1);
            resultMsg.setMessage("成功 删除");
        } else {
            resultMsg.setSuccess(0);
            resultMsg.setMessage("删除 失败");
        }
        String s = JSON.toJSONString(resultMsg);
        System.out.println("s = " + s);
        resp.getWriter().println(s);
        resp.getWriter().flush();

    }
    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bno = req.getParameter("bno");
        String cno = req.getParameter("cno");
        String bname = req.getParameter("bname");
        List<Book> books = bookDao.searchBooks(bno,bname,cno);

        String s = JSON.toJSONString(books);
        System.out.println("s = " + s);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }
}
