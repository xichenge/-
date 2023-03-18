
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
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <%--    <script src="<%=path %>/js/bootstrap3.min.js"></script>--%>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>


    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>






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
            <a class="navbar-brand" href="homepage_nurse.jsp">
                <img src="<%=path %>/images/3.png" height="100%" />
            </a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="homepage_nurse.jsp">主页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="shownursesalary.jsp">薪资情况</a>
                </li>
                <li ><a href="shownurseData.jsp">个人信息</a>
                </li>
<%--                <li>--%>
<%--                    <a href="userorder.jsp">订单详情</a>--%>
<%--                </li>--%>
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
            <a href="#" class="list-group-item active">订单查询
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

                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-default" onclick="nursefindorder()">开始搜索</button>
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



        <ul id="page" class="pagination" style="float: right;">

        </ul>
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
    $.ajax({//初始化订单
        type:"POST",
        url :"getmnurseorder",
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
            }


            $("#ordertable").html(nurses);

            // console.log(date2);

        },
        error:function () {
            console.log("失败");
        }
    })





    $.ajax({//初始化页数
        type:"POST",
        url :"nurseinitorder",
        data:{},
        success:function(data){
            var page=null;
            // alert(data.currentPage)
            page="  <tr>\n" +
                "                <th><button id=1 onclick='fan(this)'>首页</button></th>\n" +
                "                <th><button onclick='fan(this)' id="+(data.currentPage)+">上一页</button></th>\n" +
                "                <th><button onclick='fan(this)' id="+(data.currentPage+1)+">下一页</button></th>\n" +
                "                <th><button onclick='fan(this)' id="+data.totalPage+">尾页</button></th>\n" +
                "                <th>当前页："+ data.currentPage+ "/总页数:"+data.totalPage+"</th>\n" +
                "            </tr>"

            $("#page").html(page);
            console.log(page);

        },
        error:function () {
            console.log("失败");
        }
    })





    function fan(e) {
        var pos=e.id;
        var context=$("#name").val();
        // alert(context)
        console.log(pos);
        $.ajax({
            type:"POST",
            url :"nurseorderpage",
            dataType: "json",
            data:{
                currentpage:pos,
                context:context
            },
            success:function(data){
                var orderList=data.orderList;
                var pageBeanUtils=data.pageBeanUtils;
                var orders=null;

                for (let i = 0; i < orderList.length; i++) {
                    let nurse=orderList[i];
                    if(true)
                        orders+="<tr> <th>"+nurse.id+"</th>\n" +
                            "            <th>"+nurse.nurseid+"</th>\n" +
                            "            <th>"+nurse.position+"</th>\n" +
                            "            <th>"+nurse.userid+"</th>\n" +
                            "            <th>"+nurse.ordertime+"</th>\n" +
                            // "        <th class=\"th1\"><button class=\"button10\" id="+nurse.id+" onclick=order(this) >预定</button></th>\n" +
                            "          </tr>";
                }


                $("#ordertable").html(orders);

                var page=null;
                page="  <tr>\n" +
                    "                <th><button id=1 onclick='fan(this)'>首页</button></th>\n" +
                    "                <th><button onclick='fan(this)' id="+pageBeanUtils.prePage+">上一页</button></th>\n" +
                    "                <th><button onclick='fan(this)' id="+pageBeanUtils.nextPage+">下一页</button></th>\n" +
                    "                <th><button onclick='fan(this)' id="+pageBeanUtils.lastPage+">尾页</button></th>\n" +
                    "                <th>当前页："+ pageBeanUtils.currentPage+ "/总页数:"+pageBeanUtils.totalPage+"</th>\n" +
                    "            </tr>"

                $("#page").html(page);


            },
            error:function () {
                console.log("失败");
            }
        })
    }




    function nursefindorder() {//用户进行查找
        var context=$("#name").val();

        $.ajax({
            type:"POST",
            url :"nursefindorder",
            dataType: "json",
            data:{
                context:context
            },
            success:function(data){
                var orderList=data.orderList;
                var pageBeanUtils=data.pageBeanUtils;

                let nurses=null;
                for (let i = 0; i < orderList.length; i++) {
                    let nurse=orderList[i];
                        nurses+="<tr> <th>"+nurse.id+"</th>\n" +
                            "            <th>"+nurse.nurseid+"</th>\n" +
                            "            <th>"+nurse.position+"</th>\n" +
                            "            <th>"+nurse.userid+"</th>\n" +
                            "            <th>"+nurse.ordertime+"</th>\n" +
                            "          </tr>";
                }
                if(orderList.length==0)
                {
                    nurses="<tr>\n" +
                        "    <th>对不起，系统找不到符合你条件的数据</th>\n" +
                        "</tr>\n";
                }

                $("#ordertable").html(nurses);


                var page=null;
                page="  <tr>\n" +
                    "                <th><button id=1 onclick='fan(this)'>首页</button></th>\n" +
                    "                <th><button onclick='fan(this)' id="+pageBeanUtils.prePage+">上一页</button></th>\n" +
                    "                <th><button onclick='fan(this)' id="+pageBeanUtils.nextPage+">下一页</button></th>\n" +
                    "                <th><button onclick='fan(this)' id="+pageBeanUtils.lastPage+">尾页</button></th>\n" +
                    "                <th>当前页："+ pageBeanUtils.currentPage+ "/总页数:"+pageBeanUtils.totalPage+"</th>\n" +
                    "            </tr>"

                $("#page").html(page);


            },
            error:function () {
                console.log("失败");
            }
        })

    }



    function order(e) {
        var pos=e.id;
        let c=confirm("是否预定id为"+pos+"的护士吗");
        console.log(c);
        if(c){
            $.ajax({
                type:"POST",
                url :"userorder",
                dataType: "json",
                data:{
                    id:pos
                },
                success:function(date){
                },
                error:function () {
                    console.log("失败");
                }
            })
            window.location.reload();
        }
    }







</script>




</html>
