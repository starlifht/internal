package com.test.internal;

/*
 * Created on 2005-3-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.security.MessageDigest;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;



public class PPTools {
	private static MessageDigest md5Digester;
	static {
		try {
			md5Digester = MessageDigest.getInstance("MD5");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final char [] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	

	public static boolean verifyV_1_1(String src, String des) {
		//
		StrMD5 md5 = new StrMD5(src);
		return (md5.getResult().equals(des));
	}

	public static String asciiReverse(String data) {
		if (data == null || data.length() == 0)
			return data;

		StringBuffer str_buf = new StringBuffer();
		for (int i = 0; i < data.length(); i++) {
			char in = data.charAt(i);

			if (in > -1 && in < 128) {
				in = (char) (127 - in);
			}
			str_buf.append(in);
		}

		return str_buf.toString();
	}//end func asciiReverse

	public static String null2String(String str) {

		if (str == null) {
			return new String("");
		} else {
			return str.trim();
		}
	}
	
	public static String usernameTolowercase(String passport){
		boolean isIgnoreCase = PPTools.isIgnoreCase(passport);
		if(isIgnoreCase)
		{
			passport=PPTools.toLowerCase(passport).trim();
		}else{
			String[] arr=passport.split("@");
			if(arr.length==2){
				passport=arr[0]+"@"+toLowerCase(arr[1]);
			}
		}
		return passport;
	}

	public static String toLowerCase(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		char c;
		StringBuffer ret_str = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			/*
			 * if ( b_multi) //��ǰ�����˫�ֽ�?{ ret_str.append( c );
			 * b_multi=false;//˫�ֽڽ��� continue; }
			 * 
			 * if ( c > 0x7f ) { //Str�ִ������������ĵ�˫�ֽ�ascii����ֵ>0x7f��ʮ����ƣ�?b_multi =
			 * true; //���ñ�־λ��֪ͨ������һ���ַ���˫�ֽڵ�һ����,����Ҫ���� ret_str.append( c );
			 * continue; }
			 */
			//ok ,��ͨ�ַ�
			if (c > 64 && c < 91) //65=A,90=Z
			{
				c += 32;
				ret_str.append(c);

			} else {
				ret_str.append(c);

			}
		}
		return ret_str.toString();
	}

	public static String toUpperCase(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		char c;
		StringBuffer ret_str = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			/*
			 * if ( b_multi) //��ǰ�����˫�ֽ�?{ ret_str.append( c );
			 * b_multi=false;//˫�ֽڽ��� continue; }
			 * 
			 * if ( c > 0x7f ) { //Str�ִ������������ĵ�˫�ֽ�ascii����ֵ>0x7f��ʮ����ƣ�?b_multi =
			 * true; //���ñ�־λ��֪ͨ������һ���ַ���˫�ֽڵ�һ����,����Ҫ���� ret_str.append( c );
			 * continue; }
			 */
			//ok ,��ͨ�ַ�
			if (c > 96 && c < 123) //97=a,122=z
			{
				c -= 32;
				ret_str.append(c);

			} else {
				ret_str.append(c);

			}
		}
		return ret_str.toString();
	}

	public static String md5(String message) {
		if (message == null) {
			return null;
		}
		try {
			MessageDigest digester = (MessageDigest)md5Digester.clone();
			byte[] digest = digester.digest(message.getBytes());
			
			StringBuffer buf = new StringBuffer(digest.length * 2);
			for (int i=0; i<digest.length; i++)
				buf.append(HEX_CHARS[(digest[i] >> 4) & 0x0F]).append(HEX_CHARS[digest[i] & 0x0F]);
				
			return buf.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public static String getEmailUser(String email) {

		if (email == null) {
			return null;
		}
		int at = email.lastIndexOf('@');
		if (at < 1 || at == (email.length() - 1)) {
			return null;
		} else {
			return email.substring(0, at);
		}

	}

	public static String getEmailDomain(String email) {

		if (email == null) {
			return null;
		}
		int at = email.lastIndexOf('@');
		if (at < 1 || at == (email.length() - 1)) {
			return null;
		} else {
			return email.substring(at + 1);
		}
	}
	
	public static String getProviderByDomain(String domain){
		if(StringUtils.isEmpty(domain)){
			return null;
		}
		
		return domain.replaceAll("\\.sohu\\.com", "");
	}

	/**
	 * ���ַ��ָ��ֳ�String[]
	 * 
	 * @param source
	 *            Ҫ�ָ���ַ�?
	 * @param delim
	 *            ���зָ����ɵ��ַ�
	 */
	public static String[] explode(String source, String delim) {
		int last = 0;
		Vector v = new Vector();
		for (int i = 0; i < source.length(); i++)
			if (delim.indexOf(source.charAt(i)) != -1) {
				v.add(source.substring(last, i));
				last = i + 1;
			}
		if (last < source.length())
			v.add(source.substring(last));
		else if (source.length() > 0 && last == source.length()) // ���һ���ַ���delim�е��ַ�Ҫ���⴦��һ�¡�
			v.add("");
		String[] a = new String[v.size()];
		System.arraycopy(v.toArray(), 0, a, 0, v.size());
		return a;
	}

	/**
	 * 
	 * @param msg
	 * @return
	 */
	public static String getXmlFormatString(String msg){
		StringBuffer formatString = new StringBuffer(128);
		formatString.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		formatString.append("<result>\r\n");
		formatString.append("<status>"+msg+"</status>\r\n");
		formatString.append("</result>");
		return formatString.toString();
	}
	
	/**
	 * 
	 * @param msg
	 * @return
	 */
	public static String getXmlFormatString(String status,String msg){
		StringBuffer formatString = new StringBuffer(128);
		formatString.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		formatString.append("<result>\r\n");
		formatString.append("<status>"+status+"</status>\r\n");
		formatString.append("<errmsg>"+msg+"</errmsg>\r\n");
		formatString.append("</result>");
		return formatString.toString();
	}
	
	/**
	 * 
	 * @param msg
	 * @param passport
	 * @return
	 */public static String getTextFormatString(String msg, String passport){
		return msg+" "+passport;
	}

	 /**
		 * 
		 * @param status
		 * @return
		 */
	public static String getXmlUserCheck(String status){
		StringBuffer formatString = new StringBuffer();
		formatString.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
		formatString.append("<users>\r\n");
		formatString.append("<status>"+status+"</status>\r\n");
		formatString.append("</users>\r\n");
		return formatString.toString();
	} 
	 
	/**
	 * 
	 * ����һ��byte�Ƿ�Ϊ�����ַ����ɲ��֡�
	 * 
	 * ֻ�Ǽ���byte�Ƿ���ڵ���?������0�����ʾ���ַ�Ϊascii�룻
	 * С��0������Ϊ���ַ�Ϊ�����ַ����ɲ��֡�

	 * 
	 */
	public static boolean chineseChr(byte b){
		if(b>=0) return false;
		else return true;
	}
	
	/**
	 * 
	 * ���һ���ַ����Ƿ�������ַ�
	 * 
	 */
	public static boolean containsCN(String str){
		if(str==null) return false;
		byte[] tmp=str.getBytes();
		for(int i=0;i<tmp.length;i++)
		{
			if(chineseChr(tmp[i])) return true;
		}
		return false;
		}
	
	/*
	 * ����û���PASSPORT���ж��Ƿ���Դ�Сд������?��ǰ,ֻ��focus.cn��open���˺���ִ�С�?
	 */
	private static boolean isIgnoreCase(String passport)
	{
		
//		if (DomainCookieUtil.isInOpenDomainList(passport)) {
//			return false;
//		}
		boolean rtn = true;
		String domain = getEmailDomain(passport);
		if(domain==null)
		{
			return rtn;
		}
		domain = domain.toLowerCase();
		if(domain.equals("focus.cn"))
		{//����ע���û��Լ�focus����ִ�С�?
			rtn = false;
		}
		return rtn;
	}
		
	/*public static void main(String[] args) {
		System.out.println(md5("testsalt"));
	}*/

}
