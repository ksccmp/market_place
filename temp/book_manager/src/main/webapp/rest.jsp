<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To SSAFY</h1>
	<hr>
	
	<h2>도서 관리</h2>
	<input type="button" id="listbtn" value="목록조회"> (상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세요.)
	<ul id="list">
	</ul>
	<br>
	<input type="button" id="insertbtn" value="추가">
	<input type="button" id="updatebtn" value="수정">
	<input type="button" id="deletebtn" value="삭제">
	
	<table border="1">
		<tr>
			<td>ISBN</td>
			<td><input type="text" id="isbn">
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" id="title">
		</tr>
		
		<tr>
			<td>출판사</td>
			<td><input type="text" id="publisher">
		</tr>
		
		<tr>
			<td>가격</td>
			<td><input type="text" id="price">
		</tr>
		
		<tr>
			<td>저자번호</td>
			<td><input type="text" id="authorno">
		</tr>
	</table>
	<textarea rows="10dp" cols="50dp" id="description">
	</textarea>
	<br>
	<div id="result"></div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function list(result) {
		$.ajax({
			url: "/rest/book",
			type: "get",
			success: function(resTxt) {
				console.log(resTxt);
				if(resTxt.status) {
					$("#list").empty();
					let data = resTxt.data;
					$(data).each(function(idx, item) {
						$("#list").append("<li class='isbn'>"+item.isbn);
					});
					$("#result").text(result);
				} else {
					$("#result").text("조회 오류");
				}
			},
			error: function(xhr) {
				$("#result").text("조회 오류");
				console.log(xhr);
			}
		});
	}
	
	$("#list").on("click", ".isbn", function() {
		console.log($(this).text());
		$.ajax({
			url: "/rest/book/" + $(this).text(),
			type: "get",
			success: function(resTxt) {
				console.log(resTxt);
				if(resTxt.status) {
					let data = resTxt.data;
					$("#isbn").val(data.isbn);
					$("#title").val(data.title);
					$("#publisher").val(data.publisher);
					$("#price").val(data.price);
					$("#authorno").val(data.authorno);
					$("#description").text(data.description);
				} else {
					$("#result").text("조회 오류");
				}
			},
			error: function(xhr) {
				$("#result").text("조회 오류");
				console.log(xhr);
			}
		});
	});
	
	$("#listbtn").on("click", function() {
		list("전체 조회 성공");
	});
	
	$("#insertbtn").on("click", function() {
		let data = {
				  authorno: $("#authorno").val(),
				  description: $("#description").text(),
				  isbn: $("#isbn").val(),
				  price: $("#price").val(),
				  publisher: $("#publisher").val(),
				  title: $("#title").val()
				};
		
		$.ajax({
			url: "/rest/book",
			type: "post",
			data: JSON.stringify(data),
			contentType: "application/json",
			success: function(resTxt) {
				console.log(resTxt);
				if(resTxt.status) {
					list("추가 성공");
				} else {
					list("추가 실패");
				}
			},
			error: function(xhr) {
				list("추가 실패");
				console.log(xhr);
			}
		});
	});
	
	$("#updatebtn").on("click", function() {
		let data = {
				  authorno: $("#authorno").val(),
				  description: $("#description").text(),
				  isbn: $("#isbn").val(),
				  price: $("#price").val(),
				  publisher: $("#publisher").val(),
				  title: $("#title").val()
				};
		
		$.ajax({
			url: "/rest/book",
			type: "put",
			data: JSON.stringify(data),
			contentType: "application/json",
			success: function(resTxt) {
				console.log(resTxt);
				if(resTxt.status) {
					list("수정 성공");
				} else {
					list("수정 실패");
				}
			},
			error: function(xhr) {
				list("수정 실패");
				console.log(xhr);
			}
		});
	});
		
	$("#deletebtn").on("click", function() {
		$.ajax({
			url: "/rest/book/"+$("#isbn").val(),
			type: "delete",
			success: function(resTxt) {
				console.log(resTxt);
				if(resTxt.status) {
					list("삭제 성공");
				} else {
					list("삭제 실패");
				}
			},
			error: function(xhr) {
				list("삭제 실패");
				console.log(xhr);
			}
		});
	});
</script>
</html>