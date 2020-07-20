<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#myProductTable {
		text-align: center;
		margin-left: auto;
		margin-right: auto;
	}
	
	#firstTd {
		padding: 5px 10px;
	}
	
	#myProductBody {
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
	<div id="myProductBody">
		<c:choose>
			<c:when test="${empty myProducts }">
				<h1>${user.userid }님은 구매내역이 없습니다.</h1>
			</c:when>
			
			<c:otherwise>
				<h1>${user.userid }님의 구매내역</h1>
				<table border="1" id="myProductTable">
					<tr>
						<td id="#firstTd">이미지</td>
						<td>이름</td>
						<td>세부 설명</td>
						<td>가격</td>
						<td>구매 갯수</td>
						<td>구매 날짜</td>
					</tr>
					
					<c:forEach items="${myProducts }" var="myProduct">
						<tr>
							<td>${myProduct.image }</td>
							<td>${myProduct.name }</td>
							<td>${myProduct.description }</td>
							<td>${myProduct.price }</td>
							<td>${myProduct.count }</td>
							<td>${myProduct.regdate }</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		
		<input type="button" value="뒤로 가기" id="back">
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$("#back").on("click", function() {
		history.go(-1);
	})
</script>
</html>