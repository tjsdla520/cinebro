<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 5 ;
	int formright = twelve - formleft ;
	int rightButton = 1 ;
%> 
<!DOCTYPE html>
<html lang="zxx">
<head>
<style type="text/css">
input#content {
    font-size: x-large;
}

button.btn.btn-info.btn-lg {
    font-size: initial;
}
</style>
</head>
<body>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container" align="center">
		<div>
			<div style="margin-top: 50px">
				<h2 align="center" style="color: white">리뷰수정</h2>
			</div>
			<br>
			<br>
			<br>
			<div>
				<form name="myform" class="form-horizontal" action="<%=YesForm%>" method="post">

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="reviewEdit">
					<input type="hidden" name="id" value="${bean1.id }">
					<div class="form-group">
						<h5><label class="control-label col-sm-<%=formleft%>" for="email"
							style="color: white">리뷰 내용</label></h5>
						<div class="col-xs-3">
							<input type="text" id="content" placeholder="리뷰내용 입력" name="content" value="${bean1.content}" style="width: 400px; height: 100px">
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px">
						<h5><label class="control-label col-sm-<%=formleft%>" for="name"
							style="color: white">별점</label></h5>
						<div class="col-xs-3">
							<select name="rating" id="rating">
								<c:forEach var="i" begin="1" end="5" step="1">
									<c:if test="${i==bean1.rating}">
										<option value="${i}" selected="selected">${i}
									</c:if>
									<c:if test="${i!=bean1.rating}">
										<option value="${i}">${i}
									</c:if>
									
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group" style="margin-top: 40px">
						<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-info btn-lg">리뷰 수정</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-info btn-lg">초기화</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>