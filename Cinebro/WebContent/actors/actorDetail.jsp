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
<div class="container">	
	<div class="panel-heading">
		<h1>
			<p class="text-white">배우 상세 페이지</p>
		</h1>
	</div>
	<div class="panel-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><p class="text-white">Actor</p></th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${bean.name}</td>
					</tr>
			</tbody>
		</table>
			<c:if test="${bean1.nickname!=sessionScope.loginfo.nickname}">
				<c:choose>
					<c:when test="${bean2==null}">
						<a href="<%=NoForm%>likefilmList&id=${bean1.id}&email=${loginfo.email}"><button class="btn-info btn-lg">좋아요</button></a>
					</c:when>
					<c:otherwise>
						<a href="<%=NoForm%>deletelikefilmList&id=${bean1.id}&email=${loginfo.email}"><button class="btn-warning btn-lg">좋아요 취소</button></a>
					</c:otherwise>
				</c:choose>				
			</c:if>	
			<div>
				<h3 style="color: white">출연작</h3>
			</div>
			<div class="row">
			<c:forEach items="${bean.actingfilms}" var="entry" varStatus="status">
				<div class="column">
				<div class="container">
					<a href="<%=NoForm%>filmDetail&id=${entry.id}&email=${loginfo.email}"><img src="upload/${entry.image}" alt="${entry.film_title}"
						style="width: 100%"></a>
						<div class="middle">
							<div class="text">${entry.film_title}</div>
						</div>
				</div>
			</div>
			</c:forEach>
	</div>
	</div>
</div>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>