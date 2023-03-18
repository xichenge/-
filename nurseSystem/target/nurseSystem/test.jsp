<%--
  Created by IntelliJ IDEA.
  User: koshi
  Date: 2022/12/18
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>饼状图的基本实现</title>
    <script src="js/echarts.min.js"></script>
</head>
<body>
<div id="app" style="width: 600px;height: 400px;"></div>
<script>
    // 1.Echarts 基本结构的创建
    // 引入js文件---创建容器---初始化对象---配置配置项---
    // 2.准备数据[{name;???, value:???},{}]
    // 运动与健康：1100，餐饮：2800，外出与旅行：4500，衣物：2202，电子游戏：2421，医药：800
    // 3.将type设置为pie
    var myCharts = echarts.init(document.querySelector('#app'))
    // 需要设置给饼图的数据
    var pieData = [
        {
            name: '底薪',
            value: '8000'
        }
        ,
        {
            name: '提成',
            value: '2202'
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
                radius:'100%',     //半径
                selectedMode: 'multiple',
                selectedOffset: 30
            }
        ]
    }
    myCharts.setOption(option)
</script>
</body>
</html>


