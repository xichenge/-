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
                    <a href="adminHomepage.jsp" class="a1">
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
                    <a href="adminDataAnalysis.jsp">
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
            <li class="licenter">用户管理
                <a href="clearcookie" style="color: whitesmoke">安全退出</a>
            </li>

        </div>

        <div >
            <table border="0" width="100%" cellspacing="0" height="36px" >
                <tr>
                    <th>用户id</th>
                    <th>用户名字</th>
                    <th>用户邮箱</th>
                    <th>用户密码</th>
                    <th ><a id="dshu">管理</a></th>
                </tr>
                <tbody id="datatable" >

                </tbody>


            </table>
        </div>
        <div id="page"></div>
    </div>
</div>
</body>
<script type="text/javascript">

    $.ajax({
        type:"POST",
        url :"admingetuser",
        data:{},
        success:function(date2){
            let users;

            for (let i = 0; i < date2.length; i++) {
                let user=date2[i];
                if(true)
                    users+="<tr> <th>"+user.id+"</th>\n" +
                        "            <th>"+user.username+"</th>\n" +
                        "            <th>"+user.e_mail+"</th>\n" +

                        "            <th>"+user.password+"</th>\n" +
                        "        <th class=\"th1\"><button class=\"button10\" id="+user.id+" onclick=dian(this) >删除</button></th>\n" +
                        "          </tr>";

            // <button class=\"button10\" id="+user.id+" onclick=diang(this)>上传</button>&nbsp&nbsp
            }


            $("#datatable").html(users);

            console.log(date2);

        },
        error:function () {
            console.log("失败");
        }
    })






    $.ajax({//初始化页数
        type:"POST",
        url :"admininituser",
        data:{},
        success:function(data){
            var page=null;
            // alert(data.currentPage)
            page="  <tr>\n" +
                "                <th><button id=1 onclick='fan(this)'>首页</button></th>\n" +
                "                <th><button onclick='fan(this)' id="+(data.currentPage-1)+">上一页</button></th>\n" +
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

        $.ajax({
            type:"POST",
            url:"adminuserpage",
            dataType: "json",
            data:{
                currentpage: pos
            },
            success:function (data) {
                var userList=data.userList;
                var pageBeanUtils=data.pageBeanUtils;
                let users;
                for (let i = 0; i < userList.length; i++) {
                    let user=userList[i];
                    if(true)
                        users+="<tr> <th>"+user.id+"</th>\n" +
                            "            <th>"+user.username+"</th>\n" +
                            "            <th>"+user.e_mail+"</th>\n" +

                            "            <th>"+user.password+"</th>\n" +
                            "        <th class=\"th1\"><button class=\"button10\" id="+user.id+" onclick=dian(this) >删除</button></th>\n" +
                            "          </tr>";

                    // <button class=\"button10\" id="+user.id+" onclick=diang(this)>上传</button>&nbsp&nbsp
                }


                $("#datatable").html(users);

                console.log(date2);


                $("#datatable").html(nurses);



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
                console.log("fail")
            }

        })

    }











    function dian(e) {
        var pos=e.id;
        let c=confirm("是否删除id为"+pos+"的用户吗");
        console.log(c);
        if(c){
            $.ajax({
                type:"POST",
                url :"admindeleuserservelet",
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
</body>
</html>
