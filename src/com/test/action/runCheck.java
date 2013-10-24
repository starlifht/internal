package com.test.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.internal.Auto;
import com.test.methods.APITools;
import com.test.methods.Params;
import com.test.methods.logOP;
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

	public String doCheck(){
		Auto.Auto_HuDun();
		//Auto.Auto_Mobile();
		//Auto.Auto_Internal();
		String loginfo=APITools.logInfo.toString();
		String errorinfo=APITools.errorInfo.toString();
		
		try {
			new toLog4j().log();
			logOP.doTmpLog(Params.tmpLog, loginfo);
			PrintWriter out;
			out = response.getWriter();
			out.print( loginfo+errorinfo);	
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "text";
	
		
	}

}
