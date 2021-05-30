<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Upload OK~~~~~</b>
<!--...DownLoad 추가 -->
<p>
<hr>
<ul>
	<li>File Down Load</li>
</ul>
<a href="upload.do?command=fileDown&&filename=${requestScope.uploadfile}">${requestScope.uploadfile}</a>
</body>
</html>
























