<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 해더 컴포넌트  -->
<header>

	<div id="logo">
		<a>
			<img alt="Brand_logo" src="imgs/logo/BBread_Logo.png" >
		</a>
	</div>
	
	<div id="menu_wrap">
		<nav id="member_menu">
			<ul>
				<c:if test ="${Mvo != null}">
					<li><a href="BBreadServlet?command=My_page">My Page</a></li>
				</c:if>
				<li><a href="BBreadServlet?command=login_page">Login</a></li>
				<!-- 로그인 페이지에서 회원가입 페이지 링크 만들기? -->
				<li>Cart</li>
				<li>Q&A</li>
			</ul>
		</nav>
		
		<nav id="product_menu">
			<ul>
				<li>
				<a>Sourdough</a>
				</li>
				
				<li>
				<a>Baguette</a>
				</li>
				
				<li>
				<a>Brioche</a>
				</li>
				
				<li>
				<a>Focaccia</a>
				</li>
				
				<li>
				<a>Ciabatta</a>
				</li>
			</ul>
		</nav>
	</div>
	
</header>