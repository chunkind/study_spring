<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center" class="body">
		<h2>상품 목록 화면</h2>
		<table border="1">
			<tr class="header">
				<th align="center" width="80">상품ID</th>
				<th align="center" width="320">상품명</th>
				<th align="center" width="100">가격</th>
			</tr>
			<c:forEach items="${itemList}" var="item">
				<tr class="record">
					<td align="center">${item.itemId}</td>
					<td align="center"><a href="detail.html?itemId=${item.itemId}">${item.itemName}</td>
					<td align="center">${item.price}원</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>