<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="utf-8">
<title>JavaScript</title>
<style>
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
h3 {
    color: w;
    font-size: 30px;
    color: white;
    font-size: x-large;
    }
    .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
    padding: 8px;
    line-height: 1.42857143;
    vertical-align: top;
    border-top: 1px solid #ddd;
    font-size: larger;
}

p.text-white {
    font-size: x-large;
}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />
	<div class="container">
		<div class="panel-body">
			<div class="row">
			<br><br>
				<h3 class="text-white"><b>${sessionScope.loginfo.nickname}님이 시청한 영화</b></h3>
				<c:forEach items="${requestScope.lists}" var="bean" varStatus="status">
					<div class="column">
						<div class="container">
							<a style="color: peachpuff;" href="<%=NoForm%>filmDetail&id=${bean.id}&email=${loginfo.email}">
								<img src="upload/${bean.image}" alt="${bean.film_title}" style="width: 100%">
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<table class="table table-hover">
			
					<p class="text-white">
								<b>${sessionScope.loginfo.nickname}님이 시청한 영화</b>
							
						
					
				
				<tbody>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<td><span style="color: white"> 
								<a style="color: peachpuff;" href="<%=NoForm %>filmDetail&id=${bean.id}&email=${loginfo.email}">
										${bean.film_title}
								</a>
							</span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br> <br> <br><br> <br> <br><br> <br>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>