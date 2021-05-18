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
<script type="text/javascript">
function filmfind(){
	var url = "<%=NoForm%>searchforlist&num=1";
		window.open(url, 'mywin', 'height=600, width=720, scrollbars=yes');
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
				<h4 align="center" style="color: white">회원 정보 수정</h4>
			</div>
			<br> <br> <br>
			<form name="myform" class="form-horizontal" action="<%=YesForm%>"
				method="post">

				<%--command 값 지정--%>
				<input type="hidden" name="command" value="editNickname"> 
				<input type="hidden" name="email" value="${requestScope.bean.email}">
				<div class="form-group">
					<label class="control-label col-sm-<%=formleft%>" for="email"
						style="color: white">변경할 닉네임</label>
					<div class="col-xs-3">
						<input type="text" id="nickname" placeholder="변경할 닉네임 입력하세요"
							name="nickname" value="${bean.nickname}"
							style="width: 100px; height: 25px">
						<span class="err">${errnickname }</span>
					</div>
				</div>
				
				<div class="form-group" style="margin-top: 20px">
					<label class="control-label col-sm-<%=formleft%>" for="filmtitle1"
						style="color: white">좋아하는 영화 제목</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" 
							disabled="disabled" placeholder="영화를 검색하세요"
							id="fakefilmtitle1" name="fakefilmtitle1" value="${bean.film_title }"> 
						<input type="hidden" name="filmtitle1"> 
						<input type="hidden" name="filmid1" value="${bean.film_id }">
					</div>
					<div class="col-sm-<%=rightButton%>">
						<input type="button" value="영화 검색" 
							class="btn btn-info" onclick="filmfind();">
					</div>
				</div>

				<div>
					<div class="form-group" style="margin-top: 20px">
						<label class="control-label col-sm-<%=formleft%>" for="genre"
							style="color: white">좋아하는 영화 장르</label>
						<div class="col-xs-3">
							<select id="genre" name="genre" >
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
				</div>

				<div class="form-group" style="margin-top: 40px">
					<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
						<button type="submit" class="btn btn-info btn-lg">닉네임 수정</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="reset" class="btn btn-info btn-lg">초기화</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>