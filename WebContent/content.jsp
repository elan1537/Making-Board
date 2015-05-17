<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>게시글 조회</h1>
		<table border = "1">
			<tr>
				<th>번호</th>
				<td>${article.idx}</td>
				<th>작성자</th>
				<td>${article.writer}</td>
				<th>IP</th>
				<td>${article.regip}</td>
				<th>날짜</th>
				<td>${article.regdate}</td>
				<th>조회수</th>
				<td>${article.count}</td>
			</tr>
			<tr>
				<th colspan="2">제목</th>
				<td colspan="6">${article.title}</td>
			</tr>
			<tr>
				<th colspan="2">내용</th>
				<td colspan="6">${article.content}</td>
			</tr>
		</table>
		<a href ="delete.do?idx=${article.idx}">게시글삭제</a>
		<a href = "list.do">목록으로</a>
</body>
</html>