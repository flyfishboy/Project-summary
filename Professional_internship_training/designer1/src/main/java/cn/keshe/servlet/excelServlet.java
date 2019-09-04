package cn.keshe.servlet;

import cn.keshe.dao.TeacherDao;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
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
import java.util.Iterator;
import java.util.List;

@WebServlet("excelServlet")
public class excelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int isgood=0;
        String uploadPath="D:/KesheExcel";
        System.out.println(uploadPath);
        File folder = new File(uploadPath);
        if(!folder.exists())
            folder.mkdirs();
        String message=null;
        String fileName="";
        if(ServletFileUpload.isMultipartContent(request)){
            DiskFileItemFactory disk=new DiskFileItemFactory();
            disk.setSizeThreshold(10*1024*1024);
            disk.setRepository(disk.getRepository());
            ServletFileUpload up=new ServletFileUpload(disk);
            int maxsize=10*1024*1024;
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
                if(!fm.isFormField()){
                    String filePath = fm.getName();
                    int startIndex = filePath.lastIndexOf("/");
                    if(startIndex!=-1){
                        fileName = filePath.substring(startIndex+1);
                    }else{
                        fileName=filePath;
                    }
                    if(fm.getSize()>maxsize){
                        message="Excel上传失败——文件大小不能超过 10MB";



                        break;
                    }
                    String fileSize=new Long(fm.getSize()).toString();
                    if((fileName==null)||(fileName.equals(""))&&(fileSize.equals("0"))){
                        message="Excel上传失败——文件不能为空";



                        break;
                    }

                    if (!fileName.contains(".xls")){
                        message="Excel上传失败——文件格式错误，只支持.xls文件";



                        break;
                    }

                    File saveFile=new File(uploadPath,fileName);
                    try{
                        fm.write(saveFile);
                        message="文件上传成功";
                        isgood=1;
                    }
                    catch(Exception e1){
                        e1.printStackTrace();
                    }
                }


            }
        }


        if(isgood==1) {

            File file = new File("D:/KesheExcel/" + fileName);//表格存储的位置
            try {
                if (file.exists()) {//判断文件是否存在
                    //创建工作簿
                    Workbook workbook = Workbook.getWorkbook(file);
                    //获得第一个工作表sheet1
                    Sheet sheet = workbook.getSheet(0);

                    TeacherDao dao=new TeacherDao();

                    String sql;

                    //获得数据
                    for (int i = 1; i < sheet.getRows(); i++) {//sheet.getRows():获得表格文件行数

                        sql="";

                        for (int j = 0; j < sheet.getColumns(); j++) {//sheet.getColumns():获得表格文件列数
                            Cell cell = sheet.getCell(j, i);
                            sql=sql+cell.getContents();
                          //  System.out.print(cell.getContents() + " ");
                        }
                        dao.insertExcel(sql);
                        System.out.println(sql);
                    }


                    workbook.close();//关闭

                    file.delete();
                } else {
                    System.out.println("文件不存在");
                }
            } catch (Exception e) {
                message="修改失败，Excel内容格式错误";
                e.printStackTrace();
            }


        }



//带回去
        request.setAttribute("mes",message);
        request.getRequestDispatcher("uploadExcel.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
