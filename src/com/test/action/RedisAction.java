package com.test.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mail.SendMail;
import com.opensymphony.xwork2.ActionSupport;
import com.test.internal.Mobile;
import com.test.methods.APITools;
import com.test.methods.Redis;

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
		String errorinfo="<font color=\"red\">"+new Redis().getKey("errorinfo")+"</font>";
		PrintWriter out=response.getWriter();		
		out.print(errorinfo+loginfo);	
		out.flush();
		out.close();		
		return "text";
		
	}

}
