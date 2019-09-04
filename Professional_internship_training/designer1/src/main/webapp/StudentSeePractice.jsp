<%@ page import="cn.keshe.entity.Student" %>
<%@ page import="cn.keshe.entity.Practice" %><%--
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
            width:15.2%;
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
            width: 72%;
            position: relative;
            float: left;
            height: 100%;
            background-color: lavender;
        }
        .opshow p{
            position: relative;
            left: 10%;
        }
        .opshow1-1{
            width: 70%;
            float: left;
            margin-top: 10px;
        }
        .opshow1-2{
            width: 48%;
            float: left;
            margin-top: 10px;
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
    String pid= (String) request.getAttribute("pid");
    String id= (String) request.getSession().getAttribute("id");
    String snid= (String) request.getAttribute("snid");
    String name= (String) request.getAttribute("sname");
    String ssex= (String) request.getAttribute("ssex");
    String pbd= (String) request.getAttribute("pbd");
    String ped= (String) request.getAttribute("ped");
    String pty= (String) request.getAttribute("pty");
    String pun= (String) request.getAttribute("pun");
    String pup= (String) request.getAttribute("pup");
    String tid=(String) request.getSession().getAttribute("teaid");

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
                <li id="li1"><a href="/StudentMain.jsp">首页</a></li>
                <li><a href="s_see_msgServlet?id=<%=id%>">个人信息</a></li>
                <li><a href="StudentApply.jsp">申请实习</a></li>
                <li><a href="s_see_workServlet?tid=<%=tid%>">实习任务</a></li>
                <li><a href="">更多</a></li>
            </ul>
        </div>
        <div class="matter">
            <div class="operation" style="text-align: center">
                <div style="margin-top: 20px;border: 2px solid #aed5e1">
                    <span style="align-content:center;font-size: 20px;"><a href="s_see_msgServlet?id=<%=id%>">个人信息</a></span>
                </div>
                <ul>
                    <li><a href="Studentupmsg.jsp">修改信息</a></li>
                    <li><a href="StudentupPas.jsp">修改密码</a></li>
                    <li><a href="s_see_practice_Servlet">实习信息</a></li>
                    <li><a href="">注销登录</a></li>
                </ul>
            </div>
            <div class="opshow">


                    <%
                    if(snid==null){
                        %>
                <div class="opshow1-1" style="margin-top: 50px" align="center">
                       <p>"对不起！您还没有申请实习，前点击下面申请按钮来申请实习。"</p><br>
                   <a href="StudentApply.jsp" ><input type="button" style="font-size: 20px;margin-left: 40%"  value="申请" ></a>
                </div>
                    <%
                    } else {
                    %>
                <div class="opshow1-1"  align="center">
                    <p >编号:&nbsp&nbsp&nbsp<%=pid%></p><br>
                    <p >学号:&nbsp&nbsp&nbsp<%=snid%></p><br>
                    <p >姓名:&nbsp&nbsp&nbsp<%=name%></p><br>
                    <p >性别:&nbsp&nbsp&nbsp<%=ssex%></p><br>
                    <p >实习开始时间:&nbsp&nbsp&nbsp<%=pbd%></p><br>
                    <p >实习结束时间:&nbsp&nbsp&nbsp<%=ped%></p><br>
                    <p >状态:&nbsp&nbsp&nbsp<%=pty%></p><br>
                    <p >实习单位:&nbsp&nbsp&nbsp<%=pun%></p><br>
                    <p >单位电话:&nbsp&nbsp&nbsp<%=pup%></p><br>
                </div>
                    <% }
                    %>
            </div>
        </div>
    </div>
</div>
</body>
</html>