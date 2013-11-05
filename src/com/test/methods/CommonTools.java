package com.test.methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.digest.DigestUtils;



public class CommonTools {
	public static String getCaptcha() throws Exception{
	    
		  URL url=new URL("http://captcha.sce.sohu.com/query?id=abcED_BuVlRg4b1cYsJ1t");
		  HttpURLConnection httpcon=(HttpURLConnection)url.openConnection();
		//  httpcon.setDoInput(true);
		 httpcon.setDoOutput(true);
		  httpcon.setConnectTimeout(8000);
		  httpcon.setReadTimeout(8000);
		  httpcon.setRequestMethod("GET");
			String secret = "mkD2h8eT1g9v4";
			String id = "abcED_BuVlRg4b1cYsJ1t";
			//��÷�����ʱ��?
			String timestamp = String.valueOf(System.currentTimeMillis());
			String sign = DigestUtils.md5Hex(id + timestamp + secret);
			//httpget ���header����

		 httpcon.setRequestProperty("timestamp", timestamp);
		 httpcon.setRequestProperty("code",sign );
		  httpcon.connect();
		 // DataOutputStream out=new DataOutputStream(httpcon.getOutputStream());
		 BufferedReader br=new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
		 String line="";
		 String captcha="";
		  for (line = br.readLine(); line != null; line = br.readLine()) {
			  captcha=captcha+line;
			 
		    }
		  return captcha;
		}

	public static String createURLConnection(String str_url, String para,String contentType) throws Exception
	{
		String rtn = "";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		InputStream is = null;

	
			System.setProperty("sun.net.client.defaultConnectTimeout", "2000");
			System.setProperty("sun.net.client.defaultReadTimeout", "2000");
			url = new URL(str_url);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
//			con.setRequestProperty("Content-Type", "text/xml");
			con.setRequestProperty("Content-Type",contentType);
			

			bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
			bw.write(para);
			bw.close();

	
			is = con.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String buffer = null;
			while ((buffer = br.readLine()) != null)
			{
				if (buffer != null)
				{
					rtn += buffer;
				}
			}

				if (br != null)
					br.close();
				if (is != null)
					is.close();
				if (con != null)
					con.disconnect();
	


		return rtn;
	}
	public static String createXMLURLConnection(String str_url, String para) throws Exception {
	     
	            URL url = new URL(str_url);
	            URLConnection con = url.openConnection();	   
	            con.setDoOutput(true);
	            con.setReadTimeout(5000);
	            con.setConnectTimeout(5000);
	            con.setRequestProperty("Pragma:", "no-cache");
	            con.setRequestProperty("Cache-Control", "no-cache");
	            con.setRequestProperty("Content-Type", "text/xml;charset=GBK");
	            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());    
	            out.write(para);
	            out.flush();
	            out.close();
	            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"GBK"));
	            String line = "";
	            String response="";
	            for (line = br.readLine(); line != null; line = br.readLine()) {
	              response=response+line;
	            }
				return response;
	    
	     
	    }
public static String HttpGet(String str_url) throws Exception{
	//String str_url="http://m.weather.com.cn/data/101010100.html";
	URL url=new URL(str_url);
	HttpURLConnection	httpcon = (HttpURLConnection) url.openConnection();
	httpcon.setDoOutput(true);
	//HttpURLConnection.setFollowRedirects(true);
	  httpcon.setConnectTimeout(5000);
	  httpcon.setReadTimeout(5000);
	 httpcon.setRequestMethod("GET");
	httpcon.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

	  httpcon.connect();
	 // DataOutputStream out=new DataOutputStream(httpcon.getOutputStream());
	  
	 BufferedReader br=new BufferedReader(new InputStreamReader(httpcon.getInputStream(),"UTF-8"));

	 String line="";
	 String response="";
	  for (line = br.readLine(); line != null; line = br.readLine()) {
		  response=response+line;

	    }
	return response;
	
}
	
}


	
