<%-- m,
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
<script src="js/jquery-1.7.2.js"></script>
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/loginuser.css">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <%
        String msg=null;
        msg= (String) request.getAttribute("msg");
    %>
</head>

<script type="text/javascript">
    var message=<%request.getParameter("message");%>

</script>

<body  style="background-color: gray">
<div class="loginForm" >
    <h2 class="h"><a href="homepage.jsp" link>用户</a> 忘记密码</h2>
    <img  class="mx-auto d-block img-fluid"  src="images/user.png"  alt="center" height="300" width="300">
    <form action="userforget" ,method="post">
        <div class="form-group">
            <label for="exampleInputPassword1"  >用户名</label>
            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入用户名" name="username">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1" >电子邮箱</label>
            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入电子邮箱" name="e_mail">
        </div>

        <div class="form-group">
            <label for="exampleInputPassword2" >修改后的密码</label>
            <input type="password" class="form-control" id="exampleInputPassword2" placeholder="请输入修改后的密码" name="password">
        </div>

        <h5 >
            <font color="red">
                <%if(!(msg==null)){%>
                <%=msg%>
                <%}%>
            </font>
        </h5>
        <br>
        <div class="button">
            <input type="submit" class="btn btn-primary" value="确 认"/>
        </div>
        <div>
            返回登录界面,<a href="loginuser.jsp">点击此处</a>
        </div>
        <div>
            没有账户,<a href="registeruser.jsp">立即注册</a>
        </div>
    </form>
</div>

</body>
</html>
