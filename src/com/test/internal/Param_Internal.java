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

			APITools.xmlCheck(
					Internal.checkUser(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status),"status" ,status);

		}
	}

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

			APITools.xmlCheck(
					Internal.checkuniqname(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",status);

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
				APITools.xmlCheck(
						Internal.authUser(userid, "1"),
						APITools.getParams("userID:" + userid)
								+ APITools.getParams("status:" + status),
								"status",status);

			} else {
				APITools.xmlCheck(
						Internal.authUser(userid, "0"),
						APITools.getParams("userID:" + userid)
								+ APITools.getParams("status:" + status),
								"status",status);
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
			APITools.xmlCheck(
					Internal.activate(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",status);
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
			APITools.xmlCheck(
					Internal.syncv(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",status);
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
			APITools.xmlCheck(
					Internal.checkV(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",status);
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
			APITools.xmlCheck(
					Internal.getlastlogin(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",status);
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
			APITools.xmlCheck(
					Internal.updateUser(userid, uniqname),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("uniqName:" + uniqname)
							+ APITools.getParams("status:" + status), "status",status);

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
			APITools.jsonCheck(
					Internal.getCookieInfo(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), status);
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
			APITools.xmlCheck(
					Internal.getUserinfo(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",status);
		}
	}

	public static void getUidByUserid(int sheet, int columns) throws Exception {
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
			APITools.xmlCheck(
					Internal.getUidByUserid(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("uid:" + uid), "uid", uid);
		}
	}

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
			APITools.xmlCheck(
					Internal.getUserIdByUid(uid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("uid:" + uid), "userid",
					userid);
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
			APITools.xmlCheck(
					Internal.getUserIdByUUid(uuid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("uuid:" + uuid), "userid",
					userid);
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
			APITools.xmlCheck(
					Internal.getUUidByUserId(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("uuid:" + uuid), "uuid", uuid);
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
			APITools.xmlCheck(
					Internal.updatepwd(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",
					"0");
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
					Internal.update_password(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",
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
				APITools.xmlCheck(
						Internal.update_password(userID),
						APITools.getParams("userID:" + userID)
								+ APITools.getParams("status:0"), "status", "0");

			} else {
				userID = userName + "@" + userID;

				response = Internal.registUser(userID, appID, Key);

				APITools.xmlCheck(
						Internal.update_password(userID),
						APITools.getParams("userID:" + userID)
								+ APITools.getParams("status:0"), "status", "0");

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
			APITools.xmlCheck(
					Mobile.wap_get_mobile(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",
					status);
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
			response1 = Mobile.wapAuthMobile(s1, phoneNumber);
			response2 = Mobile.wapBindMobile(s2, phoneNumber);
			response3 = Mobile.switchMobile(s2, s1, phoneNumber);
			response4 = Mobile.wapUnBindMobile(phoneNumber);
			APITools.apiName = "wapAuthMobile";
			APITools.xmlCheck(response1, APITools.getParams("user1:" + s1)+ APITools.getParams("status:" + "0"), "status", "0");
			APITools.apiName = "wapBindMobile";
			APITools.xmlCheck(response2, APITools.getParams("user2:" + s2)
					+ APITools.getParams("status:" + "0"), "status", "0");
			APITools.apiName = "switchMobile";
			APITools.xmlCheck(response3, APITools.getParams("user1:" + s1)+APITools.getParams("user2:" + s2)
					+ APITools.getParams("status:" + "0"), "status", "0");
			APITools.apiName = "unbindMobile";
			APITools.xmlCheck(response4,
					APITools.getParams("phoneNum:" + phoneNumber), "status",
					"0");

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
			APITools.xmlCheck(
					Internal.mailsynchuser(userid),
					APITools.getParams("userID:" + userid)
							+ APITools.getParams("status:" + status), "status",
					status);
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
				APITools.xmlCheck(
						Internal.Bindemail(userid),
						APITools.getParams("userID:" + userid)
								+ APITools.getParams("status:" + status), "status",
						status);
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
				APITools.xmlCheck(
						Internal.clearuserinfo(userid, String.valueOf(i)),
						APITools.getParams("userID:" + userid)
								+ APITools.getParams("type:"
										+ String.valueOf(i))
								+ APITools.getParams("status:" + status),
								"status",status);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
