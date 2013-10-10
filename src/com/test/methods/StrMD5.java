package com.test.methods;

/*
 * Created on 2005-3-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class StrMD5 {

	private String m_result;

	private String m_key;

	private MessageDigest currentAlgorithm;

	public StrMD5(String key) {
		this.m_key = key;
		try {
			currentAlgorithm = MessageDigest.getInstance("MD5");
			this.m_result = computeDigest(loadBytes(this.m_key));//+ "\r\n";
		} catch (NoSuchAlgorithmException e) {
			System.out.println("MD5 algorithm not available.");
		}
	}

	public String getResult() {
		currentAlgorithm.reset();
		return this.m_result;

	}

	static private byte[] loadBytes(String name) {
		byte[] buffer = name.getBytes();

		/*
		 * byte [] buffer; try { buffer = name.getBytes("iso8859-1");
		 * //System.out.println(name); //System.out.println("Begin...");
		 * }catch(Exception ex) { buffer = name.getBytes();
		 *  }
		 */
		return (buffer);
	}

	private String computeDigest(byte[] b) {
		currentAlgorithm.reset();
		currentAlgorithm.update(b);
		byte[] hash = currentAlgorithm.digest();
		String d = "";
		int usbyte = 0; // unsigned byte
		for (int i = 0; i < hash.length; i += 2) { // format with 2-byte words
												   // with spaces.
			usbyte = hash[i] & 0xFF; // byte-wise AND converts signed byte to
									 // unsigned.
			if (usbyte < 16)
				d += "0" + Integer.toHexString(usbyte); // pad on left if single
														// hex digit.
			else
				d += Integer.toHexString(usbyte);
			usbyte = hash[i + 1] & 0xFF; // byte-wise AND converts signed byte
										 // to unsigned.
			if (usbyte < 16)
				d += "0" + Integer.toHexString(usbyte);//+ " "; // pad on left
													   // if single hex digit.
			else
				d += Integer.toHexString(usbyte);// + " ";
		}
		//return d.toUpperCase();
		return d.trim().toLowerCase();
	}

}