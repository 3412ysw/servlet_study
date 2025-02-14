package com.gn.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.gn.member.service.MemberService;
import com.gn.member.vo.Member;


@WebServlet(name="memberUpdateEndServlet" , urlPatterns="/memberUpdateEnd")
public class MemberUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberUpdateEndServlet() {
        super(); 
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("member_no"));
		String pw = request.getParameter("member_pw");
		String name = request.getParameter("member_name");
		
		//Member m = new Member(); 매개변수 생성자나 set으로 담아주서 m 으로 보내는게 더 나음
		
		
		int result = new MemberService().updateMember(pw,name,no);
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg", "회원 정보 수정 중 오류가 발생하였습니다.");
		if(result>0) {
			Member m = new MemberService().selectMemberOne(no);
			if(m != null) {
				HttpSession session = request.getSession(false);
				if(session != null && session.getAttribute("member")!=null) {
					session.setAttribute("member",m);
				}
				
			}
			obj.put("res_code", "200");
			obj.put("res_msg", "회원 정보 수정이 완료되었습니다.");
		}
		response.setContentType("application/json; charset=utf-8");
	    response.getWriter().print(obj);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
