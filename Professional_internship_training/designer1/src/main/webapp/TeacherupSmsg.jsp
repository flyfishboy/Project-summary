<%@ page import="cn.keshe.entity.Student" %><%--
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
            background-color: #ff1e19;
        }
        .opshow1{
            width: 60%;
            position: relative;
            left: 20%;
        }
        .opshow1 form p{
            width: 19%;
            margin-top: 15px;
            float: left;
        }
        .opshow1 form input{
            margin-top: 15px;
            border: #aed5e1 2px solid;
            width: 80%;
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
    String s_id=(String) request.getSession().getAttribute("s_id");
    String name= (String) request.getSession().getAttribute("s_n");
    String sex= (String) request.getSession().getAttribute("s_sex");
    String clas= (String) request.getSession().getAttribute("s_c");
    String password=(String) request.getSession().getAttribute("s_psd");
    String birthday= (String) request.getSession().getAttribute("s_d");
    String profession= (String)  request.getSession().getAttribute("s_p");
    String phone= (String)  request.getSession().getAttribute("s_tel");
    String qq= (String)  request.getSession().getAttribute("s_q");
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
                <form action="t_s_upmsgServlet" method="post">
                    <input type="text" value="<%=s_id%>" name="old" style="display: none">
                    <p>学号：</p><input type="text" value="<%=s_id%>" name="id">
                    <p>姓名：</p><input type="text" value="<%=name%>" name="n">
                    <p>性别：</p><input type="text" value="<%=sex%>" name="sex">
                    <p>班级：</p><input type="text" value="<%=clas%>" name="c">
                    <p>专业</p><input type="text" value="<%=profession%>" name="pro">
                   <p>密码：</p><input type="text" value="<%=password%>" name="psd">
                    <p>出生年月：</p><input type="date" value="<%=birthday%>" name="birth">
                    <p>电话：</p><input type="text" value="<%=phone%>" name="tel">
                    <p>QQ：</p><input type="text" value="<%=qq%>" name="q">
                    <input type="submit" value="提交" style="position: relative;left: 20%;width: 100px">
                </form>
                </div>
            </div>

        </div>

    </div>
</div>
</body>
</html>