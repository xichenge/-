package servlet;

import Dao.OrderDao;
import Impl.OrderImpl;
import com.alibaba.fastjson.JSON;
import pojo.Nurse;
import pojo.Order;
import utils.OrderPageUtil;
import utils.PageBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/nursefindorder")
public class NurseFindorderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        String context = req.getParameter("context");
        HttpSession session=req.getSession();
        Nurse nurse= (Nurse) session.getAttribute("user");
        OrderDao orderDao=new OrderImpl();
        List<Order> orders = orderDao.findorder_Bynurseid(context, nurse.getId());//查找所有符合条件的数据
        System.out.println("ordersize:"+orders.size());
        PageBeanUtils pageBeanUtils=new PageBeanUtils(1,15,orders.size());//算出有多少页
        List<Order> orderList = orderDao.findorder_Bynurseid_page(context, nurse.getId(), 1, 15);

        OrderPageUtil orderPageUtil=new OrderPageUtil(pageBeanUtils,orderList);

        String json= JSON.toJSONString(orderPageUtil);

        resp.getWriter().println(json);

    }
}
