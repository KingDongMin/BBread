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
		
			<h1>My Page</h1>
			
			<form action="BBreadServlet?command=update_member" method="post" id="frm">
				<ul>
					<li>
					<label for="id">아이디</label>
					<input type="text" name="id" value="${Mvo.id }" readonly="readonly">
					</li>

					<li>
					<label for="pw">비밀번호</label>
					<input type="password" name="pw" value="${Mvo.pw }" >
					</li>
					
					<li>
					<label for="pw">비밀번호 확인</label>
					<input type="password" name="pw_check">
					</li>
					
					<li>
					<label for="name">이름</label>
					<input type="text" name="name" value="${Mvo.name}">
					</li>
					
					<li>
					<label for="email">이메일</label>
					<input type="text" name="email" value="${Mvo.email }">
					</li>
					
					<li>
					<label for="address">주소</label>
					<input type="text" name="address" value="${Mvo.address }">
					</li>
					
					<li>
					<label for="phone">전화번호</label>
					<input type="text" name="phone" value="${Mvo.phone }">
					</li>
				</ul>
				
				
				<div id="login_footer">
					<a href="BBreadServlet">메인화면</a>
					<input class="input_button" type="submit" value="정보수정">
				</div>

			</form>

		</section>
	</div>
</body>
</html>