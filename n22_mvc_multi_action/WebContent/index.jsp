<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 
	폼에 입력된 값을 CarController가 받을 것이고
	폼에 입력된 값을 VO에 바인딩...이 값을 받은 Controller가 비지니스 로직과 연결...
	service.addCar(carVO) -- dao.addCar(carVO)
 -->
<body>
<h2 align="center">AbstractCommandController Test...</h2><p>
<form action="car1.do" method="post">
<input type = "hidden" name = "mode" value = "registerCar">
Model :: <input type="text" name="model"><p>
Price :: <input type="text" name="price"><p>
<input type="submit" value="상품등록">
</form>
<p>
<hr>
<form action="testMulti.do" method = "post">
	<input type = "hidden" name = "mode" value = "update">
	UPDATE ::<input type = "submit" value = "update 요청하기">
</form>
<p>
<hr>
<form action="testMulti.do" method = "post">
	<input type = "hidden" name = "mode" value = "delete">
	DELETE ::<input type = "submit" value = "delete 요청하기">
</form>
</body>
</html>