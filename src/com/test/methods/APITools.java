package com.test.methods;

import java.io.InputStream;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;







import net.sf.json.JSONObject;







public class APITools {
	public static String xmlInfo=null;
	 public static StringBuffer errorInfo=new StringBuffer();
	 public static String apiName=null;
	 public static StringBuffer logInfo=new StringBuffer();
//	 public static void xmlCheck(String response,String params,String status) throws Exception{//״̬���
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
	 public static void xmlCheck(String response,String element,String status) throws Exception{//״̬���

			if(XML.string2Doc(response).getRootElement().getChildText(element).equals(status)){			
				APITools.getInfo(logInfo, apiName, response+APITools.replaceBlank(APITools.xmlInfo.trim()));

			}else{
				APITools.getInfo(errorInfo, apiName, "[ERROR]"+response+APITools.replaceBlank(APITools.xmlInfo.trim()));

			}
			
		}
	 public static String getInfoFromXML(String response,String element) throws Exception{
		return XML.string2Doc(response).getRootElement().getChildText(element);
		 
	 }
	 public static void jsonCheck(String response,String element,String status) throws Exception{//״̬���

			if(APITools.toJson(response).get(element).equals(status)){			
				APITools.getInfo(logInfo, APITools.apiName, response);

			}else{
				APITools.getInfo(errorInfo, APITools.apiName, "[ERROR]"+response+APITools.replaceBlank(APITools.xmlInfo.trim()));

			}
			
		}
	 public static String  getXMLelement(String xml,String tag) throws Exception{
		return XML.string2Doc(xml).getRootElement().getChildText(tag);
		 
	 }
	public static String subStr(String response,String str){//�������ַ���
		response=response.trim();
		int a=response.indexOf(str);
		int b=response.indexOf(str,a+str.length()+1);
		String flag=response.substring(a+str.length()+1,b-2);

		return flag;
		 	}

	public static String getFuncName() { // ��ȡ������
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		return traceElement.getMethodName();
	}

	public static String getPhoneNum() {// �����ֻ���

		return "17"+ String.valueOf((int) (Math.random() * 900000000) + 100000000);
	}
	public static String getPhoneNum2() {// �����ֻ���2

		return "12"+ String.valueOf((int) (Math.random() * 900000000) + 100000000);
	}
	public static String getUserName() {// �����û���

		return "sspa"+ String.valueOf((int) (Math.random() * 90000000) + 10000000)+EnglishName();
	}
	public static String getIP() throws Exception{//���IP��ַ
		InetAddress addr = InetAddress.getLocalHost();
		String ip=addr.getHostAddress().toString();//��ñ���IP
		//String address=addr.getHostName().toString();//��ñ�������
		//System.out.println(ip);//
		return ip;
	}
	public static String getAPIname(String APIname){//��ʽAPI����
		return String.format("%-22s", String.format("[%s]", APIname));
	}
	public static String getParams(String params){//��ʽ����˵
		return String.format(String.format("(%s)", params));
	}

	public static void getInfo(StringBuffer info,String APIname,String response){//ƴ��log��Ϣ
		response=response.replaceAll("/", "").replaceAll("><", "|").replaceAll("<", "|").replaceAll(">", "|");
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());		
		 info.append(date+" "+APITools.getAPIname(APIname)+" "+response).append(System.getProperty("line.separator"));			
	}
	public static void doException(String APIname,StringBuffer info,Exception e) 
	{//�����쳣
		e.printStackTrace();
		getInfo(info,APIname,"[ERROR]"+e.toString()+APITools.replaceBlank(APITools.xmlInfo.trim()));

	}

	public static String replaceBlank(String str) {// �滻 �س� �ո� ����
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}/*----------------------------------- /
	ע��\n �س�
	\t ˮƽ�Ʊ��(\u0009)
	\s �ո�(\u0008)
	\r ����( 
	)*/
	public static String EnglishName() { // �������Ӣ����
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
	
	public static JSONObject toJson(String s){//תjson
		return JSONObject.fromObject(s);
		
	}
	public static String getDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	public static String  getProperty(String value){
		InputStream inputStream =APITools.class.getClassLoader().getResourceAsStream("internal.properties");   
		  Properties p = new Properties();   
		  try {   
		   p.load(inputStream);   
		  } catch (Exception e1) {   
		   e1.printStackTrace();   
		  }   
		//System.out.println("ip:"+p.getProperty("ip")+",port:"+p.getProperty("port")); 
		return p.getProperty(value);
	}
	public static void main(String[] args) throws Exception {
String s="{\"error_code\":\"10200\",\"access_token\":\"9eeedd319b2644d99cc4709a29c2bf95\"}";

		System.out.println(JSONObject.fromObject(s).getString("access_token"));
		
	}

}
