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
				<p style="color: white; margin-left: 30px">비밀 번호 : ${bean.password}</p>
				<p style="color: white; margin-left: 30px">닉네임 : ${bean.nickname}</p>
				<p>
					<a href="<%=NoForm%>editNickname">
						<button type="button" class="btn btn-primary">닉네임 수정하기</button>
					</a>
				</p>
			</div>
		</div>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>