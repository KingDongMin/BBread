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
<script type="text/javascript" src="js/main.js" defer></script>
<script type="text/javascript" src="js/message.js" defer></script>

</head>
<body onload="popupMessage('${message}')">
	<c:import url="message.jsp" />
	
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<ul class="product_list">
				<c:forEach var="product" items="${ProductList}">
					<li class="product_card" onClick="return window.location.href='http://localhost:8181/BBread/BBreadServlet?command=product_detail&pseq=${product.pseq}'">
						<div>
							<img alt="${product.image}" src="upload/${product.image}">
							<p class="title">${product.name}</p>
							<p class="price">￦ ${product.price}</p>
						</div>
					</li>
					
				</c:forEach>
			</ul>
		</section>

		<!-- Footer Section  -->
		<c:import url="footer.jsp" />
	</div>
</body>
</html>