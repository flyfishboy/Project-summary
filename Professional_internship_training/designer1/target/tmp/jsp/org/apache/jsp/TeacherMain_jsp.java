/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.8.v20171121
 * Generated at: 2019-01-17 04:22:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cn.keshe.entity.Student;

public final class TeacherMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("cn.keshe.entity.Student");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>实习实训管理系统</title>\r\n");
      out.write("    <script src=\"http://libs.baidu.com/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        body,ul,div,img,h5,h4,h3,h2,h1,p,span,table,figure,i,li{ margin:0; padding:0}/*设置所有标签的内外边距为0*/\r\n");
      out.write("        .header{/*标题模块*/\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            height: 150px;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 15%;\r\n");
      out.write("        }\r\n");
      out.write("        .header1-1{\r\n");
      out.write("            width: 45%;\r\n");
      out.write("            height: 120px;\r\n");
      out.write("            float: left;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 4%;\r\n");
      out.write("        }\r\n");
      out.write("        .header1-1 p{\r\n");
      out.write("            font-size: 40px;\r\n");
      out.write("            margin-top: 40px;\r\n");
      out.write("            color: #131215;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .header1-2{\r\n");
      out.write("            width: 45%;\r\n");
      out.write("            height: 120px;\r\n");
      out.write("            float: left;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 4%;\r\n");
      out.write("        }\r\n");
      out.write("        .header1-2 p{\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            color: black;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        .header1-2 li{\r\n");
      out.write("            margin: 10px;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 40%;\r\n");
      out.write("        }\r\n");
      out.write("        .header1-2 a{\r\n");
      out.write("            color: black;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .header1-2 a:hover{\r\n");
      out.write("            color: #f60;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        .header1-2 a:active{\r\n");
      out.write("            color: #ff6633;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        .contmain{/*内容模块*/\r\n");
      out.write("            width: 60%;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 20%;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        .nav{//**导航栏**//\r\n");
      out.write("        width: 100%;\r\n");
      out.write("            line-height:40px;\r\n");
      out.write("            margin:auto;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        .nav ul{\r\n");
      out.write("            list-style:none;\r\n");
      out.write("            margin:auto;\r\n");
      out.write("            width:100%;\r\n");
      out.write("        }\r\n");
      out.write("        .nav ul li{\r\n");
      out.write("            float:left;\r\n");
      out.write("            width:111px;\r\n");
      out.write("            padding-left: 20px;\r\n");
      out.write("            padding-right: 20px;\r\n");
      out.write("            text-align:center;\r\n");
      out.write("            background: #aed5e1;\r\n");
      out.write("            color: #f1ffbb;\r\n");
      out.write("            font-weight:bold;\r\n");
      out.write("        }\r\n");
      out.write("        .nav ul li a{/*设置导航栏字体属性*/\r\n");
      out.write("            display:block;\r\n");
      out.write("            color:#131215;\r\n");
      out.write("            -webkit-transition: all 0.5s;\r\n");
      out.write("            -moz-transition: all 0.5s;\r\n");
      out.write("            -o-transition: all 0.5s;\r\n");
      out.write("            -ms-transition: all 0.5s;\r\n");
      out.write("            text-decoration:none\r\n");
      out.write("        }\r\n");
      out.write("        .nav ul li a:hover{/* 背景颜色过渡效果 */\r\n");
      out.write("            background: #06adff;\r\n");
      out.write("            color: #f1ffbb;\r\n");
      out.write("            font-weight:bold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .box2 {\r\n");
      out.write("\r\n");
      out.write("            overflow:hidden;\r\n");
      out.write("            position:relative;\r\n");
      out.write("        }\r\n");
      out.write("        .box-go2 {\r\n");
      out.write("            position:relative;\r\n");
      out.write("        }\r\n");
      out.write("        .box-go2 li {\r\n");
      out.write("            position:relative;\r\n");
      out.write("            list-style:none;\r\n");
      out.write("            float:left;\r\n");
      out.write("        }\r\n");
      out.write("        .box-go2 img {\r\n");
      out.write("            width:100%;\r\n");
      out.write("            position:relative;\r\n");
      out.write("            top:0;\r\n");
      out.write("        }\r\n");
      out.write("        .box2 .quan {\r\n");
      out.write("            position:absolute;\r\n");
      out.write("            bottom:30px;\r\n");
      out.write("            left:40%;\r\n");
      out.write("            z-index:30;\r\n");
      out.write("            height:20px;\r\n");
      out.write("        }\r\n");
      out.write("        .box2 i {\r\n");
      out.write("            display:inline-block;\r\n");
      out.write("            width:20px;\r\n");
      out.write("            height:20px;\r\n");
      out.write("            border-radius:50%;\r\n");
      out.write("            background:gray;\r\n");
      out.write("            margin:0 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .quan .red {\r\n");
      out.write("            background:red;\r\n");
      out.write("        }\r\n");
      out.write("        .conten{\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("        .news{\r\n");
      out.write("            width: 48%;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            float: left;\r\n");
      out.write("            height: 200px;\r\n");
      out.write("            background-color: white;\r\n");
      out.write("        }\r\n");
      out.write("        #newscont{\r\n");
      out.write("            position: relative;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("        .newscont li{\r\n");
      out.write("            font-size: 10px;\r\n");
      out.write("            display: inline-list-item;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 20px;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            list-style: none;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .newscont  a{\r\n");
      out.write("            display:block;\r\n");
      out.write("            color:#131215;\r\n");
      out.write("            -webkit-transition: all 0.5s;\r\n");
      out.write("            -moz-transition: all 0.5s;\r\n");
      out.write("            -o-transition: all 0.5s;\r\n");
      out.write("            -ms-transition: all 0.5s;\r\n");
      out.write("            text-decoration:none;\r\n");
      out.write("        }\r\n");
      out.write("        .newscont a:hover{\r\n");
      out.write("            color: #05f5ed;\r\n");
      out.write("            font-weight:bold;\r\n");
      out.write("        }\r\n");
      out.write("        .dynam{\r\n");
      out.write("            width: 48%;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            float: left;\r\n");
      out.write("            margin-left: 15px;\r\n");
      out.write("            height: 200px;\r\n");
      out.write("            background-color: white;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"margin: 0px;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height:100%;\r\n");
      out.write("    background-image: url(image2/body1.png);\r\n");
      out.write("    background-repeat: no-repeat;\r\n");
      out.write("    background-position: center top;\r\n");
      out.write("    background-size: 100% 100%;\">\r\n");

    String id= (String) request.getSession().getAttribute("id");
    String name= (String) request.getSession().getAttribute("name");

      out.write("\r\n");
      out.write("<div class=\"all\" >\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("        <div class=\"header1-1\">\r\n");
      out.write("            <p>实习实训管理系统</p><br>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"header1-2\">\r\n");
      out.write("            <div style=\"margin-top: 20px\">\r\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&nbsp您好！欢迎使用本系统！</p><br>\r\n");
      out.write("                <u1 >\r\n");
      out.write("                    <li ><a href=\"/login.jsp\" style=\"decoration: none\">注销</a></li>\r\n");
      out.write("                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                        <li>/<a href=\"/altpassword.jsp\" style=\"decoration: none\">修改密码</a></li>\r\n");
      out.write("                    </c:if>\r\n");
      out.write("                </u1>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"contmain\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"nav\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li id=\"li1\"><a href=\"TeacherMain.jsp\">首页</a></li>\r\n");
      out.write("                <li><a href=\"t_see_msgSerlvet\">个人信息</a></li>\r\n");
      out.write("                <li><a href=\"t_seeP_applyServlet\">审核申请</a></li>\r\n");
      out.write("                <li><a href=\"t_seeWorkServlet\">周记批阅</a></li>\r\n");
      out.write("                <li><a href=\"t_seePracticeServlet?t_id=");
      out.print(id);
      out.write("\">实习管理</a></li>\r\n");
      out.write("                <li><a href=\"t_s_seemsgServlet\">学生信息管理</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"box2\">\r\n");
      out.write("            <ul class=\"box-go2\">\r\n");
      out.write("                <li><img src=\"/images/B2.jpg\" alt=\"\"></li>\r\n");
      out.write("                <li><img src=\"/images/B7.jpg\" alt=\"\"></li>\r\n");
      out.write("                <li><img src=\"/images/B8.jpg\" alt=\"\"></li>\r\n");
      out.write("                <li><img src=\"/images/B2.jpg\" alt=\"\"></li>\r\n");
      out.write("                <li><img src=\"/images/B6.jpg\" alt=\"\"></li>\r\n");
      out.write("                <li><img src=\"/images/B6.jpg\" alt=\"\"></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"quan\">\r\n");
      out.write("                <i></i>\r\n");
      out.write("                <i></i>\r\n");
      out.write("                <i></i>\r\n");
      out.write("                <i></i>\r\n");
      out.write("                <i></i>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"conten\">\r\n");
      out.write("            <div class=\"news\">\r\n");
      out.write("                <div style=\"width: 100%;line-height: 30px;background-color: lavender;margin-bottom: 10px\">\r\n");
      out.write("                    <p style=\"position: relative;left: 40%\">实习公告</p>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"newscont\" id=\"newscont\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"\">软件学院走访实习学生基地报道一-----------------------2019.1.8</a></li>\r\n");
      out.write("                        <li><a href=\"\">软件学院走访实习学生基地报道二-----------------------2019.1.8</a></li>\r\n");
      out.write("                        <li><a href=\"\">材料学院走访实习学生基地报道三-----------------------2019.1.8</a></li>\r\n");
      out.write("                        <li><a href=\"\">音乐学院走访实习学生基地报道四-----------------------2019.1.8</a></li>\r\n");
      out.write("                        <li><a href=\"\">土建学院走访实习学生基地报道一-----------------------2019.1.8</a></li>\r\n");
      out.write("                        <li><a href=\"\">航制学院走访实习学生基地报道一-----------------------2019.1.8</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"dynam\">\r\n");
      out.write("                <div style=\"width: 100%;line-height: 30px;background-color: lavender\">\r\n");
      out.write("                    <p style=\"position: relative;left: 40%\">企业信息</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"newscont\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"\">杭州君意阁电子商务有限公司招聘-----------------------2019.1.5</a></li>\r\n");
      out.write("                        <li><a href=\"\">上海信而富企业管理有限公司招聘-----------------------2019.1.1</a></li>\r\n");
      out.write("                        <li><a href=\"\">甬港现代工程有限公司招聘信息-----------------------2019.1.7</a></li>\r\n");
      out.write("                        <li><a href=\"\">浙江天骏纺织有限公司招聘简介-----------------------2019.1.3</a></li>\r\n");
      out.write("                        <li><a href=\"\">杭州掌医网络科技有限公司招聘-----------------------2019.1.1</a></li>\r\n");
      out.write("                        <li><a href=\"\">杭州恒生网络科技有限公司招聘-----------------------2019.1.7</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    var z = $(\".box-go li\").length //获得box-go里的li数量\r\n");
      out.write("    var x = 900 //获取窗口的宽，$(window).width()\r\n");
      out.write("    var y = 0.2 * x //这里的计算公式是根据图标宽高比例得到的\r\n");
      out.write("    var b = $(\".box-go2 li\").length //获取li的个数\r\n");
      out.write("    $(\".box2\").css(\"width\", x); //大盒子的宽\r\n");
      out.write("    $(\".box2\").css(\"height\", y); //大盒子的高，var y = 0.25*x\t\t//这里的计算公式是根据图标宽高比例得到的\r\n");
      out.write("    $(\".box-go2\").css(\"width\", b * x); //装图片文字的大盒子ul的宽=窗口的宽*li的个数\r\n");
      out.write("    $(\".box-go2 li\").css(\"width\", x); //li的宽\r\n");
      out.write("    var a = 0\r\n");
      out.write("    //document.title = b\r\n");
      out.write("    $(\".quan i\").eq(0).addClass(\"red\")\r\n");
      out.write("\r\n");
      out.write("    //右边按钮部分\r\n");
      out.write("    $(\".btn2-r\").click(function() { //朝左\r\n");
      out.write("        if (a < (b - 2)) {\r\n");
      out.write("            a = a + 1;\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(a).addClass(\"red\")\r\n");
      out.write("        } else if (a < (b - 1)) {\r\n");
      out.write("            a = a + 1;\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(0).addClass(\"red\")\r\n");
      out.write("        } else {\r\n");
      out.write("            a = 1\r\n");
      out.write("            $(\".box-go2\").css(\"left\", 0);\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(1).addClass(\"red\")\r\n");
      out.write("        }\r\n");
      out.write("        $(\".box-go2\").stop().animate({\r\n");
      out.write("            left: -x * a\r\n");
      out.write("        })\r\n");
      out.write("    }).mouseleave(function() {\r\n");
      out.write("        ee = a\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("    ///左边按钮部分\r\n");
      out.write("    $(\".btn2-l\").click(function() { //朝右\r\n");
      out.write("        if (a > 1) { //为了保留重复的第一张，显示红点\r\n");
      out.write("            a = a - 1\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(a).addClass(\"red\") //这里是中间部分的显示\r\n");
      out.write("        } else if (a > 0) {\r\n");
      out.write("            a = a - 1 //对应的这里到了第一张图片，所以要把第一个点显示出来\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(0).addClass(\"red\")\r\n");
      out.write("        } else {\r\n");
      out.write("            a = b - 2 //这里是最右边，第5个点的显示\r\n");
      out.write("            $(\".box-go2\").css(\"left\", -x * (a + 1))\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(b - 2).addClass(\"red\")\r\n");
      out.write("        };\r\n");
      out.write("        $(\".box-go2\").stop().animate({\r\n");
      out.write("            left: -x * a\r\n");
      out.write("        });\r\n");
      out.write("    }).mouseleave(function() {\r\n");
      out.write("        ee = a\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("    $(\".quan i\").mouseenter(function() {\r\n");
      out.write("        var d = $(this).index();\r\n");
      out.write("        $(\".box-go2\").stop().animate({\r\n");
      out.write("            left: -x * d\r\n");
      out.write("        });\r\n");
      out.write("        $(\".quan i\").removeClass(\"red\").eq(d).addClass(\"red\");\r\n");
      out.write("        ee = d\r\n");
      out.write("        a = d\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("    var ee = 0\r\n");
      out.write("    var tt = setInterval(function() {\r\n");
      out.write("        if (ee < (b - 2)) {\r\n");
      out.write("            ee = ee + 1\r\n");
      out.write("\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(ee).addClass(\"red\")\r\n");
      out.write("        } else if (ee < (b - 1)) {\r\n");
      out.write("            ee = ee + 1;\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(0).addClass(\"red\")\r\n");
      out.write("        } else {\r\n");
      out.write("            ee = 1\r\n");
      out.write("            $(\".box-go2\").css(\"left\", 0);\r\n");
      out.write("            $(\".quan i\").removeClass(\"red\").eq(1).addClass(\"red\")\r\n");
      out.write("        }\r\n");
      out.write("        $(\".box-go2\").animate({\r\n");
      out.write("            left: -x * ee\r\n");
      out.write("        });\r\n");
      out.write("    }, 2000)\r\n");
      out.write("\r\n");
      out.write("    $(\".box2\").mouseenter(function() {\r\n");
      out.write("        clearInterval(tt)\r\n");
      out.write("        a = ee\r\n");
      out.write("    }).mouseleave(function() {\r\n");
      out.write("        tt = setInterval(function() {\r\n");
      out.write("            if (ee < (b - 2)) {\r\n");
      out.write("                ee = ee + 1\r\n");
      out.write("\r\n");
      out.write("                $(\".quan i\").removeClass(\"red\").eq(ee).addClass(\"red\")\r\n");
      out.write("            } else if (ee < (b - 1)) {\r\n");
      out.write("                ee = ee + 1;\r\n");
      out.write("                $(\".quan i\").removeClass(\"red\").eq(0).addClass(\"red\")\r\n");
      out.write("            } else {\r\n");
      out.write("                ee = 1\r\n");
      out.write("                $(\".box-go2\").css(\"left\", 0);\r\n");
      out.write("                $(\".quan i\").removeClass(\"red\").eq(1).addClass(\"red\")\r\n");
      out.write("            }\r\n");
      out.write("            $(\".box-go2\").animate({\r\n");
      out.write("                left: -x * ee\r\n");
      out.write("            });\r\n");
      out.write("        }, 2000)\r\n");
      out.write("    })\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
