/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.8.v20171121
 * Generated at: 2019-01-17 02:13:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("file:/C:/Users/Administrator/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1547523529902L));
    _jspx_dependants.put("jar:file:/C:/Users/Administrator/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>登录</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        input{\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        .inputDiv{\r\n");
      out.write("            height: 47px;\r\n");
      out.write("            border: 1px solid #85dea5;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            width:450px;\r\n");
      out.write("        }\r\n");
      out.write("        .icon{\r\n");
      out.write("            margin:0px;\r\n");
      out.write("            float: left;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            border-radius: 5px 0 0 5px;\r\n");
      out.write("        }\r\n");
      out.write("        .txt{\r\n");
      out.write("            padding: 0px;\r\n");
      out.write("            height: 47px;\r\n");
      out.write("            line-height: 47px;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            float: left;\r\n");
      out.write("            border: none;\r\n");
      out.write("            width:403px;\r\n");
      out.write("            outline:medium;\r\n");
      out.write("        }\r\n");
      out.write("        a{\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        a:hover{\r\n");
      out.write("            color: #f60;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        a:active{\r\n");
      out.write("            color: #ff6633;\r\n");
      out.write("            text-decoration: none;\r\n");
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
      out.write("<br><br>\r\n");
      out.write("        ");

            String id= (String) session.getAttribute("id");
            String name=(String)session.getAttribute("name");
        
      out.write("\r\n");
      out.write("        <div style=\"height: 40px;width:15%;float:left; \"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--导航栏-->\r\n");
      out.write("<!--登陆界面-->\r\n");
      out.write("<br><br><br><br><br>\r\n");
      out.write("<div style=\"overflow: hidden\">\r\n");
      out.write("    <div style=\"height:1px;width:35%;float: left\"></div>\r\n");
      out.write("    <div align=\"center\">\r\n");
      out.write("        <div style=\"width:30%;overflow: hidden;float: left;background-color: #f5fcfe\">\r\n");
      out.write("            <div style=\"font-size: 30px;color: #333333;\">实习实训管理系统</div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <form method=\"post\" action=\"LoginServlet\">\r\n");
      out.write("                <div class=\"inputDiv\">\r\n");
      out.write("                    <p class=\"icon\">\r\n");
      out.write("                        <img src=\"image/1.png\"  style=\"height: 47px;width:47px\">\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <input  type=\"text\" placeholder=\"请输入账号\" name=\"s_id\" class=\"txt\" >\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"inputDiv\">\r\n");
      out.write("                    <p class=\"icon\">\r\n");
      out.write("                        <img src=\"image/2.png\"  style=\"height: 47px;width:47px\">\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <input type=\"password\" placeholder=\"请输入密码\" name=\"s_password\" class=\"txt\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"inputDiv\" style=\"background-color: lavender\">\r\n");
      out.write("                    <p class=\"icon\" style=\"font-size:14px;margin-top: 10px;border-right: #AEAEAE  solid 2px \">\r\n");
      out.write("                        类型：\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <select name=\"usertype\" style=\"width: 90%;height: 99%;position: relative;float: right;\">\r\n");
      out.write("                        <option value=\"1\">学生</option>\r\n");
      out.write("                        <option value=\"2\">教师</option>\r\n");
      out.write("                        <option value=\"3\">管理员</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div style=\"height:47px;width:450px;overflow: hidden\">\r\n");
      out.write("                    <input type=\"submit\" value=\"立即登录\" style=\"background-color:#3845ff;color:#fff7e5;width:250px;height:45px;padding: 0px;border: white 0px;float:left;overflow: hidden\">\r\n");
      out.write("                    <input type=\"reset\" value=\"重填\" style=\"background-color:#3845ff;color:#fff7e5;width:150px;height:45px;padding: 0px;border: white 0px;float:right;\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <br><br>\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /login.jsp(111,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty msg}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <span style=\"color: red\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
