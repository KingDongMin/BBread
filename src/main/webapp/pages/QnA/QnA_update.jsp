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
<link rel="stylesheet" href="css/QnA/edit.css">
<script type="text/javascript" src="js/main.js" defer></script>
</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<h1> QnA 문의글 수정</h1>
			<c:if test="${message != null }">${message}</c:if>
			
			<form action="BBreadServlet" method="post">
				<input type="hidden" name="command" value="QnA_update">
				<input type="hidden" name="qseq" value="${QnA.qseq}">
				
				<div class="table_wrap">
				<table>
				 	<tr>
				 		<td>작성자</td>
				 		<td>
				 			${QnA.mid}
				 		</td>
				 	</tr>
				 	<tr>
				 		<td>등록일</td>
				 		<td>
				 			<fmt:formatDate value="${QnA.indate }" var="format_indate" pattern="yy년 MM월 dd일"/>
				 			${format_indate}
				 		</td>
				 	</tr>
				 	<tr>
				 		<td>제목</td>
				 		<td>
				 			<input class="data" type="text" name="title" value="${QnA.title }" >
				 		</td>
				 	</tr>
				 	<tr>
				 		<td>문의 내용</td>
				 		<td>
				 			<textarea class="data" name="inquiry" rows="20" cols="50">${QnA.inquiry}</textarea>
				 		</td>
				 	</tr>
		
				</table>
				</div>
				<div class="btn_wrap">
					<input type="reset" value="다시 쓰기">
					<input type="submit" value="수정 완료" onClick="return checkNull()">
				</div>
					 		
			</form>
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>