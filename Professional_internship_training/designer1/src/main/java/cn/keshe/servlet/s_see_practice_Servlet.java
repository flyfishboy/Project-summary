package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Practice;
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

@WebServlet("s_see_practice_Servlet")
public class s_see_practice_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String sid= (String) request.getSession().getAttribute("id");

            String pbdate=request.getParameter("p_bdate");
            System.out.println("查询学生信息servlet收到的学生id为"+sid);
           Practice s=null;
           String sql="select * from practice where s_id=?";
          ResultSet rs=JDBCHelper.query(sql,sid);
          if (rs!=null){
              while (rs.next()) {
                  s = new Practice();
                  s.setP_id(rs.getString("id"));
                  s.setS_id(rs.getString("s_id"));
                  s.setS_name(rs.getString("s_name"));
                  s.setS_sex(rs.getString("s_sex"));
                  s.setP_bdata(rs.getString("p_bdate"));
                  s.setP_edata(rs.getString("p_edate"));
                  s.setP_type(rs.getString("p_type"));
                  s.setP_unit(rs.getString("p_unit"));
                  s.setP_uphone(rs.getString("p_uphone"));

                  String pid=s.getP_id();
                  String snid=s.getS_id();
                  String sname=s.getS_name();
                  String ssex=s.getS_sex();
                  String pbd=s.getP_bdata();
                  String ped=s.getP_edata();
                  String pty=s.getP_type();
                  String pun=s.getP_unit();
                  String pup=s.getP_uphone();
                  request.setAttribute("practice",s);


                  request.setAttribute("pid", pid);
                  request.setAttribute("snid", snid);
                  request.setAttribute("sname", sname);
                  request.setAttribute("ssex", ssex);
                  request.setAttribute("pbd",pbd);
                  request.setAttribute("ped",ped);
                  request.setAttribute("pty",pty);
                  request.setAttribute("pun",pun);
                  request.setAttribute("pup",pup);

              }
          }else {
              System.out.println("RS为空");
          }


            System.out.println("传出的学生id:"+sid+"开始时间"+pbdate);
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("StudentSeePractice.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
