<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String idx = request.getParameter("idx");	
		try {
			String driverName = "org.gjt.mm.mysql.Driver";
			String url = "jdbc:mysql://localhost:3306/Pengpark";
			ResultSet rs = null;
			
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, "Pengpark", "miswneh8");
			out.println("데이터베이스 접속 성공");
			
			Statement stmt = con.createStatement();
			String sql = "select * from board where idx = " + idx;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				request.setAttribute("idx", rs.getString("idx"));
				request.setAttribute("writer", rs.getString("writer"));
				request.setAttribute("regdate", rs.getString("regdate"));
				request.setAttribute("count", rs.getString("count"));
				request.setAttribute("title", rs.getString("title"));
				request.setAttribute("content", rs.getString("content"));
			}
			con.close();
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
%>

<body>
		<h1>게시글 조회</h1>
		<table border = "1">
			<tr>
				<th>번호</th>
				<td>${idx}</td>
				<th>작성자</th>
				<td>${writer}</td>
				<th>날짜</th>
				<td>${regdate}</td>
				<th>조회수</th>
				<td>${count}</td>
			</tr>
			<tr>
				<th colspan="2">제목</th>
				<td colspan="6">${title}</td>
			</tr>
			<tr>
				<th colspan="2">내용</th>
				<td colspan="6">${content}</td>
			</tr>
		</table>
		<a href ="delete.jsp?idx=${idx}">게시글삭제</a>
		<a href = "list.jsp">목록으로</a>
</body>
</html>