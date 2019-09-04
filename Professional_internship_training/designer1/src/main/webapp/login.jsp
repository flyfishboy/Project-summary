<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/7/12
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
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
            color: white;
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
    background-image: url(image2/body1.png);
    background-repeat: no-repeat;
    background-position: center top;
    background-size: 100% 100%;">
<br><br>
        <%
            String id= (String) session.getAttribute("id");
            String name=(String)session.getAttribute("name");
        %>
        <div style="height: 40px;width:15%;float:left; "></div>
    </div>
</div>
<!--导航栏-->
<!--登陆界面-->
<br><br><br><br><br>
<div style="overflow: hidden">
    <div style="height:1px;width:35%;float: left"></div>
    <div align="center">
        <div style="width:30%;overflow: hidden;float: left;background-color: #f5fcfe">
            <div style="font-size: 30px;color: #333333;">实习实训管理系统</div>
            <br>
            <br>
            <form method="post" action="LoginServlet">
                <div class="inputDiv">
                    <p class="icon">
                        <img src="image/1.png"  style="height: 47px;width:47px">
                    </p>
                    <input  type="text" placeholder="请输入账号" name="s_id" class="txt" >
                </div>

                <div class="inputDiv">
                    <p class="icon">
                        <img src="image/2.png"  style="height: 47px;width:47px">
                    </p>
                    <input type="password" placeholder="请输入密码" name="s_password" class="txt">
                </div>
                <div class="inputDiv" style="background-color: lavender">
                    <p class="icon" style="font-size:14px;margin-top: 10px;border-right: #AEAEAE  solid 2px ">
                        类型：
                    </p>
                    <select name="usertype" style="width: 90%;height: 99%;position: relative;float: right;">
                        <option value="1">学生</option>
                        <option value="2">教师</option>
                        <option value="3">管理员</option>
                    </select>
                </div>
                <div style="height:47px;width:450px;overflow: hidden">
                    <input type="submit" value="立即登录" style="background-color:#3845ff;color:#fff7e5;width:250px;height:45px;padding: 0px;border: white 0px;float:left;overflow: hidden">
                    <input type="reset" value="重填" style="background-color:#3845ff;color:#fff7e5;width:150px;height:45px;padding: 0px;border: white 0px;float:right;">
                </div>
                <br><br>
                <c:if test="${not empty msg}">
                    <span style="color: red">${msg}</span>
                </c:if>
            </form>
        </div>
    </div>

    </div>
</div>


</body>
</html>
