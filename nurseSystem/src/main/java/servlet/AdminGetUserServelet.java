package servlet;

import Dao.UserDao;
import Impl.UserImpl;
import com.alibaba.fastjson.JSON;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admingetuser")
public class AdminGetUserServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        List<User> userList=new ArrayList<>();
        UserDao userDao=new UserImpl();
        userList=userDao.pageuser(1,15);
        String all= JSON.toJSONString(userList);
        System.out.println(all);
        resp.getWriter().println(all);
    }
}
