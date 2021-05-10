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
</c:if>s
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
				<div class="col-lg-1">
					<div class="header__logo">
						<a href="<%=contextPath%>/anime-main/main.jsp"> <img src="<%=contextPath%>/img/logo.png" alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="header__nav">
						<nav class="header__menu mobile-menu">
							<ul> 
								<li class="arrow_carrot-down"><a href="<%=contextPath%>/filmwatch/bridge.jsp">영화n보러가기</a></li>
								<li class="arrow_carrot-down"><a href="./main.jsp">영화&리뷰</a></li>
								<li class="arrow_carrot-down"><a href="./main.jsp">영화리스트</a></li>
								<li class="arrow_carrot-down"><a href="./main.jsp">멤버</a></li>
								<li class="arrow_carrot-down"><a href="./main.jsp">검색</a></li>
								<c:if test="${whologin != 0}">
									<li style="color: white"> ${sessionScope.loginfo.nickname}님 </li>
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
							<c:when test="">
								<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">닉네임<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="<%=NoForm%>viewExam01">회원과 게시물</a></li>
										<li><a href="<%=NoForm%>viewExam02">회원별 게시물 건수</a></li>
										<li><a href="<%=NoForm%>viewExam03">주문 정보</a></li>
										<li><a href="<%=NoForm%>viewExam04">고객별 매출 총액</a></li>
										<li><a href="<%=NoForm%>viewExam05">회원별 주문 건수</a></li>
									</ul>
								</li>
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