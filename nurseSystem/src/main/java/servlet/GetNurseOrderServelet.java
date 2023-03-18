package servlet;

import Dao.OrderDao;
import Impl.OrderImpl;
import com.alibaba.fastjson.JSON;
import pojo.Nurse;
import pojo.Order;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/getmnurseorder")
public class GetNurseOrderServelet extends HttpServlet{
    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/json;charset=utf-8");
            HttpSession session=req.getSession();
            Nurse nurse=(Nurse)session.getAttribute("user");
            OrderDao orderDao=new OrderImpl();
            List<Order> nurseorder =orderDao.pageordernurse(1,15,nurse.getId());
            String json=null;
            json= JSON.toJSONString(nurseorder);
        System.out.println(nurseorder);
            resp.getWriter().println(json);
        }
    }
