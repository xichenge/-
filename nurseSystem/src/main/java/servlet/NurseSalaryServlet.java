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
import java.util.HashMap;
import java.util.List;

@WebServlet("/nursesalary")
public class NurseSalaryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        HttpSession session=req.getSession();
        Nurse nurse= (Nurse) session.getAttribute("user");
        OrderDao orderDao=new OrderImpl();
        List<Order>nurseorder=orderDao.getOrderby_Nurseid(nurse.getId());
        System.out.println("size:"+nurseorder.size());
        int c=nurseorder.size()*20;
        HashMap<String,Integer>map=new HashMap<>();
        map.put("c",c);
        String s = JSON.toJSONString(map);
        System.out.println("json:"+s);
        resp.getWriter().println(s);

    }
}
