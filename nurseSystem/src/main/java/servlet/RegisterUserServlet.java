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

@WebServlet("/registeruser")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String verifycode = req.getParameter("verifycode");//自己文本输入的

        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if(!checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            //提示信息
            req.setAttribute("login_msg", "验证码错误！");
            //跳转登录页面
            req.getRequestDispatcher("/registeruser.jsp").forward(req, resp);

        }
        else{
            String md5=null;
            String username=req.getParameter("username");
            String name=req.getParameter("name");
            String phone=req.getParameter("phone");
            String e_mail=req.getParameter("e_mail");
            String address=req.getParameter("address");
            String password=req.getParameter("password");
            Integer age = Integer.valueOf(req.getParameter("age"));
            String gender=req.getParameter("gender");
            try {

                md5= MyMD5Util.getEncryptedPwd(password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            System.out.println("username"+username);
            System.out.println("name:"+name);
            System.out.println("e_mail"+e_mail);
            System.out.println("address:"+address);
            System.out.println("password:"+password);
            System.out.println("gender:"+gender);


            User user=new User();
            user.setAddress(address);
            user.setAge(33);
            user.setE_mail(e_mail);
            user.setMd5(md5);
            user.setGender(gender);
            user.setName(name);
            user.setUsername(username);
            user.setPhone(phone);
            user.setAge(age);
            user.setPassword(password);
            UserDao userDao=new UserImpl();
            userDao.addUser(user);



             session=req.getSession();
            session.setAttribute("user",user);//将用户信息存入到session中
            req.getRequestDispatcher("homepage_user.jsp").forward(req,resp);//走向主页

        }
    }
}
