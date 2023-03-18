<%@ page import="pojo.User" %>
<%@ page import="pojo.Nurse" %><%--
  Created by IntelliJ IDEA.
  User: koshi
  Date: 2022/12/1
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>列表页</title>
    <meta name="keywords" content="blog" />
    <meta name="description" content="blog" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-1.7.2.js"></script>
    <link href="css/base.css" rel="stylesheet">
    <link href="css/m.css" rel="stylesheet">
    <link rel="stylesheet" href="css/ownerdate.css">

    <!--<script src="js/jquery-1.8.3.min.js" ></script>-->
    <%
        Nurse nurse = (Nurse) session.getAttribute("user");
    %>
</head>
<body>

<div class="row bg">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <!-- Brand/logo -->
        <a class="navbar-brand" href="http://localhost:8080/nurseSystem/homepage_nurse.jsp" ><img class="img-fluid" src="images/testlogo.png" width="250" height="150" > </a>
        <a class="navbar-brand" href="http://localhost:8080/nurseSystem/homepage_nurse.jsp" ><img class="img-fluid" src="images/3.png" width="93" height="127.6"> </a>

        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="homepage_nurse.jsp">主页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="shownursesalary.jsp">薪资情况</a>
            </li>
            <li class="nav-item">
            </li>
            <li class="nav-item">
                <a class="nav-link" href="changenursedata.jsp">修改用户信息</a>
            </li>
            <li class="nav-item">
                <a  class="nav-link" href="homepage.jsp" data-bs-toggle="modal"  data-bs-target="#myModal" >退出</a>
                <!-- 模态框内容 -->
            </li>

        </ul>
    </nav>

    <!-- 模态框 -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">退出用户</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <!-- 模态框内容 -->
                <div class="modal-body">
                    是否退出账户
                </div>

                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <form action="logout" method="get">
                        <button type="button" class="btn btn-success" data-bs-dismiss="modal" >不是</button>
                        <button  type="submit" class="btn btn-danger">是</button>
                    </form>
                </div>

            </div>
        </div>
    </div>




    <form action="#" method="post">

        <div class ="rg_layout" >
            <div class="rg_left">
                <p class="p_reg">个人资料</p>
            </div>

            <div class="rg_center" >
                <div  id="app">
                    <!--    定义表单-->
                    <form action="#" method="post">
                        <table >

                            <tr>
                                <td class = "td_left"><label for="username">用户名</label></td>
                                <td class = "td_right"><input class="input1" type="text" readonly name="username" id="username" value="<%=nurse.getUsername()%>">
                                </td>
                            </tr>

                            <tr>
                                <td class = "td_left"><label for="name">姓名</label></td>
                                <td class = "td_right"><input class="input1" type="text" readonly name="name" id="name" value="<%=nurse.getName()%>">
                                </td>
                            </tr>

                            <tr>
                                <td class = "td_left"><label for="name">邮箱</label></td>
                                <td class = "td_right"><input class="input1" type="text" readonly name="e_mail" id="e_mail" value="<%=nurse.getE_mail()%>">
                                </td>
                            </tr>



                            <tr>
                                <td class = "td_left"><label for="phone">手机号</label></td>
                                <td class = "td_right"><input class="input1" type="text" readonly name="phone" id="phone" value="<%=nurse.getPhone()%>">
                                </td>
                            </tr>

                            <%if("男".equals(nurse.getGender())){%>
                            <tr>
                                <td class = "td_left"><label>性别</label></td>
                                <td class = "td_right2"  >
                                    <input type="radio" name="gender" value="男" onselect="" id="male" checked>男
                                    <%--                                <input type="radio" name="gender" value="female"  id="gender_female">女--%>
                                </td>
                            </tr>
                            <%} else{%>
                            <tr>
                                <td class = "td_left"><label>性别</label></td>
                                <td class = "td_right2"  >
                                    <input type="radio" name="gender" value="女" onselect="" id="female" checked>女
                                    <%--                                <input type="radio" name="gender" value="female"  id="gender_female">女--%>
                                </td>
                            </tr>

                            <%}%>

                            <tr>
                                <td class = "td_left"><label for="address">住址</label></td>
                                <td class = "td_right"><input class="input1" type="text" name="address" id="address" readonly value="<%=nurse.getAddress()%>">
                                </td>
                            </tr>

                            <tr>
                                <td class = "td_left"><label for="age">年龄</label></td>
                                <td class = "td_right"><input class="input1" type="text" name="age" id="age" readonly value="<%=nurse.getAge()%>">
                                </td>
                            </tr>

                            <tr>
                                <td class = "td_left"><label for="position">护工类别</label></td>
                                <td class = "td_right"><input class="input1" type="text" name="position" id="position" readonly value="<%=nurse.getPosition()%>">
                                </td>
                            </tr>

                            <tr>
                                <td class = "td_left"><label for="salary">底薪</label></td>
                                <td class = "td_right"><input class="input1" type="text" name="position" id="salary" readonly value="<%=nurse.getSalary()%>">
                                </td>
                            </tr>

                        </table>
                    </form>
                </div>
            </div>


        </div>
    </form>
</body>


</html>

</body>
</html>
