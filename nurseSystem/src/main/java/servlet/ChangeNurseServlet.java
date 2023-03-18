package servlet;

import Dao.NurseDao;
import Dao.UserDao;
import Impl.NurseImpl;
import Impl.UserImpl;
import pojo.Nurse;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/changenurse")
public class ChangeNurseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String position=req.getParameter("position");

        System.out.println("name:"+name);
        System.out.println("username:"+username);
        System.out.println("gender:"+gender);
        System.out.println("phone"+phone);
        System.out.println("adddress:"+address);
        System.out.println("age:"+age);
        System.out.println("position:"+position);
        HttpSession session=req.getSession();
        Nurse nurse=(Nurse)session.getAttribute("user");
        nurse.setAge(age);
        nurse.setName(name);
        nurse.setUsername(username);
        nurse.setAddress(address);
        nurse.setPhone(phone);
        nurse.setGender(gender);
        nurse.setPosition(position);

        if("病人护工".equals(position))
        {
         nurse.setPositiontype(1);
        }else if("老人护工".equals(position))
        {
            nurse.setPositiontype(2);
        }else
        {
            nurse.setPositiontype(3);
        }



        session.setAttribute("user",nurse);

        NurseDao nurseDao=new NurseImpl();
        nurseDao.changeNurseData(nurse);
        req.getRequestDispatcher("changenursedata.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
