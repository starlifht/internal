package com.test.methods;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelTools {

	public static void CreateExcel() {// ����excel

		try {
			// ���ļ�
			WritableWorkbook book = Workbook.createWorkbook(new File(
					"test.xls"));
			// ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
			WritableSheet sheet = book.createSheet("��һҳ", 0);
			// ��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)
			// �Լ���Ԫ������Ϊtest
			Label label = new Label(0, 0, "test");

			// ������õĵ�Ԫ����ӵ���������
			sheet.addCell(label);
			/*
			 * ����һ���������ֵĵ�Ԫ�� ����ʹ��Number��������·�����������﷨���� ��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123
			 */
			jxl.write.Number number = new jxl.write.Number(1, 0, 555.12541);
			sheet.addCell(number);

			// д�����ݲ��ر��ļ�
			book.write();
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static List<String> ReadExcel(String url, int sheet,int column) throws Exception {// ��ȡexcel sheet a

	column--;

		int i = 1;

		Workbook book = Workbook.getWorkbook(new File(url));
		// ��õ�һ�����������
		Sheet sheet1 = book.getSheet(sheet);
		// �õ���һ�е�һ�еĵ�Ԫ��

		// if(cell.getContents()!=null){
		List<String> list = new ArrayList<String>();

		while (i < sheet1.getColumn(column).length) {
			Cell cell = sheet1.getCell(column, i);// ���м���
			String result = cell.getContents();

			list.add(result);
			// System.out.println(i + result);
			i++;
		}

		// }
		book.close();
		return list;

	}

	public static void UpdateExcel() {

		try {
			// Excel����ļ�
			Workbook wb = Workbook.getWorkbook(new File("f://test.xls"));
			// ��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�
			WritableWorkbook book = Workbook.createWorkbook(new File(
					"f://test.xls"), wb);
			// ���һ��������
			WritableSheet sheet = book.createSheet("�ڶ�ҳ", 1);
			sheet.addCell(new Label(0, 0, "�ڶ�ҳ�Ĳ�������"));
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws Exception, Exception {
		// CreateExcel();
		System.out.println("sdfsds");
		int i=0;
		List<String>  ll=ReadExcel("f://asd.xls",1,1);
		//Iterator<String> iter = ll.iterator();

		//List<String>  ss=ReadExcel("f://test.xls",8,2);
		Iterator<String> iter1 = ll.iterator();
		while (iter1.hasNext()) {
			String s=iter1.next();
			//String m = iter1.next();
			// ��ӡ��Ϣ����Ϣ���浽һ������������
			i++;
			System.out.println(s);

		}
		// UpdateExcel();
	}

}