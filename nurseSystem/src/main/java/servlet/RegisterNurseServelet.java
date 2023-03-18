package servlet;

import pojo.Nurse;
import utils.MyMD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/registernurse")
public class RegisterNurseServelet extends HttpServlet {
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
            req.getRequestDispatcher("/registernurse.jsp").forward(req, resp);

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
            System.out.println("username:"+username);
            try {

                md5= MyMD5Util.getEncryptedPwd(password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            HttpSession session1=req.getSession();
            Nurse nurse=new Nurse();
            nurse.setAddress(address);
            nurse.setGender(gender);
            nurse.setAge(age);
            nurse.setE_mail(e_mail);
            nurse.setMd5(md5);
            nurse.setPhone(phone);
            nurse.setPassword(password);
            nurse.setName(name);
            nurse.setUsername(username);
            nurse.setTypestatus("1");
            nurse.setSalary(8000);
            nurse.setStatus("0");//还未通过审核
            session.setAttribute("user",nurse);//将用户信息存入到session中
            System.out.println(nurse);
            req.getRequestDispatcher("registernursetwo.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
