package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.Practice_workDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Practice;
import cn.keshe.entity.Practice_work;
import com.nchu.utils.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("t_seeWorkServlet")
public class t_seeWorkServlet extends HttpServlet {
    Practice_workDao workDao=new Practice_workDao();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String totalPages = request.getParameter("page");
        if(totalPages==null) {
            totalPages = "" + 1;
        }
        String t_id =(String ) request.getSession().getAttribute("id");
        String m_title=(String) request.getParameter("m_title");
        System.out.println("收到的ID为"+t_id+"获得的标题："+m_title);
        ArrayList<Practice> list1=null;
        if(m_title==null){
            list1=workDao.select(t_id);
        }else{
            list1=workDao.selectWNumber(m_title);
        }
        if(list1==null){
            System.out.println("收到的list为空");
        }
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("list1",list1);
        request.getRequestDispatcher("TeacherMWork.jsp").forward(request , response );
    }
}

