import com.zelin.web.dao.DeptDao;
import com.zelin.web.dao.EmpDao;
import com.zelin.web.dao.impl.DeptDaoImpl;
import com.zelin.web.dao.impl.EmpDaoIpm;
import com.zelin.web.pojo.Dept;
import com.zelin.web.pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
    private EmpDao empDao;
    private DeptDao deptDao;

    @Override
    public void init() throws ServletException {
        empDao = new EmpDaoIpm();
        deptDao = new DeptDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if (cmd != null && !"".equals(cmd)) {
            if ("list".equals(cmd)) {
                list(req, resp);
            } else if ("toadd".equals(cmd)) {
                toadd(req, resp);
            } else if ("add".equals(cmd)) {
                add(req, resp);
            }else if ("search".equals(cmd)) {
                search(req, resp);
            }
        }

    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String did = req.getParameter("did");
        List<Emp> emps = null;
        if (did != null && !"".equals(did)) {
            emps = empDao.findAllByDno(did);
        } else {
            emps = empDao.findAll();
        }
        req.setAttribute("emps", emps);
        List<Dept> depts = deptDao.findAllDept();
        req.setAttribute("depts", depts);
        req.getRequestDispatcher(req.getContextPath() + "/emp_list.jsp").forward(req, resp);
    }

    private void toadd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> depts = deptDao.findAllDept();
        req.setAttribute("depts", depts);
        req.getRequestDispatcher(req.getContextPath() + "/emp_add.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eid = req.getParameter("eid");
        String ename = req.getParameter("ename");
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String eamil = req.getParameter("eamil");
        String status = req.getParameter("status");
        String did = req.getParameter("did");
        Emp emp = new Emp(eid, ename, username, phone, eamil,status, did);
        empDao.addEmp(emp);
        resp.sendRedirect(req.getContextPath() + "/emp?cmd=list");
    }

    //模糊查询分页查询
    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ename = req.getParameter("ename");
        String dname = req.getParameter("dname");
        String sdate = req.getParameter("sdate");
        String edate = req.getParameter("edate");

        List<Emp> emps = empDao.search(ename,dname,sdate,edate);
        req.setAttribute("emps", emps);
        List<Dept> depts = deptDao.findAllDept();
        req.setAttribute("depts", depts);
        req.getRequestDispatcher(req.getContextPath() + "/emp_list.jsp").forward(req, resp);
    }
}
