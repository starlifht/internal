package com.test.internal;

import java.util.HashMap;
import java.util.Map;



import net.sf.json.JSONObject;

import com.test.methods.CommonTools;

public class OpenLogin {
@SuppressWarnings("unchecked")
public static String getToken() throws Exception{//��ȡ������ƽ̨���û���access_token�����access_token���ڣ����Զ�ˢ��access_token֮���ٷ��ء�

//Ŀǰ����appid��1106��1030��1120���Է��ʡ�
	JSONObject josn=new JSONObject();
	Map <String, String> ingredients = new HashMap <String, String>();
    // String url="http://10.11.49.38:8007/openlogin/api/token/get";
     String url ="http://internal.passport.sohu.com/openlogin/api/token/get";
	//josn.put("ingredients", ingredients);
	String id="227097200@renren.sohu.com";
	//String id="1689967123@sina.sohu.com";
	//String id ="1325599907@baidu.sohu.com";
	//String id ="96879025@taobao.sohu.com";
	 String userid=id;
	  String appid="1120";
	  String appkey="4xoG%9>2Z67iL5]OdtBq$l#>DfW@TY";
//	  String appid="1044";
//	  String appkey="=#dW$h%q)6xZB#m#lu'x]]wP=\\FUO7";
//	  String appid="1030";
//	  String appkey="v)TXj6k*e&ieP$%wDIVRj.BM.ZEVHa";
//	  String appid="1160";
//	  String appkey="f@JclHjuQ`DORG<f0,OqS/Q(Lpp4&G";
	  String ct=String.valueOf(System.currentTimeMillis());
	  String code=PPTools.md5(userid + appid + appkey + ct);
	
	  ingredients.put("userid",userid);
	  ingredients.put("openid", id);
	  ingredients.put("appid", appid);
      // parameterMap.put("app_key", new String[]{"test"});
      // parameterMap.put("product_id", new String[]{"9999"});
	  ingredients.put("ct", ct);
	  ingredients.put("code", code);
	josn.putAll(ingredients);
	System.out.println(josn);
	String response=CommonTools.createXMLURLConnection(url, josn.toString());
	System.out.println(response);
	return response;
	
}
	public static void main(String[] args) throws Exception {
		OpenLogin.getToken();

	}

}
