
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style type="text/css">
	p{ color: white;}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	 
			<div class="panel-heading">
				<h3 style="color: white;">
				인기있는 영화리뷰
				</h3>
			</div>
			<div class="panel-body">

					<c:forEach var="bean" items="${requestScope.reviewlists}">
						<section>
							<h3><a href="<%=NoForm%>filmListDetail&id=${bean.id}">${bean.filmTitle}</a> </h3>
							<p >${bean.writer}</p>
							<p>${bean.content}</p>
							<p>${bean.rating}</p>
							<p>${bean.getlike}</p>
							<p>${bean.writeDate}</p>
						</section>>
					</c:forEach>

			</div>
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>