package com.test.methods;



public class Params {
	public  static   String DOMAIN;
	
	//public static String DOMAIN="http://192.168.108.158:8000/";
	//public static String DOMAIN="http://10.16.1.119:8000/";
	public static String realPath;
	//public static  String FilePath;
	public static  String tmpLog;
	public static void getDOMAIN(){
		//DOMAIN= APITools.getProperty("domain");
		DOMAIN="http://passport-service-test.apps.sohuno.com/";
	}
    
	public static void getFilePath(){
		FilePath= APITools.getProperty("filepath");
	}
	public static void getParams(){
		getDOMAIN();
		//getFilePath();
	}



	public static String FilePath = "WebContent\\files\\Param.xls";
	
	public static void main(String[] args) {
		System.out.print(DOMAIN);
	}
	}
