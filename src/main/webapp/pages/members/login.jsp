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
<link rel="stylesheet" href="css/login.css">

</head>
<body>
	<div id="wrap">
		<section>
			<div id="logo">
				<a> <img alt="Brand_logo" src="imgs/logo/BBread_Logo.png">
				</a>
			</div>
			
			<c:if test="${message != null }">${message}</c:if>
			<form action="BBreadServlet?command=login" method="post" id="frm">
				<ul>
					<li >
					<label for="id">아이디</label>
					<input type="text" name="id" required="required"
					 oninvalid="this.setCustomValidity('아이디를 입력해주세요.')"
					 oninput="this.setCustomValidity('')">
					</li>

					<li>
					<label for="pw">비밀번호</label>
					<input type="password" name="pw" required="required"
					oninvalid="this.setCustomValidity('비밀번호를 입력해주세요.')"
					oninput="this.setCustomValidity('')">
					</li>
				</ul>
				<div id="login_footer">
					<a href="BBreadServlet?command=join_page">아직 회원이 아니신가요? 회원가입하기</a>
					<input class="input_button" type="submit" value="로그인">
				</div>

			</form>

		</section>
	</div>
</body>
</html>