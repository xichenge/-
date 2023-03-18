package servlet;

import Dao.UserDao;
import Impl.UserImpl;
import pojo.User;
import utils.MyMD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/userforget")
public class UserForgetCheckServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String e_mail=req.getParameter("e_mail");
        String password=req.getParameter("password");
        System.out.println(username);
        System.out.println(e_mail);

        UserDao userDao=new UserImpl();
        User user = userDao.checkUser(username, e_mail);
        if(user==null)
        {
            String msg="用户名或邮箱错误";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("userForgetPassword.jsp").forward(req,resp);
        }
        else
        {
            try {
                String md5= MyMD5Util.getEncryptedPwd(password);
                user.setPassword(password);
                user.setMd5(md5);

                System.out.println("md5:"+md5);


                userDao.changgePassword(user);


                HttpSession session=req.getSession();
                session.setAttribute("user",user);//将用户信息存入到session中
                req.getRequestDispatcher("homepage_user.jsp").forward(req,resp);//走向主页
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }


        }
    }
}
