<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style type="text/css">
b {
    font-size: x-large;
}
.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
    padding: 8px;
    line-height: 1.42857143;
    vertical-align: top;
    border-top: 1px solid #ddd;
    font-size: x-large;
}

</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container">
	
		<table class="table table-hover">
			<p class="text-white">
			  <br>
				<b>${requestScope.nickname}님의 리뷰</b>
				</p>
				<br>				
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
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>