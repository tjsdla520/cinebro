<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />

	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg"
		data-setbg="<%=contextPath%>img/normal-breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="text-center">
					<div class="normal__breadcrumb__text">
						<h2>단돈 만원으로 제공되는</h2>
						<h2>한달간의 무제한 스트리밍 서비스</h2>
						<p>Welcome to the CINEBRO</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<section class="anime-details spad">
		<div class="container">
			<div class="text-center">
				<div class="anime__details__btn" align="center">
					<a href="<%=NoForm%>pay" class="follow-btn"> <i
						style="font-size: 48px; color: black;"> <b>cinebro 구독하러가기</b>
					</i>
					</a>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>