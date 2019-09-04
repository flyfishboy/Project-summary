package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.Practice_workDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.dao.positionDao;
import cn.keshe.entity.Practice;
import cn.keshe.entity.Practice_work;
import cn.keshe.entity.Student;
import cn.keshe.entity.position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_AddPointServlet")
public class t_AddPointServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_id=(String)request.getSession().getAttribute("id");
        String n_id=request.getParameter("t_id");
        String lat=request.getParameter("lat");
        String lon=request.getParameter("lon");
        String d_name=request.getParameter("d_name");
        if(d_name!=null) {
            position p = new position();
            p.setT_id(t_id);
            p.setN_id(n_id);
            p.setLat(lat);
            p.setLon(lon);
            p.setD_name(d_name);
            positionDao positionDao = new positionDao();
            System.out.println("教师Id为" + t_id + "经度：" + lon + "纬度：" + lat + "企业名称：" + d_name);
            Boolean b = positionDao.insert( d_name, lon, lat);//传入坐标信息，执行
        }else{
            position p = new position();
            p.setT_id(t_id);
            p.setN_id(n_id);
            p.setLat(lat);
            p.setLon(lon);
            p.setD_name(d_name);
            positionDao positionDao = new positionDao();
            System.out.println("教师Id为" + t_id + "经度：" + lon + "纬度：" + lat + "企业名称：" + d_name);
            Boolean b = positionDao.insert( t_id, lon, lat);//传入坐标信息，执行
        }
        request.getRequestDispatcher("TeacherVisitUnit.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
