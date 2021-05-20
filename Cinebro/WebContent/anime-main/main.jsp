<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style>
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
  font-size: 10px;
  padding: 16px 32px;
}
.section-title h4:after, .section-title h5:after {
    position: absolute;
    left: -15;
    top: -6px;
    height: 32px;
    width: 4px;
    background: #e53637;
    content: "";
    }
    .footer {
    background: #070720;
    padding-top: 60px;
    padding-bottom: 40px;
    position: relative;
}
h3 {
    font-size: large;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
			<div><br><br>
				<h3 style="color: white;"><b>인기 영화</b></h3>
			</div>
			<div class="panel-body">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<c:forEach var="n" end="${requestScope.endpage1}" varStatus="now"
							begin="1">
							<li data-target="#myCarousel" data-slide-to="${now.index }"></li>
						</c:forEach>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<c:forEach var="i" begin="1" end="${requestScope.endpage1}" varStatus="now">
							<c:choose>
								<c:when test="${now.index==1 }">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose>
							<c:forEach var="bean" items="${requestScope.list1}"
								begin="${(now.index-1)*5}" end="${now.index*5-1	 }">
								<div class="column">
									<div class="container">
										<a href="<%=NoForm%>filmDetail&id=${bean.id}&email=${whologin.email}">
											<img src="upload/${bean.image}" alt="${bean.film_title}" style="width: 100%" class="image">
										</a>
										<div class="middle">
											<div class="text">${bean.film_title }</div>
										</div>
									</div>
								</div>
							</c:forEach>
							</div>
							</c:forEach>
						</div>
			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> 
				<span class="sr-only">Previous</span>
			</a> 
			<a class="right carousel-control" href="#myCarousel"data-slide="next"> 
				<span class="glyphicon glyphicon-chevron-right"></span> 
				<span class="sr-only">Next</span>
			</a>
			</div>
			<div>
				<h3 style="color: white;"><b>평점 높은 영화</b></h3>
			</div>
			<div class="panel-body">
				<div id="myCarousel2" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<c:forEach var="n" end="${requestScope.endpage4}" varStatus="now"
							begin="1">
							<li data-target="#myCarousel" data-slide-to="${now.index }"></li>
						</c:forEach>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<c:forEach var="i" begin="1" end="${requestScope.endpage4}" varStatus="now">
							<c:choose>
								<c:when test="${now.index==1 }">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose>
							<c:forEach var="bean" items="${requestScope.list4}"
								begin="${(now.index-1)*5}" end="${now.index*5-1	 }">
								<div class="column">
									<div class="container">
										<a href="<%=NoForm%>filmDetail&id=${bean.id}&email=${whologin.email}">
											<img src="upload/${bean.image}" alt="${bean.film_title}" style="width: 100%" class="image">
										</a>
										<div class="middle">
											<div class="text">${bean.film_title }</div>
										</div>
									</div>
								</div>
							</c:forEach>
							</div>
							</c:forEach>
						</div>
			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel2" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> 
				<span class="sr-only">Previous</span>
			</a> 
			<a class="right carousel-control" href="#myCarousel2"data-slide="next"> 
				<span class="glyphicon glyphicon-chevron-right"></span> 
				<span class="sr-only">Next</span>
			</a>
			</div>
			<div>
				<h3 style="color: white;"><b>인기 FilmList</b></h3>
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
						<c:forEach var="bean2" items="${requestScope.lists2}">
							<tr>
								<td><a  class="text-white"
									href="<%=NoForm%>filmListDetail&id=${bean2.id}&${requestScope.parameters}">${bean2.list_title}</a></td>
								<td><p class="text-white">${bean2.nickname}</p></td>
								<td><p class="text-white">${bean2.comments}</p></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div>
				<h3 class="text-white"><b>인기 Review</b></h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><p class="text-white">영화제목</p></th>
							<th><p class="text-white">작성자</p></th>
							<th><p class="text-white">리뷰내용</p></th>
							<th><p class="text-white">별점</p></th>
							<th><p class="text-white">좋아요수</p></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="bean3" items="${requestScope.lists3}">
							<tr>
								<td><a  class="text-white"
									href="<%=NoForm%>filmListDetail&id=${bean3.id}&${requestScope.parameters}">${bean3.filmTitle}</a></td>
								<td><p class="text-white">${bean3.writer}</p></td>
								<td><p class="text-white">${bean3.content}</p></td>
								<td><p class="text-white">${bean3.rating}</p></td>
								<td><p class="text-white">${bean3.getlike}</p></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	<jsp:include page="footer.jsp" />
</body>
</html>