<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<c:set var="whologin" value="0" />
<c:if test="${ empty sessionScope.loginfo}">
	<c:set var="whologin" value="0" />
</c:if>
<c:if test="${ not empty sessionScope.loginfo}">
	<c:if test="${ sessionScope.loginfo.email == 'admin'}">
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${ sessionScope.loginfo.email != 'admin'}">
		<c:set var="whologin" value="1" />
	</c:if>
</c:if>
<head>
<style>
.header__logo{
	width: 150;
}
li.btn {
    font-size: large;
}
.col-lg-3 {
    padding-top: 7px;
}
</style>
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
				<div class="col-lg-1.5">
					<div class="header__logo">
						<a href="<%=NoForm%>main"> <img
							src="<%=contextPath%>/img/logo.png" alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-6.5">
					<div class="header__nav">
						<nav class="header__menu mobile-menu">
							<ul>								
									<li class="arrow_carrot-down">
									<c:choose>
										<c:when
											test="${whologin == 0}">
											<a href="<%=NoForm%>meLogin">영화 보러가기</a>
										</c:when> 
										<c:when test="${whologin != 0}">
											<c:if test="${sessionScope.loginfo.subscribe == 0}"> 
												<a href="<%=NoForm%>bridge">영화 보러가기</a>
											</c:if>
											<c:if test="${sessionScope.loginfo.subscribe == 1}">
												<a href="<%=NoForm%>filmPlay&email=${sessionScope.loginfo.email}">영화 보러가기</a>
											</c:if>
										</c:when>
									</c:choose>
									</li>
								
								<li class="arrow_carrot-down"><a
									href="<%=NoForm%>reviewList">영화 리뷰</a></li>
								<li class="arrow_carrot-down"><a href="<%=NoForm%>filmList&email=${sessionScope.loginfo.email}">영화 리스트</a></li>
								<li class="arrow_carrot-down"><a href="<%=NoForm%>memberList&email=${sessionScope.loginfo.email}">멤버</a></li>
								<li class="arrow_carrot-down"><a href="<%=NoForm%>search">검색</a></li>
								<c:if test="${whologin != 0}">

									<li class="btn" style="color: white">
										${sessionScope.loginfo.nickname}님 <span
										class="arrow_carrot-down"></span>
										<ul class="dropdown">
											<li><a href="<%=NoForm%>myproFile&email=${sessionScope.loginfo.email}">myProfile</a></li>
											<li><a href="<%=NoForm%>myFilms&email=${sessionScope.loginfo.email}">Films</a></li>
											<li><a href="<%=NoForm%>myReviews&email=${sessionScope.loginfo.email}">Reviews</a></li>
											<li><a href="<%=NoForm%>myWish&email=${sessionScope.loginfo.email}">myWish</a></li>
											<li><a href="<%=NoForm%>myFollowing&email=${sessionScope.loginfo.email}">myFollowing</a></li>
											<c:if test="${whologin != 2}">
											<li><a
												href="<%=NoForm%>meDelete&email=${sessionScope.loginfo.email}">회원탈퇴</a></li>
											</c:if>
											<c:if test="${whologin == 2}">
												<li><a href="<%=NoForm%>inSertfilm">영화 등록</a></li>
											</c:if>
										</ul>
									</li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="header__right">
						<c:choose>
							<c:when test="${whologin==0 }">
								<a href="<%=NoForm%>meLogin">로그인</a>
								<a href="<%=NoForm%>meInsert">회원가입</a>
							</c:when>
							<c:when test="${whologin !=0 }">
								<a href="<%=NoForm%>meLogout">로그아웃</a>
							</c:when>
						</c:choose>

					</div>
				</div>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<!-- Header End -->
</body>
</html>