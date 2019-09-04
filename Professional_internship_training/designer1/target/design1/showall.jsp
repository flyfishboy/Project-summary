<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nchu.entity.Employment" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/7/15
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有招聘</title>
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
<h1 align="center">所有的招聘信息</h1>
<br><br>

<div style="overflow: hidden">
    <div style="width:35%;height:1px;float: left"></div>
    <div align="center">
        <form action="/select" method="post" style="overflow: hidden;width:30%;float: left">
            <input type="text" style="width: 400px;height: 40px;float:left;border-radius: 15px;outline:medium;" name="select" placeholder="按照工作简介查找">
            <div style="float:left;height:5px;width:15px;"></div>
            <img src="image/select.jpg" onclick=" submit()" style="height:38px;float:left;border-radius: 20px">
        </form>
    </div>
    <div style="width:35%;height:1px;float: left"></div>
</div>


<br><br>



<!--显示界面-->
<div style="overflow: hidden">
    <div style="width: 27.5%;height: 1px;float: left"></div>
    <div style="width: 45%;float: left">
        <c:if test="${ not empty list}">
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
                            <div >
                                工作简介：${name.current.getIntroduction()}
                            </div>
                            <div>
                                <c:if test="${ not empty username}">
                                    <div style="margin-top: 10px">
                                        <form method="post" action="/submitresume" enctype="Multipart/form-data">
                                            <input type="text" value="${name.current.getId()}" style="display: none" name="id">
                                            <input type="file" name="resume" style="width:180px">
                                            <input type="submit" value="上传简历" style="border-radius: 10px;width:100px;height:30px;border:1px black solid;">
                                        </form>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <br><br><br><br><br><br>
                </c:if>


                <c:if test="${name.count%2==0}">
                    <div style="overflow: hidden;width: 700px;">
                        <div style="float: left;height:200px ;width:310px;padding:20px;background-color: #fff;opacity:0.8">
                            <h3 style="height: 30px">工作名：${name.current.getJobname()}</h3>
                            <div style="height: 27px">
                                联系电话：${name.current.getPnumber()}
                            </div>
                            <div style="height: 27px">
                                薪水：${name.current.getSalary()}
                            </div>
                            <div >
                                工作简介：${name.current.getIntroduction()}
                            </div>
                            <c:if test="${not empty username}">
                                <div style="margin-top: 10px">
                                    <form method="post" action="/submitresume" enctype="Multipart/form-data">
                                        <input type="text" value="${name.current.getId()}" style="display: none" name="id">
                                        <input type="file" name="resume" style="width:180px">
                                        <input type="submit" value="上传简历" style="border-radius: 10px;width:100px;height:30px;border:1px black solid;">
                                    </form>
                                </div>
                            </c:if>

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


</div>

</body>
</html>
