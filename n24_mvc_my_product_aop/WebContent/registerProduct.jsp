<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!--  
	  com.product.controller
	  MyProductController extends MultiActionController
	  insert(m,m,m)
-->
<body>
<h2 align="center">Product Register Form...</h2><p>
<form action="myproduct.do" method="post">
<input type="hidden" name="command" value="insert">
상품명 :: <input type="text" name="name"><p>
메이커 :: <input type="text" name="maker"><p>
가  격 :: <input type="text" name="price"><p>
<input type="submit" value="상품등록">
</form> 
<p><hr><p>
+++++++++++++++++++++++ 상품명 / 제조사별로 상품 검색하기 ++++++++++++++++++++++++
<form action="myproduct.do">
	<select name="command">
		<option value="findByProductName">상품명별 검색</option>
		<option value="findByMaker">제조사별 검색</option>
	</select>
	<input type="text" name="word">
	<input type="submit" value="검색하기">
</form><p><hr>

<a href="report.do?command=selectReport">검색어 순위보기</a>
</body>
</html>


























