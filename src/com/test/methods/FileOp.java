package com.test.methods;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileOp {
	public  StringBuffer readFile(String url) throws Exception {
		String line = null;
		StringBuffer s=new StringBuffer();
		FileInputStream f = new FileInputStream(url);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(f,"UTF-8")); // 

		while ((line = input.readLine()) != null) { 
		
			//s.append(line);
			
			s.append(line).append(System.getProperty("line.separator"));
			//System.out.println(s);
		}

		input.close();

		return s;
	}

	public static void main(String[] args) {

	}

}
