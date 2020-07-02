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
	<jsp:include page="/header.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach items="${phones }" var="phone">
			<tr>
				<td><a href="view.do?num=${phone.num }">${phone.num }</a></td>
				<td>${phone.model }</td>
				<td>${phone.price }</td>
				<td>${phone.comp.vendor }</td>
				<td><input type="checkbox" num="${phone.num }"></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="regPhone.do">추가 등록</a>
	<a href="delPhone.do" id="del">선택항목 삭제</a>
</body>
<script>
	// 링크는 클릭하면 타고 가려는 동작이 기본
	$("#del").on("click", function(e) {
		e.preventDefault(); // 링크 이동 막기
		let url = "delPhone.do?";
		$(":checkbox:checked").each(function(idx, item) {
			url = url + "num=" + $(item).attr("num") + "&";
		});
		console.log(url);
		location.href=url;
	});
</script>
</html>