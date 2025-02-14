package com.gn.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.member.vo.Member;
import static com.gn.common.sql.JDBCTemplate.close;

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
			close(pstmt);
		}
		
		return result;
		
	}
	
	public Member loginMember(String id, String pw,Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			String sql = "SELECT * FROM member "
					+ "WHERE member_id= ? && member_pw=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}
	
	public int updateMember(String pw, String name, int no , Connection conn) {
		PreparedStatement pstmt = null;
		int result =0;
		try {
			String sql = "	UPDATE member SET member_pw = ? , member_name = ? WHERE member_no = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pw);
			pstmt.setString(2, name);
			pstmt.setInt(3,no);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public Member selectMemberOne(int no,Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			String sql = "SELECT * FROM member "
					+ "WHERE member_no= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}
	
	
}
