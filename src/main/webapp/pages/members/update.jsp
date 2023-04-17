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
		
			<h1>My Page</h1>
			
			<form action="BBreadServlet?command=update_member" method="post" id="frm">
				<ul>
					<li>
					<label for="id">아이디</label>
					<input type="text" name="id" value="${Mvo.id }" readonly="readonly">
					</li>
					<li class="ID_resultMsgBox resultMsgBox"></li>

					<li>
					<label for="pw">비밀번호</label>
					<input class="PW_input" type="password" name="pw"  >
					</li>
					
					
					<li>
					<label for="pw">비밀번호 확인</label>
					<input class="PW_check" type="password" name="pw_check">
					</li>
					<li class="PW_resultMsgBox resultMsgBox"></li>
					
					<li>
					<label for="name">이름</label>
					<input class="name_input" type="text" name="name" value="${Mvo.name}">
					</li>
					<li class="name_resultMsgBox resultMsgBox"></li>
					
					<li>
					<label for="email">이메일</label>
					<input class="email_input" type="text" name="email" value="${Mvo.email }">
					</li>
					<li class="email_resultMsgBox resultMsgBox"></li>
					
					<li>
					<label for="address">주소</label>
					<input class="address_input" type="text" name="address" value="${Mvo.address }">
					</li>
					<li class="address_resultMsgBox resultMsgBox"></li>
					
					<li>
					<label for="phone">전화번호</label>
					<input class="phone_input" type="text" name="phone" value="${Mvo.phone }">
					</li>
					<li class="phone_resultMsgBox resultMsgBox"></li>
				</ul>
				
				<p class="All_warning"></p>
				<div id="login_footer">
					<div>
						<a href="BBreadServlet?command=My_page">마이페이지로 돌아가기</a>
					</div>
					<input class="input_button" type="submit" value="정보수정하기" onClick="return checkAll()">
				</div>
				
			</form>

		</section>
	</div>
</body>
</html>