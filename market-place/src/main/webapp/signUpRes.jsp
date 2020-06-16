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
	
</body>
<script>
	<c:if test="${signUpRes eq 1}">
		alert("회원가입에 성공했습니다.");
	</c:if>
	
	<c:if test="${signUpRes ne 1}">
		alert("회원가입에 실패했습니다.");
	</c:if>
	
	window.location.href = "/market-place/productList";
</script>
</html>