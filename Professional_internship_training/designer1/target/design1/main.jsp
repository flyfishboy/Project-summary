<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/14
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>平步青云</title>
</head>
<script src="http://api.asilu.com/cdn/jquery.js,jquery.backstretch.min.js" type="text/javascript"></script>
<body  onload = "startTimer()" style="padding: 0px;margin: 0px" >
<%
    String username= (String) session.getAttribute("username");
    String nickname=(String)session.getAttribute("nickname");
%>
<div  name="header"  style="padding: 0px;margin: 0px">
<div style="background-image: url(images/B2.jpg);background-size: cover;background-repeat: no-repeat;padding: 0px;margin: 0px">
    <div name="header1" style="height: 30px;width: 100%;padding: 5px;margin: 0px">

        <div name="header1-1" style="width: 40%;height:1px;float: left">
            <audio autoplay="autoplay">
                <source src="song/Richard Clayderman - 梦中的婚礼 (钢琴曲).mp3" type="audio/ogg">
                <source src="song/Richard Clayderman - 梦中的婚礼 (钢琴曲).mp3" type="audio/mpeg">
            </audio>
        </div>

        <div name="header1-2"style="width: 40%;float: left">
            <u1 >
                <li><a href=""style="border: 0px;margin: 10px">首页</a></li>
                <li><a href="/showall"style="border: 0px;margin: 10px">招聘信息</a></li>
                <li><a href="/showmine"style="border: 0px;margin: 10px">我的信息</a></li>

            </u1>
        </div>

        <div name="header1-3" style="width: 20%;float: left">
            <u1 >
                <c:if test="${not empty s_name}">
                    <li style="margin: 10px 0px 0px 0px"><span style="color:red;">${s_name}</span></li>/
                </c:if>
                <c:if test="${empty s_name}">
                    <li style="margin: 10px 0px 0px 0px"><a href="login.jsp" style="text-decoration: none">登录</a></li>/
                </c:if>
                <li style="margin: 10px 0px 0px 0px"><a href="register.jsp" style="text-decoration: none">注册</a>/</li>
                <li style="margin: 10px 0px 0px 0px"><a href="/cancel" style="text-decoration: none">注销</a></li>
                <c:if test="${not empty s_name}">
                    <li style="margin: 10px 0px 0px 0px">/<a href="/altpassword.jsp" style="text-decoration: none">修改密码</a></li>
                </c:if>

            </u1>
        </div>

    </div>
    </div>
    <div style="overflow: hidden;height: 500px;width: 100%;opacity: 100%"align="center">
        <div style="padding: 0px;margin: 0px">

    </div>
    </div>
    <div name="header2"style="width: 100%;height:300px">
        <div>

        </div>
    </div>
</div>
    <div style="padding: 0px;margin: 0px;background-color: white">
    <div name="header3"style="width: 100%;height:600px;background-repeat:no-repeat;background-size: cover;padding: 0px;margin: 0px;background-color: white">
        <div align="center"><img src="images/1.jpg"style="height: 600px"></div>
    </div>

    <div  name="header4" style="height: 260px;width: 100%;background-color:rgba(49,49,49,0.1);padding: 0px;margin: 0px;
    border-color: #AEAEAE; ">
    <div align="center";>
        <ul >
            <li><a href=""><img src="images/i5.png" width="164" height="164"style="margin: 20px 30px 0px 30px"/>
                <p style="margin: 0px 30px 20px 30px">首页</p></a></li>
            <li><a href=""><img src="images/i6.png" width="164" height="164"style="margin: 20px 30px 0px 30px"/>
                <p style="margin: 0px 30px 20px 30px">招聘信息</p></a></li>
            <li><a href=""><img src="images/i7.png" width="164" height="164"style="margin: 20px 30px 0px 30px"/>
                <p style="margin: 0px 30px 20px 30px">发布信息</p></a></li>
            <li ><a href=""><img src="images/i8.png" width="164" height="164" style="margin: 20px 30px 0px 30px"/>
                <p style="margin: 0px 30px 20px 30px">求职指导</p></a></li>
        </ul>
    </div>
</div>
    </div>
<div name="header5" align="center" style="background-color: darkgray;height: 200px">
    <u1 >
        <li ><a href="">  关于我们    </a></li>
        <li><a href="">  相关条款    </a></li>
        <li><a href="">  联系我们    </a></li>
        <li><a href="">  更多  </a></li>
    </u1><br>
   <u1>
    <li><a href="">网站简介</a></li>
    <li><a href="">版权声明</a></li>
    <li>021-31604293</li>
    </u1><br>
    <u1>
        <li><a href=""> 团队简介</a></li>
        <li><a href="">免责声明</a></li>
        <li>info@gappernet.org</li>
    </u1>
</div>


</div>
<style type="text/css">
    #header{

    font-size:30px;
    }
    #header1{
        padding: 0px;
        margin: 0px;
     height: 50px;
    }
    #header2{

    }
    #header4{
     border-color: #05ffc4;
        padding:0px;
        padding: 0px;
        margin: 0px;
    }
    li{
        margin: 10px;

        display: inline-block;
    }
    a{
        color: #131215;
        text-decoration: none;
    }

    a:hover{
        color: #f60;
        text-decoration: none;
    }
    a:active{
        color: #ff6633;
        text-decoration: none;
    }

</style>


<script type = "text/javascript">
    function displayNextImage() {x = (x === images.length - 1) ? 0 : x + 1;
        document.getElementById("img").src = images[x];   }
    function displayPreviousImage() {x = (x <= 0) ? images.length - 1 : x - 1;
        document.getElementById("img").src = images[x];
    }
    function startTimer() {
        setInterval(displayNextImage, 3000);}
    var images = [], x = -1;
    images[0] = "image1/ad1.jpg";
    images[1] = "image1/ad2.jpg";
    images[2] = "image1/ad3.jpg";
</script>

</body>
</html>
