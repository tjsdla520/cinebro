<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style>
* {
  box-sizing: border-box;
}

.column {
  float: left;
  width: 10%;
  padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}

</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<h2>My Wish Films</h2>
	<p style="color: white">내가 보고싶어요 누른 영화</p>

	<div class="row">
		<c:forEach var="bean" items="${requestScope.lists}">
			<div class="column">
				<a href="<%=NoForm%>filmDetail&id=${bean.id}"><img src="img/${bean.film_title}.jpg" alt="${bean.film_title}"
					style="width: 100%"></a>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>