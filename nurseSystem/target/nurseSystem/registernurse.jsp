
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-1.7.2.js"></script>
<script src="js/registeruser.js"></script>
<script type="text/javascript" ></script>
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/registeruser.css">
<html>
<head>
    <title>SAKANA</title>
</head>
<script>
</script>
<body  style="background-color: gray">
<div class="registerForm">
    <h2 class="h"><a href="homepage.jsp" link>护工系统</a> 护工验证</h2>
    <form action="registernurse" method="post">
        <div class="form-group">
            <label for="exampleInputUserName1">用户名</label>
            <input name="username" type="text" class="form-control" id="exampleInputUserName1" onblur="judgeusername()" placeholder="请输入用户名">
            <span id="usernameInfo"></span>
        </div>

        <div class="form-group">
            <label for="exampleInputName1">真实姓名</label>
            <input name="name" type="text" class="form-control" id="exampleInputName1" onblur="judgename()" placeholder="请输入真实姓名">
            <span id="nameInfo"></span>
        </div>


        <div class="form-group">
            <label for="exampleInputEmail1" name="email">邮箱</label>
            <input  name="e_mail" type="email" class="form-control" id="exampleInputEmail1" onblur="judgee_mail()"  placeholder="请输入邮箱" >
        </div>
        <span id="useremailInfo"></span>
        <%--        style="width:200px; height:20px;"--%>
        <div class="form-group">
            <label for="exampleInputPhone1">手机</label>
            <input name="phone" type="text" class="form-control" id="exampleInputPhone1" onblur="judgephone()" placeholder="请输入手机">
            <span id="userphoneInfo"></span>
        </div>

        <div class="form-group">
            <label for="exampleInputAge1">年龄</label>
            <input name="age" type="text" class="form-control" id="exampleInputAge1"  placeholder="请输入年龄">
        </div>
        <div class="form-group">
            <label for="exampleInputAddress1">地址</label>
            <input name="address" type="text" class="form-control" id="exampleInputAddress1" onblur="judgeaddress()" placeholder="请输入地址">
            <span id="useraddressInfo"></span>
        </div>

        <div class="form-group">
            <label for="exampleInputPassword1">密码</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1" onblur="judgepassword1()" placeholder="请输入密码">
            <span id="userpassword1Info"></span>
        </div>

        <div class="form-group">
            <label for="exampleInputPassword2">确认密码</label>
            <input name="password1" type="password" class="form-control" id="exampleInputPassword2" onblur="judgepassword2()" placeholder="请确认密码">
            <span id="userpassword2Info"></span>
        </div>




        <div>
            性别
            <input checked type="radio" name="gender" value="男" />男
            <input type="radio" name="gender" value="女" />女
        </div>


        <div>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode()">
                <img src="./checkCodeServlet" title="看不清点击刷新" id="vcode" />
            </a>

        </div>

        <div class="button">
            <input type="submit" class="btn btn-primary" value="注 册"/>
        </div>




        <div>
            已有账户,<a href="loginuser.jsp">立即登录</a>
        </div>

    </form>
    <div class="alert-dismissible" role="alert">

    </div>




</div>
</body>
</html>
