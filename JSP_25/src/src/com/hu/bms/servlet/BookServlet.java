package src.com.hu.bms.servlet;

import src.com.hu.bms.dao.BookDao;
import src.com.hu.bms.dao.impl.BookDaoImpl;
import src.com.hu.bms.pojo.Book;
import src.com.hu.bms.utils.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //使用dao层
        BookDao BookDao = new BookDaoImpl();

        String bname = req.getParameter("bname");
        String publisher = req.getParameter("publisher");

        String pageStr = req.getParameter("page");
        //当前页面赋值
        int page = new Integer((null == pageStr || "".equals(pageStr)) ? "1" : pageStr);
        int pageSize = 5;
        PageResult<Book> pageResult = BookDao.findAllPage(page, pageSize,bname,publisher);
        System.out.println("pageResult = " + pageResult);
        req.setAttribute("pageResult", pageResult);
        req.getRequestDispatcher("WEB-INF/book/booklist.jsp").forward(req, resp);

    }
}
