package com.gn.common.filter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordEncodingWrapper extends HttpServletRequestWrapper{

	public PasswordEncodingWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		if(name.contains("member_pw")) {
			String ori = super.getParameter(name); //form요소의 name 값
			System.out.println("암호화 전 : " + ori);
			String enc = getSHA512(ori);
			System.out.println("암호화 후  : "+ enc);
			return enc;
		}
		
		return super.getParameter(name);
	}
	
	//단방향 암호화 메소드
	@SuppressWarnings("unused")
	private String getSHA512(String str) {
		// 1.암호화 처리 클래서 선언
		MessageDigest md = null;
		try {
			// 2.적용할 알고리즘 선택 후 인스턴스화
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 3.String 을 byte[]로 자름
		byte[] strByte = str.getBytes();
		// 4.자른 데이터를 암호화 처리 
		md.update(strByte);
		// 5.암호화 처리된 값을 byte[]로 가져옴
		byte[] encryptByte = md.digest();
		// 6.Base64 인코더로 byte[]을 String으로 변환
		return Base64.getEncoder().encodeToString(encryptByte);
	}
	
	

}
