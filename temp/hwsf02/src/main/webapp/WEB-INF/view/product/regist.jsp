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
		아이디 <input type="text" name="id"> <br>
		상품명 <input type="text" name="name"> <br>
		가격 <input type="text" name="price"> <br>
		성명 <input type="text" name="description"> <br>
		<input type="submit" value="등록">
	</form>
</body>
</html>