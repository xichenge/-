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
    <script src="js/echarts.min.js"></script>
    <script src="js/jquery-1.7.2.js"></script>
    <link href="css/base.css" rel="stylesheet">
    <link href="css/m.css" rel="stylesheet">
    <link rel="stylesheet" href="css/ownerdate.css">

    <!--<script src="js/jquery-1.8.3.min.js" ></script>-
    -->
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
                <p class="p_reg">护工薪资</p>
            </div>

            <div class="rg_center" >
                <div  id="app">
                    <!--    定义表单-->
                      <span>
                            <div id="main" style="width: 600px;height: 400px;"></div>
                      </span>
                    <span id="salaryspan"  class="rg_left">
                    </span>

                </div>
            </div>


        </div>
    </form>
</body>


</html>

</body>
<script>
    // 1.Echarts 基本结构的创建
    // 引入js文件---创建容器---初始化对象---配置配置项---
    // 2.准备数据[{name;???, value:???},{}]
    // 运动与健康：1100，餐饮：2800，外出与旅行：4500，衣物：2202，电子游戏：2421，医药：800
    // 3.将type设置为pie


    $.ajax({
        type:"POST",
        url:"nursesalary",
        data:{},
        success:function (data2) {

            var myCharts = echarts.init(document.querySelector('#main'))
            // 需要设置给饼图的数据
            var pieData = [
                {
                    name: '底薪',
                    value: '8000'
                }
                ,
                {
                    name: '提成',
                    value: data2.c
                }

            ]
            var option = {
                // 注意：饼图不是直角坐标系图表，就不用配置x轴和y轴了
                series: [
                    {
                        type: 'pie', // 类型： 饼图
                        data: pieData,//数据
                        label: {//饼图文字的显示
                            show: true, //默认  显示文字
                            formatter: function (arg) {
                                console.log(arg);
                                return arg.name  + arg.value + " 元" +'\n'+ arg.percent + "%"
                            }
                        },

                        // 饼图的半径
                        // radius: '20%' //百分比参照的事宽度和高度中较小的那一部分的一半来进行百分比设置
                        // 圆环
                        // radius: ['50%','80%']

                        // 南丁格尔图  饼图的每一个部分的半径是不同的
                        // roseType: 'radius',
                        radius:'70%',     //半径
                        selectedMode: 'multiple',
                        selectedOffset: 30
                    }
                ]
            }
            myCharts.setOption(option)
            $("#salaryspan").html("总工资为:"+(8000+data2.c))
        }
    })









    // var myCharts = echarts.init(document.querySelector('#main'))
    // // 需要设置给饼图的数据
    // var pieData = [
    //     {
    //         name: '底薪',
    //         value: '8000'
    //     },
    //     {
    //         name: '提成',
    //         value: '2202'
    //     }
    //
    // ]
    // var option = {
    //     // 注意：饼图不是直角坐标系图表，就不用配置x轴和y轴了
    //     series: [
    //         {
    //             type: 'pie', // 类型： 饼图
    //             data: pieData,//数据
    //             label: {//饼图文字的显示
    //                 show: true, //默认  显示文字
    //                 formatter: function (arg) {
    //                     console.log(arg);
    //                     return arg.name  + arg.value + " 元" +'\n'+ arg.percent + "%"
    //                 }
    //             },
    //             radius:'100%',     //半径
    //             selectedMode: 'multiple',
    //             selectedOffset: 30
    //         }
    //     ]
    // }
    // myCharts.setOption(option)
</script>
</html>
