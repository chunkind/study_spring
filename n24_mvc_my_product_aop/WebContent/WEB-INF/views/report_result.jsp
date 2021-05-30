<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">AOP를 이용한 검색어 Ranking 보기</h2><p>
<table border="2" bgcolor='pink' width="50%" align="center">
	<tr>
		<td>랭킹 </td><td>검색어</td><td>조회수</td>
	</tr>
	<!-- resultType이 hashmap으로 지정했을때는 key에 해당하는 값을 컬럼명의 대문자-->
	<c:forEach items="${list}" var="reportMap">
		<tr>
			<td>${reportMap.RANKING}</td>
			<td>${reportMap.WORD}</td>
			<td>${reportMap.CNT}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>













