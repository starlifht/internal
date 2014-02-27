package com.test.internal;

import com.interapi.open.InterOpen;
import com.test.methods.APITools;
import com.test.methods.Params;

public class Auto_Internal {//test
	static String response;
	public static void Auto_interOpen(){
		try{
			APITools.apiName="checkauth";
			response=InterOpen.checkauth("starlifht@sohu.com");
			APITools.jsonCheck(response, "status", "10404");

		}catch(Exception e ){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="cancelauth";
			response=InterOpen.cancelauth("starlifht@sohu.com");
			APITools.jsonCheck(response, "status", "10200");

		}catch(Exception e ){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="getall";
			response=InterOpen.getall("ppauthtest11@qq.com");
			APITools.jsonCheck(response, "status", "10200");

		}catch(Exception e ){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="checkdeveloper";
			response=InterOpen.checkdeveloper();
			APITools.jsonCheck(response, "status", "10200");

		}catch(Exception e ){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}

	}
	public static void authuser(){
		try {

			Param_Internal.authuser(3, 2);//——————验证用户
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
	}
	public static void wapauth(){//
		try {

			Param_Internal.wapauth(12, 2);//——————wap验证用户
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
	}
public static void registUser(){
	try {

		Param_Internal.registUser(19, 1);//——————registUser
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void updateUser(){
	try {

		Param_Internal.updateUser(8, 3);//——————更新用户信息
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void wapAuthMobile(){
	try {

		Param_Internal.wapAuthMobile(18, 2);;//————————验证、手机绑定、交换、解绑流程
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void getUserinfo(){
	try {

		Param_Internal.getUserinfo(10, 2);//——————获得用户信息
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void checkUser(){
	try {

		Param_Internal.checkUser(1, 2);//——————检查账号是否存在

	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void getUidByUserid(){
	try {

		Param_Internal.getUidByUserid(11, 2);//——————getUidByUserid
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void getUserIdByUid(){
	try {

		Param_Internal.getUserIdByUid(11, 2);//——————getUserIdByUid
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void getUserIdByUUid(){
	try {

		Param_Internal.getUserIdByUUid(13, 2);//——————getUserIdByUUid
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void getUUidByUserId(){
	try {

		Param_Internal.getUUidByUserId(13, 2);//——————getUUidByUserId
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void checkuniqname(){
	try {

		Param_Internal.checkuniqname(2, 2);//——————检查昵称是否可用

	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void syncv(){
	try {

		Param_Internal.syncv(5, 2);//——————给用户加v
		
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void checkV(){
	try {

		Param_Internal.checkV(6, 2);//——————检查用书是否加V
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void getlastlogin(){
	try {

		Param_Internal.getlastlogin(7, 2);//——————获取最后登录信息
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void get_createip(){
	try {

		Param_Internal.get_createip(7,2);//——————获取最后登录信息
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void activate(){
	try {

		Param_Internal.activate(4, 2);//——————激活用户
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void bindMail(){
	try {

		Param_Internal.Bindemail(22, 2);//——————绑定邮箱接口
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
public static void clearuserinfo(){
	try {

		Param_Internal.clearuserinfo(26, 2);//——————清除用户信息

	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void getCookieInfo(){
	try {

		Param_Internal.getCookieInfo(9, 2);//——————获得cookie信息
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

	}
}
//********************************************************************************
public static void getMobCode(){//
	try{
		APITools.apiName="getMobCode";
		response=Mobile.getMobCode(APITools.getPhoneNum2());
		APITools.xmlCheck(response, "status", "0");
	}catch(Exception e){
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
}
public static void mobile_authtoken(){//
	try{
		APITools.apiName="mobile_authtoken";
		response=Mobile.mobile_authtoken();
		APITools.xmlCheck(response, "status", "0");
	}catch(Exception e){
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
}

public static void getMobileInfoByUserid(){
	try{
		APITools.apiName="getMobileInfoByUserid";
		response=Mobile.getMobileInfoByUserid("ada2013001@sogou.com");
		APITools.xmlCheck(response, "status", "0");
	}catch(Exception e){
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
}
public static void getUseridListByMobile(){
	try{
		APITools.apiName="getUseridListByMobile";
		response=Mobile.getUseridListByMobile();
		APITools.xmlCheck(response, "status", "0");
	}catch(Exception e){
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
}
public static void wapgetmobile(){
	try{
		APITools.apiName="wapgetmobile";
		response=Mobile.wapgetmobile();
		APITools.xmlCheck(response, "status", "0");
	}catch(Exception e){
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
}
public static void sendcaptcha(){
	try{
		APITools.apiName="sendcaptcha";
		response=Mobile.sendcaptcha(APITools.getPhoneNum2());
		APITools.xmlCheck(response, "status", "0");
	}catch(Exception e){
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
}


public static void updatepwd(){
	try{//————————————————updatepwd
		 APITools.apiName="updatepwd";		
		 response=Internal.updatepwd("ppauthtest32@sohu.com");
			APITools.xmlCheck(response, "status", "0");			
			}catch(Exception e){
	APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void recoverpwd(){
	try{
		APITools.apiName="recoverpwd";
		response=Internal.recoverpwd("ppauthtest32@sohu.com");
		APITools.xmlCheck(response, "status", "0");
	}catch(Exception e){
					APITools.doException(APITools.apiName, APITools.errorInfo, e); 
		}
}
public static void adminUpdatePassword(){
	try{
		APITools.apiName="recoverpwd";
		response=Internal.adminUpdatePassword("ppauthtest32@sohu.com","12345687");
		APITools.xmlCheck(response, "status", "0");
	}catch(Exception e){
					APITools.doException(APITools.apiName, APITools.errorInfo, e); 
		}
}
//============================狐盾==================================================
public static void gethudunconfig(){
	
	
	try {

		Param_HuDun.gethudunconfig(23, 2);//——————获得狐盾配置信息
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void synchudun(){
	try {

		Param_HuDun.synchudun(23, 2);//————————同步护盾状态
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void sethudunconfig(){
	try {

		Param_HuDun.sethudunconfig(23, 2);//———————— 设置护盾状态
	} catch (Exception e) {
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void isbind(){
	try{
		APITools.apiName="isbind";
		response=HuDun.isbind("ppauthtest2@sohu.com");
		APITools.xmlCheck(response, "status", "0");

	}catch(Exception e ){
				APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}					
}
public static void sendStoken(){
	try{//————————————————sendSToken
		 APITools.apiName="sendSToken";		
		 response=HuDun.sendSToken("ppauthtest2@sohu.com",APITools.getPhoneNum2());
			APITools.xmlCheck(response, "status", "0");
			}catch(Exception e){
	APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}	
}
public static void verifySToken(){
	try{//————————————————verifySToken
		 APITools.apiName="verifySToken";		
		 response=HuDun.verifySToken("ppauthtest32@sohu.com","05291");
			APITools.xmlCheck(response, "status", "1");			
			}catch(Exception e){
	APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
//============================狐盾==================================================
public static void deletVUsers(){
	
	try{//————————————————deletVUsers
		 APITools.apiName="deletVUsers";		
	APITools.xmlCheck(Internal.deletVUsers("107607194@vip.sohu.com"), "status", "0");
}catch(Exception e){
	APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void monitorblacklist(){
	try{//————————————————deletVUsers
		 APITools.apiName="monitorblacklist";		
	Internal.monitorblacklist();
}catch(Exception e){
	APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void sendSms(){
	try{//————————————————deletVUsers
		 APITools.apiName="sendSms";		
		Mobile.sendSms("11810606513", "test");
}catch(Exception e){
	APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void sendJms(){
	
	try{//————————————————deletVUsers
		 APITools.apiName="sendJms";		
	APITools.xmlCheck(Mobile.sendJms(), "status", "0");
}catch(Exception e){
	APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
//public static void getToken_authToken(){
//	
//	try{//————————————————deletVUsers
//		 APITools.apiName="getToken_authToken";		
//	response=Internal.getToken("ppauthtest12@sohu.com");
//	APITools.xmlCheck(response, "status", "0");
//	APITools.xmlCheck(Internal.authToken("ppauthtest12@sohu.com", APITools.getInfoFromXML(response, "token")), "status", "0");
//	System.out.print(APITools.getInfoFromXML(response, "token"));
//	}catch(Exception e){
//	APITools.doException(APITools.apiName, APITools.errorInfo, e);
//	}
//}

public static void mailsynchuser(){
	
	try{//————————————————deletVUsers
		 APITools.apiName="mailsynchuser";		
	APITools.xmlCheck(Internal.mailsynchuser("ppauthtest56@sohu.com"),"status", "0");
}catch(Exception e){
	APITools.doException(APITools.apiName, APITools.errorInfo, e);
	}
}
public static void set_del_OpenBind(){
	try{
		APITools.apiName="set_del_OpenBind";
		String response1=Internal.setOpenBind("272438388@renren.sohu.com","ppauthtest56@sohu.com");
		String response2=Internal.deleteOpenBind("272438388@renren.sohu.com","ppauthtest56@sohu.com");
		APITools.xmlCheck(response1,  "status", "0");
		APITools.xmlCheck(response2,  "status", "0");
	}catch(Exception e){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
}
public static void getOpenBindList(){
	try{
		APITools.apiName="getOpenBindList";
		response=Internal.getOpenBindList("6A04A49CA00227FFEB9090A3B20F44AD@qq.sohu.com");;
		APITools.xmlCheck(response,  "status", "0");
	}catch(Exception e){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}	
}
public static void up_del_OpenBind(){
	try{
		APITools.apiName="up_del_OpenBind";
		String response1=Internal.updateopenbind("96879025@taobao.sohu.com","ppauthtest55@sohu.com");
		String response2=Internal.deleteOpenBind("96879025@taobao.sohu.com","ppauthtest55@sohu.com");
		APITools.xmlCheck(response1, "status", "0");
		APITools.xmlCheck(response2, "status", "0");
	}catch(Exception e){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
}

	public static void main(String[] args) {
		Params.getParams();
		wapauth();
	}

}
