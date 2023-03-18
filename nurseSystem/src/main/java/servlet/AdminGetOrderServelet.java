package servlet;

import Dao.OrderDao;
import Impl.OrderImpl;
import com.alibaba.fastjson.JSON;
import pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admingetorder")
public class AdminGetOrderServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        List<Order> orderList=new ArrayList<>();
        orderList=null;
        OrderDao orderDao=new OrderImpl();
        orderList=orderDao.pageorder(1,15);
        String json= JSON.toJSONString(orderList);
//        System.out.println(json);
        resp.getWriter().println(json);
    }
}
