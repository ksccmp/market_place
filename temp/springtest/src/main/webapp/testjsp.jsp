<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" id="btnAll" value="전체검색"> <br>
	<ol id="linked">
	</ol>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td><input type="text" name="num" id="num"></td>
		</tr>
		
		<tr>
			<td>모델</td>
			<td><input type="text" name="model" id="model"></td>
		</tr>
		
		<tr>
			<td>가격</td>
			<td><input type="number" name="price" id="price"></td>
		</tr>
		
		<tr>
			<td>코드</td>
			<td><input type="text" name="vcode" id="vcode"></td>
		</tr>
	</table>
	
	<input type="button" id="btninsert" value="등록"> <br>
	<input type="button" id="btnupdate" value="수정"> <br>
	<input type="button" id="btndelete" value="삭제"> <br>
	
	<input type="text" name="num" id="searchnum"> <input type="button" id="btnsearch" value="검색"> <br>
	
	<div id="result"></div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function list() {
		$.ajax({
			url: "selectAll",
			type: "get",
			success: function(resData) {
				console.log(resData);
				if(resData.status) {
					let myData = resData.data;
					$("#linked").empty();
					
					$.each(myData, function(idx, item) {
						$("#linked").append("<li>"+item.num+"</li>");
					});
				}
			},
			error: function(xhr) {
				$("#result").text("검색에러");
				console.log(xhr);
			}
		});
	}
	
	$("#btnAll").on("click", function() {
		list();
	});
</script>
</html>