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
	<h1>도서등록</h1>
	<form method="post" action="regist">
		<input type="text" name="isbn" placeholder="isbn">
		<input type="text" name="title" placeholder="title">
		<input type="text" name="author" placeholder="author">
		<input type="text" name="publisher" placeholder="publisher">
		<input type="number" name="price" placeholder="price">
		<input type="text" name="description" placeholder="description">
		<input type="submit" value="등록">
	</form>
</body>
</html>