package com.test.internal;

import java.util.Iterator;
import java.util.List;

import com.test.methods.APITools;
import com.test.methods.ExcelTools;
import com.test.methods.Params;


public class Param_HuDun {

	public  static void synchudun(int sheet, int columns) throws Exception {
		
		APITools.apiName = APITools.getFuncName();
	
		 List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet, columns-1);
		 List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet, columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext()&&iter2.hasNext()){
			String userid = iter1.next();
			String status= iter2.next();
			System.out.print(userid);
			APITools.xmlCheck(HuDun.synchudun(userid), APITools.getParams("userID:" + userid)
					+ APITools.getParams("status:" + status), "status",
			status);		}
	}
	public static void gethudunconfig(int sheet, int columns) throws Exception {
		
		APITools.apiName = APITools.getFuncName();
		
		 List<String>list1 = ExcelTools.ReadExcel(Params.FilePath, sheet, columns-1);
		 List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet, columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext()&&iter2.hasNext()){
			String userid = iter1.next();
			String status= iter2.next();
			APITools.xmlCheck(HuDun.gethudunconfig(userid), APITools.getParams("userID:" + userid)
					+ APITools.getParams("status:" + status), "status",
			status);		
		}
	}
	public static void sethudunconfig(int sheet, int columns) throws Exception {
		
		APITools.apiName = APITools.getFuncName();
		
		 List<String>list1 = ExcelTools.ReadExcel(Params.FilePath, sheet, columns-1);
		 List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet, columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext()&&iter2.hasNext()){
			String userid = iter1.next();
			String status= iter2.next();
			APITools.xmlCheck(HuDun.sethudunconfig(userid), APITools.getParams("userID:" + userid)
					+ APITools.getParams("status:" + status), "status",
			status);
		
		}
	}
	public static void main(String[] args) throws Exception {		
	
	}

}