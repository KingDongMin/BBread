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
				<a href="BBreadServlet"> <img alt="Brand_logo" src="imgs/logo/BBread_Logo.png">
				</a>
			</div>

			<h1>회원가입</h1>

			<form action="BBreadServlet?command=join" method="post" id="frm">
				<ul>
					<li class="joinID_wrap"><label for="id">아이디</label> <input
						type="text" name="id" class="ID_input" required
						placeholder="아이디를 입력해주세요."> <input type="hidden"
						name="re_id" class="ID_check">
						<button type="button" class="ID_check_btn" onClick="checkID()">ID
							중복 체크</button></li>
					<li class="ID_resultMsgBox resultMsgBox"></li>

					<li><label for="pw">비밀번호</label> <input type="password"
						name="pw" class="PW_input" required placeholder="비밀번호를 입력해주세요.">
					</li>

					<li><label for="pw">비밀번호 확인</label> <input type="password"
						name="pw_check" class="PW_check" required
						placeholder="비밀번호를 확인해주세요."></li>
					<li class="PW_resultMsgBox resultMsgBox"></li>

					<li><label for="name">이름</label> <input type="text"
						name="name" class="name_input input" required
						placeholder="이름을 입력해주세요."></li>
					<li class="name_resultMsgBox resultMsgBox"></li>

					<li><label for="email">이메일</label> <input type="text"
						name="email" class="email_input input" required
						placeholder="이메일을 입력해주세요."></li>
					<li class="email_resultMsgBox resultMsgBox"></li>

					<li><label for="address">주소</label> <input type="text"
						name="address" class="address_input input" required
						placeholder="주소를 입력해주세요."></li>
					<li class="address_resultMsgBox resultMsgBox"></li>

					<li><label for="phone">전화번호</label> <input type="text"
						name="phone" class="phone_input input" required
						placeholder="전화번호를 입력해주세요."></li>
					<li class="phone_resultMsgBox resultMsgBox"></li>
				</ul>
				<p class="All_warning"></p>
				<div id="login_footer">
					<div>
						<a href="BBreadServlet?command=login_page">로그인 화면으로 돌아가기</a>
					</div>
					<input class="input_button" type="submit" value="가입하기"
						onClick="return checkAll()">
				</div>

			</form>

		</section>
	</div>
</body>
</html>