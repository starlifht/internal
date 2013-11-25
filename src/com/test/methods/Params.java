package com.test.methods;

import org.apache.struts2.ServletActionContext;

public class Params {
	public  static  final String DOMAIN="http://internal.passport.sohu.com/";
	public static final String realPath=ServletActionContext.getServletContext().getRealPath("/")+"/";
	public static final String FilePath = realPath+"files/Param.xls";
	public static final String tmpLog=realPath+"tmp/tmpLog";
	public Params(){
	
	}

	
	//public static final String FilePath = "Param.xls";
	}
