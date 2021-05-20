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
	<div class="container">
	<div class="panel-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><p class="text-white">
							<b>${requestScope.nickname}님의 리뷰</b>
						</p>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bean" items="${requestScope.Review}">
					<tr>
						<td><span style="color: white">
							<a style="color: peachpuff;" href="<%=NoForm %>reviewDetail&id=${bean.id}">${bean.filmTitle}
							</a></span>
						</td>
						<td><span style="color: white">${bean.content}</span></td>
						<td><span style="color: white">${bean.rating}</span></td>
						<td><span style="color: white">${bean.watchDate}</span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="./../anime-main/footer.jsp"/>
	</div>
</body>
</html>