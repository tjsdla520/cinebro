<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
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
  font-size: 10px;
  padding: 16px 32px;
}
</style>
</head>
<body>

	<jsp:include page="./../anime-main/header.jsp"/>

	 <div class="dropdown">
	  <button class="dropbtn"><b>장르별 보러가기</b></button>
		  <div class="dropdown-content">
		  	<c:forEach var="bean" items="${requestScope.list1 }">
		  		<a href="<%=NoForm%>genrePlay&id=${bean.id }&name=${bean.name}">${bean.name }</a>
		  	</c:forEach>    
		  </div>
	</div>
	<br><br>
			<div class="row">
				<div class="col-lg-8">
					<div class="container">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>보고싶어요한 영화</h4>
								</div>
							</div>						
						</div>
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<c:forEach var="n" end="${requestScope.endpage2 }" varStatus="now" begin="1">
									<li data-target="#myCarousel" data-slide-to="${now.index }"></li>
								</c:forEach>
							</ol>
				
							<!-- Wrapper for slides -->
							<div class="carousel-inner">
								<c:forEach var="i" begin="1" end="${requestScope.endpage2 }" varStatus="now">									
									<c:choose>
										<c:when test="${now.index==1 }">
											<div class="item active">
										</c:when>
										<c:otherwise>
											<div class="item">
										</c:otherwise>
									</c:choose>			
										<c:forEach var="bean2" items="${requestScope.list2}" begin="${(now.index-1)*5+1 }" end="${now.index*5 }">
											<div class="column">
												<div class="container">
													<a href="<%=NoForm%>filmDetail&id=${bean2.id}"><img
														src="img/${bean2.film_title}.jpg" alt="${bean2.film_title}"
														style="width: 100%" class="image"></a>
													<div class="middle">
														<div class="text">${bean2.film_title }</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
				
							<!-- Left and right controls -->
							<a class="left carousel-control" href="#myCarousel" data-slide="prev">
								<span class="glyphicon glyphicon-chevron-left"></span> <span
								class="sr-only">Previous</span>
							</a> 
							<a class="right carousel-control" href="#myCarousel"
								data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span> <span
								class="sr-only">Next</span>
							</a>
					</div>
				</div>
			</div>
			<br><br><br><br><br><br><br>
			<div class="row">
				<div class="col-lg-8">
					<div class="container">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>재생중인 영화</h4>
								</div>
							</div>						
						</div>
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<c:forEach var="n" end="${requestScope.endpage2 }" varStatus="now" begin="1">
									<li data-target="#myCarousel" data-slide-to="${now.index }"></li>
								</c:forEach>
							</ol>
				
							<!-- Wrapper for slides -->
							<div class="carousel-inner">
								<c:forEach var="i" begin="1" end="${requestScope.endpage2 }" varStatus="now">									
									<c:choose>
										<c:when test="${now.index==1 }">
											<div class="item active">
										</c:when>
										<c:otherwise>
											<div class="item">
										</c:otherwise>
									</c:choose>			
										<c:forEach var="bean2" items="${requestScope.list2}" begin="${(now.index-1)*5+1 }" end="${now.index*5 }">
											<div class="column">
												<div class="container">
													<a href="<%=NoForm%>filmDetail&id=${bean2.id}"><img
														src="img/${bean2.film_title}.jpg" alt="${bean2.film_title}"
														style="width: 100%" class="image"></a>
													<div class="middle">
														<div class="text">${bean2.film_title }</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
				
							<!-- Left and right controls -->
							<a class="left carousel-control" href="#myCarousel" data-slide="prev">
								<span class="glyphicon glyphicon-chevron-left"></span> <span
								class="sr-only">Previous</span>
							</a> 
							<a class="right carousel-control" href="#myCarousel"
								data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span> <span
								class="sr-only">Next</span>
							</a>
					</div>
				</div>
			</div>
				<br><br><br><br><br><br><br>
			<div class="row">
				<div class="col-lg-8">
					<div class="container">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>평점 높은 영화</h4>
								</div>
							</div>						
						</div>
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<c:forEach var="n" end="${requestScope.endpage3}" varStatus="now" begin="1">
									<li data-target="#myCarousel" data-slide-to="${now.index }"></li>
								</c:forEach>
							</ol>
				
							<!-- Wrapper for slides -->
							<div class="carousel-inner">
								<c:forEach var="i" begin="1" end="${requestScope.endpage3}" varStatus="now">									
									<c:choose>
										<c:when test="${now.index==1 }">
											<div class="item active">
										</c:when>
										<c:otherwise>
											<div class="item">
										</c:otherwise>
									</c:choose>			
										<c:forEach var="bean" items="${requestScope.list3}" begin="${(now.index-1)*5+1 }" end="${now.index*5 }">
											<div class="column">
												<div class="container">
													<a href="<%=NoForm%>filmDetail&id=${bean.id}"><img
														src="img/${bean.film_title}.jpg" alt="${bean.film_title}"
														style="width: 100%" class="image"></a>
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
								<span class="glyphicon glyphicon-chevron-left"></span> <span
								class="sr-only">Previous</span>
							</a> 
							<a class="right carousel-control" href="#myCarousel"
								data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span> <span
								class="sr-only">Next</span>
							</a>
					</div>
				</div>
			</div>
				<br><br><br><br><br><br><br>
			<div class="row">
				<div class="col-lg-8">
					<div class="container">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>${sessionScope.loginfo.nickname }님에게 추천드리는 영화</h4>
								</div>
							</div>						
						</div>
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<c:forEach var="n" end="${requestScope.endpage2 }" varStatus="now" begin="1">
									<li data-target="#myCarousel" data-slide-to="${now.index }"></li>
								</c:forEach>
							</ol>
				
							<!-- Wrapper for slides -->
							<div class="carousel-inner">
								<c:forEach var="i" begin="1" end="${requestScope.endpage2 }" varStatus="now">									
									<c:choose>
										<c:when test="${now.index==1 }">
											<div class="item active">
										</c:when>
										<c:otherwise>
											<div class="item">
										</c:otherwise>
									</c:choose>			
										<c:forEach var="bean2" items="${requestScope.list2}" begin="${(now.index-1)*5+1 }" end="${now.index*5 }">
											<div class="column">
												<div class="container">
													<a href="<%=NoForm%>filmDetail&id=${bean2.id}"><img
														src="img/${bean2.film_title}.jpg" alt="${bean2.film_title}"
														style="width: 100%" class="image"></a>
													<div class="middle">
														<div class="text">${bean2.film_title }</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
				
							<!-- Left and right controls -->
							<a class="left carousel-control" href="#myCarousel" data-slide="prev">
								<span class="glyphicon glyphicon-chevron-left"></span> <span
								class="sr-only">Previous</span>
							</a> 
							<a class="right carousel-control" href="#myCarousel"
								data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span> <span
								class="sr-only">Next</span>
							</a>
					</div>
				</div>
			</div>
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>