<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.annotation.ElementType" %>
<%@ page import="com.nchu.entity.Employment" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/7/15
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的招聘</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
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
<body style="width: 100%;background-image:url(/image2/002.jpg)">
<!--导航栏-->
<div style="background-color: #f5fcfe;">
    <div style="height: 40px">
        <div style="height: 40px;width:50%;float:left; ">

        </div>
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

                <c:if test="${empty username}">
                    <a href="login.jsp" style="text-decoration: none">登录</a>
                </c:if>
                <c:if test="${not empty nickname}">
                <span style="color:red;">
                        ${nickname}
                </span>
                </c:if>
                /
                <a href="register.jsp" style="text-decoration: none">注册</a>/
                <a href="/cancel" style="text-decoration: none">注销</a>
            </div>
        </div>
    </div>
</div>
<!--导航栏-->


<br><br>


<div style="overflow: hidden">
    <!--左块-->
    <div style="width: 25%;height: 1px;float: left"></div>


    <!--中间块-->
    <div style="width: 50%;float: left">

        <c:if test="${not empty username}">
            <h1 align="center">我发布的招聘信息</h1><br><br>
            <div align="center">
                <a href="add.jsp" style="text-decoration: none"><img src="image/timg-3.jpg" style="width:150px;border-radius: 30px;" /></a>
            </div>
        </c:if>

        <c:if test="${ not empty list}">
            <br><br>
            <c:forEach items="${list}"  varStatus="name"><!--显示模块-->
                <c:if test="${name.count%2==1}">
                    <div style="overflow: hidden;width: 700px;">
                        <div style="float: left;height:240px ;width:350px">
                            <img src="jobimage/${name.current.getImg()}" style="height:240px ;width:350px">
                        </div>
                        <div style="float: left;height:200px ;width:310px;padding:20px;background-color: #fff;opacity:0.8;">
                            <h3 style="height: 30px">工作名：${name.current.getJobname()}</h3>
                            <div style="height: 27px">
                                联系电话：${name.current.getPnumber()}
                            </div>
                            <div style="height: 27px">
                                薪水：${name.current.getSalary()}
                            </div>
                            <div>
                                工作简介：${name.current.getIntroduction()}
                            </div>
                            <div style="overflow: hidden;margin-top: 10px">
                                <form method="post" action="/delete" style="float: left;width:150px">
                                    <input type="text" value="${name.current.getId()}" style="display: none" name="id">
                                    <input type="submit" value="取消招聘" style="border-radius: 10px;width:100px;height:30px;border:1px black solid;">
                                </form>
                                <form method="post" action="/alter.jsp" style="float: left;width: 150px">
                                    <input type="text" value="${name.current.getId()}" style="display: none" name="id">
                                    <input type="text" value="${name.current.getJobname()}" style="display: none" name="jobname">
                                    <input type="text" value="${name.current.getUsername()}" style="display: none" name="username">
                                    <input type="text" value="${name.current.getPnumber()}" style="display: none" name="pnumber">
                                    <input type="text" value="${name.current.getIntroduction()}" style="display: none" name="introduction">
                                    <input type="text" value="${name.current.getSalary()}" style="display: none" name="salary">
                                    <input type="submit" value="修改招聘" style="border-radius: 10px;width:100px;height:30px;border:1px black solid;">
                                </form>
                            </div>
                        </div>
                    </div>
                    <br><br><br><br><br><br>
                </c:if>


                <c:if test="${name.count%2==0}">
                    <div style="overflow: hidden;width: 700px;">
                        <div style="float: left;height:200px ;width:310px;padding:20px;background-color: #fff;opacity:0.8;">
                            <h3 style="height: 30px">工作名：${name.current.getJobname()}</h3>
                            <div style="height: 25px">
                                联系电话：${name.current.getPnumber()}
                            </div>
                            <div style="height: 25px">
                                薪水：${name.current.getSalary()}
                            </div >
                            <div >
                                工作简介：${name.current.getIntroduction()}
                            </div>
                            <div style="overflow: hidden;margin-top: 10px">
                                <form method="post" action="/delete" style="width:150px;float:left">
                                    <input type="text" value="${name.current.getId()}" style="display: none" name="id">
                                    <input type="submit" value="取消招聘" style="border-radius: 10px;width:100px;height:30px;border:1px black solid;">
                                </form>
                                <form method="post" action="/alter.jsp" style="width:150px;float:left">
                                    <input type="text" value="${name.current.getId()}" style="display: none" name="id">
                                    <input type="text" value="${name.current.getJobname()}" style="display: none" name="jobname">
                                    <input type="text" value="${name.current.getUsername()}" style="display: none" name="username">
                                    <input type="text" value="${name.current.getPnumber()}" style="display: none" name="pnumber">
                                    <input type="text" value="${name.current.getIntroduction()}" style="display: none" name="introduction">
                                    <input type="text" value="${name.current.getSalary()}" style="display: none" name="salary">
                                    <input type="submit" value="修改招聘" style="border-radius: 10px;width:100px;height:30px;border:1px black solid;">
                                </form>
                            </div>

                        </div>
                        <div style="float: left;height:240px ;width:350px">
                            <img src="jobimage/${name.current.getImg()}" style="height:240px ;width:350px">
                        </div>
                    </div>
                    <br><br><br><br><br><br>
                </c:if>

            </c:forEach>
        </c:if>
    </div>


    <!--右块-->

    <div style="width: 25%;height: 30px;float: right">

        <c:if test="${empty username}">
            <div>
                您还未登录？点此&nbsp;&nbsp;&nbsp;
                <a href="login.jsp">登录</a>
            </div>
        </c:if>
    </div>


</div>

</body>
</html>
