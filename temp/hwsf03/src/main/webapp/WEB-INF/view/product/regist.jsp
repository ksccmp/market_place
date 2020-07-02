<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<h1>상품 등록</h1>
	<form method="post" action="product/regist">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
				<td>상품명</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>가격</td>
				<td><input type="text" name="price"></td>
				<td>성명</td>
				<td><input type="text" name="description"></td>
			</tr>
		</table>
		<input type="submit" value="등록">
	</form>
</body>
</html>