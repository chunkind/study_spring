<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Multi File Upload Test...</h2>
	<p>
	<form action="multiupload.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="command" value="multiFileUpload">
		사용자명 :: <input type="text" name="userName">
		<p>
			<!-- 폼의 이름에도 나름의 규칙이 있다. -->
			<input type="file" name="file[0]">
		<p>
			<input type="file" name="file[1]">
		<p>
			<input type="file" name="file[2]">
		<p>
			<input type="submit" value="멀티 파일 전송">
	</form>
</body>
</html>
<!--  원래는 Controller로 넘어가지만...VO를 먼저 작성.-->