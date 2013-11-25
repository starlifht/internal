package com.test.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ApplicationWatch implements ServletContextListener {
	



@Override
public void contextDestroyed(ServletContextEvent arg0) {
	System.out.print("停止动");
	
}

@Override
public void contextInitialized(ServletContextEvent event) {
//	ServletContext context = event.getServletContext();
//	  //取得appliction上下文
//	   WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
	   System.out.print("启动");
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