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
<link rel="stylesheet" href="css/message.css">
<link rel="stylesheet" href="css/product/detail.css">
<script type="text/javascript" src="js/main.js" defer></script>
<script type="text/javascript" src="js/product.js" defer></script>
<script type="text/javascript" src="js/message.js" defer></script>

</head>
<body onload="popupMessage('${message}')">
	<c:import url="../../message.jsp" />

	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
				
			<div class="img_wrap">
				<img alt="${product.name}_img" src="upload/${product.image}">
			</div>
			
			<div class="content_wrap">
				<div >
					<h2>${product.name}</h2>
					<p>${product.content }</p>
					<p>￦ ${product.price}</p>
				</div>
				
				<form action="BBreadServlet" method="post">
					<input type="hidden" name="command" value="add_cart">
					<input type="hidden" name="pseq" value="${product.pseq}">
					
					<div id="quantity_box" >
						<button id="minus" value="minus" type="button">-</button>
						<input  class="data" id="quantity" type="number" name="quantity" value="1">
						<button id="plus" value="plus" type="button"  >+</button>
					</div>
					<c:if test="${Avo == null}">
					<input type="submit" value="장바구니에 담기" onClick="return checkNull()">
					</c:if>
				</form>
				
				
				<c:if test="${Avo != null}">
				<div class="btn_wrap">
					<button onClick="return createMessage(${product.pseq})">제품 삭제</button>
					<button onClick="return updateProduct(${product.pseq})">제품 수정</button>
				</div>
				</c:if>
			</div>

		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>
</body>
</html>