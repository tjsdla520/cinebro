<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style type="text/css">
	td{
		color: white;
	}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />
	<div class="panel-heading">
		<h1>
			<p class="text-white">상세 영화리스트</p>
		</h1>
	</div>
	<div class="panel-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><p class="text-white">FILMLIST Subject</p></th>
					<th><p class="text-white">WRITER</p></th>
					<th><p class="text-white">FILMLIST COMMEND</p></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bean" items="${requestScope.lists }">
					<tr>
						<td>${bean.list_title}</td>
						<td>${bean.nickname}</td>
						<td>${bean.comments}</td>
						<td>${bean.film_title }
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>