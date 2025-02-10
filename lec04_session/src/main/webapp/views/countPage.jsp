<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방문 횟수</title>
</head>
<body>
	<% 
	int visitCount = 0;
	
	if(cookies != null){ 
		for(Cookie ck : cookies){
			if("visit_count".equals(ck.getName())){
				// ㅠ벨류값을 숫자로 바꾸고 1 더함
				visitCount = Integer.parseInt(ck.getValue())+1;
				Cookie c = new Cookie("visit_count",String.valueOf(visitCount));
				c.setMaxAge(60*60*24);
				response.addCookie(c);
				
			}else{
				// 만약에 없다면 쿠키를 만들어준다 
				Cookie c = new Cookie("visit_count","0");
				c.setMaxAge(60*60*24);
				response.addCookie(c);
			}
		}
	}
	%>
	<p>
	당신은 이 페이지를 
	<strong><%=visitCount%></strong>번 방문했습니다.
	</p>
</body>
</html>