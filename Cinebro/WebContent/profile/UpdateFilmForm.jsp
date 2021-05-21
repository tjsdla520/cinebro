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
input#film_title {
    font-size: initial;
}
input#image {
    font-size: initial;
}
input#director {
    font-size: initial;
}
input#country {
    font-size: initial;
}
input#year {
    font-size: initial;
}
input#playUrl {
    font-size: initial;
}
button.btn.btn-info.btn-lg {
    font-size: initial;
}
</style>
<script type="text/javascript">
function actorfind(num){
	switch (num){
	case '1':
		var url = "<%=NoForm%>searchforactor&num=1";
		window.open(url,'mywin','height=600, width=720, scrollbars=yes');
		break;
	case '2':
		var url = "<%=NoForm%>searchforactor&num=2";
		window.open(url,'mywin','height=600, width=720, scrollbars=yes');
		break;
	
	}
	
}

function actorfind3(){
	var url = "<%=NoForm%>searchforactor&num=1";
	window.open(url,'mywin','height=600, width=720, scrollbars=yes');
}

function actorfind2(){
	var url = "<%=NoForm%>searchforactor&num=2";
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
				<h2 align="center" style="color: white">영화 정보 수정</h2>
			</div>
			<br>
			<br>
			<br>
			<div>
				<form name="myform" class="form-horizontal" action="<%=YesForm%>"
					method="post" enctype="multipart/form-data">

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="updateFilm">
					<input type="hidden" name="id" value="${fbean.id }">
					
					<%--isCheck 변수. 값이 false이면 영화등록이 안된다. 모든 체크를 통과했을 경우에만 true로 변경 --%>

					<div class="form-group">
						<h5><label class="control-label col-sm-<%=formleft%>" for="film_title"
							style="color: white">영화 제목</label></h5>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="film_title"
								placeholder="영화제목을 입력해주세요" name="film_title"
								value="${fbean.film_title}">
							<span class="err form-control-static">${errfilm_title}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<h5><label class="control-label col-sm-<%=formleft%>" for="image"
							style="color: white">포스터</label></h5>
						<div class="col-xs-3">
							<input type="file" class="form-control" id="image"
								name="image" value="${fbean.image}">
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<h5><label class="control-label col-sm-<%=formleft%>" for="director"
							style="color: white">감독명</label></h5>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="director"
								name="director" value="${fbean.director}"
								placeholder="감독 이름을 입력해주세요">
							<span class="err form-control-static">${errdirector}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<h5><label class="control-label col-sm-<%=formleft%>" for="year"
							style="color: white">개봉 연도</label></h5>
						<div class="col-xs-3">
							<input type="number" class="form-control" id="year" name="year"
								value="${fbean.year}" placeholder="개봉연도를 입력해주세요">
							<span class="err form-control-static">${erryear}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<h5><label class="control-label col-sm-<%=formleft%>" for="country"
							style="color: white">개봉 국가</label></h5>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="country"
								name="country" value="${fbean.country}" placeholder="국가를 입력해주세요">
							<span class="err form-control-static">${errcountry}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<h5><label class="control-label col-sm-<%=formleft%>" for="playUrl"
							style="color: white">영화 주소</label></h5>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="playUrl"
								name="playUrl" value="${fbean.playUrl}" 
								placeholder="영화 주소를 입력해주세요">
							<span class="err form-control-static">${errplayUrl}</span>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<h5><label class="control-label col-sm-<%=formleft%>" for="genre"
							style="color: white">영화 장르</label></h5>
						<div class="col-xs-3">
							<select id="genre" name="genre">
								<option value="1">가족
								<option value="2">공연
								<option value="3">공포(호러)
								<option value="4">다큐멘터리
								<option value="5">드라마
								<option value="6">멜로/로맨스
								<option value="7">뮤지컬
								<option value="8">미스터리
								<option value="9">범죄
								<option value="10">사극
								<option value="11">서부극(웨스턴)
								<option value="12">스릴러
								<option value="13">애니메이션
								<option value="14">액션
								<option value="15">어드벤처
								<option value="16">전쟁
								<option value="17">코미디
								<option value="18">판타지
								<option value="19">SF
							</select>
						</div>
						</div>
						 <span class="err form-control-static">${errgenre}</span>
						 <c:if test="${actorsize==0}">
							<div class="form-group" style="margin-top: 20px">
							<h5>
								<label class="control-label col-sm-<%=formleft%>"
									for="actorname1" style="color: white">영화 배우</label>
							</h5>
							<div class="col-xs-3">
								<input type="text" class="form-control" disabled="disabled"
									id="fakeactorname1" name="fakeactorname1"> <input
									type="hidden" name="actorname1"> <input type="hidden"
									name="actorid1">
							</div>
							<div class="col-sm-<%=rightButton%>">
								<input type="button" value="배우 검색" class="btn btn-info"
									onclick="actorfind3()">
							</div>
							</div>
							<div class="form-group" style="margin-top: 20px">
							<h5>
								<label class="control-label col-sm-<%=formleft%>"
									for="actorname2" style="color: white">영화 배우</label>
							</h5>
							<div class="col-xs-3">
								<input type="text" class="form-control" disabled="disabled"
									id="fakeactorname2" name="fakeactorname2"> <input
									type="hidden" name="actorname2"> <input type="hidden"
									name="actorid2">
							</div>
							<div class="col-sm-<%=rightButton%>">
								<input type="button" value="배우 검색" class="btn btn-info"
									onclick="actorfind2()">
							</div>	
							</div>			 
						 </c:if>
						 <c:forEach var="entry" items="${fbean.actors}" varStatus="status">
						<div class="form-group" style="margin-top: 20px">
							<h5>
								<label class="control-label col-sm-<%=formleft%>"
									for="actorname1" style="color: white">영화 배우</label>
							</h5>
							<div class="col-xs-3">
								<input type="text" class="form-control" disabled="disabled"
									id="fakeactorname1" name="fakeactorname${status.count }" value="${entry.value}"> 
								<input type="hidden" name="actorname${status.count }" value="${entry.value}"> 
								<input type="hidden" name="actorid${status.count }" value="${entry.key }">
							</div>
							<div class="col-sm-<%=rightButton%>">
								<input type="button" value="배우 검색" class="btn btn-info"
									onclick="actorfind('${status.count}');">
							</div>
						</div>
						</c:forEach>
					<div class="form-group" style="margin-top: 40px">
						<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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