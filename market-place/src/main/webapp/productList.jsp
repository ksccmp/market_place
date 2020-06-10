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
	<jsp:include page="header.jsp"></jsp:include>
	
	<form action="registerProduct" method="get">
		<input type="submit" value="물품 등록">
	</form>
	
	<br>
	
	<c:choose>
		<c:when test="${empty productList}">
			<h1>판매중인 상품이 없습니다.</h1>
		</c:when>
		
		<c:otherwise>
			<table border="1">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>설명</td>
				<td>판매여부</td>
				<td>등록날짜</td>
			</tr>
			
			<c:forEach items="${productList }" var="product">
				<tr>
					<td>${product.userid }</td>
					<td>${product.name }</td>
					<td>${product.description }</td>
					<td>${product.sales }</td>
					<td>${product.regdate }</td>
				</tr>
			</c:forEach>
		</table>
		</c:otherwise>
	</c:choose>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>