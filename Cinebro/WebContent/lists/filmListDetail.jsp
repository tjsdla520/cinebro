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
	* {
  box-sizing: border-box;
}

.column {
  float: left;
  width: 20%;
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
					<tr>
						<td>${bean.list_title}</td>
						<td>${bean.nickname}</td>
						<td>${bean.comments}</td>	
					</tr>
			</tbody>
		</table>
			<div class="row">
			<c:forEach items="${bean.film_title}" var="entry" varStatus="status">
				<div class="column">
				<div class="container">
					<a href="<%=NoForm%>filmDetail&id=${entry.key}"><img src="img/${entry.value}.jpg" alt="${entry.value}"
						style="width: 100%"></a>
						<div class="middle">
							<div class="text">${entry.value }</div>
						</div>
				</div>
			</div>
			</c:forEach>
	</div>
	</div>

	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>