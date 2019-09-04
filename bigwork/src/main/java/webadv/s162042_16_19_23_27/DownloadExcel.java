package webadv.s162042_16_19_23_27;

import static org.mockito.Mockito.never;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;


public class DownloadExcel {

	public void ReadExcel(String Excelurl) {
		try {

			// 读取文件
			InputStream is = new FileInputStream(Excelurl);
			// 将文件流解析成 POI 文档
			POIFSFileSystem fs = new POIFSFileSystem(is);
			// 再将 POI 文档解析成 Excel 工作簿
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFRow row = null;
			HSSFCell cell = null;
			// 得到第 1 个工作簿
			HSSFSheet sheet = wb.getSheetAt(0);
			// 得到这一行一共有多少列
			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
			// 得到最后一行的坐标
			Integer lastRowNum = sheet.getLastRowNum();
			System.out.println("lastRowNum => " + lastRowNum);

			// List<CorpusWord> corpusBeanList = new ArrayList<>();
			// CorpusWord corpusBean = null;
			String cellValue = null;

			// 从第 2 行开始读
			for (int i = 1; i <= lastRowNum; i++) {
				row = sheet.getRow(i);
				// corpusBean = new CorpusWord();
				for (int j = 0; j < totalColumns; j++) {
					cell = row.getCell(j);
					if (cell != null) {
						cellValue = cell.getStringCellValue();
					} else {
						cellValue = "【没有数据】";
					}
					if (j == 0) {
						// corpusBean.setKey(cellValue);
					}
					if (j == 1) {
						// corpusBean.setAnnotation(cellValue);
					}
					if (j == 2) {
						/*
						 * corpusBean.setType(cellValue); corpusBean.setSource("自建");
						 * corpusBean.setPre(""); corpusBean.setSuf("");
						 */
					}
				}
				// corpusBeanList.add(corpusBean);
			}
			/*
			 * for (CorpusWord cb : corpusBeanList) { System.out.println(cb); }
			 */
			// System.out.println("数据条数：" + corpusBeanList.size());

			fs.close();
			is.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void WriteExcel(String[] str, ArrayList<String[]> str2) {
		String Excelurl = "D:/EXCEL.xls";
		try {
			
			System.out.println("ssss  "+str[0]);
			System.out.println("ssssssd  "+str2.get(0)[0]);
			

			File file = new File(Excelurl);// 生成的表格存储的位置
			// String[] str = { "id", "name", "sex" };// 标题内容
			// String[] str2 = { "idfsdfd", "nsdfsdame", "dog good","pig not good","sedfdfx"
			// };// 内容

			if (!file.exists()) {// 判断文件是否存在
				file.createNewFile();// 创建新的文件
			}

			OutputStream out = new FileOutputStream(Excelurl);

			HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			HSSFSheet sheet = hssfWorkbook.createSheet("嘤嘤嘤");

			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);

			for (int i = 0; i < str.length; i++) {
				HSSFCell cell = row.createCell(i);

				HSSFRichTextString text = new HSSFRichTextString(str[i]);

				cell.setCellValue(text);
			}

			for (int j = 0; j < str2.size(); j++) {
				row = sheet.createRow(j + 1);

				// 添加内容
				for (int i = 0; i < str2.get(j).length; i++) {

					HSSFCell cell = row.createCell(i);

					HSSFRichTextString text = new HSSFRichTextString(str2.get(j)[i]);

					cell.setCellValue(text);

				}

			}

			hssfWorkbook.write(out);// 写入表格

			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
