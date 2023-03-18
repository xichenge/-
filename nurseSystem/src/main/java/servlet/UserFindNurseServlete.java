package servlet;

import Dao.NurseDao;
import Impl.NurseImpl;
import com.alibaba.fastjson.JSON;
import pojo.Nurse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@WebServlet("/userfindnurse")
public class UserFindNurseServlete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        String context = req.getParameter("context");
//        System.out.println("context:"+context);
        String positiontype=req.getParameter("positiontype");
//        System.out.println("positiontype:"+positiontype);
        NurseDao nurseDao=new NurseImpl();
        List<Nurse> nurseList = nurseDao.findnurse(context, positiontype);
        String json= JSON.toJSONString(nurseList);
//        System.out.println(json);

        resp.getWriter().println(json);


    }
}
