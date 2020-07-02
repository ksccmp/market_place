<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<body>
	<h1>모든 사용자 페이지</h1>

	${message }
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>밸런스</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td><input type="checkbox" name="checkbox" data="${user.userid }"></td>
				<td><a href="detail?userid=${user.userid }">${user.userid }</a></td>
				<td>${user.name }</td>
				<td>${user.pass }</td>
				<td>${user.balance }</td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="button" value="멀티삭제" id="multiDelete">
</body>
<script>
	$("#multiDelete").on("click", function() {
		// 화면에서 선택된 체크박스를 가져와보자.
		let $selected = $(":checked")
		let target = "?";
		$.each($selected, function(idx, item) {
			console.log(idx, item, $(item).attr("data"));
			target = target + "target=" + $(item).attr("data")+"&";
		})
		location.href = "multiDelete"+target;
	});
</script>
</html>