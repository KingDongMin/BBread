<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBread</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/product.css">
<script type="text/javascript" src="js/main.js" defer></script>
<script type="text/javascript" src="js/product.js" defer></script>
<script type="text/javascript" src="js/message.js" defer></script>

</head>
<body onload="setOption('${product.kind}')">
	<div id="wrap">
		<section>
			<div id="logo">
				<a> <img alt="Brand_logo" src="imgs/logo/BBread_Logo.png">
				</a>
			</div>

			<h1>Update Product</h1>

			<form action="BBreadServlet?command=update_product" method="post"
				id="frm" enctype="multipart/form-data">
				<input type="hidden" name="origin_imageURL" value="${product.image}">
				<input type="hidden" name="pseq" value="${product.pseq}">

				<div class="table_wrap" >
				<table>
					<tr>
						<td>제품 이름</td>
						<td>
							<input type="text" name="name" class="name data" value="${product.name}">
						</td>
					</tr>

					<tr>
						<td>제품 분류</td>
						<td>
						<select name="kind" class="kind data" >
								<option value="">선택</option>
								<option value="바게트">바게트</option>
								<option value="치아바타">치아바타</option>
								<option value="포카치아">포카치아</option>
								<option value="효모">효모</option>
								<option value="브리오슈">브리오슈</option>
						</select>
						</td>
					</tr>
					<tr>
						<td >제품 가격</td>
						<td>
							<input type="number" name="price" class="price data" value="${product.price}">
						</td>
					</tr>

					<tr>
						<td>제품 이미지</td>
						<td>
							<input type="file" name="imageURL" class="img">
						</td>
					</tr>


					<tr>
						<td>제품 내용</td>
						<td>
							<textarea rows="10" cols="50" name="content"class="content data">${product.content}</textarea>
						</td>
					</tr>
				</table>
				</div>
				
				<button class="submit_btn" type="submit" onClick="return checkNull()">수정하기</button>

			</form>

		</section>
	</div>
</body>
</html>