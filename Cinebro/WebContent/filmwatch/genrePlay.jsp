<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container">
<%-- 		<div class="row">
				<div class="col-lg-8">
					<div class="trending__product">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>가족 추천 영화들</h4>
								</div>
							</div>						
						</div>
						<div class="row">
							<div class="col-lg-4 col-md-6 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="<%=contextPath%>/img/trending/trend-1.jpg">
									
										<div class="comment">
											<i class="fa fa-comments"></i> 11
										</div>
										<div class="view">
											<i class="fa fa-eye"></i> 9141
										</div>
									</div>
									<div class="product__item__text">
										<ul>
											<li>Active</li>
											<li>Movie</li>
										</ul>
										<h5>
											<a href="#">The Seven Deadly Sins: Wrath of the Gods</a>
										</h5>
									</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="<%=contextPath%>/img/trending/trend-2.jpg">
									
										<div class="comment">
											<i class="fa fa-comments"></i> 11
										</div>
										<div class="view">
											<i class="fa fa-eye"></i> 9141
										</div>
									</div>
									<div class="product__item__text">
										<ul>
											<li>Active</li>
											<li>Movie</li>
										</ul>
										<h5>
											<a href="#">Gintama Movie 2: Kanketsu-hen - Yorozuya yo
												Eien</a>
										</h5>
									</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="<%=contextPath%>/img/trending/trend-3.jpg">
								
										<div class="comment">
											<i class="fa fa-comments"></i> 11
										</div>
										<div class="view">
											<i class="fa fa-eye"></i> 9141
										</div>
									</div>
									<div class="product__item__text">
										<ul>
											<li>Active</li>
											<li>Movie</li>
										</ul>
										<h5>
											<a href="#">Shingeki no Kyojin Season 3 Part 2</a>
										</h5>
									</div>
								</div>
							</div>
					   </div> --%>
					   
					   <!-- 새로운 로직 -->
					   <div class="panel-body">
				<table class="table table-hover" >
					<thead>
						<tr>
							<th><p class="text-white">전체 영화 목록</p></th>
						</tr>
					</thead>
					<tbody>
					<class="text-body">
					<c:forEach var="bean1" items="${requestScope.films}">
						<tr>
							<td>${bean1.film_title}</a> </td>
							<td>${bean1.country}</td>
							<td>${bean1.director}</td>
							<td>${bean1.id}</td>
							<td>${bean1.year}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			 <br><br><br>
			
			<div class="panel-heading" class="text-body">
				<h1>
				<p class="text-white">흠..가족장르..</p>	
				</h1>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><p class="text-white">가족 장르</p></th>					
						</tr>
					</thead>
					<tbody>
					<c:forEach var="bean2" items="${requestScope.films}">
						<tr>
							<td>${bean2.film_title}</a> </td>
							<td>${bean2.country}</td>
							<td>${bean2.director}</td>
							<td>${bean2.id}</td>
							<td>${bean2.year}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
					   
					</div>
	
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>