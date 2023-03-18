package servlet;

import Dao.OrderDao;
import Impl.OrderImpl;
import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLPort;
import utils.PageBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/admininitorderpage")
public class AdminInitOrderPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        OrderDao orderDao=new OrderImpl();
        int allOrderCount = orderDao.getAllOrderCount();
//        System.out.println("allcount:"+allOrderCount);
        PageBeanUtils pageUtils=new PageBeanUtils(1,15,allOrderCount);

        String json= JSON.toJSONString(pageUtils);

        resp.getWriter().println(json);
    }
}
