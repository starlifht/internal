package com.mail;

import java.io.IOException;

import com.sohu.apps.api.mail.MailMessage;
import com.sohu.apps.api.mail.MailService;
import com.sohu.apps.api.mail.MailServiceImpl;

public class SendMail {//=========ģ�ⷢ�ʼ�

	public static void sendMail(String title, String content, String toAddress) {//����ÿ���޷�500
		MailSenderInfo mailInfo = new MailSenderInfo();
		
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
//		 mailInfo.setMailServerHost("smtp.163.com");
//		 mailInfo.setUserName("starlight00@163.com");
//		 mailInfo.setPassword("787870724");//������������
//		 mailInfo.setFromAddress("starlight00@163.com");
		 mailInfo.setMailServerHost("mail.sohu-inc.com");
		 mailInfo.setUserName("starwang@sohu-inc.com");
		 mailInfo.setPassword("Star02240323&");//������������
		 mailInfo.setFromAddress("starwang@sohu-inc.com");
//		mailInfo.setMailServerHost("mail.sohu-inc.com");
//		mailInfo.setUserName("starwang0224@sohu-inc.com");
//		mailInfo.setPassword("Star224323!");// ������������
//		mailInfo.setFromAddress("starwang0224@sohu-inc.com");
		mailInfo.setToAddress(toAddress);
		mailInfo.setSubject(title);
		mailInfo.setContent(content);
		// �������Ҫ�������ʼ�
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);// ���������ʽ
		// sms.sendHtmlMail(mailInfo);//����html��ʽ
	}

	public static void main(String[] args) {
	//sendMail("67777", "235234235235253"+"\r\n"+"sdfdsff", "107607195@qq.com");

//     String s="<xml>sdfsdfd<xml>             " +
//     		"" +
//     		"" +
//     		"<sdfsf><sdfsdffd>" +
//     		"" +
//     		"" +
//     		"<status>0</status>";
//     String m="0";
//     int aa=s.indexOf("status");
//     int bb=s.indexOf("status", aa+7);
//     String n=s.substring(aa+7,bb-2);
//		System.out.print(s.substring(aa+7,bb-2));
//		if(n.equals(m)){
//			System.out.print("true");
//		}else{
//			System.out.print("false");
//		}
	MailService mailService = new MailServiceImpl();
	MailMessage msg = new MailMessage();
	msg.setSender("username");
	msg.setSubject("subject");
	String to = "107607195@qq.com;starwang@sohu-inc.com;";
	msg.setTo(to.split(";"));
	msg.setTextBody("hello sce mail");
	try {
		mailService.send(msg);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
