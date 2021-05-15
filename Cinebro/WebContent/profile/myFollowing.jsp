<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="utf-8">
<title>JavaScript</title>
<style>
body {
	font-family: Consolas, sans-serif;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.dropbtn {
	background-color: red;
	color: white;
	padding: 10px;
	font-size: 20px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: red;
}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />
	<div class="container">
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th><p class="text-white">
								<b>멤버 닉네임</b>
							</p></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<td><span style="color: white"> <a
									href="<%=NoForm%>myproFile&email=${bean.follwingemail}">
										${bean.following} </a>
							</span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br> <br> <br>
	</div>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>