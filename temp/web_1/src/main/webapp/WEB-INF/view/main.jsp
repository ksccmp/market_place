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
	<h1>여기는 main입니다</h1>
	<c:if test="${not empty loginUser }">
		${loginUser }님 반갑습니다.
	</c:if>
	
	<c:url value="login" var="login"></c:url>
	<c:if test="${empty loginUser }">
		<a href="${login }">로그인 후 이용해주세요.</a>
	</c:if>
	
	<c:url value="list" var="list"></c:url>
	<ul>
		<li><a href="${list }">회원목록</a>
	</ul>
</body>
<script>
	<c:if test="${not empty message }">
		alert("${message }");
	</c:if>
</script>
</html>