/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.8.v20171121
 * Generated at: 2019-01-17 12:46:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cn.keshe.entity.Student;

public final class Teacheruppassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            height: 500px;\r\n");
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
      out.write("        .matter{\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 400px;\r\n");
      out.write("        }\r\n");
      out.write("        .operation{/*功能选择栏*/\r\n");
      out.write("            width: 25%;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            margin-right:5px ;\r\n");
      out.write("            float: left;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background-color: lavender;\r\n");
      out.write("        }\r\n");
      out.write("        .operation li{\r\n");
      out.write("            margin: 10px;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            display: inline-list-item;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            list-style: none;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .operation a{\r\n");
      out.write("            display:block;\r\n");
      out.write("            color:#131215;\r\n");
      out.write("            -webkit-transition: all 0.5s;\r\n");
      out.write("            -moz-transition: all 0.5s;\r\n");
      out.write("            -o-transition: all 0.5s;\r\n");
      out.write("            -ms-transition: all 0.5s;\r\n");
      out.write("            text-decoration:none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .operation a:hover{\r\n");
      out.write("            font-weight:bold;\r\n");
      out.write("        }\r\n");
      out.write("        .operation a:active{\r\n");
      out.write("            color: #ff6633;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        .opshow{/*显示功能栏*/\r\n");
      out.write("            width: 72%;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            float: left;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background-color: lavender;\r\n");
      out.write("        }\r\n");
      out.write("        .opshow p{\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 9%;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .opshow form{\r\n");
      out.write("            width: 60%;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 20%;\r\n");
      out.write("        }\r\n");
      out.write("        .opshow input{\r\n");
      out.write("            margin-top: 10px;\r\n");
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
    String sex= (String) request.getSession().getAttribute("sex");
    String password= (String) request.getSession().getAttribute("password");
    String birthday= (String) request.getSession().getAttribute("birth");
    String profession= (String)  request.getSession().getAttribute("profess");
    String phone= (String)  request.getSession().getAttribute("telphone");
    String qq= (String)  request.getSession().getAttribute("q1");
    request.setAttribute("id",id);

      out.write("\r\n");
      out.write("<div class=\"all\" >\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("        <div class=\"header1-1\">\r\n");
      out.write("            <p>实习实训管理系统</p><br>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"header1-2\">\r\n");
      out.write("            <div style=\"margin-top: 20px\">\r\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&nbsp您好！欢迎使用本系统！</p><br>\r\n");
      out.write("                <u1 >\r\n");
      out.write("                    <li ><a href=\"/login.jsp\" style=\"decoration: none\">注销</a></li>\r\n");
      out.write("                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                        <li>/<a href=\"Teacheruppassword.jsp\" style=\"decoration: none\">修改密码</a></li>\r\n");
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
      out.write("        <div class=\"matter\">\r\n");
      out.write("            <div class=\"operation\" style=\"text-align: center\">\r\n");
      out.write("                <div style=\"margin-top: 20px;border: 2px solid #aed5e1\">\r\n");
      out.write("                    <span style=\"align-content:center;font-size: 20px;\">个人信息</span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"Teacherupmsg.jsp\">修改信息</a></li>\r\n");
      out.write("                    <li><a href=\"Teacheruppassword.jsp\">修改密码</a></li>\r\n");
      out.write("                    <li><a href=\"login.jsp\">注销登录</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"opshow\" style=\"background-color: white\">\r\n");
      out.write("\r\n");
      out.write("                <form action=\"t_change_passServlet\" method=\"post\">\r\n");
      out.write("                    ");

                        if (request.getAttribute("fmsg")==null){

                        }else{ 
      out.write("\r\n");
      out.write("                    <p style=\"color: red\">");
      out.print(request.getAttribute("fmsg"));
      out.write("</p>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                    <input type=\"text\" value=\"");
      out.print(id);
      out.write("\" name=\"id\" style=\"display: none\">\r\n");
      out.write("                    <input type=\"text\" value=\"");
      out.print(password);
      out.write("\" name=\"oldpassword\" style=\"display: none\">\r\n");
      out.write("                    原密码：<input type=\"text\" value=\"\" name=\"password\" style=\"margin-top: 30px;line-height: 30px;border: #aed5e1 solid 2px;width: 200px\"><br>\r\n");
      out.write("                    新密码：<input type=\"text\" value=\"\" name=\"npassword\"  style=\"margin-top: 30px;line-height: 30px;border: #aed5e1 solid 2px;width: 200px\"><br>\r\n");
      out.write("                    <input type=\"submit\" value=\"确认修改\" style=\"position: relative;left: 30%;\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
