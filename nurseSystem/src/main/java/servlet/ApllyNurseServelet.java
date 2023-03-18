package servlet;

import Dao.NurseDao;
import Impl.NurseImpl;
import pojo.Nurse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/applynurse")
public class ApllyNurseServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String nursetype = req.getParameter("nursetype");
        HttpSession session=req.getSession();
        Nurse nurse = (Nurse) session.getAttribute("user");
        if("1".equals(nursetype))
        {
            nurse.setPosition("病人护工");
            nurse.setPositiontype(1);
        }
        else
            if("2".equals(nursetype))
            {
                nurse.setPosition("老人护工");
                nurse.setPositiontype(2);
            }
            else
            {
                nurse.setPosition("孕妇产妇护工");
                nurse.setPositiontype(3);
            }
        System.out.println(nurse);
        NurseDao nurseDao=new NurseImpl();
            nurseDao.registerNurse(nurse);
            session.removeAttribute("user");
            resp.getWriter().println("<b>认证上传成功，请等管理员验证，即可登录，点击此链接返回主页<a href=http://localhost:8080/nurseSystem/homepage.jsp>点我返回主页</a></b>");
    }
}
