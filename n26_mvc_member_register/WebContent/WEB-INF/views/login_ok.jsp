<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h2>로그인 결과 페이지 입니다...</h2></center><p>
<c:choose>
	<c:when test="${sessionScope.vo==null }">
		<script type="text/javascript">
			alert("로그인 부터하세여...");
			location.href="login/login.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("${sessionScope.vo.name} 님 로그인 성공하셨어여!!");
			location.href="index.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>















