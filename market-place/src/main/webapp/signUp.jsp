<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#signUpBody {
		margin: auto;
		text-align: center;
	}
	
	#signUpTable {
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body>
	<div id="signUpBody">
		<form action="signUp.do" method="post">
			<table id="signUpTable">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid"></td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone"></td>
				</tr>
			</table>
			
			<br>
			
			<input type="button" value="뒤로 가기" id="back">
			<input type="submit" value="회원가입">
		</form>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$("#back").on("click", function() {
		history.go(-1);
	})
</script>
</html>