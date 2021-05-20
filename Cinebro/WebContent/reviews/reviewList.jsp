
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
  width: 33%;
  padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}
h3 {
    font-size: large;
}
a {
    color: white;
}

</style>
</head>
<body>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container">
	<br><br>
		<h3 style="color: white;"><b>인기있는 영화리뷰</b></h3><br>
		<div class="row">
			<c:forEach var="bean" items="${requestScope.popularReviews}">
				<div class="column">
					<div class="media">
						<div class="media-left media-top">
							<img src="img/${bean.filmTitle}.jpg" class="media-object"
								style="width: 100px">
						</div>
						<div class="media-body">
							<h5 class="media-heading" >
								<a style="color: peachpuff;"
									href="<%=NoForm%>reviewDetail&id=${bean.id}&email=${sessionScope.whologin.email}">${bean.filmTitle}</a>
								<small> <i style="color: white;">${bean.writeDate}</i>
								</small>
							</h5>
							<h5 ><a  style="color: white;" href="<%=NoForm%>myproFile&email=${bean.email}&${requestScope.parameters}">${bean.writer}</a>
								<small> <i style="color: white;">${bean.rating}점</i>
								</small>
							</h5>
							<br>
							<p style="color: white;">${bean.content}</p>
							<p style="color: white;">${bean.getlike}likes</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<h3 style="color: white;"><b>내가 좋아요 누른 영화리뷰</b></h3><br>
		<div class="row">
			<c:forEach var="bean" items="${requestScope.mylikeReviews}">
				<div class="column">
					<div class="media">
						<div class="media-left media-top">
							<img src="img/${bean.filmTitle}.jpg" class="media-object"
								style="width: 100px">
						</div>
						<div class="media-body">
							<h5 class="media-heading">
								<a  style="color: peachpuff;"
									href="<%=NoForm%>reviewDetail&id=${bean.id}&email=${sessionScope.whologin.email}">${bean.filmTitle}</a>
								<small> <i>${bean.writeDate}</i>
								</small>
							</h5>
							<h5 style="color: white;">
							<a   style="color: white;" href="<%=NoForm%>myproFile&email=${bean.email}&${requestScope.parameters}">${bean.writer}</a>
								<small> <i style="color: white;">${bean.rating}점</i>
								</small>
							</h5>
							<br>
							<p style="color: white;">${bean.content}</p>
							<p style="color: white;">${bean.getlike}likes</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>	
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>