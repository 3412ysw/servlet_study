<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.board.vo.Board, java.util.*, java.time.format.*" %>
<% List<Board> list = (List<Board>)request.getAttribute("resultList");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href='<%=request.getContextPath()%>/resources/css/board/list.css' rel="stylesheet" type="text/css">
<link href='<%=request.getContextPath()%>/resources/css/include/paging.css' rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script>
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<%Board paging = (Board)request.getAttribute("paging");  %>
	<section>
		<div id="section_wrap">
			<div class="search">
				<form action="/boardList" name="search_board_form" method="get">
					<input type="text" name="board_title" placeholder="검색하고자 하는 게시글 제목을 입력하세요."
					value="<%=paging.getBoardTitle() == null ? "" : paging.getBoardTitle()%>">
					<input type="submit" value="검색">
				</form>	
			</div>
			<div class="word">
				<h3>게시글 목록</h3>
			</div><br>
		    <div class="board_list">
				<table>
					<colgroup>
						<col width="10%">
						<col width="50%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일시</th>
						</tr>
					</thead>
					<tbody>
					<% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");%>
					<c:choose>
						<c:when test="${not empty resultList }">
							<c:forEach var="b" items="${resultList }" varStatus="vs">
								<tr data-board-no="${b.boardNo }">
									<td>${((paging.nowPage-1)*paging.numPerPage)+(vs.index+1)}</td>
									<td>${b.boardTitle }</td>
									<td>${b.memberName }</td>
									<td>${b.regDate }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
							<td colspan="4">조회된 목록이 없습니다.</td>
						   </tr>
						</c:otherwise>
					</c:choose>				
					</tbody>
				</table>
			</div>
		</div>
	</section>
 				<% if(paging.isPrev()){ %>
					<a href="/boardList?nowPage=<%=(paging.getPageBarStart()-1) %>&board_title=<%=paging.getBoardTitle()==null ? "" : paging.getBoardTitle()%>">&laquo;</a> <!-- << -->
				<%} %> 
	<c:choose>
	<c:when test="${not empty paging }">
		<div class="center">
			<div class="pagination">
				<c:choose>
					<c:when test="${empty paging.boardTitle }">
						<c:set var="result" value=""/>
					</c:when>
					<c:otherwise>
						<c:set var="result" value="${paging.boardTitle }"/>
					</c:otherwise>
				</c:choose>
				<c:if test="${paging.prev }">
					<a href="/boardList?nowPage=${(paging.pageBarStart)-1 }&board_title=${result}">&laquo;</a>
				</c:if>
				<c:set var="result" value=""/>
				<c:forEach var="i" begin="${paging.pageBarStart }" end="${paging.pageBarEnd }" >
					<a href="/boardList?nowPage=${i }&board_title=${result}">
						${i }
					</a>
				</c:forEach>
				<c:if test="${paging.next }">
					<a href="/boardList?nowPage=${(paging.pageBarEnd)+1 }&board_title=${result}">&raquo;</a>
				</c:if>
			</div>
		</div>
	</c:when>
	</c:choose>
	<script>
		$('.board_list tbody tr').on('click',function(){
			const boardNo = $(this).data('board-no');
			location.href='/boardDetail?board_no='+boardNo;
		})	
	</script>
	
</body>
</html>