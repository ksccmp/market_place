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
</body>
<script>
	<c:if test="${empty sessionScope.user }">
		alert("로그인에 실패했습니다.");
	</c:if>
	
	<c:if test="${not empty sessionScope.user }">
		alert("로그인에 성공했습니다.");
	</c:if>
	
	window.location.href = "/market-place/productList";
</script>
</html>