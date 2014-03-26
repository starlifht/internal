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

	public static void CreateExcel() {// 创建excel

		try {
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File(
					"test.xls"));
			// 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("第一页", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
			// 以及单元格内容为test
			Label label = new Label(0, 0, "test");

			// 将定义好的单元格添加到工作表中
			sheet.addCell(label);
			/*
			 * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
			 */
			jxl.write.Number number = new jxl.write.Number(1, 0, 555.12541);
			sheet.addCell(number);

			// 写入数据并关闭文件
			book.write();
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static List<String> ReadExcel(String url, int sheet,int column) throws Exception {// 读取excel sheet a

	column--;

		int i = 1;

		Workbook book = Workbook.getWorkbook(new File(url));
		// 获得第一个工作表对象
		Sheet sheet1 = book.getSheet(sheet);
		// 得到第一列第一行的单元格

		// if(cell.getContents()!=null){
		List<String> list = new ArrayList<String>();

		while (i < sheet1.getColumn(column).length) {
			Cell cell = sheet1.getCell(column, i);// 几列几行
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
			// Excel获得文件
			Workbook wb = Workbook.getWorkbook(new File("f://test.xls"));
			// 打开一个文件的副本，并且指定数据写回到原文件
			WritableWorkbook book = Workbook.createWorkbook(new File(
					"f://test.xls"), wb);
			// 添加一个工作表
			WritableSheet sheet = book.createSheet("第二页", 1);
			sheet.addCell(new Label(0, 0, "第二页的测试数据"));
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
			// 打印信息或将信息保存到一个公共集合中
			i++;
			System.out.println(s);

		}
		// UpdateExcel();
	}

}