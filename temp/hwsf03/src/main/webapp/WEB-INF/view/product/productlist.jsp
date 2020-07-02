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
	<jsp:include page="../header.jsp"></jsp:include>
	<h1>상품 목록</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가격</th>
			<th>상품설명</th>
		</tr>
		
		<c:forEach items="${products }" var="product">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.description }</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="../regist">새 상품 등록</a>
</body>
<script>
	<c:if test="${not empty message }">
		alert("${message }");
	</c:if>
</script>
</html>