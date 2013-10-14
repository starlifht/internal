package com.test.internal;


import com.test.methods.APITools;



public class Auto {

	// ****************************************HuDun*************************************************
static String response=null;
	public static void Auto_HuDun() {
		try {

			Param_HuDun.synchudun(23, 2);//————————同步护盾状态
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try {

			Param_HuDun.sethudunconfig(25, 2);//———————— 设置护盾状态
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try {

			Param_HuDun.gethudunconfig(24, 2);//——————获得狐盾配置信息
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
	}
	// ****************************************Mobile*************************************************
	public static void Auto_Mobile() {
		try {

			Param_Internal.wapAuthMobile(18, 2);;//————————手机绑定 解绑流程
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="mobileRegUser";
			response=Mobile.mobileRegUser();
			
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "4");
		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="sendSms";
			response=Mobile.sendSms("11110606513","Happy Everyday!");
			if(!response.trim().equals("success")){
				APITools.getInfo(APITools.errorInfo, APITools.apiName, response);
			}
		}catch(Exception e ){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}

		try{
			APITools.apiName="wapGetUserid";
			response=Mobile.wapGetUserid();
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}

		try{
			APITools.apiName="getMobileInfoByUserid";
			response=Mobile.getMobileInfoByUserid();
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}

		try{
			APITools.apiName="getUseridListByMobile";
			response=Mobile.getUseridListByMobile();
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			
			APITools.apiName="regmobiled";
			response=Mobile.regmobiled("18810606511");
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "4");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="wapAuth";
			response=Mobile.wapAuth();
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="sendJms";
			response=Mobile.sendJms();
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="mobile_gettoken";
			response=Mobile.mobile_gettoken();
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="mobile_authtoken";
			response=Mobile.mobile_authtoken();
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="sendmobileregcaptcha";
			response=Mobile.sendmobileregcaptcha(APITools.getPhoneNum());
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");
		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="regmobileuser";
			response=Mobile.regmobileuser(APITools.getPhoneNum());
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "8");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="regist_mobilecaptcha";
			response=Mobile.regist_mobilecaptcha(APITools.getPhoneNum());
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "8");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="sendcaptcha";
			response=Mobile.sendcaptcha();
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "6");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="BindMobile";
			response=Mobile.BindMobile();
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "1");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="UnbindMobile";
			response=Mobile.UnbindMobile();
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "1");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="getMobCode";
			response=Mobile.getMobCode(APITools.getPhoneNum2());
		//	getLogInfo(AutoTools.replaceBlank(response));
			APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{
			APITools.apiName="authMobCode";
			response=Mobile.authMobCode();
		//	getLogInfo(AutoTools.replaceBlank(response));
			//APITools.xmlCheck(response,APITools.xmlInfo, "status", "0");

		}catch(Exception e ){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
	}

	// ****************************************Internal*************************************************
	public static void Auto_Internal() {
		try {

			Param_Internal.checkUser(1, 2);//——————检查账号是否存在

		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.checkuniqname(2, 2);//——————检查昵称是否可用

		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.authuser(3, 2);//——————验证用户
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.activate(4, 2);//——————激活用户
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.syncv(5, 2);//——————激活用户
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.checkV(6, 2);//——————检查用书是否加V
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.getlastlogin(7, 2);//——————获取最后登录信息
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.updateUser(8, 3);//——————更新用户信息
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.getCookieInfo(9, 2);//——————获得cookie信息
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.getUserinfo(10, 2);//——————获得用户信息
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.getUidByUserid(11, 2);//——————getUidByUserid
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.getUserIdByUid(11, 2);//——————getUserIdByUid
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.getUserIdByUUid(13, 2);//——————getUserIdByUUid
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.getUUidByUserId(13, 2);//——————getUUidByUserId
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.updatepwd(15, 2);//——————updatepwd
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.update_password(16, 2);//——————update_password
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.registUser(19, 1);//——————registUser
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.wap_get_mobile(20, 2);//——————registUser
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.mailsynchuser(21, 2);//——————箱同步用户信息
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.Bindemail(22, 2);//——————绑定邮箱接口
		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try {

			Param_Internal.clearuserinfo(26, 2);//——————清除用户信息

		} catch (Exception e) {
			APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		//==============================================================================
//========================================================================未参数化=========================================
		try{//————————————————deletVUsers
			 APITools.apiName="deletVUsers";		
		APITools.xmlCheck(Internal.deletVUsers("107607194@vip.sohu.com"),APITools.xmlInfo, "status", "0");
	}catch(Exception e){
		APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{//———————————————sendemailcaptcha
			APITools.apiName="sendemailcaptcha";
		response=Internal.sendemailcaptcha(APITools.getPhoneNum2()+"@qq.com");
		APITools.xmlCheck(response.trim(), APITools.xmlInfo, "status", "0");

	}catch(Exception e){
		APITools.doException(APITools.apiName, APITools.errorInfo, e);

		}
		try{//————————————————getServerToken
			APITools.apiName="getServerToken";
			response=Internal.getServerToken();
			APITools.xmlCheck(response, APITools.xmlInfo, "status", "0");
	}catch(Exception e){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
		try{//————————————————authServerToken
			APITools.apiName="authServerToken";
		response=Internal.authServerToken("a33aed52226b5ebf32c2a94e28db4b13");
		APITools.xmlCheck(response, APITools.xmlInfo, "status", "0");
	}catch(Exception e){
					APITools.doException(APITools.apiName, APITools.errorInfo, e);
		}
	

		try{
			APITools.apiName="setOpenBind";
			response=Internal.setOpenBind();
			APITools.xmlCheck(response, APITools.xmlInfo, "status", "0");
		}catch(Exception e){
						APITools.doException(APITools.apiName, APITools.errorInfo, e);
			}
		try{
			APITools.apiName="deleteOpenBind";
			response=Internal.deleteOpenBind();
			APITools.xmlCheck(response, APITools.xmlInfo, "status", "0");
		}catch(Exception e){
						APITools.doException(APITools.apiName, APITools.errorInfo, e);
			}
		try{
			APITools.apiName="getOpenBindList";
			response=Internal.getOpenBindList();
			APITools.xmlCheck(response, APITools.xmlInfo, "status", "0");
		}catch(Exception e){
						APITools.doException(APITools.apiName, APITools.errorInfo, e);
			}
		try{
			APITools.apiName="recoverPassword";
			response=Internal.recoverPassword();
			APITools.xmlCheck(response, APITools.xmlInfo, "status", "0");
		}catch(Exception e){
						APITools.doException(APITools.apiName, APITools.errorInfo, e);
			}
		try{
			APITools.apiName="recoverpwd";
			response=Internal.recoverpwd();
			APITools.xmlCheck(response, APITools.xmlInfo, "status", "0");
		}catch(Exception e){
						APITools.doException(APITools.apiName, APITools.errorInfo, e); 
			}

	}

	public static void main(String[] args) {
		// Auto.Auto_HuDun();
		 Auto_HuDun();
		// Auto_Mobile();
		//Auto_Internal();
	
		//System.out.print(HuDun.logInfo);
		System.out.println(APITools.logInfo);
		System.out.println("===============ERROR==============");
		System.out.println(APITools.errorInfo);
	}

}
