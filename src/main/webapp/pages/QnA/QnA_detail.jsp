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
<link rel="stylesheet" href="css/QnA/detail.css">
<link rel="stylesheet" href="css/message.css">
<script type="text/javascript" src="js/message.js" defer></script>
<script type="text/javascript" src="js/QnA.js" defer></script>

</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<h1>Q & A</h1>
			
			
			<div class="table_wrap">
			<table>
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
					<td >제목</td>
					<td colspan="5">
						<p>${QnA.title}</p>
					</td>
				</tr>
				

				<tr class="inquiry">
					<td >문의 글</td>
					<td colspan="5">
						<pre>${QnA.inquiry}</pre>
					</td>
				</tr>
				<tr>
					<td >답 변</td>
					<td colspan="5">
					<c:choose>
						<c:when test="${QnA.answer == null && Avo != null}">
							<form action="BBreadServlet" method="post">
								<input type="hidden" name="command" value="QnA_answer">
								<input type="hidden" name="qseq" value="${QnA.qseq}">
								<textarea class="answer" name="answer" rows="5" cols="20"></textarea>
								<button onClick="return checkAnswer()">답변 작성</button>
							</form>
						</c:when>
						<c:when test="${QnA.answer == null}">
							<p class="wait">답변 대기</p>
						</c:when>
						<c:otherwise>
							<pre class="finish">${QnA.answer}</pre>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</table>
			</div>
			
			<div class="btn_wrap">
				<button onClick="location.href='BBreadServlet?command=QnA_page'">Q&A 페이지</button>
				<c:if test="${Mvo.id == QnA.mid }">
					<button onClick="location.href='BBreadServlet?command=QnA_update_page&qseq=${QnA.qseq}'">문의 수정</button>
					<button class="delete_btn" onClick="createMessage(${QnA.qseq})">문의 삭제</button>
				</c:if>
			</div>
			
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>
	

</body>
</html>