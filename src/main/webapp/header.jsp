<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 해더 컴포넌트  -->
<header>
	

	<div id="logo">
		<a href="BBreadServlet">
			<img alt="Brand_logo" src="imgs/logo/BBread_Logo.png" >
		</a>
		
	</div>
	
	<div id="menu_wrap">
		<nav id="member_menu">
			<ul>
				<c:if test ="${Mvo != null && Avo == null}">
					<li><a href="BBreadServlet?command=My_page">My Page</a></li>
				</c:if>
				
				<c:if test="${Avo != null }">
					<li style="color:red;">관리자 접속 : ${Avo.name}</li>
					<li><a href="BBreadServlet?command=AddProduct_page">Add Product</a></li>
				</c:if>
				
				<c:choose>
					<c:when test="${Mvo == null && Avo == null }">
						<li><a href="BBreadServlet?command=login_page">Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="BBreadServlet?command=logout">Logout</a></li>
					</c:otherwise>
				</c:choose>

				<li>Cart</li>
				<li>Q&A</li>
			</ul>
		</nav>
		
		<nav id="product_menu">
			<ul>
				<li class="menu 효모">
				<a href="BBreadServlet?command=product_list&kind=효모">Sourdough</a>
				</li>
				
				<li class="menu 바게트">
				<a href="BBreadServlet?command=product_list&kind=바게트">Baguette</a>
				</li>
				
				<li class="menu 브리오슈">
				<a href="BBreadServlet?command=product_list&kind=브리오슈">Brioche</a>
				</li>
				
				<li class="menu 포카치아">
				<a href="BBreadServlet?command=product_list&kind=포카치아">Focaccia</a>
				</li>
				
				<li class="menu 치아바타">
				<a href="BBreadServlet?command=product_list&kind=치아바타">Ciabatta</a>
				</li>
			</ul>
		</nav>
	</div>
	
</header>