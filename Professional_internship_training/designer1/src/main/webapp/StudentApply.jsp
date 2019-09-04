
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page import="cn.keshe.entity.Student" %>
    <%@ page import="cn.keshe.entity.Teacher" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>实习实训管理系统</title>
        <style>                               /*管理员查询所有教师，并可跳转其他增删改*/
        body,ul,div,img,h5,h4,h3,h2,h1,p,span,table,figure,i,li{ margin:0; padding:0}/*设置所有标签的内外边距为0*/
        .header{/*标题模块*/
            width: 70%;
            height: 150px;
            position: relative;
            left: 15%;
        }
        td, th {
            text-align: center;
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
            width:15.4%;
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
            width: 98.5%;
            position: relative;
            float: left;
            height: 100%;
            background-color: lavender;
        }
            .opshow form p{
                position: relative;
                width: 48%;
                float: left;
            }
            .opshow1{
                width: 60%;
                position: relative;
            }
        .opshow1 form input{
            position: relative;
            width: 48%;
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
    String tid= (String) request.getSession().getAttribute("teaid");
    String sex= (String) request.getSession().getAttribute("sex");
    String birthday= (String) request.getSession().getAttribute("birthday");
    String tname= (String) request.getAttribute("tea");
    //String password= (String) request.getAttribute("");
    request.setAttribute("id",id);
    Date da=new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date = df.format(da);
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
            <div class="opshow" style="background-color: white" align="center">
                <div class="opshow1" >
                <form  action="s_add_apply_Servlet" method="post" style="margin-top: 40px">
                    <p>学号：</p><p><%=id%></p><input type="hidden" name="id" value="<%=id%>">
                    <p>姓名：</p><p><%=name%></p><input type="hidden" name="name" value="<%=name%>">
                    <p>性别：</p><p><%=sex%></p><input type="hidden" name="sex" value="<%=sex%>">
                   <input type="hidden" value="<%=date%>" name="date">
                    <input type="hidden" value="false" name="state">
                    <input type="hidden" name="tid" value="<%=tid%>">
                    <p >实习开始时间：</p><input type="date" name="pbd" value="">
                    <p >实习结束时间：</p><input type="date" name="ped" value="">
                    <input type="hidden" value="还未实习" name="pyp" >
                    <p >实习单位：</p><br><input type="text" name="pun" value="">
                    <p >单位电话：</p><br><input type="text" name="pup" value="">
                    <input style="position: relative;left: 50%;width: 100px;margin-top: 30px" type="submit" value="提交">
                </form>
                </div>
            </div>

        </div>

    </div>
</div>
</body>
</html>
<title>Title</title>
</head>
<body>

</body>
</html>
