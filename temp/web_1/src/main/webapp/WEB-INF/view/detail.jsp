<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<body>
	<h1>회원수정</h1>
	<c:url value="/modfiy" var="modify"></c:url>
	<c:url value="/delete" var="delete"></c:url>
	<form method="post" id="myform">
		<input type="text" name="userid" readonly="readonly" value="${user.userid}"> <br>
		<input type="text" name="name" placeholder="name" value="${user.name }"> <br>
		<input type="password" name="pass" placeholder="password" value="${user.pass }"> <br>
		<input type="number" name="balance" placeholder="balance" value="${user.balance }"> <br>
	</form>
	<input type="submit" value="수정" id="bModify">
	<input type="submit" value="삭제" id="bDelete">
</body>
<script>
	let modifyUrl = "${modify}";
	let deleteUrl = "${delete}";
	
	$("#bModify").on("click", function() {
		$("#myform").attr("action", modifyUrl);
		$("#myform").submit();
	});
	
	$("#bDelete").on("click", function() {
		$("#myform").attr("action", deleteUrl);
		$("#myform").submit();
	});
</script>
</html>