<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/7/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>

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

<!--导航栏-->
<div style="background-color: #f5fcfe;">
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

<div style="overflow: hidden">
    <div style="float: left;width:35%;height:1px;">

    </div>
    <div style="float: left;width: 30%">
        <br><br><br>
        <span style="font-size: 50px;color: white;">修改密码</span>
        <br><br><br>
        <form method="post" action="/altpassword">
            <div class="inputDiv">
                <p class="icon">
                    <img src="image/2.png"  style="height: 47px;width:47px">
                </p>
                <input type="password" placeholder="设置新密码" name="password" class="txt">
            </div>


            <div class="inputDiv">
                <p class="icon">
                    <img src="image/2.png"  style="height: 47px;width:47px">
                </p>
                <input type="password" placeholder="确认新密码" name="confirmPassword" class="txt">

            </div>

            <div style="height:47px;width:450px;overflow: hidden">
                <input type="submit" value="立即修改" style="background-color:#3845ff;color:#fff7e5;width:250px;height:45px;padding: 0px;border: white 0px;float:left;overflow: hidden">
                <input type="reset" value="重填" style="background-color:#3845ff;color:#fff7e5;width:150px;height:45px;padding: 0px;border: white 0px;float:right;">
            </div>
        </form>
    </div>


    <div style="float: left;width: 35%;">
        <div style="margin:180px 0px 0px 0px">
            <c:if test="${ not empty password_msg}">
                <span style="color: red;">${password_msg}</span>
            </c:if>
        </div>

    </div>

</div>



</body>
</html>
