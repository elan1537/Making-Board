<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.regex.Pattern" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	int idx = 1;
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String regdate = request.getParameter("regdate");
	String content = request.getParameter("content");

	if(title == "" || title == null) out.println("title이 null입니다.");
	if(writer == "" || writer == null) out.println("writer가 null입니다.	");
//	else if(!Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+$", writer)) out.println("이메일 형식이 아닙니다.");
	
	try {
		String url = "jdbc:mysql://localhost:3306/Pengpark"; // 사용하려는 데이터베이스명
		String id = "Pengpark";
		String pw = "miswneh8";
		
		Class.forName("org.gjt.mm.mysql.Driver");
		Connection conn = DriverManager.getConnection(url, id, pw);
		out.println("제대로 연결되었습니다.");	
		
		Statement stmt = conn.createStatement();
		
		String sql = "INSERT INTO Pengpark.board" + 
			"(title, writer, regdate, count, content)"  + 
			"VALUES('"+title+"', '"+writer+"', now(), '1', '"+content+"')";
		stmt.executeUpdate(sql);
		conn.close();
		
	} catch(Exception e) {
		out.println("데이터베이스 접속 실패");
		out.println(e.getMessage());
		e.printStackTrace();
	}
	
	finally {
		out.print("<script>location.href='list.jsp';</script>");
	}
%>
<body>

</body>
</html>