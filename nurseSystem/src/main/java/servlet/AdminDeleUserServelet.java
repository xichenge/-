package servlet;

import Dao.UserDao;
import Impl.UserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//管理员删除用户
@WebServlet("/admindeleuserservelet")
public class AdminDeleUserServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        Integer id=Integer.valueOf(req.getParameter("id"));
//        System.out.println("id:"+id);
        UserDao userDao=new UserImpl();
        Integer integer = userDao.deleUser(id);
//        System.out.println(integer);

    }
}
