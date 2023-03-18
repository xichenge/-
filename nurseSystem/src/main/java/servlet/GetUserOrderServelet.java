package servlet;

import Dao.OrderDao;
import Impl.OrderImpl;
import com.alibaba.fastjson.JSON;
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

@WebServlet("/getuserorder")
public class GetUserOrderServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        OrderDao orderDao=new OrderImpl();
        List<Order> userorder = orderDao.getOrderBy_Userid(user.getId());
        String json=null;
        json= JSON.toJSONString(userorder);
//        System.out.println(userorder);
        resp.getWriter().println(json);
    }
}
