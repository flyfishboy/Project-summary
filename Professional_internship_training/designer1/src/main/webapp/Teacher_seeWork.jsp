<%--
  Created by IntelliJ IDEA.
  User: 石立山
  Date: 2019/1/12
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cn.keshe.entity.Student" %>
<%@ page import="cn.keshe.entity.Practice" %>
<%@ page import="cn.keshe.entity.Practice_work" %>
<%@ page import="java.util.List" %>
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
        .opshow p{
            position: relative;
            left: 20%;
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
System.out.println(id);
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
            <div class="opshow" style="background-color: white" align="center">

                <br>
                <div style="background-color: lavender;width: 100%">
                    <p style="position: relative;float: left;width: 20%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">任务名称</p>
                    <p style="position: relative;float: left;width: 15%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">任务内容</p>
                    <p style="position: relative;float: left;width: 20%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">任务截止时间</p>

                </div>
                <%
                    response.setContentType("text/html;charset=UTF-8");
                    List<Practice_work> list=(List<Practice_work>) request.getAttribute("list");
                    if(list==null){
                        out.print("没有数据");
                    }else{
                        int totalPages=Integer.parseInt(""+request.getAttribute("totalPages"));
                        totalPages=(totalPages-1)*5;
                        for (int i=0;i<5&&totalPages<list.size();i++){
                            Practice_work message=list.get(totalPages);
                            totalPages++;
                %>
                <div style="margin-top: 30px;text-align: center">
                    <br>
                    <p style="position: relative;float: left;width: 20%"><%=message.getM_title()%></p>
                    <p style="position: relative;float: left;width: 15%"><%=message.getM_content() %></p>
                    <p style="position: relative;float: left;width: 20%"><%=message.getM_date()%></p>

                    <div style="position: relative;width: 20%;float: left ;margin-left: 60px">

                        <form method="post" action="t_downfileServlet" style="float:right">
                            <input type="text" value="<%=message.getM_title() %>" style="display: none" name="tit">
                            <input type="text" value="<%=message.getM_date() %>" style="display: none" name="date">
                            <input type="text" value="<%=id %>" style="display: none" name="tid">
                            <input type="submit" value="进入" style="font-size: 12px;margin-left: 30px">
                        </form>

                    </div>
                    <%	}
                    } %>


                    </div>

                </div>

            <div style="width: 60%;position: relative;left: 20%;background-color: #05f5ed" class="feye">
                <%
                    for (int i = 1; i <= (list.size() % 5==0?list.size() / 5:list.size() / 5+1); i++) {
                %>
                <a href="t_see_workServlet?page=<%=i%>" style="position: relative;width: 50px;float: left;"><%=i%></a>
                <%
                    }
                %>

            </div>


        </div>
    </div>
</div>
</body>
</html>