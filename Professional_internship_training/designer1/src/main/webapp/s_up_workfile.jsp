<%--
  Created by IntelliJ IDEA.
  User: 石立山
  Date: 2019/1/12
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cn.keshe.entity.Student" %>
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
        width: 98.5%;
        position: relative;
        float: left;
        height: 100%;
        background-color: lavender;
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
    String id= request.getParameter("id");
    String tid= request.getParameter("t_id");
    String tit=request.getParameter("tit");
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
            <div class="opshow" style="text-align: center">
                <%
                    String mes=(String)request.getAttribute("mes");
                %>
                <form method="post" action="s_upworkServlet" enctype="multipart/form-data">
                        <tr>
                            <td align="center"></td>
                            <td >反馈信息： <%=mes%></td>
                        </tr><br>
                        <input type="text" value="<%=tid %>" style="display: none" name="t_id">
                        <input type="text" value="<%=tit %>" style="display: none" name="tit">
                        <input type="text" value="<%=id %>"style="display: none"  name="id">
                        <tr>
                            <td > <textarea name="m_content"  placeholder="输入内容" cols="50" rows="15" style="resize: none" ></textarea>
                            </td>
                        </tr><br>
                        <tr>
                            <td align="right">选择文件：</td>
                            <td > <input type="file" name="file1"></td>
                        </tr>
                        <tr>
                            <td > <input type="submit" value="开始上传" onclick=""></td>
                        </tr>
                        <tr>
                            <td height="40" colspan="2"></td>
                        </tr>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>