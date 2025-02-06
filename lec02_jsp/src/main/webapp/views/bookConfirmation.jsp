<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String)request.getAttribute("name");
	String userPhone = (String)request.getAttribute("phone");
	String userEmail = (String)request.getAttribute("email");
	String bookName = (String)request.getAttribute("bookName");
	int date = (int)request.getAttribute("date");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출 금액 확인</title>
</head>
<body>
	<h1>도서 대출 내역</h1>
	<h4>[고객 정보]</h4>
	<ul>
		<li>고객명 : <%=userName %></li>
		<li>전화번호 : <%=userPhone %></li>
		<li>이메일 : <%=userEmail %></li>
	</ul>
	<ul>
		<li>도서 제목 : <%=bookName %></li>
		<li>대출 기간 : <%=date %></li>
	</ul>
	<h2>대출 금액 <%=price %>원</h2>
	<h3>도서를 즐겁게 읽으세요!</h3>
</body>
</html>