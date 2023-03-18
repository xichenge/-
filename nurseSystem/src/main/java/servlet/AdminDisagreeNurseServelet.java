package servlet;

import Dao.NurseDao;
import Impl.NurseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admindisagress")
public class AdminDisagreeNurseServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        NurseDao nurseDao=new NurseImpl();
        Integer id = Integer.valueOf(req.getParameter("id"));
        nurseDao.deleNurse(id);
    }
}
