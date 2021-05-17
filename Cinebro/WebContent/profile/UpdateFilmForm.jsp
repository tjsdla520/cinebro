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
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.badge {
	background: orange;
	color: red
}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />

	<div class="container" align="center">
		<div>
			<div style="margin-top: 50px">
				<h4 align="center" style="color: white">영화 정보 수정</h4>
			</div>
			<br>
			<br>
			<br>
			<div>
				<form name="myform" class="form-horizontal" action="<%=YesForm%>"
					method="post" enctype="multipart/form-data">

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="updateFilm">
					
					<%--isCheck 변수. 값이 false이면 영화등록이 안된다. 모든 체크를 통과했을 경우에만 true로 변경 --%>

					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="film_title"
							style="color: white">영화 제목</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="film_title"
								placeholder="영화제목을 입력해주세요" name="film_title"
								value="${bean.film_title}">
							<span class="err form-control-static">${errfilm_title}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<label class="control-label col-sm-<%=formleft%>" for="image"
							style="color: white">포스터</label>
						<div class="col-xs-3">
							<input type="file" class="form-control" id="image"
								name="image" value="${bean.image}">
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<label class="control-label col-sm-<%=formleft%>" for="director"
							style="color: white">감독명</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="director"
								name="director" value="${bean.director}"
								placeholder="감독 이름을 입력해주세요">
							<span class="err form-control-static">${errdirector}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<label class="control-label col-sm-<%=formleft%>" for="year"
							style="color: white">개봉 연도</label>
						<div class="col-xs-3">
							<input type="number" class="form-control" id="year" name="year"
								value="${bean.year}" placeholder="개봉연도를 입력해주세요">
							<span class="err form-control-static">${erryear}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<label class="control-label col-sm-<%=formleft%>" for="country"
							style="color: white">개봉 국가</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="country"
								name="country" value="${bean.country}" placeholder="국가를 입력해주세요">
							<span class="err form-control-static">${errcountry}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<label class="control-label col-sm-<%=formleft%>" for="playUrl"
							style="color: white">영화 주소</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="playUrl"
								name="playUrl" value="${bean.playUrl}" 
								placeholder="영화 주소를 입력해주세요">
							<span class="err form-control-static">${errplayUrl}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 40px">
						<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
							<button type="submit" class="btn btn-info btn-lg">영화 수정 하기</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-info btn-lg">초기화</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>