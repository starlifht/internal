package com.test.methods;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.test.internal.PPTools;






public class APITools {
	public static String xmlInfo=null;
	 public static StringBuffer errorInfo=new StringBuffer();
	 public static String apiName=null;
	 public static StringBuffer logInfo=new StringBuffer();
//	 public static void xmlCheck(String response,String params,String status) throws Exception{//状态检查
//
//			if(XML.string2Doc(response).getRootElement().getChildText("status").equals(status)){			
//				logInfo=APITools.getInfo(logInfo, APITools.getAPIname(apiName), response);
//
//			}else{
//				errorInfo=APITools.getInfo(errorInfo, APITools.getAPIname(apiName), "[ERROR]"+response+"{"+APITools.replaceBlank(APITools.xmlInfo.trim())+"}");
//
//			}
//			
//		}
	 public static void xmlCheck(String response,String element,String status) throws Exception{//状态检查

			if(XML.string2Doc(response).getRootElement().getChildText(element).equals(status)){			
				APITools.getInfo(logInfo, APITools.getAPIname(apiName), response+APITools.replaceBlank(APITools.xmlInfo.trim()));

			}else{
				APITools.getInfo(errorInfo, APITools.getAPIname(apiName), "[ERROR]"+response+APITools.replaceBlank(APITools.xmlInfo.trim()));

			}
			
		}
	 public static void jsonCheck(String response,String params,String status) throws Exception{//状态检查

			if(APITools.toJson(response).get("status").equals(status)){			
				APITools.getInfo(logInfo, APITools.getAPIname(apiName), response+"{"+params+"}");

			}else{
				APITools.getInfo(errorInfo, APITools.getAPIname(apiName), "[ERROR]"+response+"{"+params+"}");

			}
			
		}

	public static String subStr(String response,String str){//截任意字符串
		response=response.trim();
		int a=response.indexOf(str);
		int b=response.indexOf(str,a+str.length()+1);
		String flag=response.substring(a+str.length()+1,b-2);

		return flag;
		 	}

	public static String getFuncName() { // 获取函数名
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		return traceElement.getMethodName();
	}

	public static String getPhoneNum() {// 生成手机号

		return "17"+ String.valueOf((int) (Math.random() * 900000000) + 100000000);
	}
	public static String getPhoneNum2() {// 生成手机号2

		return "12"+ String.valueOf((int) (Math.random() * 900000000) + 100000000);
	}
	public static String getUserName() {// 生成用户名

		return "s_pa"+ String.valueOf((int) (Math.random() * 90000000) + 10000000)+EnglishName();
	}
	public static String getIP() throws Exception{//获得IP地址
		InetAddress addr = InetAddress.getLocalHost();
		String ip=addr.getHostAddress().toString();//获得本机IP
		//String address=addr.getHostName().toString();//获得本机名称
		//System.out.println(ip);//
		return ip;
	}
	public static String getAPIname(String APIname){//格式API名称
		return String.format("%-22s", String.format("[%s]", APIname));
	}
	public static String getParams(String params){//格式参数说
		return String.format(String.format("(%s)", params));
	}

	public static void getInfo(StringBuffer info,String APIname,String response){//拼凑log信息
		response=response.replaceAll("/", "").replaceAll("><", "|").replaceAll("<", "|").replaceAll(">", "|");
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());		
		 info.append(date+" "+APIname+" "+response).append(System.getProperty("line.separator"));			
	}
	public static void doException(String APIname,StringBuffer info,Exception e) 
	{//处理异常
		e.printStackTrace();
		getInfo(info,getAPIname(APIname),"[ERROR]"+e.toString());

	}

	public static String replaceBlank(String str) {// 替换 回车 空格 换行
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}/*----------------------------------- /
	注：\n 回车
	\t 水平制表符(\u0009)
	\s 空格(\u0008)
	\r 换行( 
	)*/
	public static String EnglishName() { // 随机生成英文名
		Random rand = new Random();

		final int A = 'a', z = 'z';

		// for (int i = 0; i < 10; i++) {
		StringBuilder sb = new StringBuilder();
		while (sb.length() < 4) {
			int number = rand.nextInt(z + 1);
			if (number >= A) {
				sb.append((char) number);
			}
		}

		// System.out.println(sb.toString());
		// }
		return sb.toString();

	}
	public static JSONObject toJson(String s){//转json
		return (JSONObject) JSONValue.parse(s);
		
	}
	public static String getDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
	JSONObject josn=new JSONObject();
	Map <String, String> ingredients = new HashMap <String, String>();

	//josn.put("ingredients", ingredients);
	 String userid="6A04A49CA00227FFEB9090A3B20F44AD@qq.sohu.com";
//	  String appid="1120";
//	  String appkey="4xoG%9>2Z67iL5]OdtBq$l#>DfW@TY";
	  String appid="1044";
	  String appkey="4xoG%9>2Z67iL5]OdtBq$l#>DfW@TY";
	  String ct=String.valueOf(System.currentTimeMillis());
	  String code=PPTools.md5(userid + appid + appkey + ct);
	
	  ingredients.put("userid",userid);
	  ingredients.put("openid", "6A04A49CA00227FFEB9090A3B20F44AD@qq.sohu.com");
	  ingredients.put("appid", appid);
      // parameterMap.put("app_key", new String[]{"test"});
      // parameterMap.put("product_id", new String[]{"9999"});
	  ingredients.put("ct", ct);
	  ingredients.put("code", code);
	josn.putAll(ingredients);
	System.out.println(josn);
	String response=CommonTools.createXMLURLConnection("http://10.11.49.38:8007/openlogin/api/token/get", josn.toJSONString());
	System.out.println(response);
		//System.out.println(InetAddress.getByName("internal-test.apps.sohuno.com"));
		
	}

}
