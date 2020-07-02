<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<h1>로그인페이지</h1>
	<img src="img/myimg.jpg">
	${message }
	<form method="post" action="login">
		<input type="text" name="userid">
		<input type="password" name="pass">
		<input type="submit" value="로그인">
	</form>
</body>
</html>