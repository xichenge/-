package servlet;

import Dao.UserDao;
import Impl.UserImpl;
import com.mysql.cj.Session;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/changeuser")
public class ChangeUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Integer age = Integer.valueOf(req.getParameter("age"));

//        System.out.println("name:"+name);
//        System.out.println("username:"+username);
//        System.out.println("gender:"+gender);
//        System.out.println("phone"+phone);
//        System.out.println("adddress:"+address);
//        System.out.println("age:"+age);
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        user.setAge(age);
        user.setName(name);
        user.setUsername(username);
        user.setAddress(address);
        user.setPhone(phone);
        user.setGender(gender);
        session.setAttribute("user",user);
        UserDao userDao=new UserImpl();
        userDao.changeUserData(user);
        req.getRequestDispatcher("changeuserdata.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
