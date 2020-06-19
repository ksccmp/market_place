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
	<c:choose>
		<c:when test="${result eq 1 }">
			alert("${successMessage }")
			window.location.href = "${nextUrl }"
		</c:when>
		
		<c:otherwise>
			alert("${failMessage }")
		</c:otherwise>
	</c:choose>
</script>
</html>