<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<title>글쓰기</title>
		</head>
		<body>
				<form action="insert.jsp" method="post" >
					제목 : <input type="text" name="title"/><br/>
					작성자 : <input type="text" name="writer"/><br/>
					날짜 : <input type="text" name="regdate"/><br/> 
					내용 : <textarea rows="10" cols="20" name="content"></textarea>
				<input type="submit"/>
				</form>
		</body>
</html>