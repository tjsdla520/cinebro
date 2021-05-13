<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<jsp:include page="./../anime-main/header.jsp" />

		<div class="media">
			<div class="media-left media-top">
				<img src="img/${bean.filmTitle}.jpg" class="media-object" style="width: 180px">
			</div>
			<div class="media-body">
				<h4 class="media-heading"><a href="<%=NoForm%>reviewDetail&id=${bean.id}">${bean.filmTitle}</a> </h4>
				<p></p>
				<p style="color: white; margin-left: 30px" >작성자 : ${bean.writer}</p>
				<p style="color: white; margin-left: 30px">리뷰 내용 : ${bean.content}</p>
				<p style="color: white; margin-left: 30px">별점 : ${bean.rating}</p>
				<p style="color: white; margin-left: 30px">좋아요 수 : ${bean.getlike}</p>
				<p style="color: white; margin-left: 30px">작성일 : ${bean.writeDate}</p>
			</div>
		</div>

			<c:if test="${bean.writer==sessionScope.loginfo.nickname}">
				<a href="<%=NoForm%>reviewEdit"><button type="button" class="btn btn-warning">리뷰 수정하기</button></a> 
				<a href="<%=NoForm%>reviewDelete&id=${bean.id}"><button type="button" class="btn btn-danger">리뷰 삭제하기</button></a> 
			</c:if>
			<c:if test="${bean.writer!=sessionScope.loginfo.nickname}">
				<a href="<%=NoForm%>likereView&bean=${bean}"><button type="button" class="btn btn-primary">좋아요</button></a>
			</c:if>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>