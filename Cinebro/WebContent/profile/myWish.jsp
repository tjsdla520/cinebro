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
  width: 20%;
  padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}
.container2 {
  position: relative;
  width: 50%;
}

.image {
  opacity: 1;
  display: block;
  width: 100%;
  height: auto;
  transition: .5s ease;
  backface-visibility: hidden;
}

.middle {
  transition: .5s ease;
  opacity: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  text-align: center;
}

.container2:hover .image {
  opacity: 0.3;
}

.container2:hover .middle {
  opacity: 1;
}

.text {
  color: white;
  font-size: 15px;
  padding: 16px 32px;
}
.container2 {
  position: relative;
  width: 50%;
}

.image {
  opacity: 1;
  display: block;
  width: 100%;
  height: auto;
  transition: .5s ease;
  backface-visibility: hidden;
}

.middle {
  transition: .5s ease;
  opacity: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  text-align: center;
}

.container2:hover .image {
  opacity: 0.3;
}

.container2:hover .middle {
  opacity: 1;
}

.text {
  color: white;
  font-size: 16px;
  padding: 16px 32px;
}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container"><br>
	<h2 style="color: white">My Wish Films</h2>
	<br>
	<div class="row">
		<c:forEach var="bean" items="${requestScope.lists}">
			<div class="column">
				<div class="container2">
				<a href="<%=NoForm%>filmDetail&id=${bean.id}&email=${loginfo.email}"><img src="upload/${bean.image}" alt="${bean.film_title}"
					style="width: 100%" class="image"></a>
					<div class="middle">
						<a href="<%=NoForm%>filmDetail&id=${bean.id}&email=${loginfo.email}"> 
							<div class="text">${bean.film_title }</div>
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	</div>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>