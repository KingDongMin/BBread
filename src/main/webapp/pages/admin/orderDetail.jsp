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
<link rel="stylesheet" href="css/orders.css">

</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			
			<h1 class="title">주문 상세 페이지</h1>
			<ul class="info_list">
				<li>
					<p>주문번호</p>
					<p>${OD_list[0].oseq }</p>
				</li>
				
				<li>
					<p>회원 아이디</p>
					<p>${mid}</p>
				</li>
				
				<li>
					<p>날짜</p>
					<p>${indate}</p>
				</li>
			</ul>
			
			<div class="table_wrap">
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
							<c:choose>
								<c:when test="${Character.toString(od.p_useyn).matches('[y]')}">
									<td class="wait">품절</td>
								</c:when>
								<c:otherwise>
									<td class="finish">여유</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${Character.toString(od.result).matches('[n]')}">
									<td class="wait">대기</td>
								</c:when>
								<c:otherwise>
									<td class="finish">완료</td>
								</c:otherwise>
							</c:choose>
							<td><button class="btn" onClick="location.href='BBreadServlet?command=order_detail_check&oseq=${od.oseq}&odseq=${od.odseq}'">완료</button></td>
						</tr>
					</c:forEach>
		
				</table>
			</div>
			
			<div class="btn_wrap">
				<button onClick="location.href='BBreadServlet?command=orders_page'">주문현황</button>
				<button onClick="location.href='BBreadServlet?command=order_check&oseq=${OD_list[0].oseq }'">주문완료</button>
			</div>
			
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>