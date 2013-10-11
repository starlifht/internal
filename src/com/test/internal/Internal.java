package com.test.internal;



import java.util.HashMap;

import org.json.simple.JSONObject;

import com.test.methods.APITools;
import com.test.methods.CommonTools;
import com.test.methods.PPTools;
import com.test.methods.Params;
import com.test.methods.XML;





public class Internal {
	
	public static String registUser(String userId,String appID, String Key) throws Exception {//�����������������û�ע��
		//0�ɹ���1��������2��֤����3�Ƿ�userid��4userid�Ѿ����ڣ�6�����û�ʧ�� 5��������� 7.�ֻ��Ѿ����󶨣�wapר�ã� 8 �Ƿ��û���uniquename 9 �û���uniquename�Ѵ��� 10 ���ó��ޣ�5���ӵ��ó�����1000�Σ�11 ����ע��vip.sohu.com���˺�
		//String appid = "200";//normal
		//String appid = "1013";//vip
		String appid = appID;//vip
		String key=Key;
		//String key = "sohu_test";//normal
		//String key = "djfi(Y&%ye483y45&%^830934dHisd2y%*HIUGDdii";//vip
		String userid = userId;
		String uniqname = "absouhu4";
		String birthday = "1978-11-16";
		String createip = "10.1.80.232";
		String gender = "2";
		String username = "XIAOxie32";
		String question = "tadmin_question";
		String answer = "tadmin_anasdswer";
		String othermail = "jyslp2002@gmail.com";
		String cardtype = "2";
		String cardid = "412523298207214542";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
	
		String password = "12345687";
		String passwordtype = "0";
		String rtn_xml = "";
    
	    String str_url = Params.DOMAIN+"interface/reguser";
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<register>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		xml.append("<passwordtype>" + passwordtype + "</passwordtype>\r\n");
		xml.append("<question>" + question + "</question>\r\n");
		xml.append("<answer>" + answer + "</answer>\r\n");
		xml.append("<createip>" + createip + "</createip>\r\n");	
		xml.append("</register>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("****************************�û�ע��*************************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static  String getUserinfo(String userId) throws Exception {//������������������ѯ�û���Ϣ0
		String appid = "200";//statusΪ0�ɹ���1��������2��֤�����3�û��������ڣ�����Ǹ����ǳƲ�ѯ��û�в�ѯ��Ҳ�Ƿ���3����4 �ֻ�����û�а� 6ȡ���û���Ϣʧ��
		String key = "sohu_test";
		String userid = userId;
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);

		String str_url = Params.DOMAIN+"interface/getuserinfo";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<register>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n"); 
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<password></password>\r\n");
		xml.append("<passwordtype></passwordtype>\r\n");
		xml.append("<question></question>\r\n");
		xml.append("<answer></answer>\r\n");
		xml.append("<createip></createip>\r\n");
		xml.append("<uniqname>aaa</uniqname>\r\n");
		xml.append("<avatarurl>aaa</avatarurl>\r\n");
		xml.append("<regappid>aaa</regappid>\r\n");
		
        xml.append("<uniqname_force>" + 1 + "</uniqname_force>\r\n");

		xml.append("</register>");
	String rtn_xml = CommonTools.createXMLURLConnection(str_url,
				xml.toString());
	APITools.xmlInfo=xml.toString();
		System.out.println("******************************************getUserinfo******************************************");
		System.out.println(rtn_xml);
		
		return rtn_xml; 

	}
	public static String checkuniqname(String userId) throws Exception {//����������CheckΨһ�û���uniqname0
		String appid = "9998";
//status �� 0���ã�1��������2code���� 3��ռ�ã�  4���д� 5�ܱ��� 6ϵͳ����
		String key = "iqE?q#gv8--`G/jGA51]=ZANMg?=Lm";
		String uniqname = userId;
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(uniqname + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/checkuniqname";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<uniqname>" + uniqname + "</uniqname>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</info>");		
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("*************************check�û�Ψһ��***********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getlastlogin(String userId) throws Exception {//	��������ȡ���û����һ�ε�¼��Ϣ0
		String appid = "200";//statusΪ0�ɹ���1��������2��֤�����3�û���Ϣ�����ڣ�6ȡ���û�����¼��Ϣʧ��
		String key = "sohu_test";
		//String userid = "1881832511@sina.sohu.com";
		String userid=userId;
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);

		String str_url = Params.DOMAIN+"interface/getlastlogin";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<register>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<password></password>\r\n");
		xml.append("<passwordtype></passwordtype>\r\n");
		xml.append("<question></question>\r\n");
		xml.append("<answer></answer>\r\n");
		xml.append("<createip></createip>\r\n");
		xml.append("<uniqname>aaa</uniqname>\r\n");
		xml.append("<avatarurl>aaa</avatarurl>\r\n");
		xml.append("<regappid>aaa</regappid>\r\n");
	xml.append("</register>");
	String rtn_xml = CommonTools.createXMLURLConnection(str_url,
				xml.toString());
	APITools.xmlInfo=xml.toString();
	System.out.println("******************************************getlastloginTest******************************************"); 
		System.out.println(rtn_xml);
		return rtn_xml;

	}
	public static String updateUser(String userId,String uniqName) throws Exception {//�������������޸��û���Ϣ0
		//statusΪ0�ɹ���1��������2��֤�����3userid�����ڣ�6�޸�ʧ�� 8 �û���uniqname ���Ϸ� 9 �û���uniqname �Ѵ��� 10 ���ó��ޣ�5���ӵ��ó�����1000�Σ�11 ��V�û������޸�uniqname
		String appid = "200";
		String key = "sohu_test";
		String userid =userId;
		String uniqname = uniqName;
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String question = "question1";
		String answer = "answer1";
		String str_url = Params.DOMAIN+"interface/updateuser";
		
		
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<register>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<modifyip>10.1.80.103</modifyip>\r\n");
		xml.append("<question>"+question+"</question>\r\n");
		xml.append("<answer>"+answer+"</answer>\r\n");
		xml.append("<uniqname>" + uniqname + "</uniqname>\r\n");

		xml.append("</register>");

		String rtn_xml = CommonTools.createXMLURLConnection(str_url,
				xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************updateUserInfoTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String setOpenBind() throws Exception{//�����������������������Ӱ�0
		//0�������ɹ�1����������,����Ƿ�ȱ�ٱ�����2��code����3��userid�Ѿ������ʺ��ˣ������������ʺ�4��refuserid�Ѿ��Ǹ��ʺ��ˣ������������ʺ�5��һ�����˺�ֻ�ܰ�ͬһ����������һ���˺�6�����������쳣7��userid �Ѿ����󶨣������ظ��󶨡�
		String userid = "3742252238@baidu.sohu.com";
		//String userid = "94F38603463AC159175FB8356166DFBD@qq.sohu.com";
		String refUserid = "zhangxiumin_003@focus.cn";
		String appid = "200";
		String key = "sohu_test";
		String ct =  String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String str_url = Params.DOMAIN+"interface/setopenbind";
			
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<refUserid>" + refUserid + "</refUserid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		
		xml.append("<ip>10.1.80.103</ip>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");

		xml.append("</info>");

		String rtn_xml;
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("******************************setOpenBindTest*******************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String deleteOpenBind() throws Exception{//����������������ɾ���󶨹�ϵ0
		//0�������ɹ�1����������,����Ƿ�ȱ�ٱ�����2��code����6�����������쳣
		//String userid = "6A04A49CA00227FFEB9090A3B20F44AD@qq.sohu.com";
		String userid = "3742252238@baidu.sohu.com";
		String refUserid = "zhangxiumin_003@focus.cn";
		String appid = "200";
		String key = "sohu_test";
		String ct =  String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/deleteopenbind";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<refUserid>" + refUserid + "</refUserid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		
		xml.append("<ip>10.1.80.103</ip>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");

		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
//
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************deleteOpenBindTest*********************************");
		System.out.println(rtn_xml);
		
		return rtn_xml;
	}
	public static String getOpenBindList() throws Exception{//������������������ѯ���б�0
		//0����ѯ�ɹ���ͬʱ����bindList��bindList����json��ʽ�İ��˺��б���expireTime������ʱ���ʽyyyy-MM-dd HH:mm:ss��û��tokenΪ������token��Զ��ЧΪ��-1����appid�����󶨵Ĳ�Ʒid��refuserid:���˺�id������ѯ��userid��
		//1����������,����Ƿ�ȱ�ٱ�����2��code����6�����������쳣

		String userid = "6A04A49CA00227FFEB9090A3B20F44AD@qq.sohu.com";
		String appid = "200";
		String key = "sohu_test";
		String ct =  String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/getopenbind";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");

		xml.append("</info>");
rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
APITools.xmlInfo=xml.toString();
		System.out.println("**********************************getOpenBindListTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
		
	}
	public static String authUser(String userId,String userType) throws Exception {//��������У���û����������Ƿ���ȷ0���û���¼�ӿ�)
		//statusΪ0�û���������ȷ��1��������2code����3�û������벻ƥ�䣬4�����û�δ���5�ֻ�����û�а󶨣�wapר�ã�6У��ʧ��
		String userid =userId;
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";
		String password = "12345687";
		String str_url = Params.DOMAIN+"interface/authuser";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		xml.append("<pwdtype>" + "0" + "</pwdtype>\r\n"); 
		xml.append("<usertype>" + userType + "</usertype>\r\n"); 
		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************authUserTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String deletVUsers(String userId) throws Exception{//��������	ɾ��vip�˺�0
		//status: 0�����ɹ� 1 �������� 2 code���� 3 appid���� 6 ����ʧ��
		String userids = userId;
		String appid = "1013";
		String key = "djfi(Y&%ye483y45&%^830934dHisd2y%*HIUGDdii";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userids + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/deleteusers.jsp";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userids>" + userids + "</userids>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************deletusersTest*********************************");

		System.out.println(rtn_xml);
		return rtn_xml;
	}

	public static String activate(String userId) throws Exception {//������������		�����Ѻ������˺�0
		//statusΪ 0����ɹ���1��������2��֤�����,3 �û�������4�û������ڣ�5 ����ʧ��
				String userid = userId;
				String appid = "200";
				String key = "sohu_test";
				String gid = "afafafasfa";
				String ct = String.valueOf(System.currentTimeMillis() / 1000);
				String code = PPTools.md5(userid + appid + key + ct);
				String rtn_xml = "";

				String str_url = Params.DOMAIN+"interface/activate";

				StringBuffer xml = new StringBuffer();
				xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
				xml.append("<info>\r\n");
				xml.append("<userid>" + userid + "</userid>\r\n");
				xml.append("<appid>" + appid + "</appid>\r\n");
				xml.append("<ct>" + ct + "</ct>\r\n");
				xml.append("<code>" + code + "</code>\r\n");
				xml.append("</info>");
				rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

				APITools.xmlInfo=xml.toString();
				System.out.println("**********************************activateUserTest*********************************");
				System.out.println(rtn_xml);
				return rtn_xml;
			}
	public static String checkUser(String userId) throws Exception {//��������check_user����˺��Ƿ����
		String appid = "200";
		String userid = userId;
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/check_user.jsp";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************checkUserTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String checkV(String userId) throws Exception {//������������û��Ƿ�Ϊ��V�û�5
		//status: 1 �������� 2 code����   4��ѯʧ�� 5 �Ǽ�V�û� 6���Ǽ�V�û�
		String userid =userId;
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/checkV";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</info>");

		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************checkVTest*********************************");

		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String syncv(String userId) throws Exception {//�����������û���V��V0
		//status: 0�����ɹ� 1 �������� 2 code���� 3 ��userid������ 4����ʧ�� 5 ���û�û���û�����Vʧ��
		//String userid = "zhangxiumin2010@sohu.com";
		String userid=userId;
		String appid = "1073";
		String key =  "?qPQ(UIeRoq.=c+IYYx%x7159ZpF'=";
		String opt = "add";//add/del
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/syncv";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<opt>" + opt + "</opt>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************syncvTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUidByUserid(String userID) throws Exception {//������������UseridȡUid<uid>o7891792</uid>
		//���ڣ�����uid�ڵ� �����ڣ�����<status>3</status>
		String userid =userID;
		//String userid = "zhangxiumin_001@changyou.com";
		// String userid = "zjcjack@37wanwan.com";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/getUidByUserid.jsp";
		
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************getUidByUsidTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUserIdByUid(String Uid) throws Exception {//������������UidȡUserid<userid>zhangxiumin_001@changyou.com</userid>
		//���ڷ���userid��ֵ��������userid�ڵ�Ϊ��
		String uid =Uid;
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(uid + appid + key + ct);
		String rtn_xml = "";
		String str_url = Params.DOMAIN+"interface/getUseridByUid.jsp";
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<uid>" + uid + "</uid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************getUserIdByUidTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}	
	public static String getUUidByUserId(String userID) throws Exception {//������������userid��ȡuuid<uuid>cbdcf2706c884e3s</uuid>
		//
		String userid = userID;
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/getuuidbyuserid";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();	
		System.out.println("**********************************getUUidByUserIdTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUserIdByUUid(String UUid) throws Exception {//������������uuid��ȡuserid<userid>zhangxiumin_002@sogou.com</userid>
		String uuid=UUid;
		//String uuid = "b70ba797a1164a1s";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(uuid + appid + key + ct);
		String rtn_xml = "";

		//String str_url = Params.DOMAIN+"interface/getuseridbyuuid";
		String str_url = Params.DOMAIN+"interface/getUseridByUuid.jsp";
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<uuid>" + uuid + "</uuid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************getUserIdByUuiddTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUUidListByUserid() throws Exception {//������������userid������ѯuuid0
		//
		String userid = "107607195@qq.com,online0001@sohu.com";

		//String userid = "test_013@chinaren.com,test_012@sogou.com,bj19090@yahoo.com.cn,zhangxiumin@sohu.com";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/getuuidsbyuserid";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userids>" + userid + "</userids>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<cache>true</cache>\r\n");
		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************getUUidListTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUserIdListByUUid() throws Exception {//������������uuid������ѯuserid0
		String uuid = "b70ba797a1164a1s,a24e89ae955f410n,41c695f8fc7c48ff";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(uuid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/getuseridsbyuuid";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<uuids>" + uuid + "</uuids>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<cache>true</cache>\r\n");
		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************getUserIdByUuidListTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String update_password(String userId) throws Exception {//�����������������û����� 2
		//statusΪ0�ɹ���1��������2��֤�����3�û��������� 4���ʴ������ޣ�1��200�Σ�

		String userid =userId ;
		String password = "12345687";
		String newPassword = "12345687";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/update_password.jsp";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<modifyip>" + "10.1.80.91" + "</modifyip>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		xml.append("<newpassword>" + newPassword + "</newpassword>\r\n");
		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************updatePasswordTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String recoverPassword() throws Exception {//��������recover_password0
		String userid = "wednesday_001@sohu.com";
		String newPassword = "12345687";
		String answer = "zhangxiumin";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/recover_password.jsp";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<modifyip>" + "10.1.80.91" + "</modifyip>\r\n");
		xml.append("<answer>" + answer + "</answer>\r\n");
		xml.append("<newpassword>" + newPassword + "</newpassword>\r\n");
		xml.append("</info>");

		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************recoverPasswordTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String recoverpwd() throws Exception {//�������������ܱ������������� 0
		//0�ɹ���1��������2��֤�����3�û��������ڣ�4��ʾ�����У��ʧ�ܣ�5һ����ͬһ���˺��ܱ����󳬹�6�Σ�6�޸�ʧ��

		String userid = "wednesday_001@sohu.com";
		String newPassword = "12345687";
		String answer = "zhangxiumin";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/recoverpwd";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<modifyip>" + "10.1.80.91" + "</modifyip>\r\n");
		xml.append("<answer>" + answer + "</answer>\r\n");
		xml.append("<newpassword>" + newPassword + "</newpassword>\r\n");
		xml.append("</info>");

		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
	
		System.out.println("**********************************recoverPasswordTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String updatepwd(String userID) throws Exception {//������������updatepwd0 ��֤����
		//String userid = "zhangxiumin2010@sohu.com";
		String userid = userID;
		//String password = "asd123";
		String password = "12345687";
		//String newPassword = "12345687";
		String newquestion = "myname";
		String newanswer = "zhangxiumin";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/updatepwd";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<modifyip>" + "10.1.80.91" + "</modifyip>\r\n");
		xml.append("<newquestion>" + newquestion + "</newquestion>\r\n");
		xml.append("<newanswer>" + newanswer + "</newanswer>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		//xml.append("<usertype>" + 1 + "</usertype>\r\n");
		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************updatepwdTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getCookieInfo(String userID) throws Exception{//��������������ȡcookie��Ϣ
		//Status:���ؽ�� 0:�����ɹ� 1 ����ʧ�� 3���˺Ų�����
		//String userid = "C9E12740CCA4467CC5DF1CBDB651CDDA@qq.sohu.com";
		String userid = userID;
		String appid = "1073";
		String key = "?qPQ(UIeRoq.=c+IYYx%x7159ZpF'=";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String persistentcookie = "1";
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/getcookieinfo";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<persistentcookie>" + persistentcookie + "</persistentcookie>\r\n");
		xml.append("<ip>10.1.80.103</ip>\r\n");
		xml.append("</info>");
		
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************getCookieInfo*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String adminUpdatePassword() throws Exception {//�������������������� 0���Ȩ�� ��CMS
		//statusΪ0�ɹ���1��������2��֤�����3�û��������� 4���ʴ������ޣ�1��200�Σ�
		String userid = "online00030@sohu.com";
		String password = "12345687";
		String appid = "9998";
		String key = "iqE?q#gv8--`G/jGA51]=ZANMg?=Lm";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		// String str_url =
		// Params.DOMAIN+"interface/wap_auth_mobile.jsp";
		String str_url = Params.DOMAIN+"admin/admin_update_password.jsp";

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<modifyip>" + "10.1.80.91" + "</modifyip>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************adminupdatepasswordTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String sendemailcaptcha(String mail) throws Exception {//����������֤��

		String email = mail;
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(email + appid + key + ct);
		String rtn_xml = "";
		// String str_url =
		// Params.DOMAIN+"interface/wap_auth_mobile.jsp";
		String str_url = Params.DOMAIN+"interface/sendemailcaptcha";
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>" +
				"" +
				"\r\n");
		xml.append("<info>\r\n");
		xml.append("<email>" + email + "</email>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</info>");

		//System.out.print(xml);
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************sendemailcaptchaTest()*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}

	public static String getUserBlackList() throws Exception {//���������������µ�½�������б�(������400)
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("Params.DOMAIN", "mail.sohu.com");
		map.put("ip", "10.10.69.199");
		map.put("instance_id", 0);
		map.put("version", "2012-06-06 by douyuan");
		map.put("appid", "9998");
		map.put("update_interval", "5");
		map.put("nginx_version", "1.0.9");
		map.put("update_version", "2");
		String str_url = Params.DOMAIN+"interface/monitorblacklist";
		JSONObject  jsonObject = new JSONObject();
		String s =jsonObject.toJSONString(map);

		String rtn = CommonTools.createURLConnection(str_url,s, "application/json");
	
		System.out.println(s);
		System.out.println("**********************************getUserBlackListTest**********************************");
		System.out.println(rtn);
		return rtn;


		
	}
	 public static String getServerToken() throws Exception{//��������������������passport����Ŀ�ڲ��ṩtoken����Ľӿ�
		 //status	0�����ͳɹ���1����������2��code����������ʧ��
		 //token		session token��������У���û�����

         String appid = "200";
         String key = "sohu_test";
         String ct = String.valueOf(System.currentTimeMillis() / 1000);
         String userid = "ada2013006@qq.sohu.com";        
         String code = PPTools.md5(userid+appid+key+ct);
         String rtn_xml = "";
         String str_url = Params.DOMAIN+"interface/token/get";
         StringBuffer xml = new StringBuffer();
         xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
        xml.append("<info>\r\n");
        xml.append("<userid>" + userid + "</userid>\r\n");
       xml.append("<type>" + 2 + "</type>\r\n");
        xml.append("<appid>" + appid + "</appid>\r\n");
        xml.append("<ct>" + ct + "</ct>\r\n");
         xml.append("<code>" + code+ "</code>\r\n");
         xml.append("</info>");
         rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
         APITools.xmlInfo=xml.toString();
         System.out.println(rtn_xml);
		return rtn_xml;

 }
	 public static String authServerToken (String Token) throws Exception{//�������������ֻ�appУ���������¼��token
//status	0���ɹ���1����������2��code���� 9��server erro
         String appid = "200";
          String key = "sohu_test";
          String userid= "";
          String token = Token;
          String ct = String.valueOf(System.currentTimeMillis() / 1000);
          String code = PPTools.md5(userid+token+appid+key+ct);
          String rtn_xml = "";
          String str_url = Params.DOMAIN+"interface/token/auth";
          StringBuffer xml = new StringBuffer();
          xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
          xml.append("<info>\r\n");
          xml.append("<type>" + 2 + "</type>\r\n");
          xml.append("<token>" + token + "</token>\r\n");
         xml.append("<appid>" + appid + "</appid>\r\n");
          xml.append("<ct>" + ct + "</ct>\r\n");
          xml.append("<code>" + code+ "</code>\r\n");
          xml.append("</info>");     
          rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
          APITools.xmlInfo=xml.toString();
          System.out.println(rtn_xml);
		return rtn_xml;

      }
	 public static String  mailsynchuser(String userId) throws Exception {// ����ͬ���û���Ϣ
		 //status	 0�����ͳɹ���1����������2��code����������ʧ��
       //String userid = "zhangxiumin@sohu.com";
		 String userid = userId;
	       String appid = "1113";
	       String key = "<aVc0Ze*P#xY8y()OWcavQOP(GmsQD";
	       String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       String code = PPTools.md5(userid + appid + key + ct);
	       String rtn_xml = "";
	       String str_url = Params.DOMAIN+"interface/mailsynchuser";
	       StringBuffer xml = new StringBuffer();
	       xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	       xml.append("<bind>\r\n");
	       xml.append("<userid>" + userid + "</userid>\r\n");
	       xml.append("<appid>" + appid + "</appid>\r\n");
	       xml.append("<ct>" + ct + "</ct>\r\n");
	       xml.append("<code>" + code + "</code>\r\n");
	       xml.append("</bind>");
	      // System.out.println(xml);
	       rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
	       APITools.xmlInfo=xml.toString();
	       System.out.println(rtn_xml);
	       return rtn_xml;

	    }
	 public static String Bindemail(String userId) throws Exception {//������������������������������ӿ�
	       //String userid = "��ada123@focus.cn";
		   String userid=userId;
	       String appid = "200";
	       String key = "sohu_test";
	       String ct = String.valueOf(System.currentTimeMillis() / 1000);
	       String code = PPTools.md5(userid + appid + key + ct);
	       String rtn_xml = "";
	       String password = PPTools.md5("12345687");
	       String newbindemail = "sohu_test@163.com";
	       String oldbindemail = "544316911@qq.com";
	       String str_url = Params.DOMAIN+"interface/bindemail";
	       StringBuffer xml = new StringBuffer();
	       xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	       xml.append("<bind>\r\n");
	       xml.append("<userid>" + userid + "</userid>\r\n");
	       xml.append("<appid>" + appid + "</appid>\r\n");
	       xml.append("<ct>" + ct + "</ct>\r\n");
	       xml.append("<code>" + code + "</code>\r\n");
	       xml.append("<password>" + password + "</password>\r\n");
	       xml.append("<newbindemail>" + newbindemail + "</newbindemail>\r\n");
	        xml.append("<oldbindemail>" + oldbindemail + "</oldbindemail>\r\n");
	        xml.append("</bind>");	       
	       rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
	       APITools.xmlInfo=xml.toString();
	       System.out.println(rtn_xml);
	       System.out.println("**********************************wapBindemailTest********************************");
	       return rtn_xml;

	    }
	 public static  String clearuserinfo(String userID, String Type) throws Exception {
			//0�����ɹ� 1 �������� 2 code���� 3 ��userid������ 6 �޸�ʧ�� 8 �û���uniqname ���Ϸ� 9 �û���uniqname �Ѵ��� 10 ���ó��� 11 ��V�û�			//1122 ??? type 1 2    1095 ???type 345
					//String appid = "1122" ;
					String appid ="1095";
					//String key = "t*Gcm>0*oT1EXm826g09gP7<197(@t";//1122
					String key ="NBOJ.#J4O\\D?R[Q1(r&cAH+,_<V$qi";//1095
					String userid = userID;
					String ct = String.valueOf(System.currentTimeMillis()/1000);
					String code = PPTools.md5(userid + appid + key + ct);
					String type = Type;//�ɹ��ܣ�1-����ǳƣ�2-���ͷ�� 3-���������; 4-����ܱ����� ;5-�������״̬
					String str_url = Params.DOMAIN+"interface/admin/clearuserinfo";						
					StringBuffer xml = new StringBuffer();
					xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
					xml.append("<info>\r\n");
					xml.append("<userid>" + userid + "</userid>\r\n");
					xml.append("<appid>" + appid + "</appid>\r\n");
					xml.append("<ct>" + ct + "</ct>\r\n");
					xml.append("<code>" + code + "</code>\r\n");				
					xml.append("<type>"+type+"</type>\r\n");				
					xml.append("</info>");
					String rtn_xml = CommonTools.createXMLURLConnection(str_url,xml.toString());
					APITools.xmlInfo=xml.toString();
					System.out.println(rtn_xml);
					System.out.println("********************************clearuserinfoTest**********************************");
				
						return rtn_xml;
		}



	public static void main(String[] args) throws Exception {
//		List a=ReadFile.readFile();
//		Iterator<String> iter = a.iterator() ; 
//		while(iter.hasNext()) { 
//		String m = iter.next(); 
//		// ��ӡ��Ϣ����Ϣ���浽һ������������ 
//		System.out.println(m); 
//		getUserinfo(m);
//		} 
//		String s="t�Ѻ�dfs";
//		checkuniqname(s);
		//deletVUsers("107607195@vip.sohu.com");
		//registUser("dsf23ds@126.com", "200", "sohu_test");
		//getServerToken();
		//authServerToken("56d2d897daf1e2b5b8cd74e04c6d53c6");
//		setOpenBind();
//		getOpenBindList();
//		deleteOpenBind();
		//getUserinfo("dsfd");
//getCookieInfo("ada2013005@sohu.com");
//		JSONObject js=APITools.toJson(s);
//		System.out.print(js.get("status"));
		//activate("ppauthtest1@focus.cn");
		//getUserBlackList();
		getServerToken();
		//registUser("zhangxiumin_001@sogou.com","200","sohu_test");
		//registUser("ppauthtest1@vip.sohu.com","1013","djfi(Y&%ye483y45&%^830934dHisd2y%*HIUGDdii");
		//getUUidByUserId("107607195@qq.com");
	}

}