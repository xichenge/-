package servlet;

import Dao.UserDao;
import Impl.UserImpl;
import com.alibaba.fastjson.JSON;
import pojo.User;
import utils.OrderPageUtil;
import utils.PageBeanUtils;
import utils.UserPageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminuserpage")
public class AdminUserPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        Integer currentpage = Integer.valueOf(req.getParameter("currentpage"));
        UserDao userDao=new UserImpl();
        Integer totalpage = userDao.getAllUserCount();
        PageBeanUtils pageBeanUtils=new PageBeanUtils(currentpage,15,totalpage);
        List<User>users=userDao.pageuser(currentpage,15);
        UserPageUtil userPageUtil=new UserPageUtil(pageBeanUtils,users);
        String json= JSON.toJSONString(userPageUtil);
//        System.out.println(json);
        resp.getWriter().println(json);
    }
}
