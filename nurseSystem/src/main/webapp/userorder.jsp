
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入样式文件和动态控制 -->
<%--    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">--%>
    <script src="<%=path %>/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <%--    <script src="<%=path %>/js/bootstrap3.min.js"></script>--%>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>


    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<%--    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>






    <title>后台管理界面二</title>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://localhost:8080/nurseSystem/homepage_user.jsp">
                <img src="<%=path %>/images/3.png" height="100%" />
            </a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="homepage_user.jsp">预定</a>
                </li>
                <li ><a href="showuserData.jsp">个人信息</a>
                </li>
                <li>
                    <a href="userorder.jsp">订单详情</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                </li>
                <li  class="active"><a href="clearusercookie">安全退出</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2">
            <a href="#" class="list-group-item active">订单详情
            </a>
        </div>



        <!--左边菜单栏-->
        <div class="col-sm-10">
            <ol class="breadcrumb">
                <li class="active">菜单
                </li>
                <li class="active">订单信息
                </li>
            </ol>

            <div class="panel panel-default">
                <div class="panel-heading">
                    搜索
                </div>
                <div class="panel-body">
                    <div role="form" class="form-inline" >
                        <div class="form-group">
                            <label for="name">名称</label>
                            <input type="text" class="form-control" id="name" name="findvalue" placeholder="支持时间模糊查找" >
                            <div class="form-group">
                                <label for="name">护工类别</label>
                                <select name="level_find" class="form-control" id="level_find">
                                    <option value="0" name="0">全部展示</option>
                                    <option value="老人护工" name="2">老人护工</option>
                                    <option value="病人护工" name="1">病人护工</option>
                                    <option value="孕妇产妇护工" name="3">孕妇产妇护工</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-default" onclick="userfindorder()">开始搜索</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--
                列表展示
            -->





        <div class="table-responsive">
            <table class="table table-striped ">
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>订单护士编号</th>
                    <th>护士类型</th>
                    <th>用户编号</th>
                    <th>订单时间</th>


                </tr>
                </thead>
                <tbody name="ordertable" id="ordertable">

                </tbody>

            </table>
        </div>



<%--        <ul class="pagination" style="float: right;">--%>
<%--            <li><a href="#">&laquo;</a>--%>
<%--            </li>--%>
<%--            <li class="active"><a href="#">1</a>--%>
<%--            </li>--%>
<%--            <li class="disabled"><a href="#">2</a>--%>
<%--            </li>--%>
<%--            <li><a href="#">3</a>--%>
<%--            </li>--%>
<%--            <li><a href="#">4</a>--%>
<%--            </li>--%>
<%--            <li><a href="#">5</a>--%>
<%--            </li>--%>
<%--            <li><a href="#">&raquo;</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
    </div>
</div>
</div>
<!-- 底部页脚部分 -->
<div class="footer">
    <p class="text-center">
        2022 &copy; user
    </p>
</div>
</body>

<script>



    function userfindorder() {
        var context=$("#name").val();
        var positiontype=$("#level_find").val();
        // alert(context)
        // alert(positiontype)
        $.ajax({
            type:"POST",
            url :"userfindorder",
            dataType: "json",
            data:{
                context:context,
                positiontype:positiontype
            },
            success:function(date2){
                let nurses;
                for (let i = 0; i < date2.length; i++) {
                    let nurse=date2[i];
                    if(true)
                        nurses+="<tr> <th>"+nurse.id+"</th>\n" +
                            "            <th>"+nurse.nurseid+"</th>\n" +
                            "            <th>"+nurse.position+"</th>\n" +
                            "            <th>"+nurse.userid+"</th>\n" +
                            "            <th>"+nurse.ordertime+"</th>\n" +
                            // "        <th class=\"th1\"><button class=\"button10\" id="+nurse.id+" onclick=order(this) >预定</button></th>\n" +
                            "          </tr>";
                    // <button class=\"button10\" id="+user.id+" onclick=diang(this)>上传</button>&nbsp&nbsp
                }
                if(date2.length==0)
                {
                    nurses="<tr>\n" +
                        "    <th>对不起，系统找不到符合你条件的数据</th>\n" +
                        "</tr>\n";
                }


                $("#ordertable").html(nurses);

                // console.log(date2);

            },
            error:function () {
                console.log("失败");
            }
        })

    }


















    $.ajax({
        type:"POST",
        url :"getuserorder",
        data:{},
        success:function(date2){
            let nurses;
            for (let i = 0; i < date2.length; i++) {
                let nurse=date2[i];
                if(true)
                    nurses+="<tr> <th>"+nurse.id+"</th>\n" +
                        "            <th>"+nurse.nurseid+"</th>\n" +
                        "            <th>"+nurse.position+"</th>\n" +
                        "            <th>"+nurse.userid+"</th>\n" +
                        "            <th>"+nurse.ordertime+"</th>\n" +
                        // "        <th class=\"th1\"><button class=\"button10\" id="+nurse.id+" onclick=order(this) >预定</button></th>\n" +
                        "          </tr>";
                // <button class=\"button10\" id="+user.id+" onclick=diang(this)>上传</button>&nbsp&nbsp
            }


            $("#ordertable").html(nurses);

            // console.log(date2);

        },
        error:function () {
            console.log("失败");
        }
    })





    function order(e) {
        var pos=e.id;
        let c=confirm("是否预定id为"+pos+"的护士吗");
        alert(pos)
        console.log(c);
        if(c){
            $.ajax({
                type:"POST",
                url :"userorder",
                dataType: "json",
                data:{
                    id:pos
                },
                success:function(data){
                    console.log("预约成功")
                   alert("预约成功")

                },
                error:function () {
                    console.log("失败");
                }
            })

        }
    }



</script>




</html>
