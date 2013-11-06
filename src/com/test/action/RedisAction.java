package com.test.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.methods.Redis;
import com.test.methods.SendCloud;

public class RedisAction extends ActionSupport{

	/**
	 * STAR
	 */
	private static final long serialVersionUID = -662924304926399470L;
	private HttpServletResponse response;
	private HttpServletRequest request;
	public RedisAction(){		
		   response=ServletActionContext.getResponse();
		   request=ServletActionContext.getRequest();
}
	public String getStatus() throws Exception{		
		String runstate =new Redis().getKey("runstate");
		PrintWriter out=response.getWriter();		
		out.print(runstate);
		out.flush();
		out.close();
		
		return "text";
		
	}
	public String getLog() throws Exception{
		String loginfo =new Redis().getKey("loginfo");
		String log=loginfo;
		if(new Redis().exits("errorinfo")){
			String errorinfo="<font color=\"red\">"+new Redis().getKey("errorinfo")+"</font>";
			log=errorinfo+loginfo;
		}
		
		PrintWriter out=response.getWriter();		
		out.print(log);	
		out.flush();
		out.close();		
		return "text";
		
	}

}
