package com.test.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.struts2.ServletActionContext;

import com.test.internal.Auto;
import com.test.internal.Mobile;
import com.test.methods.Clock;
import com.test.methods.Params;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
import com.test.methods.SendCloud;

public class ApplicationWatch implements ServletContextListener {
	



@Override
public void contextDestroyed(ServletContextEvent arg0) {
	System.out.print("停止");
	try {
		SendCloud.sendMail("107607195@qq.com","Internal Monitor Stoped","Internal Monitor Stoped");
		Mobile.sendSms("18810606513", "Internal Monitor Stoped");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Override
public void contextInitialized(ServletContextEvent event) {
	ServletContext context = event.getServletContext();
//	  //取得appliction上下文
	Params.realPath=context.getRealPath("/")+"/";
	Params. FilePath=Params. realPath+"files/Param.xls";
	Params. tmpLog=Params. realPath+"tmp/tmpLog";
 //  WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
	   System.out.println("启动"+Params.realPath);
	   try {

		   new Clock(88888888,1000);
			//SendCloud.sendMail("107607195@qq.com","Internal Monitor Started","Internal Monitor Started");
			//Mobile.sendSms("18810606513", "Internal Monitor Started");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   //取得特定bean
//	   TableService tableService=(TableService)ctx.getBean("tableService");
//	  list = tableService.getTBType();
//	  mapsize = list.size();
//	  System.out.println(mapsize+"=========");
//	  TBType tempTBType = new TBType();
//	  for (int i = 0; i < list.size(); i++) {
//	   tempTBType = list.get(i);
//	   if (tempTBType.getLevel() == 1) {
//	    mainList.add(tempTBType);
//	   }
//	  }
//	  //将对象放入上下文
//	  context.setAttribute("mainList",mainList);
//	  context.setAttribute("list",list);
//	
}}