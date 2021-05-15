<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
/* position for grid system */
int offset = 2;
int mywidth = twelve - 2 * offset;
int formleft = 5;
int formright = twelve - formleft;
int rightButton = 1;
%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />

		<div class="media" align="center">
			<div class="media-body">
				
				<h4 class="media-heading" style="color: white;" align="center">${bean.nickname}님의 프로필</h4>
				<br><br><br>
				<p style="color: white; margin-left: 30px">아이디 : ${bean.email}</p>
				<c:if test="${bean.nickname==sessionScope.loginfo.nickname}">
					<p style="color: white; margin-left: 30px">비밀 번호 : ${bean.password}</p>
				</c:if>
				<p style="color: white; margin-left: 30px">닉네임 : ${bean.nickname}</p>
				<c:if test="${bean.nickname==sessionScope.loginfo.nickname}">
					<c:if test="${requestScope.bean.subscribe == 1}">
						<p style="color: white; margin-left: 30px">구독 여부 : 구독중</p>
						<p style="color: white; margin-left: 30px">카드사 : ${bean.name}</p>
						<p style="color: white; margin-left: 30px">카드 번호 : ${bean.cardnumber}</p>
					</c:if>
					<c:if test="${requestScope.bean.subscribe == 0}">
						<p style="color: white; margin-left: 30px">구독 여부 : 
							<a href="<%=NoForm%>bridge">
								<button type="button" class="btn btn-warning">
									구독 하러 가기
								</button>
							</a> 
						</p>
						<p style="color: white; margin-left: 30px">카드사 : </p>
						<p style="color: white; margin-left: 30px">카드 번호 : </p>
					</c:if>
				</c:if>
				<p style="color: white; margin-left: 30px">좋아하는 영화 제목 : <a href="<%=NoForm%>filmDetail&id=${bean.film_id}">${bean.film_title}</a></p>
				<p style="color: white; margin-left: 30px">좋아하는 영화 장르 : ${bean.genre_name}</p>
				<c:if test="${bean.nickname==sessionScope.loginfo.nickname}">
					<p>
						<a href="<%=NoForm%>editNickname">
							<button type="button" class="btn btn-primary">닉네임 수정하기</button>
						</a>
					</p>
				</c:if>
				<c:if test="${bean.nickname!=sessionScope.loginfo.nickname}">
					<p>
						<!-- 팔로우 하기 버튼하나로 줄이고 한번더 클릭하면 
							c:if로 requestScope에 있는 팔로우 값을 바인딩해서 
							팔로우 취소하기로 변경하기 -->
						<a href="<%=NoForm%>memberFollow&email2=${bean.email}&email1=${sessionScope.loginfo.email}">
							<button type="button" class="btn btn-primary">팔로우 하기</button>
						</a>
						&nbsp;&nbsp;&nbsp;
						<a href="<%=NoForm%>memberFollow">
							<button type="button" class="btn btn-primary">팔로우 취소하기</button>
						</a>
					</p>
					
				</c:if>
			</div>
		</div>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>