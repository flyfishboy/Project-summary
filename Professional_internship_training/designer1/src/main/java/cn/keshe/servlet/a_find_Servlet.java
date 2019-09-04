package cn.keshe.servlet;

import cn.keshe.dao.AdminDao;
import cn.keshe.entity.Admin;
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

@WebServlet("a_find_Servlet")
public class a_find_Servlet extends HttpServlet { /*管理员查询所有管理员信息*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String totalPages = request.getParameter("page");
            if(totalPages==null){
                totalPages = ""+1;
            }
            request.setCharacterEncoding("UTF-8");
            String fname = request.getParameter("aname");
            System.out.println("" + fname);
            String sql = null;
            String a = "select * from t_admin";
            String b = "select * from t_admin where a_name like '%" + fname + "%'";
            if (fname == null) {
                sql = a;
            } else {
                sql = b;
            }
            ResultSet rs = JDBCHelper.query(sql);
            if (rs == null) {
                System.out.println("执行SQL查询语句失败");
            } else {
                System.out.println("执行SQL查询语句成功");
            }

            List<Admin> list = new ArrayList<>();
            while (rs.next()) {
                Admin ad = new Admin();
                ad.setA_id(rs.getString("a_id"));
                ad.setA_name(rs.getString("a_name"));
                ad.setA_password(rs.getString("a_password"));
                ad.setA_sex(rs.getString("a_sex"));
                System.out.println("查询结果" + rs.getString("a_id"));
                list.add(ad);
            }
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("list", list);
           // request.getSession().setAttribute("name", fname);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("AdminFindAdmin.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

