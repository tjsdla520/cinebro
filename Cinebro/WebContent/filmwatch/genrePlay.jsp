<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.dropbtn {
  background-color: red;
  color: white;
  padding: 10px;
  font-size:20px;
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
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: red;}
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
.container {
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

.container:hover .image {
  opacity: 0.3;
}

.container:hover .middle {
  opacity: 1;
}

.text {
  color: white;
  font-size: 15px;
  padding: 16px 32px;
}
.container {
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

.container:hover .image {
  opacity: 0.3;
}

.container:hover .middle {
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
	<div class="container">
		<div class="dropdown">
			<button class="dropbtn">
				<b>장르별 보러가기</b>
			</button>
			<div class="dropdown-content">
				<c:forEach var="bean" items="${requestScope.list1 }">
					<a href="<%=NoForm%>genrePlay&id=${bean.id }&name=${bean.name}">${bean.name }</a>
				</c:forEach>
			</div>
		</div>
		<br>
		<br>
		<h3 style="color: white">${requestScope.genrename } 인기영화</h3>
	<div class="row">
		<c:forEach var="bean1" items="${requestScope.films}">
			<div class="column">
				<div class="container">
				<a href="<%=NoForm%>filmDetail&id=${bean1.id}"><img src="img/${bean1.film_title}.jpg" alt="${bean1.film_title}"
					style="width: 100%" class="image"></a>
					<div class="middle">
						<div class="text">${bean1.film_title }</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	</div>

	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>