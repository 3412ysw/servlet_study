package com.gn.member.service;

import java.sql.Connection;

import com.gn.member.dao.MemberDao;
import com.gn.member.vo.Member;

import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.close;

public class MemberService {
	private MemberDao md = new MemberDao();
	// createMember 메소드
	// Member를 매개변수로 받아서
	//Connection 객체 생성
	//멤버다오에게 커넥션과 멤버 전달
	//int 반환
	
	public int createMember(Member member) {
		Connection conn = getConnection();
		int result = md.createMember(member, conn);
		close(conn);
		return result;
	}
	
	
	
}
