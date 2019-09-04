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

			// ��ȡ�ļ�
			InputStream is = new FileInputStream(Excelurl);
			// ���ļ��������� POI �ĵ�
			POIFSFileSystem fs = new POIFSFileSystem(is);
			// �ٽ� POI �ĵ������� Excel ������
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFRow row = null;
			HSSFCell cell = null;
			// �õ��� 1 ��������
			HSSFSheet sheet = wb.getSheetAt(0);
			// �õ���һ��һ���ж�����
			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
			// �õ����һ�е�����
			Integer lastRowNum = sheet.getLastRowNum();
			System.out.println("lastRowNum => " + lastRowNum);

			// List<CorpusWord> corpusBeanList = new ArrayList<>();
			// CorpusWord corpusBean = null;
			String cellValue = null;

			// �ӵ� 2 �п�ʼ��
			for (int i = 1; i <= lastRowNum; i++) {
				row = sheet.getRow(i);
				// corpusBean = new CorpusWord();
				for (int j = 0; j < totalColumns; j++) {
					cell = row.getCell(j);
					if (cell != null) {
						cellValue = cell.getStringCellValue();
					} else {
						cellValue = "��û�����ݡ�";
					}
					if (j == 0) {
						// corpusBean.setKey(cellValue);
					}
					if (j == 1) {
						// corpusBean.setAnnotation(cellValue);
					}
					if (j == 2) {
						/*
						 * corpusBean.setType(cellValue); corpusBean.setSource("�Խ�");
						 * corpusBean.setPre(""); corpusBean.setSuf("");
						 */
					}
				}
				// corpusBeanList.add(corpusBean);
			}
			/*
			 * for (CorpusWord cb : corpusBeanList) { System.out.println(cb); }
			 */
			// System.out.println("����������" + corpusBeanList.size());

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
			

			File file = new File(Excelurl);// ���ɵı��洢��λ��
			// String[] str = { "id", "name", "sex" };// ��������
			// String[] str2 = { "idfsdfd", "nsdfsdame", "dog good","pig not good","sedfdfx"
			// };// ����

			if (!file.exists()) {// �ж��ļ��Ƿ����
				file.createNewFile();// �����µ��ļ�
			}

			OutputStream out = new FileOutputStream(Excelurl);

			HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			HSSFSheet sheet = hssfWorkbook.createSheet("������");

			// ������������
			HSSFRow row = sheet.createRow(0);

			for (int i = 0; i < str.length; i++) {
				HSSFCell cell = row.createCell(i);

				HSSFRichTextString text = new HSSFRichTextString(str[i]);

				cell.setCellValue(text);
			}

			for (int j = 0; j < str2.size(); j++) {
				row = sheet.createRow(j + 1);

				// �������
				for (int i = 0; i < str2.get(j).length; i++) {

					HSSFCell cell = row.createCell(i);

					HSSFRichTextString text = new HSSFRichTextString(str2.get(j)[i]);

					cell.setCellValue(text);

				}

			}

			hssfWorkbook.write(out);// д����

			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
