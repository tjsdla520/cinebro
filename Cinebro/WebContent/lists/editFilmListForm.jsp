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

input#filmilst_title {
    font-size: initial;
}
button.btn.btn-info.btn-lg {
    font-size: initial;
}
input#comments {
    font-size: initial;
}
.badge {
	background: orange;
	color: red
}
</style>
<script type="text/javascript">
function filmfind(){
	var url = "<%=NoForm%>searchforlist&num=1";
	window.open(url,'mywin','height=600, width=720, scrollbars=yes');
}
function filmfind2(){
	var url = "<%=NoForm%>searchforlist&num=2";
	window.open(url,'mywin','height=600, width=720, scrollbars=yes');
}
function filmfind3(){
	var url = "<%=NoForm%>searchforlist&num=3";
	window.open(url,'mywin','height=600, width=720, scrollbars=yes');
}
function filmfind4(){
	var url = "<%=NoForm%>searchforlist&num=4";
	window.open(url,'mywin','height=600, width=720, scrollbars=yes');
}
function filmfind5(){
	var url = "<%=NoForm%>searchforlist&num=5";
	window.open(url,'mywin','height=600, width=720, scrollbars=yes');
}
</script>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />

	<div class="container" align="center">
		<div>
			<div style="margin-top: 50px">
				<h2 align="center" style="color: white">FilmList 만들기</h2>
			</div>
			<br>
			<br>
			<br>
			<div>
				<form name="myform" class="form-horizontal" action="<%=YesForm%>"
					method="post">

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="editFilmList">
					<input type="hidden" name="id" value="${bean1.id}">
					
					<%--isCheck 변수. 값이 false이면 영화등록이 안된다. 모든 체크를 통과했을 경우에만 true로 변경 --%>

					<div class="form-group">
						<h5><label class="control-label col-sm-<%=formleft%>" for="film_title"
							style="color: white">FilmList 제목</label></h5>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="filmilst_title"
								placeholder="FilmList 제목을 입력해주세요" name="filmlist_title" value="${bean1.list_title}">
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<h5><label class="control-label col-sm-<%=formleft%>" for="comments"
							style="color: white">FilmList 설명</label></h5>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="comments"
								name="comments" placeholder="설명을 입력해주세요" value="${bean1.comments }">
						</div>
					</div>
					<c:forEach var="entry" items="${bean1.film_title }" varStatus="status">
					<div class="form-group" style="margin-top: 20px">					
						<h5><label class="control-label col-sm-<%=formleft%>" for="playUrl"
							style="color: white">담을 영화	</label></h5>
						<div class="col-xs-3">
							<input type="text" class="form-control" disabled="disabled" id="fakefilmtitle${status.count}" name="fakefilmtitle${status.count}" value="${entry.value }">
							<input type="hidden" name="filmtitle${status.count}" value="${entry.value }">
							<input type="hidden" name="filmid${status.count}" value="${entry.key }">
						</div>
						<div class="col-sm-<%=rightButton%>">
				        	<input type="button" value="영화 검색" class="btn btn-info"
				        		onclick="filmfind();">
				      	</div>
					</div>
					</c:forEach>
					<div class="form-group" style="margin-top: 40px">
						<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-info btn-lg">FilmList 수정하기</button>
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