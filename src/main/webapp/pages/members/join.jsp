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
<script type="text/javascript" src="js/validation.js" defer></script>

</head>
<body>
	<div id="wrap">
		<section>
			<div id="logo">
				<a> <img alt="Brand_logo" src="imgs/logo/BBread_Logo.png">
				</a>
			</div>
		
			<h1>회원가입</h1>
			
			<form action="BBreadServlet?command=join" method="post" id="frm">
				<ul>
					<li>
					<label for="id">아이디</label>
					<input type="text" name="id" class="id" required >
					<input type="hidden" name="re_id" class="re_id">
					<button type="button" class="ID_check_btn" onClick="check_ID()">ID 중복 체크</button>
					</li>
					<li>
						<p class="ID_warning"></p>
					</li>

					<li>
					<label for="pw">비밀번호</label>
					<input type="password" name="pw" class="pw" required >
					</li>
					
					<li>
					<label for="pw">비밀번호 확인</label>
					<input type="password" name="pw_check" class="re_pw" required >
					</li>
					
					<li>
					<p class="PW_warning"></p>
					</li>
					
					<li>
					<label for="name">이름</label>
					<input type="text" name="name" required>
					</li>
					
					<li>
					<label for="email">이메일</label>
					<input type="text" name="email" required>
					</li>
					
					<li>
					<label for="address">주소</label>
					<input type="text" name="address" required>
					</li>
					
					<li>
					<label for="phone">전화번호</label>
					<input type="text" name="phone" required>
					</li>
				</ul>
				<p class="warning_message"></p>
				<div id="login_footer">
					<a href="BBreadServlet?command=login_page">로그인 화면으로 돌아가기</a>
					<input class="input_button" type="submit" value="회원가입" onClick="checkAll()">
				</div>

			</form>

		</section>
	</div>
</body>
</html>