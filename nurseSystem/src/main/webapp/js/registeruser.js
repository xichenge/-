function judgeusername() {
    var name=document.getElementById("exampleInputUserName1").value;
   if(name=="")
   {
       // alert("名字不可以空");
       $("#usernameInfo").css("color","red");
       $("#usernameInfo").html("用户名不可以为空");
   }
   else
       $("#usernameInfo").empty();
}

function judgename() {
    var name=document.getElementById("exampleInputName1").value;
    if(name=="")
    {
        // alert("姓名不可以空");
        $("#nameInfo").css("color","red");
        $("#nameInfo").html("姓名不可以为空");
    }
    else
        $("#usernameInfo").empty();
}





function judgeaddress() {
    var phone=document.getElementById("exampleInputAddress1").value;
    if(phone=="")
    {
        // alert("地址不可以空");
        $("#useraddressInfo").css("color","red");
        $("#useraddressInfo").html("地址不可以为空");
    }
    else
    {
        $("#userphoneInfo").empty();
    }
}



function judgephone() {
    var phone=document.getElementById("exampleInputPhone1").value;
    if(phone=="")
    {
        // alert("手机号码不可以空");
        $("#userphoneInfo").css("color","red");
        $("#userphoneInfo").html("手机号不可以为空");
    }
    else
    {
        $("#userphoneInfo").empty();
    }
}



function judgepassword1() {
    //获取
    var password=document.getElementById("exampleInputPassword1").value;

    // 密码至少八个字符，至少一个字母和一个数字：
    var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9~!@&%#_]{8,16}$/;
//必须包含一个大写，一个小写字母，且长度为8到16位
    if(password=="")
    {
        // alert("密码不可以为空");
        $("#userpassword1Info").css("color","red");
        $("#userpassword1Info").html("密码不可以为空");
    }
    else
        if(passwordPattern.test(password)==false)
        {
            alert("密码不符合要求，包含一个大写，一个小写字母，且长度为8到16位：")
            $("#userpassword1Info").css("color","red");
            $("#userpassword1Info").html("密码不符合要求");
        }
        else
        {
            $("#userpassword1Info").empty();
        }

}

function judgepassword2() {
    var password2=document.getElementById("exampleInputPassword2").value;
    var password=document.getElementById("exampleInputPassword1").value;
    if(password2=="")
    {
        // alert("确认密码不可以为空");
        $("#userpassword2Info").css("color","red");
        $("#userpassword2Info").html("确认密码不可以为空");
    }
    else
        if(!(password2==password))
        {
            // alert("密码前后不一致");
            $("#userpassword2Info").css("color","red");
            $("#userpassword2Info").html("密码前后不一致");

        }
        else
        {
            $("#userpassword2Info").empty();

        }
}



//切换验证码
function refreshCode(){
    //1.获取验证码图片对象
    var vcode = document.getElementById("vcode");

    //2.设置其src属性，加时间戳
    vcode.src = "./checkCodeServlet?time="+new Date().getTime();
}
