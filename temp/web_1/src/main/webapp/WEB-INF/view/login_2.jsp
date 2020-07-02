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
	${error }
	<form method="post" action="login">
		ID <input type="text" name="id" id="id" value=${myid }>
		PASSWORD <input type="password" name="password" id="password">
		<input type="submit" value="로그인">
	</form>
	
	<h2>DTO기반 전달</h2>
	<form method="post" action="loginByDto">
		ID <input type="text" name="id" id="id" value=${myid }>
		PASSWORD <input type="password" name="pass" id="pass">
		<input type="submit" value="로그인">
	</form>
	
	<h1>REST방식의 API 처리</h1>
	<a href="user/hong">홍길동 조회</a>
</body>
</html>