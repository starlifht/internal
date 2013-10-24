package com.test.methods;

import java.io.FileWriter;
import java.io.IOException;

public class logOP {

	public static void doTmpLog(String uri,String content) throws IOException{
		FileWriter fileWriter = new FileWriter(uri, false);

		fileWriter.write(content);

		fileWriter.flush();
		fileWriter.close();
	}
	public static void main(String[] args) {
		try {
			doTmpLog("d://dsfsdf","2343sdfsdf3242");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
