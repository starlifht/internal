package com.test.methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;



public class CommonTools {
	 public static String getXMLString(Map<String,String> hm) {
	        String key = "", value = "";
	        StringBuffer formatString = new StringBuffer();

	        formatString.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n");
	        formatString.append("<info>\r\n");

	        Iterator iter = hm.keySet().iterator();
	        while (iter.hasNext()) {
	            key = (String) iter.next();
	            value = (String) hm.get(key);
	            if(StringUtils.isEmpty(value)){
	                value = "";
	            }
	            formatString.append("<" + key + ">" + value + "</" + key + ">\r\n");
	        }

	        formatString.append("</info>\r\n");
	        return formatString.toString();
	    }
	public static String getCaptcha() throws Exception{
	    
		  URL url=new URL("http://captcha.sce.sohu.com/query?id=abcED_BuVlRg4b1cYsJ1t");
		  HttpURLConnection httpcon=(HttpURLConnection)url.openConnection();
		//  httpcon.setDoInput(true);
		 httpcon.setDoOutput(true);
		  httpcon.setConnectTimeout(7000);
		  httpcon.setReadTimeout(7000);
		  httpcon.setRequestMethod("GET");
			String secret = "mkD2h8eT1g9v4";
			String id = "abcED_BuVlRg4b1cYsJ1t";
			//锟斤拷梅锟斤拷锟斤拷锟绞憋拷锟?
			String timestamp = String.valueOf(System.currentTimeMillis());
			String sign = DigestUtils.md5Hex(id + timestamp + secret);
			//httpget 锟斤拷锟絟eader锟斤拷锟斤拷

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
	public static  String doPost(String url, Map<String, String[]> data) throws Exception {
	      List<NameValuePair> formparams = new ArrayList<NameValuePair>(); 
	        
	        for (Entry<String, String[]> entry : data.entrySet()) {
	            for(String value : entry.getValue()){
	                if ("".equals(value)){
	                    continue;
	                }
	                formparams.add(new BasicNameValuePair(entry.getKey(), value)); 
	            }
	        }
	        
	        UrlEncodedFormEntity requestEntity = null;
	   
	            requestEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
	       
	          //  System.out.println(requestEntity.toString());
	        HttpPost httpPost = new HttpPost(url);
	        httpPost.setEntity(requestEntity);
	        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + "UTF-8");
	        
	        return sendRequest(httpPost);
  }
	static String sendRequest(HttpUriRequest httpUriRequest) throws Exception{
		   HttpClient client = new DefaultHttpClient();
		

         client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 7000);
	        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 7000);
//	        wrapClient(client);
	        HttpResponse response = null;
	       // HttpContext httpContext = new BasicHttpContext();
	            response = client.execute(httpUriRequest);
//	            HttpHost targetHost = (HttpHost)httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
//				//获取实际的请求对象的URI,即重定向之后的"/blog/admin/login.jsp"
//				HttpUriRequest realRequest = (HttpUriRequest)httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
//				System.out.println("主机地址:" + targetHost);
//				System.out.println("URI信息:" + realRequest.getURI());

	        String responseContent = "";
	        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
	            HttpEntity responseEntity = response.getEntity();
	       
	                responseContent = EntityUtils.toString(responseEntity, "UTF-8");
	                EntityUtils.consume(responseEntity);
	         
	        }

	        client.getConnectionManager().shutdown();

	        return responseContent;
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
public static void main(String[] arg0) throws Exception{
	String s =CommonTools.HttpGet("http://10.10.124.105:8005/appstore/ios/newest");
	System.out.println(s);
}
}


	
