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
	
	<form action="registerProduct.do" method="post">
		<table>
			<tr>
				<td>물품 이미지</td>
				<td><input type="text" name="image" required="required" value="default"></td>
			</tr>
			
			<tr>
				<td>물품 이름</td>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			
			<tr>
				<td>물품 세부정보</td>
				<td><input type="text" name="description" required="required"></td>
			</tr>
			
			<tr>
				<td>물품 가격</td>
				<td><input type="number" name="price" required="required"></td>
			</tr>
			
			<tr>
				<td>물품 갯수</td>
				<td><input type="number" name="count" required="required"></td>
			</tr>
		</table>
		
		<br>
		
		<input type="button" value="뒤로 가기" id="back">
		<input type="submit" value="물품 등록">
	</form>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	<c:if test="${empty sessionScope.user }">
		alert("로그인을 해주세요.");
		history.go(-1);
	</c:if>
	
	$("#back").on("click", function() {
		history.go(-1);
	})
</script>
</html>