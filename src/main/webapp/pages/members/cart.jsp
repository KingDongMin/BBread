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
<link rel="stylesheet" href="css/cart.css">

<script type="text/javascript" src="js/main.js" defer></script>
<script type="text/javascript" src="js/cart.js" defer></script>

</head>
<body>
<c:set var="all_price" value="${0}"></c:set>
<c:set var="del_fee" value="${3000 }"></c:set>

	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<h1>장바구니</h1>
			<ul class="cart_list">
			<c:choose>
				<c:when test="${carts != null }">
					<c:forEach var="item" items="${carts}">
						<c:set var="all_price" value="${all_price+item.p_price }"></c:set>
						<li class="cart_item" value="${item.cseq }">
							<div class="img_box">
								<img alt="item_image" src="upload/${item.p_url}">
							</div>
							
							<div class="product">
								<p>${item.p_name}</p>
								<p>￦ ${item.p_price}</p>
							</div>
						
							<div class="quantity_btn">
								<button value="minus">-</button>
								<p>${item.quantity}</p>
								<button value="plus">+</button>
							</div>
							
							<button class="delete_btn" value="delete">삭 제</button>
						</li>
					</c:forEach>
				</c:when>
				
				<c:otherwise>
					<li id="cart_item_none">${null_carts}</li>
				</c:otherwise>
			</c:choose>
			</ul>
			
			<c:if test="${carts.isEmpty() != null}">
				<div class="price_wrap">
					<ul>
						<li>
						<p>모든 제품가격</p>
						<p>￦ ${all_price}</p>
						</li>
						<li>+</li>
						<li>
						<p>배송비</p>
						<p>￦ ${del_fee}</p>
						</li>
						<li>=</li>
						<li>
						<p>총 합계</p>
						<p>￦ ${all_price+del_fee}</p>
						</li>
					</ul>
				</div>
			</c:if>
			
			<div class="message_box">${message}</div>
			
			<form action="BBreadServlet" method="post" class="form_box">
				<input type="hidden" name="command" value="cart_order">
				<input type="hidden" name="mid" value="">
				<c:if test="${carts.isEmpty() != null}">
					<input class="submit_btn" type="submit" value="주문 하기">
				</c:if>
			</form>
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>
</body>
</html>