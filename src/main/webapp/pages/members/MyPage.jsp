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
		<div id="edit-wrap">
			<!-- 회원정보 -->
			<article >
			<h1>회원정보</h1>
			<ul class="member-info">
				<li>
					<span >아이디 :</span>
					<span class="item">${Mvo.id}</span>
				</li>
				<li>
					<span>이름 :</span>
					<span class="item">${Mvo.name }</span>
				</li>
				<li>
					<span >주소 :</span>
					<span class="item">${Mvo.address}</span>
				</li>
				<li>
					<span >전화번호 :</span>
					<span class="item">${Mvo.phone }</span>
				</li>
				<li class="edit-btn">
					<a href="BBreadServlet?command=member_update_page">회원정보 수정</a>
				</li>
			</ul>
			</article>
			
			<!-- 주문현황 -->
			<article>
			<h1>주문 현황</h1>
			<ul>
				<li>제품1</li>
				<li>제품2</li>
				<li>제품3</li>
			</ul>
			</article>
		</div>
		</section>

		<!-- Footer Section  -->
		<c:import url="../../footer.jsp" />
	</div>

	<script type="text/javascript" defer>
	
		//제품 수량 증감
		const quantityBox = document.getElementById("quantity_box");
		const quantity = document.getElementById("quantity");
		quantityBox.onclick = (e)=>{
			const value = e.target.value;
			
			if(value != "plus" && value != "minus" ) return;
			
			if(value == "plus"){
				quantity.value = Number(quantity.value)+ 1;
			}else if(value=="minus" && Number(quantity.value) > 1 ){
				quantity.value = Number(quantity.value) - 1;
			}
		}
	
	</script>
</body>
</html>