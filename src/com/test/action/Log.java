package com.test.action;

import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.internal.Auto;
import com.test.methods.APITools;

public class Log extends ActionSupport{

	/**
	 * STAR
	 */
	private String info;
	private static final long serialVersionUID = -6468499618794119083L;
	private static final Logger log = Logger.getLogger(Log.class);
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	private HttpServletResponse response;
	//private HttpServletRequest request;
	//private String responseContent;
	   public  Log() throws  Exception{
	
		   //responseContent=HttpMethods.get("http://urlfetch.sce.sohu.com/http/m.weather.com.cn/data/101010100.html");
		   response=ServletActionContext.getResponse();
//		   request=ServletActionContext.getRequest();
		
		}
	public String doLog() throws Exception {
		Auto.Auto_HuDun();
		Properties props = new Properties();        
		props.setProperty("log4j.rootLogger","INFO,CONSOLE");
		props.setProperty("log4j.appender.CONSOLE","org.apache.log4j.RollingFileAppender");
		props.setProperty("log4j.appender.Threshold","WARN");
		props.setProperty("log4j.appender.CONSOLE.layout","org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.CONSOLE.layout.ConversionPattern","[%-5p]%d{yyyy-MM-dd HH:mm:ssS} %c %m%n");
		props.setProperty("log4j.appender.CONSOLE.File",System.getenv("LOG_FILE"));   
		PropertyConfigurator.configure(props);
		log.info(APITools.logInfo);	
		PrintWriter out=response.getWriter();
		out.print(APITools.logInfo);
		out.print("ssss");
		out.flush();
		out.close();
		return "text";
	}
}
