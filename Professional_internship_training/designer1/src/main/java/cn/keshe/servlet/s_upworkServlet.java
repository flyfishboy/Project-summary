package cn.keshe.servlet;

import cn.keshe.dao.Practice_workDao;
import cn.keshe.dao.fileDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet("s_upworkServlet")
public class s_upworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id="" ;
        String tid=""  ;
        String tit=""  ;
        String content="";

        int isin=0;
        fileDao fi=new fileDao();



        String uploadPath="D:/KesheExcel";
        System.out.println(uploadPath);
        File folder = new File(uploadPath);
        if(!folder.exists())
            folder.mkdirs();
        String message=null;
        String fileName="";
        if(ServletFileUpload.isMultipartContent(request)){
            DiskFileItemFactory disk=new DiskFileItemFactory();
            disk.setSizeThreshold(20*1024*1024);
            disk.setRepository(disk.getRepository());
            ServletFileUpload up=new ServletFileUpload(disk);
            int maxsize=20*1024*1024;
            List list=null;
            try{
                list=up.parseRequest(request);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            Iterator i=list.iterator();
            while(i.hasNext()){
                FileItem fm=(FileItem)i.next();


                {
                    String foename=fm.getFieldName();
                    String con=fm.getString("utf-8");

                    if(foename.equals("id")){
                        id = con;
                    }else if(foename.equals("t_id")){
                        tid = con;
                    }else if(foename.equals("tit")){
                        tit = con;
                    }else if(foename.equals("m_content")){
                        content = con;
                    }

                }



                if(!fm.isFormField()){
                    String filePath = fm.getName();
                    int startIndex = filePath.lastIndexOf("/");
                    if(startIndex!=-1){
                        fileName = filePath.substring(startIndex+1);
                    }else{
                        fileName=filePath;
                    }
                    if(fm.getSize()>maxsize){
                        message="文件上传失败——文件大小不能超过 20MB";
                        break;
                    }
                    String fileSize=new Long(fm.getSize()).toString();
                    if((fileName==null)||(fileName.equals(""))&&(fileSize.equals("0"))){
                        message="上传成功";
                        break;
                    }else{if(fileName.length()>20)
                    {
                        message="文件上传失败——文件名称过长";
                        break;
                    }

                    File saveFile=new File(uploadPath,id+"-"+fileName);
                    try{
                        fm.write(saveFile);
                        message="文件上传成功";
                        isin=1;
                    }
                    catch(Exception e1){
                        e1.printStackTrace();
                    }}
                }


            }
        }

        Date da=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = df.format(da);

        Practice_workDao wdao=new Practice_workDao();
        wdao.upcontent(tit,content,now,"-1",id,tid);
        if(isin==1)
        {

            fi.insert(id+"-"+fileName,tit,id,tid);
        }


//带回去
        request.setAttribute("mes",message);
        request.getRequestDispatcher("s_up_workfile.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
