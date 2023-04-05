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

<!-- index는 메인 페이지를 의미? 메인 페이지가 전체 페이지의 틀이 된다?  -->
</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<div class="detail_wrap">
				<h1>담긴 제품</h1>
				<ul class="carts">
				<c:choose>
					<c:when test="${carts != null }">
						<c:forEach var="item" items="${carts}">
							<li class="cart">
								<div class="img_box">
									<img alt="item_image" src="upload/${item.p_url}">
								</div>
								
								<div class="product">
									<p>${item.p_name}</p>
									<p>￦ ${item.p_price}</p>
								</div>
								
								<div class="quantity_btn">
									<button>-</button>
									<p>${item.quantity}</p>
									<button>+</button>
								</div>
								
								<button class="delete_btn">삭제</button>
							</li>
						</c:forEach>
					</c:when>
					
					<c:otherwise>
						<li>여기</li>
						<li>${null_carts}</li>
					</c:otherwise>
				</c:choose>
				</ul>
				
				<div class="message_box">${message}</div>
				
				<div class="form_box">
					<form action="BBreadServlet" method="post">
						<input type="hidden" name="command" value="cart_order">
						<input type="hidden" name="mid" value="">
						<input class="submit_btn" type="submit" value="주문 하기">
					</form>
				</div>
			</div>	
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>
</body>
</html>