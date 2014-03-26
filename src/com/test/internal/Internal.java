package com.test.internal;



import java.util.HashMap;




import net.sf.json.JSONObject;

import com.test.methods.APITools;
import com.test.methods.CommonTools;
import com.test.methods.Params;
import com.test.methods.XML;





public class Internal {
	
	public static String registUser(String userId,String appID, String Key) throws Exception {//————————用户注册
		//0成功，1参数错误，2验证错误，3非法userid，4userid已经存在，6创建用户失败 5进入黑名单 7.手机已经被绑定（wap专用） 8 非法用户名uniquename 9 用户名uniquename已存在 10 调用超限（5分钟调用超过了1000次）11 不能注册vip.sohu.com的账号
		//String appid = "200";//normal
		//String appid = "1013";//vip
		String appid = appID;//vip
		String key=Key;
		//String key = "sohu_test";//normal
		//String key = "djfi(Y&%ye483y45&%^830934dHisd2y%*HIUGDdii";//vip
		String userid = userId;
		String uniqname = "absouhu4";
		String birthday = "1978-11-16";
		String createip = "159.1.80.232";
		String gender = "2";
		String username = "XIAOxie32";
		String question = "我的名字是什么";
		String answer = "sohutest";
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
		APITools.xmlInfo=xml.toString();

		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		System.out.println("****************************用户注册*************************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static  String getUserinfo(String userId) throws Exception {//————————查询用户信息0
		String appid = "200";//status为0成功，1参数错误，2验证码错误，3用户名不存在（如果是根据昵称查询，没有查询到也是返回3），4 手机号码没有绑定 6取得用户信息失败
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
		xml.append("<email></email>\r\n");
		xml.append("<emailflag></emailflag>\r\n");
		xml.append("<createip></createip>\r\n");
		xml.append("<uniqname>aaa</uniqname>\r\n");
		xml.append("<avatarurl>aaa</avatarurl>\r\n");
		xml.append("<regappid>aaa</regappid>\r\n");
		
        xml.append("<uniqname_force>" + 1 + "</uniqname_force>\r\n");

		xml.append("</register>");
		APITools.xmlInfo=xml.toString();
	String rtn_xml = CommonTools.createXMLURLConnection(str_url,
				xml.toString());

		System.out.println("******************************************getUserinfo******************************************");
		System.out.println(rtn_xml);
		
		return rtn_xml; 

	}
	public static String checkuniqname(String userId) throws Exception {//—————Check唯一用户名uniqname0
		String appid = "9998";
//status ： 0可用，1参数错误，2code错误， 3被占用，  4敏感词 5受保护 6系统错误
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
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		
		System.out.println("*************************check用户唯一性***********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String get_createip(String userId) throws Exception {//获取用户注册信息
		String appid = "9998";
//status ： 0可用，1参数错误，2code错误， 3被占用，  4敏感词 5受保护 6系统错误
		String key = "iqE?q#gv8--`G/jGA51]=ZANMg?=Lm";
		String userid = userId;
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		String str_url = Params.DOMAIN+"interface/getcreateip";
		//String str_url = Params.DOMAIN+"interface/get_createip.jsp";
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
		System.out.println("*************************check用户唯一性***********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getlastlogin(String userId) throws Exception {//	————取得用户最后一次登录信息0
		String appid = "200";//status为0成功，1参数错误，2验证码错误，3用户信息不存在，6取得用户最后登录信息失败
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
	public static String updateUser(String userId,String uniqName) throws Exception {//——————修改用户信息0
		//status为0成功，1参数错误，2验证码错误，3userid不存在，6修改失败 8 用户名uniqname 不合法 9 用户名uniqname 已存在 10 调用超限（5分钟调用超过了1000次）11 加V用户不能修改uniqname
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
		APITools.xmlInfo=xml.toString();

		String rtn_xml = CommonTools.createXMLURLConnection(str_url,
				xml.toString());

		System.out.println("**********************************updateUserInfoTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String setOpenBind(String Userid,String refUserID) throws Exception{//——————————添加绑定0
		//0：操作成功1：参数错误,检查是否缺少必填项2：code错误3：userid已经是主帐号了，不能再做副帐号4：refuserid已经是副帐号了，不能再做主帐号5：一个主账号只能绑定同一个第三方的一个账号6：处理出现异常7：userid 已经被绑定，不能重复绑定。
		String userid = Userid;
		//String userid = "94F38603463AC159175FB8356166DFBD@qq.sohu.com";
		String refUserid = refUserID;//主账号
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
	public static String updateopenbind(String userID,String refuserID) throws Exception{//——————————添加绑定0
// 0：操作成功 1：参数错误,检查是否缺少必填项 2：code错误 4：refuserid已经是副帐号了，不能再做主帐号 5：一个主账号只能绑定同一个第三方的一个账号 6：处理出现异常
		String userid =userID ;
		//String userid = "94F38603463AC159175FB8356166DFBD@qq.sohu.com";
		String refUserid =refuserID;//主账号
		String appid = "200";
		String key = "sohu_test";
		String ct =  String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String str_url = Params.DOMAIN+"interface/updateopenbind";
			
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
	public static String deleteOpenBind(String userID,String refuserID) throws Exception{//————————删除绑定关系0
		//0：操作成功1：参数错误,检查是否缺少必填项2：code错误6：处理出现异常
		//String userid = "6A04A49CA00227FFEB9090A3B20F44AD@qq.sohu.com";
		String userid = userID;
		String refUserid = refuserID;
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
	public static String getOpenBindList(String userID) throws Exception{//————————查询绑定列表0
		//0：查询成功，同时返回bindList，bindList中是json格式的绑定账号列表（expireTime：过期时间格式yyyy-MM-dd HH:mm:ss，没有token为“”，token永远有效为“-1”，appid发生绑定的产品id，refuserid:主账号id，即查询的userid）
		//1：参数错误,检查是否缺少必填项2：code错误6：处理出现异常

		String userid = userID;
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
	public static String authUser(String userId,String userType) throws Exception {//————校验用户名、密码是否正确0（用户登录接口)
		
		//1:userid的值为手机号；usertype为0，userid值为全域名id，如：test-1@sohu.com
		//0用户名密码正确，1参数错误，2code错误，3用户名密码不匹配，4外域用户未激活，5手机号码没有绑定（wap专用）6校验失败 7 手机注册的sohu域账号未激活 8账号已被锁定 9用户输入的动态口令（stoken）错误
		String userid =userId;
		String appid = "200";
		String appkey = "sohu_test";
//		  String appid="1120";
//		  String appkey="4xoG%9>2Z67iL5]OdtBq$l#>DfW@TY";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + appkey + ct);
		String rtn_xml = "";
		String password = "12345687";
		String str_url = Params.DOMAIN+"interface/authuser";
            
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<info>\r\n");
		xml.append("<userid>" + userid + "</userid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<ip>" + "123.12.12.12" + "</ip>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("<password>" + password + "</password>\r\n");
		xml.append("<pwdtype>" + "0" + "</pwdtype>\r\n"); 
		xml.append("<usertype>" + userType + "</usertype>\r\n");
		//xml.append("<stoken>"+"962872"+"</stoken>\r\n");	
		xml.append("</info>");
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		
		//System.out.println(xml.toString());
		System.out.println("**********************************authUserTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String deletVUsers(String userId) throws Exception{//————	删除vip账号0
		//status: 0操作成功 1 参数错误 2 code错误 3 appid错误 6 操作失败
		String userids = userId;
		String appid = "1013";
		String key = "djfi(Y&%ye483y45&%^830934dHisd2y%*HIUGDdii";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userids + appid + key + ct);
		String rtn_xml = "";

		//String str_url = Params.DOMAIN+"interface/deleteusers.jsp";
		String str_url = Params.DOMAIN+"interface/deleteusers";
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<userids>" + userids + "</userids>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
	
		System.out.println("**********************************deletusersTest*********************************");

		System.out.println(rtn_xml);
		return rtn_xml;
	}

	public static String activate(String userId) throws Exception {//——————		激活搜狐矩阵账号0
		//status为 0激活成功，1参数错误，2验证码错误,3 用户名错误，4用户不存在，5 激活失败
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
				APITools.xmlInfo=xml.toString();
				rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

			
				System.out.println("**********************************activateUserTest*********************************");
				System.out.println(rtn_xml);
				return rtn_xml;
			}
	public static String checkUser(String userId) throws Exception {//————check_user检查账号是否存在
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
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		
		System.out.println("**********************************checkUserTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String checkV(String userId) throws Exception {//————检查用户是否为加V用户5
		//status: 1 参数错误 2 code错误   4查询失败 5 是加V用户 6不是加V用户
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
	public static String syncv(String userId) throws Exception {//————给用户加V减V0
		//status: 0操作成功 1 参数错误 2 code错误 3 该userid不存在 4操作失败 5 该用户没有用户名加V失败
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
		APITools.xmlInfo=xml.toString();

		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		System.out.println("**********************************syncvTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUidByUserid(String userID) throws Exception {//————根据Userid取Uid<uid>o7891792</uid>
		//存在：返回uid节点 不存在：返回<status>3</status>
		String userid =userID;
		//String userid = "zhangxiumin_001@changyou.com";
		// String userid = "zjcjack@37wanwan.com";
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		//String str_url = Params.DOMAIN+"interface/getUidByUserid.jsp";
		String str_url = Params.DOMAIN+"interface/getuidbyuserid";
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
	public static String getUserIdByUid(String Uid) throws Exception {//————根据Uid取Userid<userid>zhangxiumin_001@changyou.com</userid>
		//存在返回userid有值，不存在userid节点为空
		String uid =Uid;
		String appid = "200";
		String key = "sohu_test";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(uid + appid + key + ct);
		String rtn_xml = "";
		//String str_url = Params.DOMAIN+"interface/getUseridByUid.jsp";
		String str_url = Params.DOMAIN+"interface/getuseridbyuid";
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		xml.append("<auth>\r\n");
		xml.append("<uid>" + uid + "</uid>\r\n");
		xml.append("<appid>" + appid + "</appid>\r\n");
		xml.append("<ct>" + ct + "</ct>\r\n");
		xml.append("<code>" + code + "</code>\r\n");
		xml.append("</auth>");
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		
		System.out.println("**********************************getUserIdByUid*********************************");
	
		System.out.println(rtn_xml);
		return rtn_xml;
	}	
	public static String getUUidByUserId(String userID) throws Exception {//————根据userid获取uuid<uuid>cbdcf2706c884e3s</uuid>
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
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		
		System.out.println("**********************************getUUidByUserIdTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUserIdByUUid(String UUid) throws Exception {//————根据uuid获取userid<userid>zhangxiumin_002@sogou.com</userid>
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
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		
		System.out.println("**********************************getUserIdByUuiddTest*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUUidListByUserid() throws Exception {//————根据userid批量查询uuid0
		//0:查询成功 1参数错误，2验证码错误，3 用户不存在 6非法用户名
		String userid = "ada2013001@sohu.com,ada2013001@sogou.com,ada2013001@focus.cn";

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
		xml.append("<cache>false</cache>\r\n");
		xml.append("</info>");
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		APITools.xmlInfo=xml.toString();
		System.out.println("**********************************getUUidListTest*********************************");
		System.out.print(xml.toString());
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getUserIdListByUUid() throws Exception {//————根据uuid批量查询userid0
		String uuid = "ba6eb68bcc9543fs,3f9ec3ae126f4ccs,31490d67efb0456f,ddb441117c7c40ec";
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
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		System.out.println("**********************************getUserIdByUuidListTest**********************************");
	
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String update_password(String userId) throws Exception {//——————重置用户密码 2
		//status为0成功，1参数错误，2验证码错误，3用户名不存在 4访问次数超限（1天200次）

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
	public static String recoverPassword() throws Exception {//————recover_password0
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
	public static String recoverpwd(String userID) throws Exception {//————根据密保问题重置密码 0
		//0成功，1参数错误，2验证码错误，3用户名不存在，4提示问题答案校验失败，5一天内同一个账号密保错误超过6次，6修改失败

		String userid = userID;
		String newPassword = "12345687";
		String answer = "sohutest";
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
	public static String updatepwd(String userID) throws Exception {//——————updatepwd0 验证问题
		//String userid = "zhangxiumin2010@sohu.com";
		String userid = userID;
		//String password = "asd123";
		String password = "12345687";
		String newPassword = "12345687";
		String newquestion = "myname";
		String newanswer = "测试的";
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
		xml.append("<newpassword>" + newPassword + "</newpassword>\r\n");
		//xml.append("<usertype>" + 1 + "</usertype>\r\n");
		xml.append("</info>");
		APITools.xmlInfo=xml.toString();

		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		System.out.println("**********************************updatepwdTest**********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String getCookieInfo(String userID) throws Exception{//———？？—获取cookie信息
		//Status:返回结果 0:处理成功 1 处理失败 3：账号不存在
		//String userid = "C9E12740CCA4467CC5DF1CBDB651CDDA@qq.sohu.com";
		String userid = userID;
		String appid = "200";
		String key = "sohu_test";
//		String appid = "1073";
//		String key = "?qPQ(UIeRoq.=c+IYYx%x7159ZpF'=";
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
		APITools.xmlInfo=xml.toString();
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
		
		System.out.println("**********************************getCookieInfo*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}
	public static String adminUpdatePassword(String userID,String PWD) throws Exception {//————重置任意密码 0最高权限 仅CMS
		//status为0成功，1参数错误，2验证码错误，3用户名不存在 4访问次数超限（1天200次）
		String userid = userID;
		String password = PWD;
		String appid = "9998";
		String key = "iqE?q#gv8--`G/jGA51]=ZANMg?=Lm";
		String ct = String.valueOf(System.currentTimeMillis() / 1000);
		String code = PPTools.md5(userid + appid + key + ct);
		String rtn_xml = "";

		// String str_url =
		// Params.DOMAIN+"interface/wap_auth_mobile.jsp";
		//String str_url = Params.DOMAIN+"admin/admin_update_password.jsp";
	String str_url = Params.DOMAIN+"interface/admin/updatepwd";
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
	public static String sendemailcaptcha(String mail) throws Exception {//发送邮箱验证码

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
		APITools.xmlInfo=xml.toString();

		//System.out.print(xml);
		rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());

		System.out.println("**********************************sendemailcaptchaTest()*********************************");
		System.out.println(rtn_xml);
		return rtn_xml;
	}

	public static String monitorblacklist() throws Exception {//——————更新登陆黑名单列表(不返回400)
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("domain", "mail.sohu.com");
		map.put("ip", "10.10.69.199");
		map.put("instance_id", 0);
		map.put("version", "2012-06-06 by douyuan");
		map.put("appid", "9998");
		map.put("update_interval", "5");
		map.put("nginx_version", "1.0.9");
		map.put("update_version", "2");
		String str_url = Params.DOMAIN+"interface/monitorblacklist";
		JSONObject  jsonObject = new JSONObject();
		jsonObject.putAll(map);
		String s=jsonObject.toString();
		System.out.println(s);
		String rtn = CommonTools.createXMLURLConnection(str_url,s);
	
		
		System.out.println("**********************************getUserBlackListTest**********************************");
		System.out.println(rtn);
		return rtn;


		
	}
	 public static String getToken(String userID) throws Exception{//——————————passport对项目内部提供token服务的接口
		 //status	0：发送成功；1：参数错误；2：code错误；其他：失败
		 //token		session token，可用于校验用户身份

         String appid = "200";
         String key = "sohu_test";
         String ct = String.valueOf(System.currentTimeMillis() / 1000);
         String userid = userID;        
         String code = PPTools.md5(userid+appid+key+ct);
         String rtn_xml = "";
         String str_url = Params.DOMAIN+"interface/token/get";
         StringBuffer xml = new StringBuffer();
         xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
        xml.append("<info>\r\n");
        xml.append("<userid>" + userid + "</userid>\r\n");
       xml.append("<type>" + 5 + "</type>\r\n");
        xml.append("<appid>" + appid + "</appid>\r\n");
        xml.append("<ct>" + ct + "</ct>\r\n");
         xml.append("<code>" + code+ "</code>\r\n");
         xml.append("</info>");
         rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
         APITools.xmlInfo=xml.toString();
         System.out.println(rtn_xml);
		return rtn_xml;

 }
	 public static String authToken(String userID,String Token) throws Exception{
		  String appid = "200";
	         String key = "sohu_test";
	         String ct = String.valueOf(System.currentTimeMillis() / 1000);
	         String userid = userID;   
	         String token=Token;
	         String code = PPTools.md5(userid+appid+key+ct);
	         String rtn_xml = "";
	         String str_url = Params.DOMAIN+"interface/token/auth";
	         StringBuffer xml = new StringBuffer();
	         xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	        xml.append("<info>\r\n");
	        xml.append("<userid>" + userid + "</userid>\r\n");
	       xml.append("<type>" + 5 + "</type>\r\n");
	        xml.append("<appid>" + appid + "</appid>\r\n");
	        xml.append("<ct>" + ct + "</ct>\r\n");
	        xml.append("<token>" + token + "</token>\r\n");
	         xml.append("<code>" + code+ "</code>\r\n");
	         xml.append("</info>");
	         rtn_xml = CommonTools.createXMLURLConnection(str_url, xml.toString());
	         APITools.xmlInfo=xml.toString();
	         System.out.println(rtn_xml);
			return rtn_xml; 
	
		 
	 }
	
	 public static String  mailsynchuser(String userId) throws Exception {// 邮箱同步用户信息
		 //status	 0：发送成功；1：参数错误；2：code错误；其他：失败
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
	 public static String Bindemail(String userId) throws Exception {//————————————绑定邮箱接口
	       //String userid = "敏ada123@focus.cn";//0成功，1参数错误，2验证码错误，3用户不存在或者密码错误，4旧绑定邮箱错误，5新的绑定邮箱没有变化，6系统错误，7密码错误次数超限
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
			//0操作成功 1 参数错误 2 code错误 3 该userid不存在 6 修改失败 8 用户名uniqname 不合法 9 用户名uniqname 已存在 10 调用超限 11 加V用户			//1122 ??? type 1 2    1095 ???type 345
					//String appid = "1122" ;
					String appid ="1095";
					//String key = "t*Gcm>0*oT1EXm826g09gP7<197(@t";//1122
					String key ="NBOJ.#J4O\\D?R[Q1(r&cAH+,_<V$qi";//1095
					String userid = userID;
					String ct = String.valueOf(System.currentTimeMillis()/1000);
					String code = PPTools.md5(userid + appid + key + ct);
					String type = Type;//1：清除昵称；2：清除头像;3-清楚绑定邮箱; 4-清楚密保问题 ;
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
		Params.getParams();
//		List a=ReadFile.readFile();
//		Iterator<String> iter = a.iterator() ; 
//		while(iter.hasNext()) { 
//		String m = iter.next(); 
//		// 打印信息或将信息保存到一个公共集合中 
//		System.out.println(m); 
		//getUserinfo("我是测试haha@focus.cn");
//		} 
		//System.out.println(PPTools.md5("star7788899"));
		//update_password("hey钟宏燕@focus.cn");
	
	for(int i=0;i<=22;i++){
		registUser("pdph34t1s"+i+"@sohu.com","200","sohu_test");
		
	System.out.println(i);
}
	
		//registUser("psdf45sdf@sohu.com","200","sohu_test");
		//getUserIdByUid("5499fe497402415s");
		//getUidByUserid("ppauthtest65@sohu.com");
		//authUser("ada2013001@wap.sohu.com","0");
	//checkUser("lg7703@bo.sohu.com");
		//adminUpdatePassword("ada2013005@sohu.com","12345687");
System.out.println(APITools.xmlInfo);

//		getOpenBindList("6A04A49CA00227FFEB9090A3B20F44AD@qq.sohu.com");
		//getUserIdListByUUid();
//		getToken("ppauthtest111@sohu.com");
		//authToken("ppauthtest111@sohu.com", "7a14e511e64ed49bcdb90dd83de060ab");
		
	}

}
