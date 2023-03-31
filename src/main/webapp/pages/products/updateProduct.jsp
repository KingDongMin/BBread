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
<link rel="stylesheet" href="css/login.css">
<script type="text/javascript" src="js/main.js"></script>

</head>
<body>
	<div id="wrap">
		<section>
			<div id="logo">
				<a> <img alt="Brand_logo" src="imgs/logo/BBread_Logo.png">
				</a>
			</div>
		
			<h1>Update Product</h1>
			
			<form action="BBreadServlet?command=update_product" method="post" id="frm" enctype="multipart/form-data">
				<input type="hidden" name="origin_imageURL" value="${product.image}">
				<input type="hidden" name="pseq" value="${product.pseq}">
				<ul>
					<li>
					<label for="name">제품 이름</label>
					<input type="text" name="name" value="${product.name}">
					</li>

					<li>
					<label for="kind">제품 분류</label>
					<input type="text" name="kind" value="${product.kind}" >
					</li>
					
					<li>
					<label for="price">제품 가격</label>
					<input type="text" name="price" value="${product.price}">
					</li>
					
					<li>
					<label for="content">제품 내용</label>
					<textarea rows="20" cols="50" name="content" >${product.content}</textarea>
					</li>
					
					<li>
					<label for="image">제품 이미지</label>
					<input type="file" name="imageURL">
					</li>
					
				</ul>
				<div id="login_footer">
					<a href="BBreadServlet">메인화면</a>
					<input class="input_button" type="submit" value="제품 수정">
				</div>

			</form>

		</section>
	</div>
</body>
</html>