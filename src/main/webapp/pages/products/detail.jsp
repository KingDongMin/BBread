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
<link rel="stylesheet" href="css/detail.css">
<script type="text/javascript" src="js/main.js" defer></script>

</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<div class="detail_wrap">
				
				<div class="img-box">
					<img alt="${product.name}_img" src="upload/${product.image}">
				</div>
				
				<div class="content">
					<div>
					<h2>${product.name}</h2>
					<h3>${product.kind}</h3>
					<p>${product.content }</p>
					<p>￦ ${product.price}</p>
					</div>
					<form action="BBreadServlet" method="post">
						<input type="hidden" name="command" value="add_cart">
						<input type="hidden" name="pseq" value="${product.pseq}">
						<div id="quantity_box" onClick="test()" >
							<button id="minus" value="minus" type="button">-</button>
							<input id="quantity" type="number" name="quantity" value="1">
							<button id="plus" value="plus" type="button" >+</button>
						</div>
						<input type="submit" value="장바구니에 담기">
						
					</form>
					
					<c:if test="${message != null }">
						<div id="message_box">${message }</div>
					</c:if>
					
					<c:if test="${Avo != null}">
						<button onClick="return window.location.href='http://localhost:8181/BBread/BBreadServlet?command=product_delete&pseq=${product.pseq}'">제품 삭제</button>
						<button onClick="return window.location.href='http://localhost:8181/BBread/BBreadServlet?command=product_update_page&pseq=${product.pseq}'">제품 수정</button>
					</c:if>
				</div>
			</div>

		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

	<script type="text/javascript" defer>
	
		//제품 수량 증감
		const quantityBox = document.getElementById("quantity_box");
		const quantity = document.getElementById("quantity");
		quantityBox.onclick = (e)=>{
			const value = e.target.value;
			
			if(value != "plus" && value != "minus" ) return;
			
			if(value == "plus"){
				quantity.value = Number(quantity.value)+ 1;
			}else if(value=="minus" && Number(quantity.value) > 1 ){
				quantity.value = Number(quantity.value) - 1;
			}
		}
	
	</script>
</body>
</html>