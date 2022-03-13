<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>Spring MVC First Sample</h2>
	<a href="hello.do">DispatcherServlet GOGO!!</a>
	<hr>
	<h2>Spring Form First Sample</h2>
	<form action="form.do" method = "post">
		NAME : <input type = "text" name = "name"><br/>
		ADDR : <input type = "text" name = "addr"><br/>
		<input type = "submit" value = "전송하기">
	</form>
</div>
</body>
</html>