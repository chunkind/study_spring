<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">BeanNameViewResolver Test..</h2>
	<p>
		<a href="test.do?command=findBoard">Board Find Test..</a>
	<p>
		<a href="test.do?command=findProduct">Product Fine Test..</a>
	<p>
		<a href="test.do?command=findCustomer">Customer Fine Test..</a>
	<p>
	<form action="test.do" method="post">
		<input type="hidden" name="command" value="register">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>