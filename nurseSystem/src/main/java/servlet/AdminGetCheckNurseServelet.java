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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admingetchecknurse")
public class AdminGetCheckNurseServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        List<Nurse>nurseList=new ArrayList<>();
        nurseList=null;
        NurseDao nurseDao=new NurseImpl();
        nurseList=nurseDao.pagenurse0(1,15);
        String json= JSON.toJSONString(nurseList);
        resp.getWriter().println(json);

    }
}
