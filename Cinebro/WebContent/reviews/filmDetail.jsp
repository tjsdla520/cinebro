
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="./../anime-main/header.jsp" />

		<div class="media">
			<div class="media-left media-top col-sm-3">
				<img src="img/${fbean.film_title}.jpg" class="media-object" style="width: 180px">
			</div>
			<div class="media-body">
				<h4 class="media-heading" style="color: white">${fbean.film_title}</h4>
				<p></p>
				<p style="color: white; " >감독 : ${fbean.director}</p>
				<p style="color: white; ">개봉연도 : ${fbean.year}</p>
				<p style="color: white; "> 국가 : ${fbean.country}</p>
				
				<p style="color: white; "> 장르 : 
				<c:forEach var="genre" items="${fbean.genres}">
					<c:out value="${genre}"></c:out>
				</c:forEach>
				</p>
				
				<p style="color: white; "> 배우 :
					<c:forEach var="actor" items="${fbean.actors}">
						<c:out value="${actor}"></c:out>
					</c:forEach>
				</p>
			</div>
		</div>
		<div class="col-sm-3"></div>
		<div>

				<a href="<%=NoForm%>reviewWrite&id=${fbean.id}"><button type="button" class="btn btn-warning">리뷰 쓰기</button></a> 
				&nbsp;&nbsp;&nbsp;&nbsp; 

			<c:if test="${bean.writer!=sessionScope.loginfo.nickname}">
				<a href="<%=NoForm%>likereView&id=${bean.id}&email=${loginfo.email}"><button class="btn-like btn-lg">👍</button></a>
			</c:if>	
		<script src="//code.jquery.com/jquery.min.js"></script>
		<script>
			$(".btn-like").click(function() {
				$(this).toggleClass("done");
			})
		</script>
		</div>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>