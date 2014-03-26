package com.test.internal;

import java.util.Iterator;
import java.util.List;

import com.test.methods.APITools;
import com.test.methods.ExcelTools;
import com.test.methods.Params;

public class Param_Internal {

	public static void checkUser(int sheet, int columns) throws Exception { // ——————检查用户合法性
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
try{
			APITools.xmlCheck(
					Internal.checkUser(userid),"status" ,status);

		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
	}}

	public static void checkuniqname(int sheet, int columns) throws Exception {// ————————检查用户名是否唯一
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
try{
			APITools.xmlCheck(
					Internal.checkuniqname(userid), "status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}
	public static void get_createip(int sheet, int columns) throws Exception {// ————————检查用户名是否唯一
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
try{
			APITools.xmlCheck(
					Internal.get_createip(userid), "status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}
	public static void authuser(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			if (userid.equals("18820606515")) {
				try{
				APITools.xmlCheck(
						Internal.authUser(userid, "1"),	"status",status);
			}catch(Exception e){
				APITools.doException(APITools.apiName, APITools.errorInfo, e);
				
			}			

			} else {
				try{
				APITools.xmlCheck(
						Internal.authUser(userid, "0"),
								"status",status);
			}catch(Exception e){
				APITools.doException(APITools.apiName, APITools.errorInfo, e);
				
			}
			}
		}
	}
	public static void wapauth(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
				APITools.xmlCheck(
						Mobile.wapAuth(userid),"status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		
		}
	}
	public static void activate(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.activate(userid), "status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void syncv(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.syncv(userid), "status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void checkV(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.checkV(userid), "status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void getlastlogin(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.getlastlogin(userid), "status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void updateUser(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 2);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list3 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		Iterator<String> iter3 = list3.iterator();
		while (iter1.hasNext() && iter2.hasNext() && iter3.hasNext()) {
			String userid = iter1.next();
			String uniqname = iter2.next();
			String status = iter3.next();
			try{
			APITools.xmlCheck(
					Internal.updateUser(userid, uniqname),
					 "status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}

		}
	}

	public static void getCookieInfo(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.jsonCheck(Internal.getCookieInfo(userid),"status", status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void getUserinfo(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.getUserinfo(userid), "status",status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void getUidByUserid(int sheet, int columns) throws Exception  {
		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String uid = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.getUidByUserid(userid), "uid", uid);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
	}}

	public static void getUserIdByUid(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();
		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String uid = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.getUserIdByUid(uid), "userid",
					userid);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void getUserIdByUUid(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();
		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String uuid = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.getUserIdByUUid(uuid), "userid",
					userid);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void getUUidByUserId(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();
		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String uuid = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.getUUidByUserId(userid), "uuid", uuid);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	// static void getCookieInfo(int sheet,int column,String status) throws
	// Exception{
	// String response=null;
	// Auto_Internal.APIname=APITools.getAPIname(APITools.getFuncName());
	// List<String> list;
	//
	// list=ExcelTools.ReadExcel(Params.FilePath,sheet,column);
	//
	// Iterator<String> iter = list.iterator();
	//
	// while (iter.hasNext()) {
	// String userID = iter.next();
	//
	// response=Internal.getCookieInfo(userID);
	// if(APITools.toJson(response).get("status").equals(status)){
	// Auto_Internal.logInfo= Auto_Internal.getLogInfo(Auto_Internal.APIname,
	// "["+userID+"]"+response);
	// }else{
	// Auto_Internal.errorInfo=
	// Auto_Internal.getErrorInfo(Auto_Internal.APIname,
	// "["+userID+"]"+response);
	// }
	// }
	// }
	// static void getUserinfo(int sheet,int column,String status) throws
	// Exception{
	// String response=null;
	// Auto_Internal.APIname=APITools.getAPIname(APITools.getFuncName());
	// List<String> list=null;
	// list=ExcelTools.ReadExcel(Params.FilePath,sheet,column);
	// Iterator<String> iter = list.iterator();
	// while (iter.hasNext()) {
	// String s = iter.next();
	//
	// response=Internal.getUserinfo(s);
	// Auto_Internal.isStatus(Auto_Internal.APIname,"["+s+"]"+response,status);
	// }
	// }
	public static void updatepwd(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();
		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.updatepwd(userid), "status",
					"0");
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void update_password(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();
		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			APITools.xmlCheck(
					Internal.update_password(userid), "status",
					"0");
		}
	}

	public static void registUser(int sheet, int columns) throws Exception {// 用户注册
		String response = null;
		String appID = null;
		String Key = null;
		String userName = APITools.getUserName();
		APITools.apiName = APITools.getFuncName();
		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter = list1.iterator();
		while (iter.hasNext()) {
			String userID = iter.next();
			if (userID.equals("vip.sohu.com")) {
				appID = "1013";
				Key = "djfi(Y&%ye483y45&%^830934dHisd2y%*HIUGDdii";
			} else {
				appID = "200";
				Key = "sohu_test";
			}
			if (userID.equals("vip.sohu.com") || userID.equals("sohu.com")
					|| userID.equals("sogou.com") || userID.equals("focus.cn")
					|| userID.equals("chinaren.com")
					|| userID.equals("wap.sohu.com")) {// 不需激活的账号
				userID = userName + "@" + userID;
				response = Internal.registUser(userID, appID, Key);

				// String authResp=Internal.authUser(userID,"0");
				APITools.xmlCheck(response, "status", "0");

			} else {
				userID = userName + "@" + userID;

				response = Internal.registUser(userID, appID, Key);

				APITools.xmlCheck(
						response, "status", "0");

			}
		}
	}

	public static void wap_get_mobile(int sheet, int columns) throws Exception {
		APITools.apiName = APITools.getFuncName();
		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.xmlCheck(
					Mobile.wap_get_mobile(userid), "status",
					status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	}

	public static void wapAuthMobile(int sheet, int columns) throws Exception {
		String response1 = null;
		String response2 = null;
		String response3 = null;
		String response4 = null;
		// APIname=AutoTools.getAPIname(AutoTools.getFuncName());
		List<String> list1 = null;
		List<String> list2 = null;
		list1 = ExcelTools.ReadExcel(Params.FilePath, sheet, columns - 1);
		list2 = ExcelTools.ReadExcel(Params.FilePath, sheet, columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String phoneNumber = APITools.getPhoneNum();
			String s1 = iter1.next();
			String s2 = iter2.next();
			try{
			response1 = Mobile.wapAuthMobile(s1, phoneNumber);
			APITools.apiName = "wapAuthMobile";
			APITools.xmlCheck(response1, "status", "0");
			response2 = Mobile.wapBindMobile(s2, phoneNumber);
			APITools.apiName = "wapBindMobile";
			APITools.xmlCheck(response2,  "status", "0");
			response3 = Mobile.switchMobile(s2, s1, phoneNumber);
			APITools.apiName = "switchMobile";
			APITools.xmlCheck(response3,  "status", "0");
			response4 = Mobile.wapUnBindMobile(phoneNumber);
		
		
		
			APITools.apiName = "unbindMobile";
			APITools.xmlCheck(response4, "status",
					"0");
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}

		}
	}

	// static void wapBindMobile(int sheet,int column1,int column2,String
	// status) throws Exception{
	// String response=null;
	// Auto_Internal.APIname=APITools.getAPIname(APITools.getFuncName());
	// List<String> list1=null;
	// List<String> list2=null;
	// list1=ExcelTools.ReadExcel(Params.FilePath,sheet,column1);
	// list2=ExcelTools.ReadExcel(Params.FilePath,sheet,column2);
	// Iterator<String> iter1 = list1.iterator();
	// Iterator<String> iter2 = list2.iterator();
	// while (iter1.hasNext()&&iter2.hasNext()) {
	// String s1 = iter1.next();
	// String s2 = iter2.next();
	// response=Mobile.wapBindMobile(s1,s2);
	// Auto_Internal.isStatus(Auto_Internal.APIname,"["+s1+"]"+"["+s2+"]"+response,status);
	// }
	// }
	// static void switchMobile(int sheet,int column1,int column2,int
	// column3,String status) throws Exception{
	// String response=null;
	// Auto_Internal.APIname=APITools.getAPIname(APITools.getFuncName());
	// List<String> list1=null;
	// List<String> list2=null;
	// List<String> list3=null;
	// list1=ExcelTools.ReadExcel(Params.FilePath,sheet,column1);
	// list2=ExcelTools.ReadExcel(Params.FilePath,sheet,column2);
	// list3=ExcelTools.ReadExcel(Params.FilePath,sheet,column3);
	// Iterator<String> iter1 = list1.iterator();
	// Iterator<String> iter2 = list2.iterator();
	// Iterator<String> iter3 = list3.iterator();
	// while (iter1.hasNext()&&iter2.hasNext()&&iter3.hasNext()) {
	// String s1 = iter1.next();
	// String s2 = iter2.next();
	// String s3 = iter3.next();
	// response=Mobile.switchMobile(s1,s2,s3);
	// Auto_Internal.isStatus(Auto_Internal.APIname,"["+s1+"]"+"["+s2+"]"+"["+s3+"]"+response,status);
	// }
	// }
	
	public static  void mailsynchuser(int sheet,int columns) throws Exception{
		APITools.apiName = APITools.getFuncName();
		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			try{
			APITools.xmlCheck(
					Internal.mailsynchuser(userid), "status",
					status);
		}catch(Exception e){
			APITools.doException(APITools.apiName, APITools.errorInfo, e);
			
		}
		}
	 }
	 public static void Bindemail(int sheet,int columns) throws Exception{
		 APITools.apiName = APITools.getFuncName();
			List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
					columns - 1);
			List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
					columns);
			Iterator<String> iter1 = list1.iterator();
			Iterator<String> iter2 = list2.iterator();
			while (iter1.hasNext() && iter2.hasNext()) {
				String userid = iter1.next();
				String status = iter2.next();
				try{
				APITools.xmlCheck(
						Internal.Bindemail(userid), "status",
						status);
			}catch(Exception e){
				APITools.doException(APITools.apiName, APITools.errorInfo, e);
				
			}
			}
	 }
	public static void clearuserinfo(int sheet, int columns) throws Exception {// 清除用户信息

		APITools.apiName = APITools.getFuncName();

		List<String> list1 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns - 1);
		List<String> list2 = ExcelTools.ReadExcel(Params.FilePath, sheet,
				columns);
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			String userid = iter1.next();
			String status = iter2.next();
			for (int i = 1; i <= 4; i++) {
				try{
				APITools.xmlCheck(
						Internal.clearuserinfo(userid, String.valueOf(i)),
					
								"status",status);
			}catch(Exception e){
				APITools.doException(APITools.apiName, APITools.errorInfo, e);
				
			}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
