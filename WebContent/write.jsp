<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
								 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/css/materialize.min.css">
				 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
				 				 <link type = "text/css" rel="stylesheet" href = "css/list.css">
				 				 <script src="JS/write.js"></script>
				<title>글쓰기</title>
		</head>
		<body>
		<div class = "row">
			<div class = "col s12">
				<div class = "row">
					<div class="input-field col s12">
						<form action="insert.do" method="post" >
							<input type="text" name="title"/><br/>
							<input type="text" name="writer"/><br/>
							<textarea id="textarea1" class="materialize-textarea" name="content"></textarea>
							<input type="submit"/>
						</form>
					</div>
				</div>
			</div>
		</div>	
		</body>
</html>