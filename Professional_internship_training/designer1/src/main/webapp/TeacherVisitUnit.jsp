<%@ page import="cn.keshe.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实习实训管理系统</title>
    <style>
        body,ul,div,img,h5,h4,h3,h2,h1,p,span,table,figure,i,li{ margin:0; padding:0}/*设置所有标签的内外边距为0*/
        .header{/*标题模块*/
            width: 70%;
            height: 150px;
            position: relative;
            left: 15%;
        }
        .header1-1{
            width: 45%;
            height: 120px;
            float: left;
            position: relative;
            left: 4%;
        }
        .header1-1 p{
            font-size: 40px;
            margin-top: 40px;
            color: #131215;
            text-align: center;
        }

        .header1-2{
            width: 45%;
            height: 120px;
            float: left;
            position: relative;
            left: 4%;
        }
        .header1-2 p{
            font-size: 20px;
            margin-top: 20px;
            color: black;
            text-align: center;
        }
        .header1-2 li{
            margin: 10px;
            font-size: 20px;

            text-align: center;
            display: inline-block;
            position: relative;
            left: 40%;
        }
        .header1-2 a{
            color: black;
            text-decoration: none;
        }

        .header1-2 a:hover{
            color: #f60;
            text-decoration: none;
        }
        .header1-2 a:active{
            color: #ff6633;
            text-decoration: none;
        }
        .contmain{/*内容模块*/
            width: 60%;
            position: relative;
            left: 20%;

            height: 500px;

        }
        .nav{//**导航栏**//
        width: 100%;
            line-height:40px;
            margin:auto;

        }
        .nav ul{
            list-style:none;
            margin:auto;
            width:100%;
        }
        .nav ul li{
            float:left;
            width:111px;
            padding-left: 20px;
            padding-right: 20px;
            text-align:center;
            background: #aed5e1;
            color: #f1ffbb;
            font-weight:bold;
        }
        .nav ul li a{/*设置导航栏字体属性*/
            display:block;
            color:#131215;
            -webkit-transition: all 0.5s;
            -moz-transition: all 0.5s;
            -o-transition: all 0.5s;
            -ms-transition: all 0.5s;
            text-decoration:none
        }
        .nav ul li a:hover{/* 背景颜色过渡效果 */
            background: #06adff;
            color: #f1ffbb;
            font-weight:bold;
        }
        .matter{
            width: 100%;
            height: 400px;
        }
        .operation{/*功能选择栏*/
            width: 25%;
            position: relative;
            margin-right:5px ;
            float: left;
            height: 100%;
            background-color: lavender;
        }
        .operation li{
            margin: 10px;
            font-size: 20px;
            text-align: center;
            display: inline-list-item;
            position: relative;
            text-decoration: none;
            list-style: none;
            margin-top: 20px;
        }
        .operation a{
            display:block;
            color:#131215;
            -webkit-transition: all 0.5s;
            -moz-transition: all 0.5s;
            -o-transition: all 0.5s;
            -ms-transition: all 0.5s;
            text-decoration:none;
        }

        .operation a:hover{
            font-weight:bold;
        }
        .operation a:active{
            color: #ff6633;
            text-decoration: none;
        }
        .opshow{/*显示功能栏*/
            width: 98%;
            position: relative;
            float: left;
            height: 100%;
            background-color: lavender;
        }
        .metter1{
            width: 60%;
            position: relative;
            left: 20%;
            background-color: #05f5ed;
        }
        .metter1 a{
            position: relative;
            margin-top: 0px;
            line-height: 30px;
        }
        .metter1 input{
            position: relative;
            float: left;
            margin-top: 0px;
            line-height: 30px;
        }
        .opshow a{
            display:block;
            color:#131215;
            -webkit-transition: all 0.5s;
            -moz-transition: all 0.5s;
            -o-transition: all 0.5s;
            -ms-transition: all 0.5s;
            text-decoration:none;
        }
        .opshow1{
            width: 60%;
            position: relative;
            left: 20%;
        }
        .opshow1 p{
            width: 20%;
            line-height: 20px;
            margin-top: 10px;
            position: relative;
            float: left;
        }
        .opshow1 input{
            width: 78%;
            line-height: 20px;
            border: #aed5e1 solid 1px;
            margin-top: 10px;
            position: relative;
            float: left;
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
<%
    String id= (String) request.getSession().getAttribute("id");
    String name= (String) request.getSession().getAttribute("name");
    String sex= (String) request.getAttribute("sex");
    String birthday= (String) request.getAttribute("birth");
    String profession= (String)  request.getAttribute("profess");
    String phone= (String)  request.getAttribute("telphone");
    String qq= (String)  request.getAttribute("q1");
    request.setAttribute("id",id);
%>
<div class="all" >
    <div class="header">
        <div class="header1-1">
            <p>实习实训管理系统</p><br>
        </div>
        <div class="header1-2">
            <div style="margin-top: 20px">
                <p>${name}&nbsp您好！欢迎使用本系统！</p><br>
                <u1 >
                    <li ><a href="/login.jsp" style="decoration: none">注销</a></li>
                    <c:if test="${not empty id}">
                        <li>/<a href="/altpassword.jsp" style="decoration: none">修改密码</a></li>
                    </c:if>
                </u1>
            </div>
        </div>
    </div>
    <div class="contmain">

        <div class="nav">
            <ul>
                <li id="li1"><a href="TeacherMain.jsp">首页</a></li>
                <li><a href="t_see_msgSerlvet">个人信息</a></li>
                <li><a href="t_seeP_applyServlet">审核申请</a></li>
                <li><a href="t_seeWorkServlet">周记批阅</a></li>
                <li><a href="t_seePracticeServlet?t_id=<%=id%>">实习管理</a></li>
                <li><a href="t_s_seemsgServlet">学生信息管理</a></li>
            </ul>
        </div>
        <div class="matter">

            <div class="opshow" style="background-color: white">
                <div class="opshow1">
                    <form action="t_AddPointServlet" method="post">
                        <input type="text" value="<%=id%>" name="t_id" style="display: none">
                        <p>企业名称：</p><input type="text" name="d_name">
                        <p >经度：</p> <input type="text" name="lon" value="">
                        <p >纬度：</p><input type="text" name="lat" value="" >
                        <input type="submit" value="添加" style="position: relative;left: 20%">
                    </form>
                    <a href="t_see_unitServlet?tid=<%=id%>"><input type="button" value="查看回访路线" style="position: relative;left: 20%"></a>
                </div>


            </div>

        </div>

    </div>
</div>
</body>
</html>