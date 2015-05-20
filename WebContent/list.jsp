<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<title>Insert title here</title>

				 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/css/materialize.min.css">
				 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
				 <link type = "text/css" rel="stylesheet" href = "css/list.css">
		</head>

		<body>
		
		<nav>
    		<div class="nav-wrapper">
      			<a href="list.do" class="brand-logo">List</a>
      			<ul id="nav-mobile" class="right hide-on-med-and-down">
        			<li><a href="write.jsp">글쓰기</a></li>
      			</ul>
    		</div>
    	</nav>

				<table class = "hoverable">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
					<c:forEach items = "${articleList}" var = "article" >
					<tr>
						<td>${article.idx}</td>
						<td><a href='count.do?idx=${article.idx}'>${article.title}</a></td>
						<td>${article.writer}</td>
						<td>${article.regdate}</td>
						<td>${article.count}</td>
					</tr>
					</c:forEach>
				</table>
				
				<c:if test="${page > 0}">
						<a href="list.do?page=${page-10}">이전페이지</a>
				</c:if>
				<c:if test="${page==0}">
						<a href="#">이전페이지</a>
				</c:if>
				||
				<fmt:parseNumber value="${page/10+1}" type="number" integerOnly="True"/>페이지
				||
				<c:if test="${fn:length(articleList) < 10}">
						<a href="#">다음페이지</a>
				</c:if>
				<c:if test="${fn:length(articleList) == 10	}" >
						<a href="list.do?page=${page+10}">다음페이지</a>
				</c:if>
		</body>
</html>