package com.test.internal;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import  com.test.internal.Auto_Internal;
import com.test.methods.APITools;
import com.test.methods.Params;
import com.test.methods.Redis;
import com.test.methods.SendCloud;
import com.test.methods.toLog4j;

public class AutoRun {
	public static void justdoit() throws Exception{
		APITools.logInfo=new StringBuffer();
		APITools.errorInfo=new StringBuffer();
		
		
		try{
			JustRun();
		new Redis().setKey("loginfo", APITools.logInfo.toString());
		new Redis().expire("loginfo", 36000);
		}catch(Exception e){
			Mobile.sendSms("18810606513", 
					" PassPort Monitor ERROR!"+e.toString());
		}
		if(APITools.errorInfo.length()!=0&&APITools.errorInfo!=null){
			try{
			SendCloud.sendMail("154985201@qq.com", "PassPort¼à¿Ø±¨¾¯", APITools.errorInfo.toString());
		//	SendCloud.sendMail("446204722@qq.com", "PassPort¼à¿Ø±¨¾¯", APITools.errorInfo.toString());
			}
			catch(Exception e){
				Mobile.sendSms("18810606513", 
						" PassPort Monitor ERROR!"+e.toString());
			}
			try{
			new toLog4j().log(APITools.errorInfo.toString());
				
			}catch(Exception e){
				Mobile.sendSms("18810606513", 
						" PassPort Monitor ERROR!"+e.toString());
			}
		
				new Redis().infoToRedis(System.currentTimeMillis());
				
			}
	}
   public static void JustRun() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	   Params.getParams();
		 java.lang.reflect.Method[] methods =  Auto_Internal.class.getDeclaredMethods();
		 //for (int i=0;i<methods.length;i++) {
          for(Method m:methods)
          {
			if(!m.getName().equals("main")){
				
				m.invoke(0, null);
			//System.out.println(m.getName());	
			}
//        	  if(m.getName().equals("test")){
//        		  try {
//					m.invoke(0, "test");
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalArgumentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//        	  }
			
		 }
	  
   }
		   
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		
	AutoRun.JustRun();
	System.out.println("====================================ERROR=================================================");
	System.out.print(APITools.errorInfo);
	}

}
