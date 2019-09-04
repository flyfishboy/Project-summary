<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/7/15
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <style type="text/css">
        *{
            margin: 0px;
            border:0px;
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
<body style="background-image: url(images/007.jpg);background-size: 100%">
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

<!--center-->
<%
    String id=request.getParameter("id");
    String jobname=request.getParameter("jobname");
    String pnumber=request.getParameter("pnumber");
    String introduction=request.getParameter("introduction");
    String salary=request.getParameter("salary");
%>
<form method="post" action="/alter" enctype="Multipart/form-data">
    <div>
        <%--top--%>
        <br><br>
        <div align="center" style="color: #ffffff;font-size: 30px">
            <h1>修改招聘信息</h1>
            <span style="font-size: 13px">只需4步即可修改招聘信息哦~</span>
        </div>
        <br><br>

        <div>
            <input type="text" value="<%=id%>" style="display: none" name="id">
        </div>

        <div align="center" style="font-size: 15px">

            <li style="font-size: 40px;font-family: 'Microsoft YaHei UI';border-radius: 8px;background-color: cornflowerblue;padding: 0px 20px">
                1
            </li>
            工作名称: <input style="border-radius:8px;background-color:#d5e5e9;width: 250px;height: 35px"  type="text" name="jobname"  value="<%=jobname%>"><br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size: 12px">您可点击浏览上传工作信息图片：</span><input style="color: white;" type="file" name="img"><br><br>

            <li style="font-size: 40px;font-family: 'Microsoft YaHei UI';border-radius: 8px;background-color: #feff9b;padding: 0px 20px">
                2
            </li>
            联系电话: <input style="border-radius:8px;background-color:#d5e5e9;width: 250px;height: 35px" type="text" name="pnumber" value="<%=pnumber%>"><br><br><br>

            <li style="font-size: 40px;font-family: 'Microsoft YaHei UI';border-radius: 8px;background-color: #ed8ec9;padding: 0px 20px">
                3
            </li>
            工作介绍:<input style="border-radius:8px;background-color:#d5e5e9;width: 250px;height: 35px" type="text" name="introduction" value="<%=introduction%>"><br><br><br>

            <li style="font-size: 40px;font-family: 'Microsoft YaHei UI';border-radius: 8px;background-color: #c685ed;padding: 0px 20px">
                4
            </li>
            大概薪水: <input style="border-radius:8px;background-color:#d5e5e9;width: 250px;height: 35px" type="text" name="salary" value="<%=salary%>"><br><br><br>

            <input style="border-radius:8px;background-color:#a0cbde;color:white;width: 100px;height: 50px" type="submit" value="确定修改">
            <input style="border-radius:8px;background-color:#a0cbde;color:white;width: 100px;height: 50px"type="reset" value="清空"><br>

        </div>

    </div>
</form>

</div>


<style type="text/css">
    li{
        display: inline-block;
    }
</style>
</body>
</html>
