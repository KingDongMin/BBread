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

			<%-- 회원정보 start --%>
			<article class="my_info">
				<ul >
					<li><span>ID</span> <span class="item">${Mvo.id}</span></li>
					<li><span>Name</span> <span class="item">${Mvo.name }</span></li>
					<li class="edit-btn">
						<a href="BBreadServlet?command=member_update_page">회원정보 수정</a>
					</li>
				</ul>
			</article>
			<%-- 회원정보 end --%>

			<%--주문현황 start --%>
			<article class="my_order">
				<h1>주문 현황</h1>
				<ul class="order_list">
					<c:choose>
						<c:when test="${order_list != null}">
							<c:forEach var="order" items="${order_list }">
								<li class="order_item">
									<div class="img_box">
										<img alt="orderItem-image" src="upload/${order.p_url }">
									</div> 
									<span>${order.p_name}</span>
									<span>￦ ${order.p_price}</span>
									<span>${order.quantity }개</span>
									<c:choose>
										<c:when test="${Character.toString(order.result).matches('[n]') }">
											<span class="wait">출고 대기</span>
										</c:when>
										<c:otherwise>
											<span class="finish">출고 완료</span>
										</c:otherwise>
									</c:choose>
									
								</li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<li class="order_item_none">
								주문하신 상품이 없습니다.
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</article>
			<%--주문현황 end --%>

			<%-- 나의 QnA start --%>
			<article class="my_QnA">
				<h1>나의 Q&A</h1>
				<div class="QnA_table_wrap">
				<table class="QnA_table">
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
										<fmt:formatDate var="indateFormat" pattern="yy년 MM월 dd일" value="${item.indate}" />
										<c:out value="${indateFormat }" /></td>
									<c:choose>
										<c:when test="${Character.toString(item.result).matches('n')}">
											<td class="wait" >답변 대기</td>
										</c:when>
										<c:otherwise>
											<td class="finish">답변 완료</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr class="item_tr_none">
								<td colspan="4">문의하신 내역이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
				</div>
			</article>
			<%-- 나의 QnA end --%>

		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>