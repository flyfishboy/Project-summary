package cn.keshe.dao;

import cn.keshe.entity.file;
import cn.keshe.utils.JDBCHelper;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class fileDao extends HttpServlet {
    static String tableName = "file";


    private ArrayList arraylist(ResultSet rs) {
        ArrayList<file> listp=new ArrayList<>();
        file E=null;
        if( rs != null ){
            try {
                while (rs.next()) {
                    E = new file();
                    E.setId(rs.getString("id"));
                    E.setFilename(rs.getString("file_name"));
                    E.setWorkname(rs.getString("workname"));
                    E.setS_id(rs.getString("s_id"));
                    E.setT_id(rs.getString("t_id"));
                    listp.add(E);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listp;
    }


     /**老师查看自己布置的任务*/
    public ArrayList<file> tselect(String t_id){
        ArrayList<file> list1=new ArrayList<>();
        String SQL="select * from file where t_id= ?";
        ResultSet rs = JDBCHelper.query( SQL ,t_id);
        list1=arraylist(rs);
        return list1;
    }


    /**
     * 插入数据
     * @param
     * @return
     */
    public  boolean  insert(String n,String w,String si,String ti){
        String SQL = "insert into " +tableName + "(file_name,workname,s_id,t_id) values (?,?,?,?) " ;
        boolean b=JDBCHelper.execute( SQL,n,w,si,ti) ;
        return b;
    }

    /**删除一条数据**/
    public boolean delete(String id){
        String SQL="delete from "+tableName+" where id= ? ";
        boolean b=JDBCHelper.execute(SQL,id);
        return b;
    }
    public void writeExcel(String s){
        File file = new File("D:/jsl_biao.xls");//生成的表格存储的位置
        String [] str = {"id","name","sex"};//标题内容
        try {
            if(!file.exists()){//判断文件是否存在
                file.createNewFile();//创建新的文件
            }
            //创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //创建sheet对象
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            //行对象
            Label label = null;

            //添加标题
            for (int i = 0; i < str.length; i++) {
                /**
                 * Label(i,j,String);
                 * i:列
                 * j:行
                 * String:表示内容
                 */
                label = new Label(i, 0, str[i]);
                sheet.addCell(label);
            }

            //添加数据
            for (int i = 1; i <= 10; i++) {
                label = new Label(0, i, i+"");
                sheet.addCell(label);
                label = new Label(1, i, "name"+i);
                sheet.addCell(label);
                label = new Label(2, i, "男");
                sheet.addCell(label);
            }
            workbook.write();//把表格信息写入文件
            workbook.close();//关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("表格生成！");
    }

}

