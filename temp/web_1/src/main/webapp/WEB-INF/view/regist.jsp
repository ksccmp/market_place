<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<c:url value="regist" var="regist"></c:url>
	<form method="post" action="${regist }">
		<input type="text" name="userid" placeholder="userid"> <br>
		<input type="text" name="name" placeholder="name"> <br>
		<input type="password" name="pass" placeholder="password"> <br>
		<input type="number" name="balance" placeholder="balance"> <br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>