<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<jsp:include page="./../anime-main/header.jsp" />

	<div class="panel-heading" align="center"></div>
	<div class="panel-body" align="center">
		<section>
			<h3>
				<a href="<%=NoForm%>reviewDetail&id=${bean.id}">영화제목 :
					${bean.filmTitle}</a>
			</h3>
			<p style="color: white">작성자 : ${bean.writer}</p>
			<p style="color: white">리뷰 내용 : ${bean.content}</p>
			<p style="color: white">별점 : ${bean.rating}점</p>
			<p style="color: white">좋아요 수 : ${bean.getlike}</p>
			<p style="color: white">작성일자 : ${bean.writeDate}</p>

			<c:if test="${bean.writer==sessionScope.loginfo.nickname}">
				<a href="<%=NoForm%>reviewEdit&id=${bean.id}"><button type="button">리뷰 수정하기</button></a> 
				<a href="<%=NoForm%>reviewDelete&bean=${bean}"><button type="button">리뷰 삭제하기</button></a> 
			</c:if>
			<a href="<%=NoForm%>likereView&bean=${bean}"><button type="button">좋아요</button></a>
		</section>
	</div>

	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>