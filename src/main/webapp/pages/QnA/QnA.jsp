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

</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<h1>Q & A</h1>
			<button onClick="location.href='BBreadServlet?command=QnAedit_page'">글쓰기</button>
			<table>
			<tr>
			</tr>
				<tr>
					<td>글 번호</td>
					<td>제 목</td>
					<td>작성자</td>
					<td>날 짜</td>
					<td>상 태</td>
				</tr>
				<tr>
					<td>15</td>
					<td>테스트 게시글</td>
					<td>kim</td>
					<td>2023/04/08</td>
					<td>대 기</td>
				</tr>
			</table>

		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>