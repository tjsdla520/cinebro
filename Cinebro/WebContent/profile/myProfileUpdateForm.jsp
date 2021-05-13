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

		<div class="container" align="center">
		<div>
			<div style="margin-top: 50px">
				<h4 align="center" style="color: white">닉네임수정</h4>
			</div>
			<br>
			<br>
			<br>
			<div>
				<form name="myform" class="form-horizontal" action="<%=YesForm%>" method="post">

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="editNickname">
					<input type="hidden" name="email" value="${bean.email }">
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="email"
							style="color: white">변경할 닉네임</label>
						<div class="col-xs-3">
							<input type="text" id="nickname" placeholder="변경할 닉네임 입력" name="nickname" value="${bean.nickname}" style="width: 100px; height: 25px">
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
	</div>

	<jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>