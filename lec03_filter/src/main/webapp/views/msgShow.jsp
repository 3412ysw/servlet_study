<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메세지 확인</title>
</head>
<body>
	<h1>메세지</h1>
	<p>
		<%=msg %>
	</p>
</body>
</html>