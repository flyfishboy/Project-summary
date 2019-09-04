<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/7/12
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style type="text/css">
        input{
             border-radius: 5px;
         }
        .inputDiv{
            height: 47px;
            border: 1px solid #85dea5;
            border-radius: 5px;
            overflow: hidden;
            margin-bottom: 20px;
            width:450px;
        }
        .icon{
            margin:0px;
            float: left;
            overflow: hidden;
            border-radius: 5px 0 0 5px;
        }
        .txt{
            padding: 0px;
            height: 47px;
            line-height: 47px;
            font-size: 14px;
            color: #333;
            float: left;
            border: none;
            width:403px;
            outline:medium;
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
</head>
<body style="margin: 0px;
    width: 100%;
    height:100%;
    background-image: url(image/102.jpg);
    background-repeat: no-repeat;
    background-position: center top;
    background-size: 100% 100%;">

<br><br>
<!--导航栏-->
<div >
    <div style="height: 40px">
        <div style="height: 40px;width:50%;float:left; "></div>
        <div style="width:20%; color:#ffffff;float:left;overflow: hidden; height: 40px;line-height: 40px;">
            <div style="float:left;">
                <a href="main.jsp" style="text-decoration: none">首页</a>
                &nbsp;&nbsp;&nbsp;
            </div>
            <div style="float:left;">
                <a href="/showall" style="text-decoration: none">招聘信息</a>
                &nbsp;&nbsp;&nbsp;
            </div>
            <div style="float:left;">
                <a href="/showmine" style="text-decoration: none">我的信息</a>
                &nbsp;&nbsp;&nbsp;
            </div>
        </div>
        <%
            String username= (String) session.getAttribute("username");
            String nickname=(String)session.getAttribute("nickname");
        %>
        <div style="height: 40px;width:15%;float:left; "></div>


        <div style="height: 40px;width:15%;float:left ;">
            <div style="border-radius: 25px;line-height: 40px">
                &nbsp;&nbsp;
                <c:if test="${empty username}">
                    <a href="login.jsp" style="text-decoration: none">登录</a>
                </c:if>
                <c:if test="${not empty nickname}">
                <span style="color:red;">
                        ${nickname}
                </span>
                </c:if>
                &nbsp;/&nbsp;
                <a href="register.jsp" style="text-decoration: none">注册</a>
            </div>
        </div>
    </div>
</div>
<!--导航栏-->

<!--注册界面-->
<div style="overflow: hidden">
    <div style="width: 35%;height:1px;float: left">

    </div>


    <div style="width:30%;overflow: hidden;float: left">
        <br><br><br><br>
        <div style="overflow: hidden">
            <div align="center">
                <div>
                    <span style="font-size: 30px;color: white;">新用户注册</span>
                </div>
                <br>
                <div align="right">
                    <span></span>已有账号？
                    <a href="login.jsp" style="color:blue;text-decoration: none">马上登录</a>
                </div>
                <br>
                <form method="post" action="/userregister">

                    <div class="inputDiv">
                        <p class="icon">
                            <img src="image/4.png"  style="height: 47px;width:47px">
                        </p>
                        <input type="text" placeholder="输入昵称" name="nickname" class="txt">

                    </div>

                    <div class="inputDiv">
                        <p class="icon">
                            <img src="image/1.png"  style="height: 47px;width:47px">
                        </p>
                        <input  type="text" placeholder="输入账号(6到18个字符)" name="username" class="txt" >
                    </div>


                    <div class="inputDiv">
                        <p class="icon">
                            <img src="image/2.png"  style="height: 47px;width:47px">
                        </p>
                        <input type="password" placeholder="设置密码" name="password" class="txt">
                    </div>


                    <div class="inputDiv">
                        <p class="icon">
                            <img src="image/2.png"  style="height: 47px;width:47px">
                        </p>
                        <input type="password" placeholder="确认密码" name="confirmPassword" class="txt">

                    </div>





                    <div class="inputDiv">
                        <p class="icon">
                            <img src="image/3.png"  style="height: 47px;width:47px">
                        </p>
                        <input type="text" placeholder="输入简要信息" name="userinformation" class="txt">

                    </div>


                    <div style="height:47px;width:450px;overflow: hidden">
                        <input type="submit" value="立即注册" style="background-color:#3845ff;color:#fff7e5;width:250px;height:45px;padding: 0px;border: white 0px;float:left;overflow: hidden">
                        <input type="reset" value="重填" style="background-color:#3845ff;color:#fff7e5;width:150px;height:45px;padding: 0px;border: white 0px;float:right;">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div style="float: left;width:35%;">

        <c:if test="${not empty username_msg}">
            <div style="margin:265px 0px 0px 0px">
                <span style="color: red">${username_msg}</span>
            </div>
        </c:if>
        <c:if test="${ not empty password_msg}">
            <div style="margin:335px 0px 0px 0px">
                <span style="color: red">${password_msg}</span>
            </div>
        </c:if>
        <c:if test="${ not empty msg}">
            <div style="margin:195px 0px 0px 0px">
                <span style="color: red">${msg}</span>
            </div>
        </c:if>
    </div>
</div>

</body>
</html>
