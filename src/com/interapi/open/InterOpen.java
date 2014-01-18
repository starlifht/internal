package com.interapi.open;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.test.methods.APITools;
import com.test.methods.CommonTools;


public class InterOpen {
	final static String domain="http://innerapi.open.sce.sohu.com/";
	//final static String domain= "http://test.innerapi.open.sce.sohu.com/";
	 static String[] product=new String[]{"9999","abcd"};
	public static String checkauth(String userid) throws Exception{//验证用户是否已授权给某应用
		  Map<String, String[]> parameterMap = new HashMap<String, String[]>();
	        parameterMap.put("user_id", new String[]{userid});
	       // parameterMap.put("app_key", new String[]{"fa0e2a63b5bd475c9af608af3d307573"});
	        parameterMap.put("app_key", new String[]{"309b1e63064e485fa57adb93ef4fb052"});
	        parameterMap.put("product_id",new String[]{product[0]});
	        parameterMap.put("ct", new String[]{String.valueOf(System.currentTimeMillis())});	 
			String sig = SignatureUtils.signatureMultiValue(parameterMap, product[1]);
			parameterMap.put("sig", new String[]{sig});
		
			String s=CommonTools.doPost(domain+"oauth2/checkauth", parameterMap);
			System.out.print(s);
			return s;
			
	}
	public static String cancelauth(String userid) throws Exception{//取消授权
		  Map<String, String[]> parameterMap = new HashMap<String, String[]>();
	        parameterMap.put("user_id", new String[]{userid});
	       // parameterMap.put("app_key", new String[]{"fa0e2a63b5bd475c9af608af3d307573"});
	        parameterMap.put("app_key", new String[]{"KADANG_COM"});
	        parameterMap.put("product_id",new String[]{product[0]});
	        parameterMap.put("ct", new String[]{String.valueOf(System.currentTimeMillis())});	 
			String sig = SignatureUtils.signatureMultiValue(parameterMap, product[1]);
			parameterMap.put("sig", new String[]{sig});
			String s=CommonTools.doPost(domain+"oauth2/cancelauth", parameterMap);
			System.out.print(s);
			return s;
			
	}
	public static void applyapp() throws Exception{//站内应用 申请
		  Map<String, String[]> parameterMap = new HashMap<String, String[]>();
	        parameterMap.put("user_id", new String[]{"107607195@qq.com"});
	        parameterMap.put("app_name", new String[]{"star2sderw3"});
	        parameterMap.put("app_logo_m", new String[]{"p2156839164.jpg"});
	        parameterMap.put("app_logo_s", new String[]{"p2156839164.jpg"});
	        parameterMap.put("app_url", new String[]{"http://www.wer9e.com"});	        
	        parameterMap.put("redirect_uri", new String[]{"http://www.sowerwerhu.com"});   
	        parameterMap.put("product_id",new String[]{product[0]});
	        parameterMap.put("ct", new String[]{String.valueOf(System.currentTimeMillis())});	 
			String sig = SignatureUtils.signatureMultiValue(parameterMap, product[1]);
			parameterMap.put("sig", new String[]{sig});
			String s=CommonTools.doPost(domain+"consumer/applyapp", parameterMap);
			System.out.print(s);			
	}
	public static String checkdeveloper() throws Exception{//校验开发者资质     0未审核，1审核通过， 2拒绝，3已取消开发者身份
		  Map<String, String[]> parameterMap = new HashMap<String, String[]>();
	        parameterMap.put("user_id", new String[]{"107607195@qq.com"});
	        parameterMap.put("app_key", new String[]{"fa0e2a63b5bd475c9af608af3d307573"});
	      // parameterMap.put("app_key", new String[]{"61b0a256f4c249e299e5aaa784fc18f4"});
	        parameterMap.put("product_id",new String[]{product[0]});
	        parameterMap.put("ct", new String[]{String.valueOf(System.currentTimeMillis())});	 
			String sig = SignatureUtils.signatureMultiValue(parameterMap, product[1]);
			parameterMap.put("sig", new String[]{sig});
			String s=CommonTools.doPost(domain+"account/checkdeveloper", parameterMap);
			System.out.print(s);
			return s;
			
	}
	public static String getall(String userid) throws Exception{//获取用户已授权应用列表    0未审核，1审核通过， 2拒绝，3已取消开发者身份
		  Map<String, String[]> parameterMap = new HashMap<String, String[]>();
	        parameterMap.put("user_id", new String[]{userid});
	      //  parameterMap.put("app_key", new String[]{"fa0e2a63b5bd475c9af608af3d307573"});
	      // parameterMap.put("app_key", new String[]{"61b0a256f4c249e299e5aaa784fc18f4"});
	        parameterMap.put("product_id",new String[]{product[0]});
	        parameterMap.put("ct", new String[]{String.valueOf(System.currentTimeMillis())});	 
			String sig = SignatureUtils.signatureMultiValue(parameterMap, product[1]);
			parameterMap.put("sig", new String[]{sig});
			String s=CommonTools.doPost(domain+"consumer/getall", parameterMap);
			System.out.print(s);
			return s;
			
	}

	public static void main(String[] args) throws Exception {
 //InterOpen.checkauth("107607195@qq.com");
//InterOpen.cancelauth("ppauthtest11@sohu.com");
		//InterOpen.applyapp();
		//InterOpen.checkdeveloper();
		
		//APITools.jsonCheck(InterOpen.checkdeveloper(), null	, "10200");
		//System.out.print(APITools.logInfo);
	String s=InterOpen.getall("ppauthtest21@sohu.com");
	//JSONObject jb=JSONObject.fromObject(s);
	//System.out.print(s);
	}

}
