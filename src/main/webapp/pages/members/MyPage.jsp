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
<link rel="stylesheet" href="css/mypage.css">

</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
		<div id="edit-wrap">
			<!-- 회원정보 -->
			<article>
			<h1>회원정보</h1>
			<ul class="member-info">
				<li>
					<span >아이디 :</span>
					<span class="item">${Mvo.id}</span>
				</li>
				<li>
					<span>이름 :</span>
					<span class="item">${Mvo.name }</span>
				</li>
				<li>
					<span >주소 :</span>
					<span class="item">${Mvo.address}</span>
				</li>
				<li>
					<span >전화번호 :</span>
					<span class="item">${Mvo.phone }</span>
				</li>
				<li class="edit-btn">
					<a href="BBreadServlet?command=member_update_page">회원정보 수정</a>
				</li>
			</ul>
			</article>
			
			<!-- 주문현황 -->
			<article>
			<h1>주문 현황</h1>
			<ul class="order-list">
				<c:forEach var="order" items="${order_list }">
					<li class="order-item">
						<div class="img-box">
							<img alt="orderItem-image" src="upload/${order.p_url }">
						</div>
						<span>${order.p_name}</span>
						<span>${order.p_price}</span>
						<span>${order.quantity }</span>
						<span>${order.result }</span>
					</li>
				
				</c:forEach>
			</ul>
			</article>
			
			<article>
			<h1>나의 Q&A</h1>
			<table class="QnA-table">
				<colgroup>
					<col width="15%">
					<col width="40%">
					<col width="30%">
					<col width="25%">
				</colgroup>
			
				<tr>
					<td>글 번호</td>
					<td>제 목</td>
					<td>날 짜</td>
					<td>상 태</td>
				</tr>
				
				<c:choose>
				<c:when test="${QnA_list != null }">
					<c:forEach var="item" items="${QnA_list }">
						<tr onClick="location.href='BBreadServlet?command=QnA_detail_page&qseq=${item.qseq}'">
							<td>${item.qseq}</td>
							<td>${item.title }</td>
							<td>
								<fmt:formatDate var="indateFormat" pattern="yy년 MM월 dd일" value="${item.indate}"/>
								<c:out value="${indateFormat }"/>
							</td>
							<c:choose>
								<c:when test="${item.result != n}">
									<td>답변 대기</td>
								</c:when>
								<c:otherwise>
									<td>답변 완료</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">
							나의 Q&A가 없습니다.
						</td>
					</tr>
				
				</c:otherwise>
				
				</c:choose>		
			
			
			</table>
			
			
			</article>
			
		</div>
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>