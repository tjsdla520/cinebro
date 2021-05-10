<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<header class="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-2">
					<div class="header__logo">
						<a href="<%=contextPath%>/anime-main/main.jsp"> <img src="<%=contextPath%>/img/logo.png" alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="header__nav">
						<nav class="header__menu mobile-menu">
							<ul>
								<li class="arrow_carrot-down"><a href="./main.jsp">영화보러가기d</a></li>
								<li class="arrow_carrot-down"><a href="./main.jsp">영화n리뷰</a></li>
								<li class="arrow_carrot-down"><a href="./main.jsp">영화리스트</a></li>
								<li class="arrow_carrot-down"><a href="./main.jsp">멤버</a></li>
								<li class="arrow_carrot-down"><a href="./main.jsp">검색</a></li>

							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="header__right">
						<a href="#" class="search-switch"><span class="icon_search"></span></a>
						<a href="<%=NoForm%>meLogin">로그인</a>
						<a href="./login.jsp"><span class="icon_profile"></span></a>
					</div>
				</div>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<!-- Header End -->
</body>
</html>