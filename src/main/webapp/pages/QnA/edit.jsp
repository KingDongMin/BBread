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
<link rel="stylesheet" href="css/QnA_edit.css">
</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<h1> QnA edit</h1>
			<c:if test="${message != null }">${message}</c:if>
			<form action="BBreadServlet" method="post">
				<input type="hidden" name="command" value="edit_QnA">
				<table class="edit-table">
				 	<tr>
				 		<td>작성자</td>
				 		<td>
				 			<input type="text" name="mid" value="${Mvo.id}">
				 		</td>
				 	</tr>
				 	<tr>
				 		<td>제목</td>
				 		<td>
				 			<input type="text" name="title">
				 		</td>
				 	</tr>
				 	<tr>
				 		<td>문의 내용</td>
				 		<td>
				 			<textarea name="inquiry" rows="20" cols="50"></textarea>
				 		</td>
				 	</tr>
		
				</table>
				
				<div class="btn-box">
					<input type="submit" value="작성 완료">
					<input type="reset" value="다시 쓰기">
				</div>
					 		
			</form>
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>