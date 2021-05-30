<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><b>목    록</b></center><p>
<table border="1" width="650" cellpadding="2" align="center">
	<tr>
		<th width="10%">번호</th>
		<th width="50%">제목</th>
		<th width="15%">작성자</th>
		<th width="15%">작성일</th>
		<th width="10%">조회수</th>
	</tr>
	<c:forEach var="bvo" items="${list}">
		<tr>
			<td>${bvo.no}</td>
			<td><a href="board.do?command=showContent&&no=${bvo.no}">${bvo.title}</a></td>
			<td>${bvo.memberVO.name}</td>
			<td>${bvo.writeDate}</td>
			<td>${bvo.count}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>














