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
<link rel="stylesheet" href="css/message.css">
<link rel="stylesheet" href="css/detail.css">
<script type="text/javascript" src="js/main.js" defer></script>

<!-- index는 메인 페이지를 의미? 메인 페이지가 전체 페이지의 틀이 된다?  -->
</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="../../header.jsp" />

		<!-- outlet Pages Section -->
		<section>
			<div class="detail_wrap">
				<ul>
					<c:forEach var="item" items="${carts}">
						<li>
							<img alt="item_image" src="upload/${item.p_url}">
							<p>${item.p_name}</p>
							<p>${item.p_price}</p>
							<p>${item.quantity}</p>
						
						</li>
					
					</c:forEach>
				
				</ul>

			
			</div>	
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

</body>
</html>