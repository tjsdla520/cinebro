
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%

%>
<!DOCTYPE html>
<html>
<c:set var="whologin" value="0" />
<c:if test="${ empty sessionScope.loginfo}">
	<c:set var="whologin" value="0" />
</c:if>
<c:if test="${ not empty sessionScope.loginfo}">
	<c:if test="${ sessionScope.loginfo.email == 'admin'}">
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${ sessionScope.loginfo.email != 'admin'}">
		<c:set var="whologin" value="1" />
	</c:if>
</c:if>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function filmplay(){
		var url = "<%=NoForm%>filmRealPlay&url=${fbean.playUrl}"
		window.open(url,'mywin','channelmode=yes, location=no, scrollbars=no, status=no');
	}
</script>
<style type="text/css">
.btn-warning:hover {
    font-size: medium;
    color: #212529;
    background-color: #e0a800;
    border-color: #d39e00;
}
.media-heading {
    margin-top: 20;
    margin-bottom: 5px;
    font-size: xx-large;
}
p {
    font-size: 20;
    font-family: "Mulish", sans-serif;
    color: #3d3d3d;
    font-weight: 400;
    line-height: 25px;
    margin: 0;
}
</style>
</head>
<body>
	<jsp:include page="./../anime-main/header.jsp" />
	<div class="container">
		<div class="media">
		<br><br>
			<div class="media-left media-top col-sm-3">
			<br> <br>
				<img src="upload/${fbean.image}" class="media-object" alt="${fbean.image }"
					style="width: 180px"> <br> <br>
				<c:if test="${loginfo.subscribe==1 }">
					<c:if test="${fbean.playUrl!=null}">
						<button class="btn-lg btn-danger" onclick="filmplay()">영화보러가기</button>
					</c:if>
				</c:if>
			</div>
		
			<div class="media-body">
			<br> <br>
				<h4 class="media-heading" style="color: peachpuff">${fbean.film_title}</h4>
				<h4 class="text-white">${fbean.director}</h4>
				<h4 class="text-white">${fbean.year}</h4>
				<h4 class="text-white">${fbean.country}</h4>
				<h4 class="text-white">${fbean.avgrating}</h4>
				<h4 class="text-white">
					<c:forEach var="genre" items="${fbean.genres}">
						<c:out value="${genre}"></c:out>
					</c:forEach>
				</h4>

				<h4 class="text-white">
					배우 :
					<c:forEach var="actor" items="${fbean.actors}">
						<c:out value="${actor}"></c:out>
					</c:forEach>
				</h4>
				<div>
				<br> <br>
				<c:if test="${whologin!=0 }">
					<a href="<%=NoForm%>reviewWrite&id=${fbean.id}"><button
							type="button" class="btn-lg btn-warning">리뷰 쓰기</button></a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<c:choose>
						<c:when test="${fbean2==null}">
							<a
								href="<%=NoForm%>likeFilm&id=${fbean.id}&email=${loginfo.email}"><button
									class="btn-info btn-lg">좋아요</button></a>
						</c:when>
						<c:otherwise>
							<a
								href="<%=NoForm%>deleteLikeFilm&id=${fbean.id}&email=${loginfo.email}"><button
									class="btn-warning btn-lg">좋아요 취소</button></a>
						</c:otherwise>
					</c:choose>
				</c:if>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${whologin == 2}">
						<a href="<%=NoForm%>updateFilm&id=${fbean.id}"><button
								type="button" class="btn btn-warning">영화 수정</button></a> 
				&nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="<%=NoForm%>deleteFilm&id=${fbean.id}"><button
								type="button" class="btn btn-danger">영화 삭제</button></a>
					</c:if>

				</div>
			</div>
   
		</div>
	</div>
	 <br><br><br><br><br><br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>