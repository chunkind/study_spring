<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Login Form...</h2>
	</center>
	<p>
	<!-- method="post"::get과 post방식중 post로 내용을 전달한다. -->
	<form action="member.do" method="post">
		<input type="hidden" name="command" value="login">
		ID : <input type="text" name="id"><br><br>
		PASS : <input type="password" name="password"><br><br>
		<!-- form의 정보를 전달:: type="submit"-->
		<input type="submit" value="로그인">
	</form>
</body>
</html>
