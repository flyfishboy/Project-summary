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
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
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
            width:12%;
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

        .box2 {

            overflow:hidden;
            position:relative;
        }
        .box-go2 {
            position:relative;
        }
        .box-go2 li {
            position:relative;
            list-style:none;
            float:left;
        }
        .box-go2 img {
            width:100%;
            position:relative;
            top:0;
        }
        .box2 .quan {
            position:absolute;
            bottom:30px;
            left:40%;
            z-index:30;
            height:20px;
        }
        .box2 i {
            display:inline-block;
            width:20px;
            height:20px;
            border-radius:50%;
            background:gray;
            margin:0 10px;
        }
        .quan .red {
            background:red;
        }
        .conten{
            width: 100%;
        }
        .news{
            width: 48%;
            position: relative;
            float: left;
            height: 200px;
            background-color: white;
        }
        #newscont{
            position: relative;
            float: left;
        }
        .newscont li{
            font-size: 10px;
            display: inline-list-item;
            position: relative;
            left: 20px;
            text-decoration: none;
            list-style: none;
            margin-top: 10px;
        }

        .newscont  a{
            display:block;
            color:#131215;
            -webkit-transition: all 0.5s;
            -moz-transition: all 0.5s;
            -o-transition: all 0.5s;
            -ms-transition: all 0.5s;
            text-decoration:none;
        }
        .newscont a:hover{
            color: #05f5ed;
            font-weight:bold;
        }
        .dynam{
            width: 48%;
            position: relative;
            float: left;
            margin-left: 15px;
            height: 200px;
            background-color: white;
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
    String sex= (String) request.getSession().getAttribute("sex");
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
        <div class="box2">
            <ul class="box-go2">
                <li><img src="/images/B2.jpg" alt=""></li>
                <li><img src="/images/B7.jpg" alt=""></li>
                <li><img src="/images/B8.jpg" alt=""></li>
                <li><img src="/images/B2.jpg" alt=""></li>
                <li><img src="/images/B6.jpg" alt=""></li>
                <li><img src="/images/B6.jpg" alt=""></li>
            </ul>
            <div class="quan">
                <i></i>
                <i></i>
                <i></i>
                <i></i>
                <i></i>
            </div>
        </div>
        <div class="conten">
            <div class="news">
                <div style="width: 100%;line-height: 30px;background-color: lavender;margin-bottom: 10px">
                    <p style="position: relative;left: 40%">实习公告</p>

                </div>
                <div class="newscont" id="newscont">
                    <ul>
                        <li><a href="">软件学院走访实习学生基地报道一-----------------------2019.1.8</a></li>
                        <li><a href="">软件学院走访实习学生基地报道二-----------------------2019.1.8</a></li>
                        <li><a href="">材料学院走访实习学生基地报道三-----------------------2019.1.8</a></li>
                        <li><a href="">音乐学院走访实习学生基地报道四-----------------------2019.1.8</a></li>
                        <li><a href="">土建学院走访实习学生基地报道一-----------------------2019.1.8</a></li>
                        <li><a href="">航制学院走访实习学生基地报道一-----------------------2019.1.8</a></li>
                    </ul>
                </div>
            </div>
            <div class="dynam">
                <div style="width: 100%;line-height: 30px;background-color: lavender">
                    <p style="position: relative;left: 40%">企业信息</p>
                </div>
                <div class="newscont">
                    <ul>
                        <li><a href="">杭州君意阁电子商务有限公司招聘-----------------------2019.1.5</a></li>
                        <li><a href="">上海信而富企业管理有限公司招聘-----------------------2019.1.1</a></li>
                        <li><a href="">甬港现代工程有限公司招聘信息-----------------------2019.1.7</a></li>
                        <li><a href="">浙江天骏纺织有限公司招聘简介-----------------------2019.1.3</a></li>
                        <li><a href="">杭州掌医网络科技有限公司招聘-----------------------2019.1.1</a></li>
                        <li><a href="">杭州恒生网络科技有限公司招聘-----------------------2019.1.7</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>


</div>
</body>
<script>
    var z = $(".box-go li").length //获得box-go里的li数量
    var x = 900 //获取窗口的宽，$(window).width()
    var y = 0.2 * x //这里的计算公式是根据图标宽高比例得到的
    var b = $(".box-go2 li").length //获取li的个数
    $(".box2").css("width", x); //大盒子的宽
    $(".box2").css("height", y); //大盒子的高，var y = 0.25*x		//这里的计算公式是根据图标宽高比例得到的
    $(".box-go2").css("width", b * x); //装图片文字的大盒子ul的宽=窗口的宽*li的个数
    $(".box-go2 li").css("width", x); //li的宽
    var a = 0
    //document.title = b
    $(".quan i").eq(0).addClass("red")

    //右边按钮部分
    $(".btn2-r").click(function() { //朝左
        if (a < (b - 2)) {
            a = a + 1;
            $(".quan i").removeClass("red").eq(a).addClass("red")
        } else if (a < (b - 1)) {
            a = a + 1;
            $(".quan i").removeClass("red").eq(0).addClass("red")
        } else {
            a = 1
            $(".box-go2").css("left", 0);
            $(".quan i").removeClass("red").eq(1).addClass("red")
        }
        $(".box-go2").stop().animate({
            left: -x * a
        })
    }).mouseleave(function() {
        ee = a
    })

    ///左边按钮部分
    $(".btn2-l").click(function() { //朝右
        if (a > 1) { //为了保留重复的第一张，显示红点
            a = a - 1
            $(".quan i").removeClass("red").eq(a).addClass("red") //这里是中间部分的显示
        } else if (a > 0) {
            a = a - 1 //对应的这里到了第一张图片，所以要把第一个点显示出来
            $(".quan i").removeClass("red").eq(0).addClass("red")
        } else {
            a = b - 2 //这里是最右边，第5个点的显示
            $(".box-go2").css("left", -x * (a + 1))
            $(".quan i").removeClass("red").eq(b - 2).addClass("red")
        };
        $(".box-go2").stop().animate({
            left: -x * a
        });
    }).mouseleave(function() {
        ee = a
    })

    $(".quan i").mouseenter(function() {
        var d = $(this).index();
        $(".box-go2").stop().animate({
            left: -x * d
        });
        $(".quan i").removeClass("red").eq(d).addClass("red");
        ee = d
        a = d
    })

    var ee = 0
    var tt = setInterval(function() {
        if (ee < (b - 2)) {
            ee = ee + 1

            $(".quan i").removeClass("red").eq(ee).addClass("red")
        } else if (ee < (b - 1)) {
            ee = ee + 1;
            $(".quan i").removeClass("red").eq(0).addClass("red")
        } else {
            ee = 1
            $(".box-go2").css("left", 0);
            $(".quan i").removeClass("red").eq(1).addClass("red")
        }
        $(".box-go2").animate({
            left: -x * ee
        });
    }, 2000)

    $(".box2").mouseenter(function() {
        clearInterval(tt)
        a = ee
    }).mouseleave(function() {
        tt = setInterval(function() {
            if (ee < (b - 2)) {
                ee = ee + 1

                $(".quan i").removeClass("red").eq(ee).addClass("red")
            } else if (ee < (b - 1)) {
                ee = ee + 1;
                $(".quan i").removeClass("red").eq(0).addClass("red")
            } else {
                ee = 1
                $(".box-go2").css("left", 0);
                $(".quan i").removeClass("red").eq(1).addClass("red")
            }
            $(".box-go2").animate({
                left: -x * ee
            });
        }, 2000)
    })
</script>
</html>
