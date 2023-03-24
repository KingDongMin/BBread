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
<!-- index는 메인 페이지를 의미? 메인 페이지가 전체 페이지의 틀이 된다?  -->
</head>
<body>
	<div id="wrap">
		<!-- Header Section -->
		<c:import url="header.jsp"></c:import>
		<section>
			<h1>main</h1>
			<h1>한글</h1>

		</section>
		<!-- Footer Section  -->
		<c:import url="footer.jsp"></c:import>
	</div>
</body>
</html>