package com.gn.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gn.member.vo.Member;

public class MemberDao {

	//creatMember 메소드
	//매개변수로 커넥션과 멤버 받아서
	//Db에 insert(아이디 , 비번, 이름)
	// Resultset ㄴㄴ excuteUpdate
	//결과를 int로 반환
	
	public int createMember(Member member , Connection conn) {
		PreparedStatement pstmt = null;
		int result =0;
		try {
			String sql = "INSERT INTO member(member_id ,member_pw ,member_name) "
					+ "VALUES(?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3,member.getMemberName());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		
		return result;
		
	}
}
