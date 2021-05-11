<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 3 ;
	int formright = twelve - formleft ;
	int rightButton = 2 ;
%>
<!DOCTYPE html>
<html lang="zxx">
<head>
	<script>	
		function search(){
			if ($('#mode').val() == null || $('#mode').val().equals("")){
				var mode = "film";
			}
			
			/* var mode = $('#mode').val() ; */
			var keyword = $('#keyword').val() ;
			location.href='<%=NoForm%>search' + '&mode=' + mode + '&keyword=' + keyword ;
		}
		$(document).ready(function(){
		});
	</script>
	<style type="text/css">
		.badge{background: orange; color: red;}
	</style>
	
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>영화, 영화리스트, 멤버 검색</h4>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글번호</th>
							<th>작성자</th>
							<th>비밀 번호</th>							
							<th>글제목</th>
							<th>글 내용</th>
							<th>조회수</th>
							<th>작성 일자</th>
							<th>비고</th>							
							<th>수정</th>
							<th>삭제</th>
							<th>답글</th>
						</tr>
					</thead>
					<%-- <tbody>
						<tr>
							<td align="center" colspan="11">
								<form action="" class="form-inline" role="form" name="myform" method="get"> 
									<div class="form-group">
										<select id="mode" name="mode" class="form-control">
											<option value="film">영화
											<option value="filmlist">영화리스트
											<option value="member">member
										</select>
									</div>									
									<div class="form-group">
										<input type="text" class="form-control" name="keyword" id="keyword"> 
									</div>									
									&nbsp;&nbsp;
									<button class="btn btn-default" type="button" onclick="search();">검색</button>
									&nbsp;&nbsp;
									
									
									&nbsp;&nbsp;
									${pageInfo.pagingStatus}								
								</form>
							</td>
						</tr>
						<c:forEach var="bean" items="${requestScope.lists}">		
							<tr>
								<td>${bean.no}</td>
								<td>${bean.writer}</td>
								<td>${bean.password}</td>
								<td>
									<c:forEach var="cnt" begin="1" end="${bean.depth}">
										<span class="badge">RE</span>&nbsp;&nbsp;
									</c:forEach>
									
									<a href="<%=NoForm%>boDetailView&no=${bean.no}&${requestScope.parameters}">
										${bean.subject}
									</a>									
								</td>
								<td>${bean.content}</td>	
								<td>${bean.readhit}</td>
								<td>${bean.regdate}</td>
								<td>${bean.remark}</td>
								<td>
									<c:if test="${sessionScope.loginfo.id == bean.writer}">
										<a href="<%=NoForm%>boUpdate&no=${bean.no}&${requestScope.parameters}">
											수정
										</a>
									</c:if>
									<c:if test="${sessionScope.loginfo.id != bean.writer}">
										수정
									</c:if>
								</td>
								<td>
									<c:if test="${sessionScope.loginfo.id == bean.writer}">
										<a href="<%=NoForm%>boDelete&no=${bean.no}&${requestScope.parameters}">
											삭제
										</a>
									</c:if>
									<c:if test="${sessionScope.loginfo.id != bean.writer}">
										삭제
									</c:if>									
								</td>
								<td>
									<c:if test="${bean.depth < 3}">
										<c:set var="reply" value="&groupno=${bean.groupno}&orderno=${bean.orderno}&depth=${bean.depth}"/>
										<a href="<%=NoForm%>boReply&no=${bean.no}&${requestScope.parameters}${reply}">
											답글
										</a>
									</c:if>									
								</td>
							</tr>
						</c:forEach>											
					</tbody> --%>
				</table>
			</div>
			<div align="center">
				<footer>${pageInfo.pagingHtml}</footer>
			</div>
		</div>
	</div>
	<br><br><br><br>
	<script type="text/javascript">
		/* 필드 검색 상태 보존 */
		$('#mode option').each(function(){
			if($(this).val() == '${pageInfo.mode}'){
				$(this).attr('selected', 'selected') ;
			}			
		});
		
		$('#keyword').val('${pageInfo.keyword}');
	</script>
	
	
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>