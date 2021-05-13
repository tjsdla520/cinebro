
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
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
</style>

</head>
<body>
	<jsp:include page="./../anime-main/header.jsp" />

		<div class="media">
			<div class="media-left media-top col-sm-3">
				<img src="img/${bean.filmTitle}.jpg" class="media-object" style="width: 180px">
			</div>
			<div class="media-body">
				<h4 class="media-heading"><a href="<%=NoForm%>filmDetail&id=${bean.filmId}">${bean.filmTitle}</a> </h4>
				<p></p>
				<p style="color: white; " >작성자 : ${bean.writer}</p>
				<p style="color: white; ">리뷰 내용 : ${bean.content}</p>
				<p style="color: white; ">별점 : ${bean.rating}</p>
				<p style="color: white; ">좋아요 수 : ${bean.getlike}</p>
				<p style="color: white; ">작성일 : ${bean.writeDate}</p>
			</div>
		</div>
		<div class="col-sm-3"></div>
		<div>
			<c:if test="${bean.writer==sessionScope.loginfo.nickname}">
				<a href="<%=NoForm%>reviewEdit"><button type="button" class="btn btn-warning">리뷰 수정하기</button></a> 
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=NoForm%>reviewDelete&id=${bean.id}"><button type="button" class="btn btn-danger">리뷰 삭제하기</button></a> 
			</c:if>
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