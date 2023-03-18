package servlet;

import Dao.CountDataDao;
import Dao.NurseDao;
import Dao.OrderDao;
import Impl.CountDataImpl;
import Impl.NurseImpl;
import Impl.OrderImpl;
import pojo.CountData;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/userorder")
public class UserOrderServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        Integer nurseid = Integer.valueOf(req.getParameter("id"));
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        Order order=new Order();
        order.setNurseid(nurseid);
        order.setUserid(user.getId());


        Date d = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        order.setOrdertime(String.valueOf(s1.format(d)));
        OrderDao orderDao=new OrderImpl();





        NurseDao nurseDao=new NurseImpl();
        Nurse nurse = nurseDao.getNurseById(nurseid);

        order.setPosition(nurse.getPosition());
        orderDao.addOrder(order);

        CountData countData=new CountData();
        CountDataDao countDataDao=new CountDataImpl();
        countData=countDataDao.getDateByTypeid(nurse.getPositiontype());
        countData.setNum(countData.getNum()+1);
//        System.out.println(countData.getNum());
        countDataDao.updateData(countData);
//        System.out.println(countData);



    }
}
