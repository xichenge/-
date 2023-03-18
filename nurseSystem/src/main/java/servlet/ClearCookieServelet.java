package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clearcookie")
public class ClearCookieServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1=new Cookie("admin_e_mail",null);
        Cookie cookie2=new Cookie("admin_password",null);
        cookie1.setMaxAge(0);//设置生存周期为0，即立即释放
        cookie2.setMaxAge(0);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        req.getRequestDispatcher("homepage.jsp").forward(req,resp);
    }
}
