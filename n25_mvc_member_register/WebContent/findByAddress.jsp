<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function searchGo(){
		var addr = document.searchForm.address.value; 
		if(addr==""){
			alert("주소 선택 하라니깐~~~");
			return;
		}
		/* 주소를 선택하면 from의 정보를 servlet으로 보내며 요청 */
		document.searchForm.submit();
	}

</script>
</head>
<body>
<!-- select 태그를 이용해서 모든 종류의 주소를 가져와서 선택할수 있도록 한다. -->
<!-- method="get"::get방식과 post방식중 get방식으로 요청을 보낸다. -->
<form method="get" action="member.do" name="searchForm">
<input type="hidden" name="command" value="findByAddress">
<!-- select중에 하나의 주소를 선택하면 자바스크립트로 연결... -->
<!-- onchange선택이 바뀔때마다 메소드 호출 -->
<select name="address" onchange="searchGo()">
	<option>===주소 종류들===</option>
	<!-- getAddressKindd에서 받아온 list를 목록에 넣어준다. -->
	<c:forEach items="${requestScope.list}" var="str">
		<option value="${str}">${str}</option>
	</c:forEach>
</select>
</form>
</body>
</html>


















