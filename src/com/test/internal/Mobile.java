package com.test.internal;

import com.test.methods.APITools;
import com.test.methods.CommonTools;
import com.test.methods.PPTools;
import com.test.methods.Params;
import com.test.methods.XML;

/*
 * Internal涉及到手机的接口
 */


public class Mobile {
	 static StringBuffer errorInfo=new StringBuffer();
	 public static String apiName=null;
	 static StringBuffer logInfo=new StringBuffer();
	 public static void check(String response,String params,String status) throws Exception{//状态检查
			logInfo=APITools.getInfo(logInfo, APITools.getAPIname(apiName), response+"{"+params+"}");

			if(!XML.string2Doc(response).getRootElement().getChildText("status").equals(status)){			
			
				errorInfo=APITools.getInfo(errorInfo, APITools.getAPIname(apiName), response+"{"+params+"}");
			}
			
		}
	static String PhoneNum=APITools.getPhoneNum();
	static String user1="online00015@sohu.com";
	static String user2="online00016@sohu.com";
	
	public static String wapAuthMobile(String userName ,String PhoneNumber) throws Exception{//————————用户验证手机号码0
		//status为0成功，1参数错误，2验证码错误，3用户不存在，5用户已经绑定了手机 6验证手机失败 
		String appid = "200";
		String mobile = PhoneNumber;
		String key = "sohu_test";
	String userid = userName;
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";
		String str_url = Params.DOMAIN+"interface/wapauthmobile";
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();

		System.out.println("————————————用户验证手机————————");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String regmobiled(String PhoneNum) throws Exception {//——————使用手机号直接注册且完成手机绑定
		String appid = "200";
		String key = "sohu_test";
		String createip = "10.1.80.232";
		String mobile = PhoneNum;
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(mobile + appid + key + ct);
		String password = "12345687";
		String passwordtype = "0";
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/regmobiled";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<register>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		xml.append("<passwordtype>" + passwordtype + "</passwordtype>\r\n");

		xml.append("<createip>" + createip + "</createip>\r\n");

		xml.append("</register>");

		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();

  System.out.print("**************************手机注册***********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String mobileRegUser() throws Exception{//————手机app用户注册4
		//0成功，1参数错误，2验证码错误，3非法userid，4userid已经存在，6创建用户失败 5进入黑名单 7.手机已经被绑定（wap专用） 8 非法用户名uniqname 9 用户名uniquename已存在 10 调用超限（一个appid5分钟调用超过了700次）11 不能注册vip.sohu.com的账号
		String appid = "9998";
		String key = "test";
		String userid = "mo3bile_102@sohu.com";
		String question = "tadmin_question";
		String answer = "tadmin_anasdswer";
		String vcode = "aaa";
		
		// String password = "testtest";
		String password = "12345687";
		String passwordtype = "0";
		String uniqname = "mobile127";
		String mobile = "18810606544";
		
		String ostype ="02";
		String modeltype ="ffff";
		String mask="1101";
		
		String imei="1";
		String imsi="1097";
		String mac="";
		String uuid="1097";
		String gid=null;
		if("".equals(imei) && "".equals(imsi) &&"".equals(mac)){
			gid = ostype + modeltype + appid + mask + PPTools.md5(uuid);
		}else{
			gid = ostype + modeltype + appid + mask + PPTools.md5(imei + imsi + mac);
		}
		String sig = PPTools.md5(userid+appid+gid+key );
		
		String rtn_xml = "";

		String str_url = "http://passport.sohu.com/mobile/reguser";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<register>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<sig>" + sig + "</sig>\r\n");
		xml.append("<gid>" + gid + "</gid>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		xml.append("<passwordtype>" + passwordtype + "</passwordtype>\r\n");
		xml.append("<question>" + question + "</question>\r\n");
		xml.append("<answer>" + answer + "</answer>\r\n");
//		xml.append("<uniqname>" + uniqname + "</uniqname>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		
		
		xml.append("<ostype>" + ostype + "</ostype>\r\n");
		xml.append("<modeltype>" + modeltype + "</modeltype>\r\n");
		xml.append("<mask>" + mask + "</mask>\r\n");
		xml.append("<imei>" + imei + "</imei>\r\n");
		xml.append("<imsi>" + imsi + "</imsi>\r\n");
		xml.append("<mac>" + mac + "</mac>\r\n");
		xml.append("<uuid>" + uuid + "</uuid>\r\n");
		
		
		xml.append("<vcode>" + vcode + "</vcode>\r\n");

		xml.append("</register>");
		APITools.xmlInfo=xml.toString();
		System.out.println("——————————手机APP用户注册————————————");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String wapAuth() throws Exception {//————??———无线passport用户认证内部校验接口3
		String appid = "200";//
		String userid = "zhangxiumin2010@sohu.com";
		String password = "12345687";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/wap_auth.jsp";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<password><![CDATA[" + password + "]]></password>\r\n");
		xml.append("<pwdtype>" + 0 + "</pwdtype>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("******************************************wapAuthTest******************************************");
		System.out.println(rtn_xml);
		
		return rtn_xml; 
	}
	public static String sendSms(String PhoneNum,String message) throws Exception {//——————发送短信success
		String mobile = PhoneNum;
		String appid = "9998";
		String key = "iqE?q#gv8--`G/jGA51]=ZANMg?=Lm";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(mobile + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/sendsms";

		String msg = message;
		String gwid = "507";
		String columnid = "5912";
		String linkid = "";
		String spcode = "1069019522832";
		String param = "0";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<msg>" + msg + "</msg>\r\n");
		xml.append("<gwid>" + gwid + "</gwid>\r\n");
		xml.append("<columnid>" + columnid + "</columnid>\r\n");
		xml.append("<linkid>" + linkid + "</linkid>\r\n");
		xml.append("<spcode>" + spcode + "</spcode>\r\n");
		xml.append("<param>" + param + "</param>\r\n");
		xml.append("</auth>");

		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		
		System.out.println("**********************************sendSmsTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}

	public static String switchMobile(String user1,String user2,String PhoneNum) throws Exception{//——————切换手机号绑定和验证的用户0
		//0 ：成功 1 ：输入参数错 2 : 验证码错误，非法调用者
	//	3 : 没有userid账号（设置验证手机接口是的userid没有，切换绑定与验证时userid1与userid2任何一个不存在，都返回3）
	//	5 ：已存在绑定手机，不能设置验证手  6 : userid1的绑定手机与给定的mobile不符
	//	7 ：userid2的验证手机与给定的mobile不符  8 ：userid1 没有绑定手   9 : userid2 没有验证手机  10 ：操作失败(数据库操作异常等)
	String appid = "200";
		String mobile =PhoneNum;
		String key = "sohu_test";
		String userid1=user1;
        String userid2=user2;
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid1+userid2 + appid + key + ct);
		String rtn_xml = "";

//		String str_url = Params.DOMAIN+"interface/wap_switch_mobile.jsp";
		String str_url = Params.DOMAIN+"interface/wapswitchmobile";
		
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid1>" + userid1 + "</userid1>\r\n");
		xml.append("<userid2>" + userid2 + "</userid2>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		System.out.println("**********************************switchMobileTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String wapGetUserid() throws Exception{//————————手机绑定的帐号查询0
		//status为0成功，1参数错误，2验证码错误，3手机号码没有绑定用户， 6查询失败
		String appid = "1073";
		String mobile = "17888888888";
		String key = "?qPQ(UIeRoq.=c+IYYx%x7159ZpF'=";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5( mobile+appid + key + ct);
		String rtn_xml = "";

//		String str_url = Params.DOMAIN+"interface/wap_get_useridlist.jsp";
		String str_url = Params.DOMAIN+"interface/wapgetuserid";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");

		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************wapGetUseridTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String wapBindMobile(String userName,String PhoneNum) throws Exception {//——————用户绑定手机号0
		//status为0成功，1参数错误，2验证码错误，3用户不存在，4用户已经绑定了手机号码，5该手机已经绑定了用户 6绑定手机失败 7手机绑定次数超限（一个手机一天只能绑定3次）
		String userid = userName;
		String appid = "200";
		String mobile = PhoneNum;
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";
		
		String str_url = Params.DOMAIN+"interface/wapbindmobile";
		//String str_url = Params.DOMAIN+"interface/wap_bind_mobile.jsp";
		

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		//xml.append("<usertype>" + usertype + "</usertype>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************wapBindMobileTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}	
	public static String wapUnBindMobile(String PhoneNum) throws Exception{//——————用户解除绑定手机号0
		String appid = "200";//status为0成功，1参数错误，2验证码错误，3手机号码没有绑定帐号， 4,该用户是手机邮箱用户，不能进行解除绑定6解除绑定手机失败
		String mobile = PhoneNum;
		String key = "sohu_test";
     
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(mobile + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/wapunbindmobile";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		//xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		//System.out.println(xml);
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		
		System.out.println("**********************************unBindMobileTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getMobileInfoByUserid() throws Exception{//——————查询一个帐号手机绑定和验证的列表0
		//Status说明：0：成功1：输入参数错误2：验证码错误，非法调用者, 3：用户不存在
		//flag说明：1：绑定，2：验证 0：未绑定也未验证mobile:绑定或者验证的手机号

		String appid = "200";
		String key = "sohu_test";
        String userid="starlifht@sohu.com";
		//String userid = "test_014@chinaren.com";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/wapgetmobileinfo";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
	
		System.out.println("**********************************getMobileInfoByUseridTest*********************************");
		
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String wap_get_mobile(String userID) throws Exception {//——————查询用户是否绑定手机0
		//Status: 0 ：成功  -1：没有帐户绑定关系发生变化 6：数据库异常
		String userid = userID;
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";
		String str_url = Params.DOMAIN+"interface/wap_get_mobile.jsp";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());


		System.out.println("**********************************wap_get_mobileTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUseridListByMobile() throws Exception{//————查询手机号验证和绑定的列表0
		//Status说明：1：输入参数错误2：code错误0：查询成功10：查询异常

		String appid = "200";
		String mobile = "15210847016";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5( mobile+appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/wapgetuseridlist";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		
		System.out.println("**********************************getUseridListByMobileTest*********************************");

		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String  sendJms() throws Exception {
		String message = "{\"messageType\":\"update\",\"user\":{\"userid\":\"zhangxiumin2010@sohu.com\",\"uniqname\":\"houlinyan01\",\"ip\":\"10.1.80.103\"},\"sendAppid\":\"9998\"}";
		String appid = "1097";
		//String appid = "200";
		String key = "SN*ET4EH+%=&Su<m%U[9oclrO)s%s4";
		//String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(message + appid + key + ct);
		String ip = "10.1.80.103";
		String type = "update";
		String str_url = Params.DOMAIN+"interface/send_jms.jsp";
		StringBuffer xml = new StringBuffer();

		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<message>" + message + "</message>\r\n");

		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<ip>" + ip + "</ip>\r\n");
		xml.append("<type>" + type + "</type>\r\n");
		xml.append("</info>");
		APITools.xmlInfo=xml.toString();
		String rtn_xml;
		
		//System.out.println(xml);
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static  String mobile_gettoken() throws Exception{//——————手机app用户登陆获取认证Token 
		//0：成功，同时返回token节点 1：缺少必填项（userid/password/appid/sig/gid） 2: sig错误 3：密码错误 6：失败

		String userid = "s_pa67153888gqou@sohu.com"; 
		String password = PPTools.md5("12345687");
		String appid = "9998";
		String key = "test";
		String rtn_xml = "";
		
		
		String ostype ="02";
		String modeltype ="ffff";
		String mask="1101";
		
		String imei="1";
		String imsi="1097";
		String mac="";
		String uuid="1097";
		String gid=null;
		if("".equals(imei) && "".equals(imsi) &&"".equals(mac)){
			gid = ostype + modeltype + appid + mask + PPTools.md5(uuid);
		}else{
			gid = ostype + modeltype + appid + mask + PPTools.md5(imei + imsi + mac);
		}
		 
		String sig = PPTools.md5(userid+appid+gid+key );
		System.out.println(userid+appid+gid+key);
//		String str_url = "http://internal.passport.sohu.com/interface/wap_auth_mobile.jsp";
		String str_url = Params.DOMAIN+"mobile/gettoken";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<sig>" + sig + "</sig>\r\n");
		xml.append("<gid>" + gid + "</gid>\r\n");

		
		
		xml.append("</info>");
		APITools.xmlInfo=xml.toString();
		//System.out.println(xml);
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		System.out.println("\n");
		System.out.println(rtn_xml);
	

		return rtn_xml;
	}
	public static String  mobile_authtoken () throws Exception{

		String userid = "s_pa31594145yjaz@sohu.com"; 
		String appid = "9998";
		String key = "iqE?q#gv8--`G/jGA51]=ZANMg?=Lm";
		String token = "31fad3316d00a1c33977ab49540337f2";
		String rtn_xml = "";
		String ostype ="02";
		String modeltype ="ffff";  
		String mask="1101";
	String imei="1";
		String imsi="1097";
		String mac="";
		String uuid="1097";
		String gid=null;
		if("".equals(imei) && "".equals(imsi) &&"".equals(mac)){
		    gid = ostype + modeltype + appid + mask + PPTools.md5(uuid);
		}else{
		    gid = ostype + modeltype + appid + mask + PPTools.md5(imei + imsi + mac);
		}
	String sig = PPTools.md5(userid+token+appid+gid+key );
	System.out.println(userid + token + appid + gid + key);
		String str_url = Params.DOMAIN+"interface/mobile_authtoken";
	StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<token>" + token + "</token>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<sig>" + sig + "</sig>\r\n");
		xml.append("<gid>" + gid + "</gid>\r\n");
	xml.append("</info>");
	APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		System.out.println(gid);
		System.out.println(rtn_xml);
		System.out.println("********************************mobile_authtokenTest********************************");
		return rtn_xml;

		}

	public static String  regmobileuser(String PhoneNum) throws Exception{//————————手机app注册手机用户
	String appid = "200";
	String mobile = PhoneNum;
	String key = "sohu_test";
	String password = "12345687";
	String captcha ="6032";
	String ct = String.valueOf(System.currentTimeMillis() / 1000);
	String ostype ="02";
	String modeltype ="ffff";
	String mask="1101";

	String imei="1";
	String imsi="1097";
	String mac="";
	String uuid="1097";
	String gid=null;
	if("".equals(imei) && "".equals(imsi) &&"".equals(mac)){
	gid = ostype + modeltype + appid + mask + PPTools.md5(uuid);
	}else{
	gid = ostype + modeltype + appid + mask + PPTools.md5(imei + imsi + mac);
	}
	 
	String sig = PPTools.md5(mobile+appid+gid+key );
	String rtn_xml = "";

	// String str_url =
	String str_url = "http://passport.sohu.com/mobile/regmobileuser";

	StringBuffer xml = new StringBuffer();
	xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	xml.append("<info>\r\n");
	xml.append("<mobile>" + mobile + "</mobile>\r\n");
	xml.append("<password>" + password + "</password>\r\n");
	xml.append("<captcha>" + captcha + "</captcha>\r\n");
	xml.append("<appid>" + appid + "</appid>\r\n");
	xml.append("<ct>" + ct + "</ct>\r\n");
	xml.append("<gid>" + gid+ "</gid>\r\n");
	xml.append("<sig>" + sig+ "</sig>\r\n");
	xml.append("</info>");

	APITools.xmlInfo=xml.toString();
	rtn_xml =CommonTools.createXMLURLConnection(str_url, xml.toString());
	
	System.out.println(rtn_xml);
	return rtn_xml;
	}
	public static String  sendmobileregcaptcha(String PhoneNum) throws Exception {//——————获取注册手机的验证码

		String mobile = PhoneNum;
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(mobile + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/sendmobileregcaptcha";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<mobile>" + mobile + "</mobile>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");

		xml.append("</info>");
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		System.out.println(rtn_xml);
		System.out.println("**********************************sendemailcaptchaTest()*********************************");
		return rtn_xml;
		}
	 public static String  regist_mobilecaptcha(String Num) throws Exception {//——————手机验证码校验
//status 0：成功 1：参数错误 2：接口签名校验不通过 3：系统错误 4：账号已经存在 5：手机号已经绑定了其他账号 6：发送验证码的次数超限 7：验证码校验次数超限 8：验证码错误或者已经过期
	       String mobile = Num;
	       String appid = "200";
	       String key = "sohu_test";
	       String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       String code = PPTools.md5(mobile + appid + key + ct);
	       String rtn_xml = "";
	       String password = "12345687";
	       String captcha ="5304";
	       String str_url = "http://internal.passport.sohu.com/interface/register/mobilecaptcha";
      StringBuffer xml = new StringBuffer();
     xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	       xml.append("<bind>\r\n");
	       xml.append("<mobile>" + mobile + "</mobile>\r\n");
	       xml.append("<appid>" + appid + "</appid>\r\n");
	       xml.append("<ct>" + ct + "</ct>\r\n");
	       xml.append("<code>" + code + "</code>\r\n");
	       xml.append("<password>" + password + "</password>\r\n");
	       xml.append("<captcha>" + captcha + "</captcha>\r\n");
    xml.append("</bind>");
    APITools.xmlInfo=xml.toString();
	       rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
    System.out.println(rtn_xml);

	    System.out.println("**********************************regist_mobilecaptcha********************************");
		return rtn_xml;

	}
	  public static String sendcaptcha() throws Exception {//-------验证码手机绑定id
//0 成功，1参数错误，2code错误，3 发送短信验证码次数超限，4 手机号@sohu.com的账号已经存在，5 手机号已经绑定了其他账号，6 手机号没有绑定账号，7手机号@sohu.com的账号不能解除绑定，9系统错误
	       String mobile = "17210847012";
	       String appid = "200";
	       String key = "sohu_test";
	       String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       String code = PPTools.md5(mobile + appid + key + ct);
	       String rtn_xml = "";
	       String str_url = "http://internal.passport.sohu.com/interface/sendcaptcha";
	       String type= "4";

	       StringBuffer xml = new StringBuffer();
	       xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	       xml.append("<info>\r\n");
	       xml.append("<mobile>" + mobile + "</mobile>\r\n");
	       xml.append("<appid>" + appid + "</appid>\r\n");
	       xml.append("<ct>" + ct + "</ct>\r\n");
	       xml.append("<code>" + code + "</code>\r\n");
	       xml.append("<type>" + type + "</type>\r\n");

	       xml.append("</info>");
	       
	       APITools.xmlInfo=xml.toString();
	       rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

	       System.out.println(rtn_xml);
	   
		return rtn_xml;
	    }
	  public static String BindMobile() throws Exception {//-------绑定手机接口（验证码）
		  //0成功，1参数错误，2验证码错误，3用户不存在，4用户已经绑定了手机号码，5该手机已经绑定了用户，6绑定手机失败，7手机绑定次数超限（一个手机一天只能绑定3次）
	       String userid = "asd555qwe@sohu.com";
	       String appid = "200";
	       String mobile = "15698563256";
	       String key = "sohu_test";
	       String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       String code = PPTools.md5(userid + appid + key + ct);
	       String rtn_xml = "";
	       String captcha= "5123";
	       
	       String str_url = "http://internal.passport.sohu.com/interface/bindmobile";
	       
	       StringBuffer xml = new StringBuffer();
	       xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	       xml.append("<auth>\r\n");
	       
	       xml.append("<userid>" + userid + "</userid>\r\n");
	       xml.append("<mobile>" + mobile + "</mobile>\r\n");
	       xml.append("<appid>" + appid + "</appid>\r\n");
	       xml.append("<ct>" + ct + "</ct>\r\n");
	       xml.append("<code>" + code + "</code>\r\n");
	       xml.append("<captcha>" + captcha + "</captcha>\r\n");
	       xml.append("</auth>");
	       APITools.xmlInfo=xml.toString();
	       rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

	       System.out.println(rtn_xml);
	 
		return rtn_xml;
	    }
	  public static String UnbindMobile() throws Exception {//——解除绑定验证码
		    //0成功，1参数错误，2验证码错误，3手机号码没有绑定帐号， 4,该用户是手机邮箱用户，不能进行解除绑定，6解除绑定手机失败
	       String appid = "200";
	       String mobile = "15696582365";
	       String key = "sohu_test";
	       String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       String code = PPTools.md5(mobile + appid + key + ct);
	       String rtn_xml = "";
	       String captcha= "5510";

	       
	       String str_url = "http://internal.passport.sohu.com/interface/unbindmobile";

	       StringBuffer xml = new StringBuffer();
	       xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	       xml.append("<auth>\r\n");
	       
	       xml.append("<mobile>" + mobile + "</mobile>\r\n");
	       xml.append("<appid>" + appid + "</appid>\r\n");
	       xml.append("<ct>" + ct + "</ct>\r\n");
	       xml.append("<code>" + code + "</code>\r\n");
	       xml.append("<captcha>" + captcha + "</captcha>\r\n");
	       xml.append("</auth>");
	       APITools.xmlInfo=xml.toString();
	       rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

	       System.out.println(rtn_xml);
		return rtn_xml;
	
	    }




	public static void main(String[] args) throws Exception {
mobileRegUser();
//		mobile_gettoken();
	//wapAuthMobile(user1,PhoneNum);
//mobileRegUser();
//wapBindMobile(user2,PhoneNum);
//switchMobile(user2,user1,PhoneNum);
//	wapGetUserid();
//		unbindMobile(user2,PhoneNum);
		//unbindMobile("18810606513@sohu.com","18810606513");
		//____________________________________
		//mobile_gettoken();
//		sendcaptcha();
//		BindMobile();
//		UnbindMobile();
		//wapAuth();
		//sendSms("11110606513","sdfsd");
		//regmobiled("18810606511");
		//getMobileInfoByUserid();
	//regmobileuser("17710606513");
		//CommonTools.HttpGet("http://hexapixel.com/download.php?file=com.hexapixel.widgets.ribbon.alphatest.src.jar");
		//sendmobileregcaptcha();
		//getUseridListByMobile();
		//mobile_gettoken();
	}

}
