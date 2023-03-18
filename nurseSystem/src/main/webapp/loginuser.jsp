<%@ page import="static jdk.nashorn.internal.runtime.regexp.joni.Config.log" %><%-- m,
  Created by IntelliJ IDEA.
  User: koshi
  Date: 2022/9/9
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>

<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/loginuser.css">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

</head>

<%
    //获取cookie
    Cookie[]cookies=request.getCookies();
    String e_mail="";
    String password="";
    if(cookies!=null)
    {
        for(Cookie cookie:cookies){
            {
                if("user_e_mail".equals(cookie.getName()))
                {
                    e_mail=cookie.getValue();
//                    System.out.println(e_mail);
                }
                if("user_password".equals(cookie.getName()))
                {
                    password=cookie.getValue();
                    System.out.println(password);
                }

            }

        }
    }
%>



<body  style="background-color: gray">
<div class="loginForm" >
    <h2 class="h"><a href="homepage.jsp" link>护工系统</a> 用户登录</h2>
    <img  class="mx-auto d-block img-fluid"  src="images/user.png"  alt="center" height="300" width="300">

    <form action="loginuserservlet" ,method="post">
        <div class="form-group">
            <label for="exampleInputEmail1" >用户名</label>
            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入用户名" name="e_mail"
                   value="<%=e_mail%>">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1"  >密码</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="password"
                   value="<%=password%>">
        </div>
        <br>

        <%      String msg= (String) request.getAttribute("msg");
//            System.out.println(msg);
            if(msg!=null&&(!"".equals(msg))){
        %>
        <span >
            <font color="red"><%=request.getAttribute("msg")%></font>
        </span>
        <%}%>

        <div class="form-check form-switch">
            <input class="form-check-input" type="checkbox" id="mySwitch" name="darkmode" value="yes" checked>
            <label class="form-check-label" for="mySwitch">记住密码</label>
        </div>

        <div class="button">
            <input type="submit" class="btn btn-primary" value="登 录"/>
        </div>

        <div>护工登录，<a href="registernurse.jsp">点击此处</a></div>
        <div>管理员登录，<a href="loginadmin.jsp">点击此处</a></div>
        <div>
            忘记密码？,<a href="userForgetPassword.jsp">点击此处</a>
        </div>
        <div>
            没有账户,<a href="registeruser.jsp">立即注册</a>
        </div>
    </form>
</div>

</body>
</html>
