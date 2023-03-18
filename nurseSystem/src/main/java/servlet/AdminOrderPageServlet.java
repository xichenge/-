package servlet;

import Dao.OrderDao;
import Impl.OrderImpl;
import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.fastjson.JSON;
import pojo.Order;
import utils.OrderPageUtil;
import utils.PageBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminorderpage")
public class AdminOrderPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        Integer currentpage = Integer.valueOf(req.getParameter("currentpage"));
//        System.out.println("currentPage:"+currentpage);
       OrderDao orderDao=new OrderImpl();
       Integer totalpage=orderDao.getAllOrderCount();
        PageBeanUtils pageBeanUtils=new PageBeanUtils(currentpage,15,totalpage);

        List<Order>orders=orderDao.pageorder(pageBeanUtils.getCurrentPage(),15);
        OrderPageUtil orderPageUtil=new OrderPageUtil(pageBeanUtils,orders);
        String json= JSON.toJSONString(orderPageUtil);
//        System.out.println(json);
        resp.getWriter().println(json);
    }
}
