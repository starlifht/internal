package com.test.methods;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendCloud {
 @SuppressWarnings("unchecked")
public static void sendMail(String to,String subject,String content) throws Exception{
	 String url = "http://urlfetch.sce.sohu.com/http/sendcloud.sohu.com/webapi/mail.send.xml";
		HttpClient httpclient = new DefaultHttpClient();
		// httpclient = wrapHttpClient(httpclient);
		HttpPost httpost = new HttpPost(url);

		List nvps = new ArrayList();
             //不同于登录SendCloud站点的帐号，您需要登录后台创建发信子帐号，使用子帐号和密码才可以进行邮件的发送。
		nvps.add(new BasicNameValuePair("api_user", "postmaster@delongbat.sendcloud.org"));
		nvps.add(new BasicNameValuePair("api_key", "delong"));
		nvps.add(new BasicNameValuePair("from", "PassPort@sendcloud.org"));
		nvps.add(new BasicNameValuePair("to", to));
		nvps.add(new BasicNameValuePair("subject", subject));
		nvps.add(new BasicNameValuePair("html", content));

		httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
		// 请求
		HttpResponse response = httpclient.execute(httpost);
		// 处理响应
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
			// 读取xml文档
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
		} else {
			System.err.println("error");
		}
 }
	public static void main(String[] args) throws ClientProtocolException, IOException {
		try {
			new SendCloud().sendMail("107607195@qq.com","测试","测试");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
