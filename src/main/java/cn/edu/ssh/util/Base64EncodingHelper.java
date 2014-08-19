package cn.edu.ssh.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.internal.util.xml.BaseXMLEventReader;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64EncodingHelper {
	
	public static String encoding(String source){
		BASE64Encoder encoder = new BASE64Encoder();
		try {
			return encoder.encode(source.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String decoding(String source){
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] bt =decoder.decodeBuffer(source);
			return new String(bt,"utf-8");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		String s = "唐一波";
		String e = encoding(s);
		System.out.println(e);
		String d = decoding(e);
		System.out.println(d);
	}
	
	public void testMd5(String s) throws NoSuchAlgorithmException{
		MessageDigest digest  = MessageDigest.getInstance("MD5");
		digest.update(s.getBytes());
		digest.digest();
	}
}
