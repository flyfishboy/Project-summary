package cn.keshe.servlet;

import cn.keshe.entity.Teacher;
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

@WebServlet("a_t_find_Servlet")/**查询所有教师信息**/
public class a_t_find_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String totalPages = request.getParameter("page");
            if(totalPages==null){
                totalPages = ""+1;
            }
            String cname = request.getParameter("cname");
            String sql = null;

            String a = "select * from teacher";//查询全部
            String b = "select * from teacher where t_name like '%"+cname+"%' "; //模糊查询

            if(cname == null){
                sql = a;
            }else
            {
                sql = b;
            }
            ResultSet rs = JDBCHelper.query(sql);
            if(rs==null){
                System.out.println("执行SQL查询语句失败");
            }else{
                System.out.println("执行SQL查询语句成功");
            }
            System.out.println("aa:"+cname);
            List<Teacher> list = new ArrayList<>();
            while (rs.next()) {
                Teacher ad = new Teacher();
                ad.setT_id(rs.getString("t_id"));
                ad.setT_name(rs.getString("t_name"));
                ad.setT_password(rs.getString("t_password"));
                ad.setT_sex(rs.getString("t_sex"));
                ad.setT_birthday(rs.getString("t_birthday"));
                ad.setT_profession(rs.getString("t_profession"));
                ad.setT_phone(rs.getString("t_phone"));
                ad.setT_qq(rs.getString("t_qq"));
                System.out.println("查询结果" + rs.getString("t_id"));
                list.add(ad);
            }
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("list", list);
            rs.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("AdminSeeTeacher.jsp").forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
