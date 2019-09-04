<%@ page import="cn.keshe.entity.Student" %>

<%@ page import="cn.keshe.entity.Teacher" %>
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
            height: 120%;
            background-color: lavender;
        }
        .opshow1{
            position: relative;
            left: 10%;
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
    String name= (String) request.getSession().getAttribute("name");
    String id= (String) request.getSession().getAttribute("id");
    String aname= (String) request.getSession().getAttribute("aname");
    String apsd= (String) request.getSession().getAttribute("apsd");
    String aid= (String) request.getSession().getAttribute("aid");
    String asex= (String) request.getSession().getAttribute("asex");
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

                </u1>
            </div>
        </div>
    </div>



    <div class="contmain">

        <div class="matter">
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
            <div class="opshow" align="center">

<div class="opshow1">

                <br>
                <div style="background-color: lavender;width: 100%">
                    <p style="position: relative;float: left;width: 8%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">回访顺序</p>
                    <p style="position: relative;float: left;width: 8%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">单位名称</p>
                    <p style="position: relative;float: left;width: 9%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">经度</p>
                    <p style="position: relative;float: left;width: 10%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">纬度</p>

                </div>
                <%
                    response.setContentType("text/html;charset=UTF-8");
                    String[] x=(String []) request.getAttribute("list");
                    if (x[0].equals("-1")){
                        out.print("没有数据");
                    }else{

                            System.out.println("需要："+x[0]+"米");
                            for (int x1=1,shun=1;x1<x.length;x1=x1+3,shun++){
                                System.out.println(x[x1]+"  "+x[x1+1]+"  "+x[x1+2]);
                %>
                <div style="margin-top: 30px;text-align: center">
                    <br>
                    <p style="position: relative;float: left;width: 10%"><%=shun%></p>
                    <p style="position: relative;float: left;width: 10%"><%=x[x1+2]%></p>
                    <p style="position: relative;float: left;width: 6%"><%=x[x1+0] %></p>
                    <p style="position: relative;float: left;width: 6%"><%=x[x1+1] %></p>
                    <br>

                    <div style="position: relative;width: 53%;float: left">



                    </div>
                    <%
                        }
                        }
                        if (!x[0].equals("-1")){
                    %>
                    <p style="position: relative;float: left;width: 20%;line-height: 30px;background-color: lavender;text-align: center;margin-top: 30px">最短遍历距离： <%=x[0]%>  公里</p>
                    <%
                        }
                    %>

                </div>

</div>

            </div>
        </div>

    </div>
</div>
</body>
</html>