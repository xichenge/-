package servlet;

import Dao.NurseDao;
import Dao.OrderDao;
import Impl.NurseImpl;
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

@WebServlet("/userfindorder")
public class UserFindorderServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        String context = req.getParameter("context");
        System.out.println("context:"+context);
        String positiontype=req.getParameter("positiontype");
        System.out.println("positiontype:"+positiontype);


        HttpSession session=req.getSession();
        User user = (User) session.getAttribute("user");

        OrderDao orderDao=new OrderImpl();
        List<Order> orderList = orderDao.findorder(context, positiontype,user.getId());
        String json= JSON.toJSONString(orderList);
        resp.getWriter().println(json);

    }
}
