
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page import="cn.keshe.entity.Student" %>
<%@ page import="cn.keshe.entity.Teacher" %>
<%@ page import="java.util.List" %>
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
    String id= (String) request.getSession().getAttribute("id");
    String name= (String) request.getSession().getAttribute("name");
    String sex= (String) request.getSession().getAttribute("asex");
    String birthday= (String) request.getSession().getAttribute("birthday");
    //String password= (String) request.getAttribute("");
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
                <li id="li1"><a href="AdminMain.jsp">首页</a></li>
                <li><a href="a_see_msgSerlvet">个人信息</a></li>
                <li><a href="chartServlet">实习统计</a></li>
                <li><a href="a_t_find_Servlet">教师管理</a></li>
                <li><a href="a_find_Servlet">管理员信息</a></li>
                <li><a href="">更多</a></li>
            </ul>
        </div>
        <div class="matter">
            <div class="opshow" style="background-color: white" align="center">

                <a href="AdminAddTeacher.jsp" >添加教师信息</a>
                <a href="uploadExcel.jsp" >Excel批量导入教师信息</a>
               <form action="a_t_find_Servlet" method="post">
                    <input type="text" name="cname"  >
                    <input type="submit" value="按模糊查找" >
                </form>

                <div style="background-color: lavender;width: 100%">
                    <p style="position: relative;float: left;width: 8%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">工号</p>
                    <p style="position: relative;float: left;width: 9%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">姓名</p>
                    <p style="position: relative;float: left;width: 10%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">密码</p>
                    <p style="position: relative;float: left;width: 6%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">性别</p>
                    <p style="position: relative;float: left;width: 13%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">出生</p>
                    <p style="position: relative;float: left;width: 13%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">专业</p>
                    <p style="position: relative;float: left;width: 13%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">电话号</p>
                    <p style="position: relative;float: left;width: 13%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">QQ</p>
                    <p style="position: relative;float: left;width: 14%;line-height: 30px;background-color: lavender;border-right: #333333 solid 1px;text-align: center">操作</p>
                </div>
                <%
                    response.setContentType("text/html;charset=UTF-8");
                    List<Teacher> list=(List<Teacher>) request.getAttribute("list");
                    if(list==null){
                        out.print("没有数据");
                    }else{
                        int totalPages=Integer.parseInt(""+request.getAttribute("totalPages"));
                        totalPages=(totalPages-1)*7;
                        for (int i=0;i<7&&totalPages<list.size();i++){
                            Teacher message=list.get(totalPages);
                            totalPages++;
                %>
                <div style="margin-top: 30px;text-align: center">
                    <p style="position: relative;float: left;width: 10%"><%=message.getT_id()%></p>
                    <p style="position: relative;float: left;width: 6%"><%=message.getT_name() %></p>
                    <p style="position: relative;float: left;width: 14%"><%=message.getT_password() %></p>
                    <p style="position: relative;float: left;width: 1%"><%=message.getT_sex() %></p>
                    <p style="position: relative;float: left;width: 17%"><%=message.getT_birthday() %></p>
                    <p style="position: relative;float: left;width: 11%"><%=message.getT_profession() %></p>
                    <p style="position: relative;float: left;width: 13%"><%=message.getT_phone() %></p>
                    <p style="position: relative;float: left;width: 13%"><%=message.getT_qq() %></p>
                    <div style="position: relative;width: 13%;float: left">

                       <form method="post" action="a_t_del_Servlet" style="float:right">
                            <input type="text" value="<%=message.getT_id() %>" style="display: none" name="t_id">
                            <input type="submit" value="删除" style="font-size: 12px;">
                        </form>
                        <form method="post" action="a_t_find_updateServlet" style="float:right">
                            <input type="text" value="<%=message.getT_id() %>" style="display: none" name="tid">
                            <input type="submit" value="修改" style="font-size: 12px;">
                        </form>
                    </div>

                    <%	}
                    } %>
                </div>
                <div style="float: left;width: 55%;position: relative;left: 20%">
                    <%
                        for (int i = 1; i <= (list.size() % 7==0?list.size() / 7:list.size() / 7+1); i++) {
                    %>
                    <a href="a_t_find_Servlet?page=<%=i%>" style="position: relative;width: 100px"><%=i %></a>
                    <%
                        }
                    %>
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
