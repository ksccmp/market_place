<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#productTable {
		text-align: center;
	}
	
	#firstTd {
		padding: 5px 10px;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<input type="button" value="물품 등록" id="registerProduct">
	
	<br>
	
	<c:choose>
		<c:when test="${empty productList}">
			<h1>판매중인 상품이 없습니다.</h1>
		</c:when>
		
		<c:otherwise>
			<table border="1" id="productTable">
			<tr>
				<td id="firstTd">등록자</td>
				<td>제품이름</td>
				<td>제품설명</td>
				<td>가격</td>
				<td>남은 갯수</td>
				<td>등록날짜</td>
				<td>기타</td>
			</tr>
			
			<c:forEach items="${productList }" var="product">
				<tr>
					<td id="firstTd">${product.userid }</td>
					<td>${product.name }</td>
					<td>${product.description }</td>
					<td>${product.price }</td>
					<td>${product.count }</td>
					<td>${product.regdate }</td>
					<td><input type="button" value="구매" class="sales"></td>
				</tr>
			</c:forEach>
		</table>
		</c:otherwise>
	</c:choose>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$("#registerProduct").on("click", function() {
		window.location.href="/market-place/registerProduct"
	})
	
	$(".sales").on("click", function() {
		console.log($(this).siblings("#firstTd").val());
	})
</script>
</html>