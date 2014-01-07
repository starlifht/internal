package com.test.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import  com.test.internal.Auto_Internal;
import com.test.methods.APITools;
import com.test.methods.Redis;
import com.test.methods.SendCloud;
import com.test.methods.toLog4j;

public class AutoRun {
	public static void justdoit() throws Exception{
		APITools.logInfo=new StringBuffer();
		APITools.errorInfo=new StringBuffer();

		JustRun();
		try{
		new Redis().setKey("loginfo", APITools.logInfo.toString());
		new Redis().expire("loginfo", 36000);
		}catch(Exception e){
			Mobile.sendSms("18810606513", 
					" PassPort Monitor ERROR!"+e.toString());
		}
		if(APITools.errorInfo.length()!=0&&APITools.errorInfo!=null){
			try{
			SendCloud.sendMail("154985201@qq.com", "PassPort¼à¿Ø±¨¾¯", APITools.errorInfo.toString());
			SendCloud.sendMail("446204722@qq.com", "PassPort¼à¿Ø±¨¾¯", APITools.errorInfo.toString());
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
   public static void JustRun(){
		 java.lang.reflect.Method[] methods =  Auto_Internal.class.getDeclaredMethods();
		 for (int i=0;i<methods.length;i++) {

			Method m = methods[i];
			try {
				m.invoke(0, null);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			System.out.println(m.getName());
		 }
	  
   }
		   
	public static void main(String[] args)  {
		
	AutoRun.JustRun();
	System.out.println("=====================================================================================");
	System.out.print(APITools.errorInfo);
	}

}
