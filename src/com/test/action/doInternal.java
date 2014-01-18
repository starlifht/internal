package com.test.action;



import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.test.internal.Internal;
import com.test.internal.Mobile;
import com.test.methods.APITools;



/**
 * 
 */
public class doInternal extends ActionSupport implements RequestAware{
	private static final long serialVersionUID = 1L;
	private String phone;
	private String username;
	private Map<String,Object> request;
public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
public String wapUnBindMobile(){
	try {
		
		String  status=APITools.getXMLelement(Mobile.wapUnBindMobile(phone), "status");
				request.put("wapUnBindMobile", "������"+status);
				if(status.equals("0")){
					request.put("getMobileInfoByUserid", "���ɹ�");
				}
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	return "success";
	
}
public String getMobileInfoByUserid(){
	try {
		String response=Mobile.getMobileInfoByUserid(username);
		String  status=APITools.getXMLelement(response, "status");
		String mobile=APITools.getXMLelement(response, "mobile");
				request.put("getMobileInfoByUserid", "������"+status);
				if(status.equals("0")){
					request.put("getMobileInfoByUserid", "�Ѱ󶨵��ֻ���"+mobile);
				}
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	return "success";
	
}
public String wapBindMobile(){
	try {
		
		String  status=APITools.getXMLelement(Mobile.wapBindMobile(username, phone), "status");
				request.put("wapBindMobile", "������"+status);
				if(status.equals("0")){
					request.put("wapBindMobile", "�󶨳ɹ�");
				}
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	return "success";
	
}
public String registUser(){
	String status=null;
	try{
	if(username.indexOf(username)!=-1){
		 status =APITools.getXMLelement(Internal.registUser(username, "1013", "djfi(Y&%ye483y45&%^830934dHisd2y%*HIUGDdii"), "status");

	}else{
	 status =APITools.getXMLelement(Internal.registUser(username, "200", "sohu_test"), "status");
	 }
	request.put("registUser", "������"+status);
	if(status.equals("0")){
		request.put("registUser", "ע��ɹ�");
	}
} catch (Exception e) {
	
	e.printStackTrace();
}
	return "success";
}
public void setRequest(Map<String,Object> request) {
	this.request = request;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

	


}
