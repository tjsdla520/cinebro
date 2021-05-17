<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<!-- Footer Section Begin -->
	<footer class="footer">
		<div class="page-up">
			<a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="footer__logo">
						<a href="<%=contextPath%>/anime-main/main.jsp"><img src="<%=contextPath%>/img/logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="footer__nav">
						<ul>
							<li class="arrow_carrot-down">
									<c:choose>
										<c:when
											test="${whologin == 0}">
											<a href="<%=NoForm%>meLogin"> 영화 보러가기</a>
										</c:when> 
										<c:when test="${whologin != 0}">
											<c:if test="${sessionScope.loginfo.subscribe == 0}"> 
												<a href="<%=NoForm%>bridge"> 영화 보러가기</a>
											</c:if>
											<c:if test="${sessionScope.loginfo.subscribe == 1}">
												<a href="<%=NoForm%>filmPlay&email=${sessionScope.loginfo.email}"> 영화 보러가기</a>
											</c:if>
										</c:when>
									</c:choose>
									</li>
								<li class="arrow_carrot-down"><a
									href="<%=NoForm%>reviewList">영화 리뷰</a></li>
								<li class="arrow_carrot-down"><a href="<%=NoForm%>filmList&email=${sessionScope.loginfo.email}">영화 리스트</a></li>
								<li class="arrow_carrot-down"><a href="<%=NoForm%>memberList&email=${sessionScope.loginfo.email}">멤버</a></li>
								<li class="arrow_carrot-down"><a href="<%=NoForm%>search">검색</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3">
					<p>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | This template is made with <i
							class="fa fa-heart" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>

				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Search model Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">
				<i class="icon_close"></i>
			</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>
	<!-- Search model end -->

	<!-- Js Plugins -->
	<script src="<%=contextPath%>/js/jquery-3.3.1.min.js"></script>
	<script src="<%=contextPath%>/js/bootstrap.min.js"></script>
	<script src="<%=contextPath%>/js/player.js"></script>
	<script src="<%=contextPath%>/js/jquery.nice-select.min.js"></script>
	<script src="<%=contextPath%>/js/mixitup.min.js"></script>
	<script src="<%=contextPath%>/js/jquery.slicknav.js"></script>
	<script src="<%=contextPath%>/js/owl.carousel.min.js"></script>
	<script src="<%=contextPath%>/js/main.js"></script>
</body>
</html>