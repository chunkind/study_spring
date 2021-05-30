<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		//confirm 선택창 :: ex)확인/취소
		//자바스크립트에서 페이지이동을 하기위한 함수
		//servlet에 logout을 요청한다.
		var f=confirm("로그아웃 하시겠습니까?");
		if(f)
			location.href="member.do?command=logout";
	}
</script>
</head>
<body>
<!-- 로그인 상태 여부에 따라서 보여지는 내용을 달리 가져갈 것이다. -->
	<!-- session에 vo가 바인딩 되어 있지 않다면 로그아웃상태이므로 회원가입과 로그인버튼을 보여준다. -->
	<!-- session에 vo가 바인딩 되어있다면 로그인상태 -->
	<!-- javascript:logout()로 자바스크립트 메소드를 호출 -->
	<!-- c:choose안에 주석 들어갈 경우 에러..;; -->
<c:choose>
	<c:when test="${sessionScope.vo==null}">
		<a href="register.jsp">회원 가입 하기</a><br><br>
		<a href="login.jsp">로그인 하기</a><br><br>
	</c:when>
	<c:otherwise>
		${sessionScope.vo.name}님, 로그인 상태입니다.^^<p><br>
		<a href="javascript:logout()">로그 아웃 하기</a><br><br>
		<a href="update.jsp">내 정보 수정하기</a><br><br>
		<a href="member.do?command=getAddressKind">주소로 회원 검색 하기</a><br><br>
	</c:otherwise>
</c:choose>
<!-- "member.do?command=getAddressKind"::findByAddress.jsp에 주소를 바인딩해준다. -->
</body>
</html>