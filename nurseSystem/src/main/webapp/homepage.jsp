<%--
  Created by IntelliJ IDEA.
  User: koshi
  Date: 2022/11/30
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Travel-mate Bootstarp Website Template | Home</title>
    <link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- web-font -->


    <!-- web-font -->
    <!-- js -->
    <script src="js/jquery.min.js"></script>
    <script src="js/modernizr.custom.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- js -->
    <script src="js/modernizr.custom.js"></script>
    <!-- start-smoth-scrolling -->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
            });
        });
    </script>
    <!-- start-smoth-scrolling -->
</head>
<body>
<!-- header -->
<div class="header">
    <div class="head-bg">
        <!-- container -->
        <div class="container">
            <div class="top-nav">
                <span class="menu"><img src="images/menu.png" alt=""></span>
                <ul class="cl-effect-1">
                    <li><a  href="loginuser.jsp">用户登录</a></li>
                    <li><a href="registernurse.jsp">护工认证</a></li>
                    <li><a href="loginnurse.jsp">护工登录</a></li>
                    <li><a href="loginadmin.jsp">管理员登录</a></li>
                </ul>
                <!-- script-for-menu -->
                <script>
                    $( "span.menu" ).click(function() {
                        $( "ul.cl-effect-1" ).slideToggle( 300, function() {
                            // Animation complete.
                        });
                    });
                </script>
                <!-- /script-for-menu -->
            </div>
            <div class="clearfix"> </div>
        </div>
        <!-- //container -->
    </div>
    <!-- container -->
    <div class="container">
        <!-- banner Slider starts Here -->
        <script src="js/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function () {
                // Slideshow 4
                $("#slider3").responsiveSlides({
                    auto: true,
                    pager: false,
                    nav: false,
                    speed: 500,
                    namespace: "callbacks",
                    before: function () {
                        $('.events').append("<li>before event fired.</li>");
                    },
                    after: function () {
                        $('.events').append("<li>after event fired.</li>");
                    }
                });

            });
        </script>
        <!--//End-slider-script -->
        <div  id="top" class="callbacks_container">
            <ul class="rslides" id="slider3">
                <li>
                    <div class="head-info">
                        <h1><span>Welcome to here</span></h1>
                        <p>This is a Support worker system </p>
                    </div>
                </li>

                <li>
                    <div class="head-info">
                        <h1> 你缺护工吗<span>那你来对地方了</span></h1>
                        <p>快去注册用户账号</p>
                    </div>
                </li>
                <li>
                    <div class="head-info">
                        <h1>你想求职一份护工工作吗<span>那你快来加入我们 </span></h1>
                        <p>我们广纳人才 </p>
                    </div>
                </li>

            </ul>
        </div>

    </div>
    <!-- container -->
</div>
<!-- //header -->
<!-- banner-grids -->
<div class="banner-grids">
    <!-- container -->
    <div class="container">
        <div class="banner-grid-info">
            <h3>金牌护工</h3>
            <p>我们送上最好的护工,给你最佳的体验</p>
        </div>
        <div class="top-grids">
            <div class="top-grid">
                <img src="images/8.jpg" alt="" />
                <div class="top-grid-info">
                    <h3>张护工</h3>
                    <p>对待工作踏实，认真，并且极富工作和团队精神.</p>
                </div>
            </div>
            <div class="top-grid">
                <img src="images/7.jpg" alt="" />
                <div class="top-grid-info">
                    <h3>李护工</h3>
                    <p>具有良好的适应性和熟练的沟通技巧，忠诚稳重坚守诚信正直原则</p>
                </div>
            </div>
            <div class="top-grid">
                <img src="images/9.jpg" alt="" />
                <div class="top-grid-info">
                    <h3>王护工</h3>
                    <p>态度诚恳认真,，勇于挑战自我开发自身潜力</p>
                </div>
            </div>
            <div class="top-grid">
                <img src="images/10.jpg" alt="" />
                <div class="top-grid-info">
                    <h3>赵护工</h3>
                    <p>对人慈善,耐心.擅长照护儿童和老人,并且获得一致好评</p>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <!-- //container -->
</div>
<!-- //banner-grids -->
<!-- before -->
<div class="before">
    <!-- container -->
    <div class="container">
        <h2>使用指拿</h2>
        <div class="before-grids">
            <div class="before-grid">
                <h3>护工</h3>
                <p>
                    可以申请护工认证,等待管理员验证成功,加入我们
                </p>
            </div>
            <div class="before-grid">
                <h3>用户</h3>
                <p>
                    预约护工,替你排忧解难
                </p>
            </div>
            <div class="before-grid">
                <h3>管理员</h3>
                <p>删除用户,护工,批注护工认证
                </p>
            </div>
            <div class="clearfix"> </div>

        </div>
    </div>
    <!-- //container -->
</div>
<!-- //before -->
<!-- footer -->
<%--<div class="footer">--%>
<%--    <!-- container -->--%>
<%--    <div class="container">--%>
<%--        <div class="footer-left">--%>
<%--            <p></p>--%>
<%--        </div>--%>
<%--        <div class="footer-right">--%>
<%--            <div class="footer-nav">--%>
<%--                <ul>--%>
<%--                    <li><a href="homepage.html">HOME</a></li>--%>
<%--                    <li><a href="about.html">ABOUT</a></li>--%>
<%--                    <li><a href="booking.html">BOOKING</a></li>--%>
<%--                    <li><a href="news.html">NEWS</a></li>--%>
<%--                    <li><a href="mail.html">MAIL US</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="clearfix"> </div>--%>
<%--    </div>--%>
<%--    <!-- //container -->--%>
<%--</div>--%>
<!-- //footer -->
<script type="text/javascript">
    $(document).ready(function() {
        /*
        var defaults = {
              containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
         };
        */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- content-Get-in-touch -->
