package com.test.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.methods.APITools;
import com.test.methods.Clock;
import com.test.methods.Params;
import com.test.methods.toLog4j;

public class runCheck extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1247575801984613966L;
	private HttpServletResponse response;
	
	public runCheck(){

	
			   response=ServletActionContext.getResponse();
	}

	public String doCheck() throws Exception{
		//Clock.doShutDownWork();
		PrintWriter out;
		out = response.getWriter();
		out.print("¼à¿ØÆô¶¯");	
		out.flush();
		out.close();

		new Params();
		new Clock(88888888,1000);
	
		
		
		return "text";
	
		
	}

}
