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
				<td><input type="text" name="image"></td>
			</tr>
			
			<tr>
				<td>물품 이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>물품 세부정보</td>
				<td><input type="text" name="description"></td>
			</tr>
			
			<tr>
				<td>물품 가격</td>
				<td><input type="number" name="price"></td>
			</tr>
			
			<tr>
				<td>물품 갯수</td>
				<td><input type="number" name="count3"></td>
			</tr>
		</table>
		
		<br>
		
		<input type="submit" value="물품 등록">
	</form>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>