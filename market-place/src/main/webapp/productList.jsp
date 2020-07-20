<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#productTable {
		text-align: center;
		margin-left: auto;
		margin-right: auto;
	}
	
	#firstTd {
		padding: 5px 10px;
	}
	
	#productBody {
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div id="productBody">
		<input type="button" value="물품 등록" id="registerProduct">
		<c:if test="${not empty user }">
			<input type="button" value="구매 내역" id="myProduct">
		</c:if>
		
		<br>
		
		<c:choose>
			<c:when test="${empty user }">
				<h1>로그인을 해주세요.</h1>
			</c:when>
		
			<c:when test="${empty productList}">
				<h1>판매중인 상품이 없습니다.</h1>
			</c:when>
			
			<c:otherwise>
				<table border="1" id="productTable">
				<tr>
					<td id="firstTd">등록자</td>
					<td>제품이름</td>
					<td>제품설명</td>
					<td>가격</td>
					<td>남은 갯수</td>
					<td>등록날짜</td>
					<td>구매 갯수</td>
					<td>기타</td>
				</tr>
				
				<c:forEach items="${productList }" var="product">
					<tr>
						<td id="userid" productId="${product.id }">${product.userid }</td>
						<td>${product.name }</td>
						<td>${product.description }</td>
						<td>${product.price }원</td>
						<td>${product.count }개</td>
						<td>${product.regdate }</td>
						<c:choose>
							<c:when test="${user.userid eq product.userid }">
								<td>-</td>
								<td><input type="button" value="삭제" class="delete"></td>
							</c:when>
							
							<c:otherwise>
								<td id="purchase"><input type="number" id="count" min="1" value="1"></td>
								<td><input type="button" value="구매" class="sales"></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
			</c:otherwise>
		</c:choose>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$("#registerProduct").on("click", function() {
		window.location.href="/market-place/registerProduct"
	})
	
	$(".delete").on("click", function() {
		let productId = $(this).parent().siblings("#userid").attr("productId");
		
		$.ajax({
			url: "http://localhost:8080/market-place//deleteProduct/" + productId,
			type: "delete",
			success: function(res) {
				let result = res.data;
				if(result == 1) {
					alert("삭제 성공했습니다.");
					window.location.href = "/market-place/productList";
				} else {
					alert("삭제 실패했습니다.");
				}
			},
			error: function(error) {
				alert("에러가 발생했습니다.\n", error);
			}
		});
	})
	
	$(".sales").on("click", function() {
		let productId = $(this).parent().siblings("#userid").attr("productId");
		let count = $(this).parent().siblings("#purchase").children("#count").val();
		
		$.ajax({
			url: "http://localhost:8080/market-place/purchaseProduct/" + productId + "/" + count,
			type: "put",
			success: function(res) {
				let result = res.data;
				let resultStatus = res.status;
				
				if(resultStatus == false) {
					alert("구매 갯수가 초과되었습니다. 남은 갯수는 " + result +"개 입니다.");
				} else {
					if(result == 1) {
						alert("구매 성공했습니다.");
						window.location.href = "/market-place/productList";
					} else {
						alert("구매 실패했습니다.")
					}
				}
			},
			error: function(error) {
				alert("에러가 발생했습니다.\n", error);
			}
		})
	})
	
	$("#myProduct").on("click", function() {
		window.location.href = "/market-place/myProduct"
	})
</script>
</html>