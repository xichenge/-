package servlet;

import Dao.NurseDao;
import Impl.NurseImpl;
import pojo.Nurse;
import utils.MyMD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/loginnurseservlet")
public class LoginnurseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String e_mail = req.getParameter("e_mail");
        String password = req.getParameter("password");
        String check=req.getParameter("darkmode");
//        System.out.println("e_mail:"+e_mail);
//        System.out.println("password:"+password);
//        System.out.println("check:"+check);
         Nurse nurse=new Nurse();

        NurseDao nurseDao=new NurseImpl();
        nurse=nurseDao.queryByE_mail(e_mail);
        System.out.println(nurse);

        if(nurse==null)//如果获取不到，就字节返回
        {
            req.setAttribute("msg","密码或用户名错误");
            req.getRequestDispatcher("loginnurse.jsp").forward(req,resp);
        }

        try {
            if(MyMD5Util.validPassword(password,nurse.getMd5()))//进行配对
            {
                System.out.println("登录成功");
                HttpSession session=req.getSession();
                session.setAttribute("user",nurse);//将用户信息存入到session中
                if("yes".equals(check))
                {
                    Cookie cookie1=new Cookie("nurse_e_mail",e_mail);
                    Cookie cookie2=new Cookie("nurse_password",password);
                    cookie1.setMaxAge(60*60);//1h
                    cookie2.setMaxAge(60*60);
                    resp.addCookie(cookie1);
                    resp.addCookie(cookie1);
                    resp.addCookie(cookie2);

                }
                else
                {
                    Cookie cookie1=new Cookie("nurse_e_mail",e_mail);
                    Cookie cookie2=new Cookie("nurse_password",password);
                    cookie1.setMaxAge(0);//设置生存周期为0，即立即释放
                    cookie2.setMaxAge(0);
                    resp.addCookie(cookie1);
                    resp.addCookie(cookie2);
                }
                req.getRequestDispatcher("homepage_nurse.jsp").forward(req,resp);//走向主页
            }
            else
            {
                req.setAttribute("msg","密码或用户名错误");
                req.getRequestDispatcher("loginnurse.jsp").forward(req,resp);//返回用户登录界面
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
