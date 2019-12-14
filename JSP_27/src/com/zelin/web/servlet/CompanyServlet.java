package com.zelin.web.servlet;

import com.zelin.web.dao.CompanyinfoDao;
import com.zelin.web.dao.TelvisitDao;
import com.zelin.web.dao.impl.CompanyinfoDaoImpl;
import com.zelin.web.dao.impl.TelvisitDaoImpl;
import com.zelin.web.pojo.Companyinfo;
import com.zelin.web.pojo.Telvisit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/company")
public class CompanyServlet extends HttpServlet {
    private CompanyinfoDao companyinfoDao ;
    private TelvisitDao telvisitDao ;

    @Override
    public void init() throws ServletException {
        companyinfoDao = new CompanyinfoDaoImpl();
        telvisitDao = new TelvisitDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if(null != cmd && !"".equals(cmd)){
            if("visitlist".equals(cmd)){
                visitlist(req,resp);
            }else if("add".equals(cmd)){
                add(req,resp);
            }else if("search".equals(cmd)){
                search(req,resp);
            }
        }else{
            List<Companyinfo> companyinfoList = companyinfoDao.findAll();
            req.setAttribute("companyinfoList",companyinfoList);
            req.getRequestDispatcher(req.getContextPath()+"/company_list.jsp").forward(req,resp);
        }
    }


    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tname = req.getParameter("tname");
        String ttime = req.getParameter("ttime");
        String tclass = req.getParameter("tclass");
        String tway = req.getParameter("tway");
        String tresult = req.getParameter("tresult");
        String tcno = req.getParameter("cno");
        Telvisit telvisit = new Telvisit(tname, ttime,tclass, tresult,tway, tcno);
        System.out.println("telvisit = " + telvisit);
        //添加回访记录
        telvisitDao.addTel(telvisit);
        resp.sendRedirect(req.getContextPath() + "/company");
    }

    //查询回访记录
    private void visitlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cno = req.getParameter("cno");
        List<Telvisit> telvisitList = telvisitDao.findByCno(cno);
        req.setAttribute("telvisitList",telvisitList);
        req.getRequestDispatcher(req.getContextPath()+"/telvisit_list.jsp").forward(req,resp);
    }
    //查询回访记录
    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        String fname = req.getParameter("fname");
        List<Companyinfo> companyinfoList = companyinfoDao.findByName(cname,fname);
        req.setAttribute("companyinfoList",companyinfoList);
        req.getRequestDispatcher(req.getContextPath()+"/company_list.jsp").forward(req,resp);
    }
}
