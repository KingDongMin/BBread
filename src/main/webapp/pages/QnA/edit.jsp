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
			<h1>QnA 문의글 작성</h1>
			
			<c:if test="${message != null }">${message}</c:if>
			<form action="BBreadServlet" method="post">
				<input type="hidden" name="command" value="edit_QnA">
				
				<div class="table_wrap">
				<table class="edit-table">
				 	<tr>
				 		<td>작성자</td>
				 		<td>
				 			<input class="data" type="text" name="mid" value="${Mvo.id}">
				 		</td>
				 	</tr>
				 	<tr>
				 		<td>제목</td>
				 		<td>
				 			<input class="data" type="text" name="title">
				 		</td>
				 	</tr>
				 	<tr>
				 		<td>문의 내용</td>
				 		<td>
				 			<textarea class="data" name="inquiry" rows="20" cols="50"></textarea>
				 		</td>
				 	</tr>
		
				</table>
				</div>
				
				
				<div class="btn_wrap">
					<button type="button" onClick="location.href='BBreadServlet?command=QnA_page'">Q&A 페이지</button>
					<input type="reset" value="다시 쓰기">
					<button type="submit" onClick="return checkNull()">작성완료</button>
				</div>
					 		
			</form>
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>