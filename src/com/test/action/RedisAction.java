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
		String errorinfo=new Redis().infoFromRedis();
		if(errorinfo.length()!=0&&errorinfo!=null){
			 errorinfo="<font color=\"red\">"+errorinfo+"</font>";
			log=errorinfo+loginfo;
		}
		
		PrintWriter out=response.getWriter();		
		out.print(log);	
		out.flush();
		out.close();		
		return "text";
		
	}

}
