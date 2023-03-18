package servlet;

import Dao.NurseDao;
import Impl.NurseImpl;
import com.alibaba.fastjson.JSON;
import utils.PageBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/admininitchecknurse")
public class AdminInitCheckNurseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        NurseDao nurseDao=new NurseImpl();
        Integer allNueseCount = nurseDao.getAllNurseCount0();
//        System.out.println("allnursecount"+allNueseCount);
        PageBeanUtils pageBeanUtils=new PageBeanUtils(1,15,allNueseCount);
        String json= JSON.toJSONString(pageBeanUtils);
//
//        System.out.println("nursepage：");
//        System.out.println(json);

        resp.getWriter().println(json);

    }
}
