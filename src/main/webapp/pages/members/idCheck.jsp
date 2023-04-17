<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBread</title>
<script type="text/javascript" src="js/validation.js" defer></script>

</head>
<body>
	<div id="wrap">
		<section>
			<h1>아이디 중복 확인</h1>
			<form action="BBreadServlet" method="get">
				<input type="hidden" name="command" value="ID_Check">
				
				<c:choose>
					<c:when test="${ID_check_result == -1 }">
						<input class="checkedID" type="text" name="id" value="${userID}" required="required" readonly="readonly">
						<p>${userID}는 사용가능합니다.</p>
						<button type="button" onClick="useID()"> 아이디 사용하기</button>
					</c:when>	
					<c:when test="${ID_check_result == 1}">
						<input class="ID_input" type="text" name="id" value="${userID}" required="required">
						<input class="ID_check" type="hidden"> 
						<div class="ID_resultMsgBox"></div>
						<button > 아이디 중복 체크</button>
						<p>${userID}는 중복된 아이디가 존재합니다.</p>
					</c:when>
			
				</c:choose>
			</form>

		</section>
	</div>
</body>
</html>