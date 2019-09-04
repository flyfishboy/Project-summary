package cn.keshe.servlet;

import cn.keshe.dao.P_applyDao;
import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.entity.P_apply;
import cn.keshe.entity.Practice;
import cn.keshe.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_addPracticeServlet")
public class t_addPracticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state=request.getParameter("state");
        String applyid=request.getParameter("applyid");
        String id=(String)request.getSession().getAttribute("id");
        String s_id=request.getParameter("s_id");//传入学生的学号
        String name=request.getParameter("s_name");//传入学生的姓名
        String sex=request.getParameter("s_sex");//传入学生的性别
        String bdate=request.getParameter("p_bdate");
        String edate=request.getParameter("p_edate");
        String p_type=request.getParameter("p_type");
        String p_unit=request.getParameter("p_unit");
        String p_uphone=request.getParameter("p_uphone");
        if(applyid!=null&&state!=null){
            P_applyDao pDao=new P_applyDao();
            pDao.changeS(applyid,state);
        }
        Practice p=new Practice();
       p.setS_id(s_id);
       p.setS_name(name);
       p.setS_sex(sex);
       p.setP_bdata(bdate);
       p.setP_edata(edate);
       p.setP_type(p_type);
       p.setP_unit(p_unit);
       p.setP_uphone(p_uphone);
       p.setT_id(id);
        PracticeDao practiceDao=new PracticeDao();
       Boolean b= practiceDao.insert(p);//传入实习信息，执行
        System.out.println("执行结果："+b);
        request.getRequestDispatcher("t_seePracticeServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
