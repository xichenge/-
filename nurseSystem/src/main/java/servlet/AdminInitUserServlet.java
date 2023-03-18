package servlet;

import Dao.UserDao;
import Impl.UserImpl;
import com.alibaba.fastjson.JSON;
import utils.PageBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admininituser")
public class AdminInitUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        UserDao userDao=new UserImpl();
        Integer allUserCount = userDao.getAllUserCount();
        PageBeanUtils pageUtils=new PageBeanUtils(1,15,allUserCount);
        String json= JSON.toJSONString(pageUtils);
        resp.getWriter().println(json);
    }
}
