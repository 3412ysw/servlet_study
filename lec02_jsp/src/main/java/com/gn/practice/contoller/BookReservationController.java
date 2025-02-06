package com.gn.practice.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrow")
public class BookReservationController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	public BookReservationController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("user_name");
		String userPhone = req.getParameter("user_phone");
		String userEmail = req.getParameter("user_email");
		String book = req.getParameter("book");
		int date = Integer.parseInt(req.getParameter("date"));
		
		int price = 0;
		String bookName ="";
		
		if(book.equals("1")) {
			price = 1500;
			bookName = "자바 프로그래밍 입문";
		}else if(book.equals("2")) {
			price = 1800;
			bookName = "웹 개발의 기초";
		}else if(book.equals("3")) {
			price = 2000;
			bookName = "데이터베이스 시스템";
		}
		
		for(int i = 1 ; i < date; i++) {
			price += 500;
		}
		
		
		System.out.println(price);
		
		RequestDispatcher view = req.getRequestDispatcher("views/bookConfirmation.jsp");
		req.setAttribute("name", userName);
		req.setAttribute("phone", userPhone);
		req.setAttribute("email", userEmail);
		req.setAttribute("bookName", bookName);
		req.setAttribute("date", date);
		req.setAttribute("price", price);
		view.forward(req, resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
}
