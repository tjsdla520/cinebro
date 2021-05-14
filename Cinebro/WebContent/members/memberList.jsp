
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
/* position for grid system */
int offset = 2;
int mywidth = twelve - 2 * offset;
int formleft = 3;
int formright = twelve - formleft;
int rightButton = 2;
%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style type="text/css">
	tr{color: white}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />

			<div class="panel-heading">
				<h1>
				<p class="text-white">팔로워가 많은 멤버</p>	
				</h1>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><p class="text-white">멤버 닉네임</p></th>
							<th><p class="text-white">팔로워 수</p></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean1" items="${requestScope.lists1}">
						<tr>
							<td> <a href="<%=NoForm%>memberDetail&email=${bean1.email}&${requestScope.parameters}">${bean1.nickname}</a> </td>
							<td>${bean1.follower}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
			 <br><br><br>
			
			<div class="panel-heading">
				<h1>
				<p class="text-white">리뷰가 많은 멤버</p>	
				</h1>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><p class="text-white">멤버 닉네임</p></th>
							<th><p class="text-white">리뷰 수</p></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean2" items="${requestScope.lists2}">
						<tr>
							<td><a href="<%=NoForm%>memberDetail&email=${bean2.email}&${requestScope.parameters}">${bean2.nickname}</a></td>
							<td>${bean2.allReviews}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
			<br><br><br>
			
			<div class="panel-heading">
				<h1>
				<p class="text-white">내가 팔로잉 하고있는 멤버</p>
					
				</h1>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><p class="text-white">멤버 닉네임</p></th>
							<th><p class="text-white">팔로워 수</p></th>
							<th><p class="text-white">리뷰 수</p></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean3" items="${requestScope.lists3}">
						<tr>
							<td><a href="<%=NoForm%>memberDetail&email=${bean3.email}&${requestScope.parameters}">${bean3.nickname}</a></td>
							<td>${bean3.follower}</td>
							<td>${bean3.allReviews}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
			<br><br><br>
		
	
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>