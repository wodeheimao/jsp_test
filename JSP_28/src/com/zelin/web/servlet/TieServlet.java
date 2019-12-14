package com.zelin.web.servlet;

import com.zelin.web.dao.BankuaiDao;
import com.zelin.web.dao.TieDao;
import com.zelin.web.dao.impl.BankuaiDaoImpl;
import com.zelin.web.dao.impl.TieDaoImpl;
import com.zelin.web.pojo.Bankuai;
import com.zelin.web.pojo.Fatie;

import javax.rmi.CORBA.Tie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tie")
public class TieServlet extends HttpServlet {
    TieDao tieDao = null;
    BankuaiDao bankuaiDao = null;

    @Override
    public void init() throws ServletException {
        tieDao = new TieDaoImpl();
        bankuaiDao = new BankuaiDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if(null!=cmd && !"".equals(cmd)){
            if("list".equals(cmd)){
                list(req,resp);
            }else if("toupdate".equals(cmd)){
                toupdate(req,resp);
            }else if("update".equals(cmd)){
                update(req,resp);
            }
        }else{
            list(req,resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Fatie> tieList = tieDao.findAllTie();
        req.setAttribute("tieList",tieList);
        req.getRequestDispatcher(req.getContextPath()+"/tie_list.jsp").forward(req,resp);
    }

    //跳转到查询页面
    private void toupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要修改的tid
        String tid = req.getParameter("tid");
        //得到帖子的信息，并放到request中
        Fatie tie = tieDao.finOneByTid(tid);
        req.setAttribute("tie",tie);
        //查询所有的板块信息，并放到request中
        List<Bankuai> bankuaiList = bankuaiDao.findAllBankuai();
        req.setAttribute("bankuaiList",bankuaiList);
        req.getRequestDispatcher(req.getContextPath()+"/tie_update.jsp").forward(req,resp);
    }

    //点击查询
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String tid = req.getParameter("tid");
        String title = req.getParameter("title");
        String pid = req.getParameter("pid");
        String msgcontent = req.getParameter("msgcontent");
        Fatie fatie = new Fatie(new Integer(tid),title,msgcontent,new Integer(pid));
        //修改帖子
        tieDao.update(fatie);
        resp.sendRedirect(req.getContextPath()+"/tie?cmd=list");
    }
}
