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
<link rel="stylesheet" href="css/QnA.css">

</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<h1>Q & A</h1>
			<c:if test="${message != null }">${message}</c:if>
			
			
			<div class="table_wrap">
			<table>
				<tr>
					<td>글 번호</td>
					<td>제 목</td>
					<td>작성자</td>
					<td>날 짜</td>
					<td>답 변</td>
				</tr>
				<c:choose>
					<c:when test="${QnA_list !=null }">
						<c:forEach var="item" items="${QnA_list}">
						<tr onClick="location.href='BBreadServlet?command=QnA_detail_page&qseq=${item.qseq}'">
							<td>${item.qseq}</td>
							<td>${item.title}</td>
							<td>${item.mid }</td>
							<td>
							<fmt:formatDate var="format_indate" pattern="yy년 MM월 dd일" value="${item.indate}" />
							${format_indate}</td>
							
							<c:choose>
								<c:when test="${Character.toString(item.result).matches('[n]')}">
									<td class="wait">대기</td>
								</c:when>
								<c:otherwise>
									<td class="finish">완료</td>
								</c:otherwise>
							</c:choose>
						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${QnA_list}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
			</div>
			
			<button class="edit_btn" onClick="location.href='BBreadServlet?command=QnAedit_page'">문의하기</button>
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>