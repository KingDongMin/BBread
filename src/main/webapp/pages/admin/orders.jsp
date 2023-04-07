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
			<h1>주문 현황</h1>
			<table style="border: 2px solid black;">
				<tr>
					<td>주문 번호</td>
					<td>회원 아이디</td>
					<td>처리 상태</td>
					<td>날짜</td>
				</tr>
				<c:forEach var="order" items="${orders}">
				<tr onClick="location.href='BBreadServlet?command=order_detail_page&oseq=${order.oseq}&mid=${order.mid}'">
					<td>${order.oseq }</td>
					<td>${order.mid }</td>
					<td>${order.result}</td>
					<td>${order.indate }</td>
				</tr> 
				</c:forEach>
			
			</table>
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

	<script type="text/javascript" defer>
		
	
	</script>
</body>
</html>