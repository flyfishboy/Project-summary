package cn.keshe.servlet;

import cn.keshe.entity.Student;
import cn.keshe.utils.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("t_s_seeStudentTest")
public class t_s_seeStudentTest extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String id= (String) request.getSession().getAttribute("id");
            String sname=request.getParameter("s_name");
            String sql=null;
            String sql1=null;
            if (sname!=null){
                sql = "select * from student where s_name like '%"+sname+"%' and  t_id= '"+id+"'";
                sql1 = "select count(*) from student where s_name like '%"+sname+"%' and  t_id= '"+id+"'";
            }else{
                sql = "select * from student where t_id= '"+id+"'";
            }
            System.out.println("查询学生信息servlet收到的教师id为"+id+"学生姓名为："+sname);
            ResultSet rs = JDBCHelper.query(sql);

            List <Student> list = new ArrayList<>();
            while (rs.next()) {
                Student ad = new Student();
                ad.setS_id(rs.getString("s_id"));
                ad.setS_name(rs.getString("s_name"));
                ad.setS_sex(rs.getString("s_sex"));
                ad.setS_birthday(rs.getString("s_birthday"));
                ad.setS_class(rs.getString("s_class"));
                ad.setS_password(rs.getString("s_password"));
                ad.setS_phone(rs.getString("s_phone"));
                ad.setS_qq(rs.getString("s_qq"));
                ad.setS_profession(rs.getString("s_profession"));
                list.add(ad);
            }

            request.setAttribute("list", list);
            request.getSession().setAttribute("id", id);
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("Teacherupdatmsg-test.jsp").forward(request,response);
    }
}

