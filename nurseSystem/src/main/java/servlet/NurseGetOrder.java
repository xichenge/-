package servlet;

import Dao.OrderDao;
import Impl.OrderImpl;
import com.alibaba.fastjson.JSON;
import pojo.Nurse;
import pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/nursegetorder")
public class NurseGetOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        OrderDao orderDao=new OrderImpl();
        HttpSession session=req.getSession();
        Nurse nurse = (Nurse) session.getAttribute("user");

        List<Order> orders= orderDao.getOrderBy_Userid(nurse.getId());
        String json=null;
        json= JSON.toJSONString(orderDao);
//        System.out.println(json);
        resp.getWriter().println(json);
    }
}
