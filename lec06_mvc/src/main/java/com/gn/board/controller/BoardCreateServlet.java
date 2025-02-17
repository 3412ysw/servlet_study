package com.gn.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/boardCreate")
public class BoardCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BoardCreateServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SPA : Single Page Application
		// 사용자가 화면전환이 된 것을 모르게 (바뀌는 부분의 코드만 가져와서 갈아끼우는) - 내용 많으면 복잡해짐 css 완벽하게 해야댕 
		// MPA :Multi Page Application ??
		RequestDispatcher view = request.getRequestDispatcher("/views/board/create.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
