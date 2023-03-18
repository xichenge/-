package servlet;

import Dao.NurseDao;
import Impl.NurseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admincancel")
public class AdminCancelNurse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        Integer id = Integer.valueOf(req.getParameter("id"));
        NurseDao nurseDao=new NurseImpl();
       nurseDao.cancelNurse(id);//不同意
    }
}
