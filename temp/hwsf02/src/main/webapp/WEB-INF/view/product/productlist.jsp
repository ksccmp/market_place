<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<h1>상품 목록</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가격</th>
			<th>상품설명</th>
		</tr>
		
		<tr>
			<td>radio</td>
			<td>레디오</td>
			<td>500</td>
			<td>잘들린다</td>
		</tr>
		
		<tr>
			<td>tv</td>
			<td>테레비</td>
			<td>1000</td>
			<td>잘나온다</td>
		</tr>
	</table>
	
	<a href="../regist">새 상품 등록</a>
</body>
</html>