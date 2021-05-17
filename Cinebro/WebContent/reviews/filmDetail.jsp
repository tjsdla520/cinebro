
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
		window.open(url,'mywin','channelmode=yes, location=no, scrollbars=no, status=no, top=50, left=10');
	}
</script>
</head>
<body>
		<jsp:include page="./../anime-main/header.jsp" />

		<div class="media">
			<div class="media-left media-top col-sm-3">
				<img src="img/${fbean.film_title}.jpg" class="media-object" style="width: 180px">
				<br><br>
				<c:if test="${fbean.playUrl!=null}">
					<button class="btn-lg btn-danger" onclick="filmplay()">영화보러가기</button>
				</c:if>
			</div>
			<div class="media-body">
				<h4 class="media-heading" style="color: white">${fbean.film_title}</h4>
				<p style="color: white; " >${fbean.director}</p>
				<p style="color: white; ">${fbean.year}</p>
				<p style="color: white; ">${fbean.country}</p>
				<p style="color: white; ">${fbean.avgrating}</p>
				<p style="color: white; ">
				<c:forEach var="genre" items="${fbean.genres}">
					<c:out value="${genre}"></c:out>
				</c:forEach>
				</p>
				
				<p style="color: white; "> 배우 :
					<c:forEach var="actor" items="${fbean.actors}">
						<c:out value="${actor}"></c:out>
					</c:forEach>
				</p>
			<div>
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

				<script src="//code.jquery.com/jquery.min.js"></script>

			</div>
		</div>

		</div>

	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>