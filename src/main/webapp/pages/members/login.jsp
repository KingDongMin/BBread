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
<script type="text/javascript" src="js/login.js" defer ></script>

</head>
<body>
	<div id="wrap">
		<section>
			<div id="logo">
				<a href="BBreadServlet"> <img alt="Brand_logo" src="imgs/logo/BBread_Logo.png">
				</a>
			</div>
			
			<c:if test="${message != null }">${message}</c:if>
			<form action="BBreadServlet?command=login" method="post" id="frm">
				<ul>
					<li>
					<label for="id">아이디</label>
					  <input class="ID_input" type="text" name="id" required="required"
					 	oninvalid="this.setCustomValidity('아이디를 입력해주세요.')"
					 	oninput="this.setCustomValidity('')"
					 	placeholder="아이디를 입력해주세요."
					 	>
					</li>
					<li class="ID_resultMsgBox resultMsgBox"></li>

					<li>
					<label for="pw">비밀번호</label>
					<input class="PW_input" type="password" name="pw" required="required"
						oninvalid="this.setCustomValidity('비밀번호를 입력해주세요.')"
						oninput="this.setCustomValidity('')"
						placeholder="비밀번호를 입력해주세요.">
					</li>
					<li class="PW_resultMsgBox resultMsgBox"></li>
					
				</ul>
				<div id="login_footer">
					<div>
						<span>아직 회원이 아니신가요?</span>
						<a href="BBreadServlet?command=join_page">회원가입하기</a>
					</div>
					<input class="input_button" type="submit" value="로그인" >
				</div>

			</form>

		</section>
	</div>
</body>
</html>