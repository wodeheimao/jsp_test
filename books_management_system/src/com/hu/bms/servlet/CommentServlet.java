package com.hu.bms.servlet;
import	java.util.Date;
import	java.sql.Timestamp;
import java.sql.Timestamp;
import	java.text.SimpleDateFormat;

import com.hu.bms.dao.CommentDao;
import com.hu.bms.dao.impl.CommentDaoImpl;
import com.hu.bms.pojo.Commentb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        CommentDao commentDao = new CommentDaoImpl();

        String cmd = req.getParameter("cmd");
        System.out.println("cmd = " + cmd);
        if(cmd!=null && !"".equals(cmd)){
            if("manage".equals(cmd)){
                String bno = req.getParameter("bno");
                List<Commentb> commentbs = commentDao.finAll(bno);
                req.setAttribute("commentbs",commentbs);
                System.out.println("commentbs = " + commentbs);
                req.getRequestDispatcher("/comment.jsp").forward(req,resp);
            }else if("add".equals(cmd)){
                String ctitle = req.getParameter("ctitle");
                String isre = req.getParameter("isre");
                String connent = req.getParameter("connent");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String date = format.format(new Date());
                String bno = req.getParameter("bno");
                Commentb commentb = new Commentb(ctitle,isre,connent,date,new Long(bno));
                System.out.println("commentb = " + commentb);
                commentDao.addComment(commentb);
                resp.sendRedirect(req.getContextPath() +"/comment?cmd=manage&bno="+bno);
            }
        }
    }
}
