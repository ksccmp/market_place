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
	<form action="signUp.do" method="post">
		<table>
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
		
		<input type="submit" value="회원가입">
	</form>
</body>
</html>