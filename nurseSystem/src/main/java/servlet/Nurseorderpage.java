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

@WebServlet("/nurseorderpage")
public class Nurseorderpage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        Integer currentpage = Integer.valueOf(req.getParameter("currentpage"));
        String context=req.getParameter("context");
        OrderDao orderDao=new OrderImpl();
        HttpSession session=req.getSession();
        Nurse nurse= (Nurse) session.getAttribute("user");

        Integer totalpage=orderDao.findorder_Bynurseid(context,nurse.getId()).size();

        PageBeanUtils pageBeanUtils=new PageBeanUtils(currentpage,15,totalpage);

        List<Order>orders=orderDao.findorder_Bynurseid_page(context,nurse.getId(),currentpage,15);

        OrderPageUtil orderPageUtil=new OrderPageUtil(pageBeanUtils,orders);

        String json= JSON.toJSONString(orderPageUtil);
//        System.out.println(json);
        resp.getWriter().println(json);

    }
}
