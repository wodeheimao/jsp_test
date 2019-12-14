package src.com.hu.bms.servlet;

import src.com.hu.bms.dao.ShopcartDao;
import src.com.hu.bms.dao.impl.ShopcartDaoImpl;
import src.com.hu.bms.pojo.Book;
import src.com.hu.bms.pojo.Shopcart;
import src.com.hu.bms.utils.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/shopcart")
public class ShopcartServlet extends HttpServlet {
    ShopcartDao shopcartDao;
    @Override
    public void init() throws ServletException {
        shopcartDao = new ShopcartDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if(cmd!=null && !"".equals(cmd)){
            if("add".equals(cmd)){
                this.add(req,resp);
            }else if ("cartlist".equals(cmd)){
                this.cartlist(req,resp);
            }else if ("delete".equals(cmd)){
                this.delete(req,resp);
            }else if ("deleteone".equals(cmd)){
                this.deleteone(req,resp);
            }
        }
    }

    //加入购物车
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String bno = req.getParameter("bno");
        Shopcart shopcart = shopcartDao.findBYGoodsId(bno);
        if(shopcart!= null){
            shopcartDao.updateGoods(bno,1);
        }else{
            shopcartDao.addGoods(bno);
        }
        resp.sendRedirect(req.getContextPath() +"/book");
    }

    //购物车信息
    private void cartlist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String pageStr = req.getParameter("page");
        //当前页面赋值
        int page = new Integer((null == pageStr || "".equals(pageStr)) ? "1" : pageStr);
        int pageSize = 5;

        PageResult<Shopcart> pageResult = shopcartDao.findAllByPage(page, pageSize);
        req.setAttribute("pageResult", pageResult);
        Map<String,Object> maps = shopcartDao.finPriceAndNums();
        System.out.println("maps = " + maps);
        req.setAttribute("maps", maps);
        req.getRequestDispatcher("WEB-INF/shopcart/shopcart.jsp").forward(req, resp);
    }

    //清空购物车信息
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String sid = req.getParameter("sid");
        if(sid!=null && !"".equals(sid)){
            shopcartDao.deleteBySid(sid);
        }else{
            shopcartDao.deleteAll();
        }
        resp.sendRedirect(req.getContextPath()+"/shopcart?cmd=cartlist");
    }
    //移出一本
    private void deleteone(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String sid = req.getParameter("sid");
        String nums = req.getParameter("nums");
        if("1".equals(nums)){
            shopcartDao.deleteBySid(sid);
        }else{
            shopcartDao.deleteOne(sid);
        }
        resp.sendRedirect(req.getContextPath()+"/shopcart?cmd=cartlist");
    }
}
