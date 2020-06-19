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

	<c:choose>
		<c:when test="${empty sessionScope.user }">
			<form action="login.do" method="post">
				<span>ID</span>
				<span><input type="text" name="userid"></span>
				<span>Password</span>
				<span><input type="password" name="password"></span>
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" id="signup">
			</form>
		</c:when>
		
		<c:otherwise>
			<form action="logout.do" method="post">
				<span>안녕하세요. ${user.userid }님</span>
				<input type="submit" value="로그아웃">
			</form>
		</c:otherwise>
	</c:choose>
	
	<br><br>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$("#signup").on("click", function() {
		window.location.href = "/market-place/signUp";
	})
</script>
</html>