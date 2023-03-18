package servlet;

import Dao.OrderDao;
import Impl.OrderImpl;
import com.alibaba.fastjson.JSON;
import pojo.Nurse;
import utils.PageBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/nurseinitorder")
public class NurseinitOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        OrderDao orderDao=new OrderImpl();
        HttpSession session=req.getSession();
        Nurse nurse= (Nurse) session.getAttribute("user");
        Integer totalpage=orderDao.getOrderby_Nurseid(nurse.getId()).size();
//        System.out.println(totalpage);
        PageBeanUtils pageBeanUtils=new PageBeanUtils(1,15,totalpage);
        String json= JSON.toJSONString(pageBeanUtils);
        resp.getWriter().println(json);

    }
}
