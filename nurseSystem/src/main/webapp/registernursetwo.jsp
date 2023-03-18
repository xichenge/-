<%--
  Created by IntelliJ IDEA.
  User: koshi
  Date: 2022/11/26
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/axios.min.js"></script>
<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/nurse_register2.css">



<%--<body>--%>
<%--<input type="file" id="uploadFile">--%>
<%--<input type="submit" onclick="a()">--%>
<%--</body>--%>
<body style="background-color: gray">
<div class="registerForm">
    <h2 class="h"><a href="homepage.jsp" link>护工系统</a> 护工验证2</h2>
    <div name="file" class="button">
       请上传图片 <input type="file" id="uploadFile" >
        <input type="submit" onclick="a()" class="btn btn-primary" value="上传">
    </div>
    <form method="post" action="applynurse" >
        请选择你申请的护工类型:
        <br/>
      <div>
          <input  type="radio" name="nursetype" value="1">病人护工
          <input checked type="radio" name="nursetype" value="2">老人护工
          <input type="radio" name="nursetype" value="3">孕妇产妇护工
          <br>
          <div class="button">
              <input type="submit" class="btn btn-primary" value="注 册" />
          </div>
      </div>
    </form>
</div>
</body>








<script>
    function a(){
        let formData = new FormData();
        formData.append("file",document.getElementById("uploadFile").files[0]);
        axios({
            method:"post",
            url:"http://localhost:8080/nurseSystem/upload",
            data:formData,
            async:false,           //同步请求
            processData: false,
            contentType: false
        }).then(function (response) {
            alert("上传成功")
        })
    }
</script>
</html>
