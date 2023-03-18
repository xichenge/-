<%--
  Created by IntelliJ IDEA.
  User: koshi
  Date: 2022/11/27
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="Keywords" content="关键词,关键词">
    <meta name="description" content="">
    <link rel="stylesheet" href="css/back.css">
    <link rel="stylesheet" href="css/list3.css">
    <!--  <link rel="stylesheet" type="text/css" href="css/xcConfirm.css"/>-->
    <!--  <script src="js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>-->
    <script src="js/jquery-1.7.2.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="tz_content">

    <!--t_left start-->
    <div class="t_left">
        <div class="l_logo"><h2 style="text-align: center;" >欢迎回来</h2 ></div>
        <div class="l_nav">
            <ul>
                <li class="active">
                    <a href="adminHomepage.jsp" >
                        <i class="icon_2"></i>
                        <span>用户管理</span>
                    </a>
                </li>
                <li>
                    <a href="adminCheckNurse.jsp" >
                        <i class="icon_1"></i>
                        <span>护工审核</span>
                    </a>
                </li>

                <li>
                    <a href="adminNurse.jsp">
                        <i class="icon_2"></i>
                        <span>护工管理</span>
                    </a>
                </li>
                <li>
                    <a href="adminOrder.jsp">
                        <i class="icon_3"></i>
                        <span>订单管理</span>
                    </a>
                </li>
                <li>
                    <a href="adminDataAnalysis.jsp" class="a1">
                        <i class="icon_3"></i>
                        <span>数据分析</span>
                    </a>
                </li>


            </ul>
        </div>
    </div>

    <div class="t_right">

        <!--r_location start-->
        <div class="r_location">
            <li class="licenter">数据分析
                <a href="clearcookie" style="color: whitesmoke">安全退出</a>
            </li>

        </div>
        <style>
            .box{
                width: 100%;
                height: 50%;
                background-color: rgb(188, 227, 236);
            }
        </style>
        <div >
            <table border="0" width="100%" cellspacing="0" height="100%" >
                <div class="box" id="main"></div>


            </table>
        </div>
    </div>
</div>
</body>

<script src="js/echarts.min.js"></script>
<script>


    $.ajax({
        type:"POST",
        url :"admingetdata",
        data:{},
        success:function(date2){

            //3.初始化实例对象 echarts.init(dom容器)
            var myChart =  echarts.init(document.getElementById('main'));
            //4.指定配置项和数据
            var option = {
                title: {
                    text: '数据分析'
                },
                tooltip: {},
                legend: {
                    data:['预约量']
                },
                xAxis: {
                    data:date2.typenames
                },
                yAxis: {},
                series: [{
                    name: '预约量',
                    type: 'bar',
                    data: date2.nums
                }]
            };
            //5.将配置项设置给echarts实例对象，使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);









        },
        error:function () {
            console.log("失败");
        }
    })













</script>





</body>
</html>
