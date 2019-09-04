package cn.keshe.servlet;

import cn.keshe.dao.P_applyDao;
import cn.keshe.entity.P_apply;
import cn.keshe.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("s_add_apply_Servlet")
public class s_add_apply_Servlet extends HttpServlet {
    P_applyDao add = new P_applyDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sid = request.getParameter("id");
        String sname = request.getParameter("name");
        String date = request.getParameter("date");
        String state = request.getParameter("state");
        String tid = request.getParameter("tid");
        String pbd = request.getParameter("pbd");
        String ped = request.getParameter("ped");
        String pyp = request.getParameter("pyp");
        String pun = request.getParameter("pun");
        String pup = request.getParameter("pup");
        String sex = request.getParameter("sex");
System.out.println("学号："+sid+"学生姓名："+sname+"教师工号："+tid+"状态："+pyp+"性别"+sex);
        P_apply a=new P_apply();
        a.setS_id(sid);
       a.setS_name(sname);
       a.setS_sex(sex);
        a.setDate(date);
        a.setState(state);
        a.setT_id(tid);
        a.setP_bdate(pbd);
        a.setP_edate(ped);
        a.setP_type(pyp);
        a.setP_unit(pun);
        a.setP_uphone(pup);
        boolean d = add.insert(a);
        System.out.println("老师工号："+tid+"实习时间："+pbd+"布尔："+d);
        request.getRequestDispatcher("s_see_msgServlet").forward(request,response);//传给老师
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
