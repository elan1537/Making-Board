<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
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
			
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, "Pengpark", "miswneh8");
			out.println("데이터베이스 접속 성공");
			
			Statement stmt = con.createStatement();
			String sql = "delete from board where idx = " + idx;
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
%>
<script type="text/javascript">
		alert("게시글이 삭제되었습니다.");
		location.href="redirect.jsp";
</script>
</body>
</html>