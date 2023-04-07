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
<link rel="stylesheet" href="css/orderDetail.css">

</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			
			<h1 class="title">주문 상세 페이지</h1>
			<ul class="user_list">
				<li>주문번호 : ${OD_list[0].oseq }</li>
				
				<!-- 추후 구현  -->
				<li>회원 아이디 : ?</li>
				<li>날짜 : ??</li>
			</ul>
			<table class="detail_table">
				<tr>
					<td>제품 번호</td>
					<td>제품 이름</td>
					<td>제품 수량</td>
					<td>재고</td>
					<td>상태</td>
					<td>출고</td>
				</tr>
				
				<c:forEach var="od" items="${OD_list}">
					<tr>
						<td>${od.pseq }</td>
						<td>${od.p_name }</td>
						<td>${od.quantity }</td>
						<td>${od.p_useyn }</td>
						<td>${od.result }</td>
						<td><button onClick="location.href='BBreadServlet?command=order_detail_check&oseq=${od.oseq}&odseq=${od.odseq}'">완료</button></td>
					</tr>
				</c:forEach>
	
			</table>
			
			<div class="order-btn-wrap">
				<button class="order-btn" onClick="location.href='BBreadServlet?command=order_check&oseq=${OD_list[0].oseq }'">주문완료</button>
			</div>
			
			
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>