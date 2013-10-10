package com.test.methods;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import jxl.demo.Write;

import com.mail.SendMail;
import com.test.internal.Mobile;

public class Clock {
	public static Timer timer;
	int second;
	int num;


	public Clock(int num, int second) {
		this.second = second;
		this.num = num;
		timer = new Timer();
		
		timer.schedule(new RemindTask(num), 0, // initial delay
				second * 1000); // subsequent rate
	}

	public static void doShutDownWork() {
		Runtime.getRuntime().addShutdownHook(new Thread() {// �����쳣�˳�����
					@Override
					public void run() {
						String date = new SimpleDateFormat("MM-dd HH:mm:ss")
								.format(new Date());
						try {
							Mobile.sendSms("18810606513", date
									+ " WARNING : Internal API  EXCEPTION "
									+ APITools.getIP());				
						
	
							SendMail.sendMail(
									"WARNING:Internal����쳣�˳���",
									date + " Internal������쳣�жϣ��뾡�����ԭ�� "
											+ APITools.getIP(),
									"107607195@qq.com");

						} catch (Exception e) {

							e.printStackTrace();
						}

					}
				});
	}

	class RemindTask extends TimerTask {
		int num;
		int count = 1;
		int errorCounts=1;

 		RemindTask(int num) {
			this.num = num;
		}
	
		public void run() {//��������������������������������ִ��

			if (count< num) {
			
				try {
				
		
					

				} catch (Exception e) {
					e.printStackTrace();
					try {
						SendMail.sendMail("WARNING:INTERNAL����쳣��",
								" Internal�ӿ� " +APITools.getIP()+ e.toString(),
								"107607195@qq.com");
					} catch (Exception e1) {
				
						e1.printStackTrace();
					}
				}
          
             
				System.out.println("=================================================");
				System.out.println("===========Internal�ӿڼ�������У�����رմ���===========" + count);
				System.out.println("=================================================");
				count++;
			} else {

				System.out.println("Time's up!");

				System.exit(0);
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		String pwd = new String();
//		Scanner c = new Scanner(System.in);
//		pwd = c.next();
//		if (pwd.equals("787870724")) {
//			System.out.println("true");
//			WriteFile.SaveTXT("SystemLog.txt", new SimpleDateFormat(
//					"MM-dd HH:mm:ss").format(new Date())
//					+ " Internal��ط������� "
//					+APITools.getIP()+ "\r\n");
//			Clock.doShutDownWork();
//			//new Clock(888888888, Integer.parseInt(Panel1.cb3.getSelectedItem().toString())*60);
//		} else {
//			System.out.print("false");
//			System.exit(0);
//		}
	}
}
