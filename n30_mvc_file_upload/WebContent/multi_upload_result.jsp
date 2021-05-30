<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--1. forEach를 사용해서 Upload된 파일명을 출력.. -->
<!-- 
	2. fileName을 클릭하면 다운로드로 이어지도록..
	이때 자바스크림트로 띄울것이다. 창 하나 띄워서 정말 다운로드 할 건지 물어본 다음에
	confrim 창을 이용하자. 
	controller의 command값은 fileDown으로 하자.
-->

<h2 align="center"> Multi File Upload Ok!!</h2><p>
<c:forEach var = "fileName" items = "${uploadfile}">
	<ul>
		<li>${fileName}</li>
	</ul>
</c:forEach>
</body>
</html>