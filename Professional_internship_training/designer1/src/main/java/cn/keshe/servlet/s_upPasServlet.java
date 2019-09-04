package cn.keshe.servlet;

import cn.keshe.dao.StudentDao;
import com.nchu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("s_up_spsdServlet")
public class s_upPasServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao u=new StudentDao();

        String id= (String) request.getSession().getAttribute("id");
        String opsd0=request.getParameter("opsd0");
        String opsd=request.getParameter("opassword");
        String npsd=request.getParameter("npassword");
        String npsd2=request.getParameter("confirmPassword");

        System.out.println("  sdff   "+opsd+"  "+opsd0+"  "+npsd);
        if (!opsd.equals(opsd0)){
            String msg = "旧密码输入错误 ";
            request.setAttribute("password_msg", msg);
            request.getRequestDispatcher("/StudentupPas.jsp").forward(request, response);
        }else if (npsd.trim().length()<6||npsd.trim().length()>18){
            String msg = "密码的长度在6到18位之间 ";
            request.setAttribute("password_msg", msg);
            request.getRequestDispatcher("/StudentupPas.jsp").forward(request, response);
        }
        else
        {
            if (npsd.equals(npsd2)) {
                // 证明可以修改
                boolean b=u.alterpassword(id,npsd);
                if (npsd.equals(opsd)){
                    // 友好提示
                    // 能进入到这里，证明 用户名已经存在
                    String msg = "三次密码都相等";
                    request.setAttribute("password_msg", msg);
                    request.getRequestDispatcher("/StudentupPas.jsp").forward(request, response);
                }else if (b) {
                    // 修改成功
                    request.getSession().invalidate();
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().print("<h1>修改密码成功，2秒之后自动回到登录</h1>");
                    response.setHeader("refresh", "2;url=/login.jsp");
                } else {
                    // 修改失败
                    String msg = "出错了，请稍后重试 ";
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("/StudentupPas.jsp").forward(request, response);
                }
            } else {
                // 友好提示
                // 能进入到这里，证明 用户名已经存在
                String msg = "两次密码不相等";
                request.setAttribute("password_msg", msg);
                request.getRequestDispatcher("/StudentupPas.jsp").forward(request, response);
            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
