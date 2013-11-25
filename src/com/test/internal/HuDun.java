package com.test.internal;

import com.test.methods.APITools;
import com.test.methods.CommonTools;
import com.test.methods.Params;
import com.test.methods.XML;






public class HuDun {
	
	public static String synchudun(String userID) throws Exception{//������������ͬ��������Ϣ
		//0�ɹ���1��������2��֤�����3 type ��Чֵ 4 δ�󶨺��ܣ� 6 ����ʧ��
        String appid = "200";
        String key = "sohu_test";
        String ct = String.valueOf(System.currentTimeMillis() / 1000);
        String userid = userID;
        String serialNumber = "320538701658";
        String mobile = "15210847015";
        String type="bind";         
        String code = PPTools.md5(userid+appid+key+ct);
        String rtn_xml = "";
        String str_url = Params.DOMAIN+"interface/synchudun";
        StringBuffer xml = new StringBuffer();
        xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
        xml.append("<info>\r\n");
        xml.append("<userid>" + userid + "</userid>\r\n");
        xml.append("<serialNumber>" + serialNumber + "</serialNumber>\r\n");
        xml.append("<mobile>" + mobile+ "</mobile>\r\n");
        xml.append("<type>" +type+ "</type>\r\n");
        xml.append("<appid>" + appid + "</appid>\r\n");
        xml.append("<ct>" + ct + "</ct>\r\n");
        xml.append("<code>" + code+ "</code>\r\n");
        xml.append("</info>");
        rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();

        System.out.println("********************************synchudun*****************************");
        System.out.println(rtn_xml);
        return rtn_xml;
	}
	public static String sethudunconfig(String userID) throws Exception{
        String appid = "200";
        String key = "sohu_test";
        String ct = String.valueOf(System.currentTimeMillis() / 1000);
        String userid = userID;
        String configName = "login";
        String configValue = "1";
              
        String code = PPTools.md5(userid+appid+key+ct);
        String rtn_xml = "";

        String str_url = Params.DOMAIN+"interface/sethudunconfig";

        StringBuffer xml = new StringBuffer();
        xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
        xml.append("<info>\r\n");
        xml.append("<userid>" + userid + "</userid>\r\n");
        xml.append("<configName>" + configName + "</configName>\r\n");
        xml.append("<configValue>" + configValue+ "</configValue>\r\n");
        xml.append("<appid>" + appid + "</appid>\r\n");
        xml.append("<ct>" + ct + "</ct>\r\n");
        xml.append("<code>" + code+ "</code>\r\n");
        xml.append("</info>");

        rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();

	        System.out.println("*********************************BindMobileTest*****************************");
	        System.out.println(rtn_xml);
	       
			return rtn_xml;

		}
	 public static String gethudunconfig(String userID) throws Exception{//��ѯ��ȫ������Ϣ
			//status 0�ɹ���1��������2��֤�����4 δ�󶨺��ܣ� 6 ����ʧ��
	        String appid = "200";
	        String key = "sohu_test";
	        String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       // String userid = "rain00a@sohu.com";
	        String userid=userID;
	        String code = PPTools.md5(userid+appid+key+ct);
	        String rtn_xml = "";
	        String str_url = Params.DOMAIN+"interface/gethudunconfig";
	        StringBuffer xml = new StringBuffer();
	        xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	        xml.append("<info>\r\n");
	        xml.append("<userid>" + userid + "</userid>\r\n");	       
	        xml.append("<appid>" + appid + "</appid>\r\n");
	        xml.append("<ct>" + ct + "</ct>\r\n");
	        xml.append("<code>" + code+ "</code>\r\n");
	        xml.append("</info>");	        
	        rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());	  
			APITools.xmlInfo=xml.toString();

	        System.out.println("*********************************gethudunconfig*****************************");
	        System.out.println(rtn_xml);
		 return rtn_xml;
		

	}
	 public static String isbind(String userID) throws Exception{//��ѯ�Ƿ�󶨺���
			//0�ɹ���1��֤����2��������500 ����������
	        String appid = "200";
	        String key = "sohu_test";
	        String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       // String userid = "rain00a@sohu.com";
	        String userid=userID;
	       String code = PPTools.md5(userid+appid+key+ct);
	        String rtn_xml = "";
	        String str_url = Params.DOMAIN+"interface/hudun/isbind";
	        StringBuffer xml = new StringBuffer();
	        xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	        xml.append("<info>\r\n");
	        xml.append("<userid>" + userid + "</userid>\r\n");	       
	        xml.append("<appid>" + appid + "</appid>\r\n");
	        xml.append("<ct>" + ct + "</ct>\r\n");
	        xml.append("<code>" + code+ "</code>\r\n");
	        xml.append("</info>");	        
	        rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());	  
			APITools.xmlInfo=xml.toString();
	        System.out.println("*********************************isbind*****************************");
	        System.out.println(rtn_xml);
		 return rtn_xml;
		

	}
	 public static String sendSToken(String userID,String phone) throws Exception{//�·���̬����
			//status 0�ɹ���1��������2��֤�����4 δ�󶨺��ܣ� 6 ����ʧ��
	        String appid = "200";
	        String key = "sohu_test";
	        String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       // String userid = "rain00a@sohu.com";
	        String userid=userID;
	       String code = PPTools.md5(userid+appid+key+ct);
	        String rtn_xml = "";
	        String mobile=phone;
	        String str_url = Params.DOMAIN+"interface/stoken/send";
	        StringBuffer xml = new StringBuffer();
	        xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	        xml.append("<info>\r\n");
	        xml.append("<userid>" + userid + "</userid>\r\n");
	        xml.append("<mobile>" + mobile + "</mobile>\r\n");	
	        xml.append("<appid>" + appid + "</appid>\r\n");
	        xml.append("<ct>" + ct + "</ct>\r\n");
	         xml.append("<code>" + code+ "</code>\r\n");
	        xml.append("</info>");	        
	        rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());	  
			APITools.xmlInfo=xml.toString();
	
	        System.out.println(rtn_xml);
		 return rtn_xml;
		

	}
	 public static String verifySToken(String userID) throws Exception{//У�� ��̬��֤��
			//0�ɹ���1��֤����2��������500 ����������
	        String appid = "200";
	        String key = "sohu_test";
	        String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       // String userid = "rain00a@sohu.com";
	        String userid=userID;
	        String stoken="457767";
	       String code = PPTools.md5(userid+appid+key+ct);
	        String rtn_xml = "";
	        String str_url = Params.DOMAIN+"interface/stoken/verify";
	        StringBuffer xml = new StringBuffer();
	        xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	        xml.append("<info>\r\n");
	        xml.append("<userid>" + userid + "</userid>\r\n");	    
	        xml.append("<stoken>" + stoken + "</stoken>\r\n");
	        xml.append("<appid>" + appid + "</appid>\r\n");
	        xml.append("<ct>" + ct + "</ct>\r\n");
	        xml.append("<code>" + code+ "</code>\r\n");
	        xml.append("</info>");	        
	        rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());	  
			APITools.xmlInfo=xml.toString();
	        System.out.println("*********************************isbind*****************************");
	        System.out.println(rtn_xml);
		 return rtn_xml;
		

	}
	public static void main(String[] args) {
		
		try {
			sendSToken("hudunbind@sohu.com",APITools.getPhoneNum2());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
