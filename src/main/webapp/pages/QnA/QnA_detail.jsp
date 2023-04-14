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
			<table class="QnA_detail-table">
				<tr>
					<td>글 번호</td>
					<td>${QnA.qseq }</td>
					<td>등록일</td>
					<td>
					<fmt:formatDate value="${QnA.indate }" var="format_indate" pattern="yy년 MM월 dd일"/>
					${format_indate}
					</td>
					<td>작성자</td>
					<td>${QnA.mid}</td>
				</tr>
				
				<tr class="inquiry">
					<td colspan="1">제목</td>
					<td colspan="5">${QnA.title}</td>
				</tr>
				

				<tr class="inquiry">
					<td colspan="1">문의 글</td>
					<td colspan="5">${QnA.inquiry}</td>
				</tr>
				<tr>
					<td colspan="1">답 변</td>
					<td colspan="5">${QnA.answer}</td>
				</tr>
			</table>
			<div class="btn-wrap">
				<button>뒤로 돌아가기</button>
				<c:if test="${Mvo.id == QnA.mid }">
				
				<button onClick="location.href='BBreadServlet?command=QnA_update_page&qseq=${QnA.qseq}'">글 수정</button>
				</c:if>
				
			</div>
			

		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>