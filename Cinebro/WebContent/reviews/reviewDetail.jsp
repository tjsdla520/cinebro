
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
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
<style>
.btn-like {
  color: transparent;
  text-shadow: 0 0 2px rgba(255,255,255,.7), 0 0 0 #000;
}
.btn-like:hover {
  text-shadow: 0 0 0 #ea0;
}
.btn-like.done {
  color: yellow;
  text-shadow: 0;
}
.btn-like.done:hover {
  color: transparent;
  text-shadow: yellow;
}

p {
    font-size: large;
}
p {
    font-size: 20;
    font-family: "Mulish", sans-serif;
    color: #3d3d3d;
    font-weight: 400;
    line-height: 25px;
    margin: 10;
}
button.btn.btn-warning {
    font-size: medium;
}
button.btn.btn-danger {
    font-size: medium;
}
</style>

</head>
<body>
	<jsp:include page="./../anime-main/header.jsp" />
	<div class="container">
		<div class="media">
			<div class="media-left media-top col-sm-3">
			<br><br>
				<img src="img/${bean1.filmTitle}.jpg" class="media-object" style="width: 180px">
			</div>
			<div class="media-body">
			<br><br>
				<h4 class="media-heading"><a  style="color: peachpuff;" href="<%=NoForm%>filmDetail&id=${bean1.filmId}&email=${loginfo.email}">${bean1.filmTitle}</a> </h4>
			     <br>
				<p></p>
				<h4 class="text-white">작성자 : <a  class="text-white" href="<%=NoForm%>myproFile&email=${bean1.email}&${requestScope.parameters}">${bean1.writer}</a></h4>
				<h4 class="text-white">리뷰 내용 : ${bean1.content}</h4>
				<h4 class="text-white">별점 : ${bean1.rating}</h4>
				<h4 class="text-white">좋아요 수 : ${bean1.getlike}</h4>
				<h4 class="text-white">작성일 : ${bean1.writeDate}</h4>
			</div>
		</div>
		<div class="col-sm-3"></div>
		<div>
			<c:if test="${whologin != 0}">
			<c:if test="${bean1.writer==sessionScope.loginfo.nickname}">
				<a href="<%=NoForm%>reviewEdit"><button type="button" class="btn btn-warning">리뷰 수정하기</button></a> 
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a style="color: white" href="<%=NoForm%>reviewDelete&id=${bean1.id}"><button type="button" class="btn btn-danger">리뷰 삭제하기</button></a> 
			</c:if>
			<c:if test="${bean1.writer!=sessionScope.loginfo.nickname}">
				<c:choose>
					<c:when test="${bean2==null}">
						<a  href="<%=NoForm%>likeReview&id=${bean1.id}&email=${loginfo.email}"><button class="btn-info btn-lg">좋아요</button></a>
					</c:when>
					<c:otherwise>
						<a href="<%=NoForm%>deletelikeReview&id=${bean2.id}&email=${loginfo.email}"><button class="btn-warning btn-lg">좋아요 취소</button></a>
					</c:otherwise>
				</c:choose>				
			</c:if>	
			</c:if>
		<script src="//code.jquery.com/jquery.min.js"></script>
 </div>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="./../anime-main/footer.jsp" />
	
</body>
</html>