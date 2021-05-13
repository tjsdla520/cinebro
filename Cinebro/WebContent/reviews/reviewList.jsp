
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
	<jsp:include page="./../anime-main/header.jsp"/>
	<h3 style="color: white;">인기있는 영화리뷰</h3>
	<c:forEach var="bean" items="${requestScope.reviewlists}">
	
		<div class="media">
			<div class="media-left media-top">
				<img src="img/${bean.filmTitle}.jpg" class="media-object" style="width: 180px">
			</div>
			<div class="media-body">
				<h4 class="media-heading"><a href="<%=NoForm%>reviewDetail&id=${bean.id}">${bean.filmTitle}</a> </h4>
				<p></p>
				<p style="color: white; margin-left: 30px" >작성자 : ${bean.writer}</p>
				<p style="color: white; margin-left: 30px">리뷰 내용 : ${bean.content}</p>
				<p style="color: white; margin-left: 30px">별점 : ${bean.rating}</p>
				<p style="color: white; margin-left: 30px">좋아요 수 : ${bean.getlike}</p>
				<p style="color: white; margin-left: 30px">작성일 : ${bean.writeDate}</p>
			</div>
		</div>
	</c:forEach>
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>