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
	<h1>도서관리 사이트에 오신것을 환영합니다.</h1>
	<c:if test="${not empty loginUser }">
		<div id="userinfo">${loginUser }님 반갑습니다.</div>
	</c:if>
	<hr>
</body>
</html>