package cn.keshe.servlet;

import cn.keshe.dao.P_applyDao;
import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.Practice_workDao;
import cn.keshe.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_deleteP_applyServlet")
public class t_deleteP_applyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id=request.getParameter("p_id");//传入申请编号
        P_applyDao workDao=new P_applyDao();
        boolean b= workDao.delete(p_id);
        System.out.println("申请编号为："+p_id+"执行结果："+b);
        request.getRequestDispatcher("t_seeP_applyServlet").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
