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
			var mode = $('#mode').val();
			var keyword = $('#keyword').val();
			alert(mode+'/'+keyword);
			location.href='<%=NoForm%>boList'+'&mode='+ mode +'&keyword='+keyword; <%--boardlistcontroller의 doget으로 간다. --%>
		}
		function searchAll(){
			location.href='<%=NoForm%>boList' //location 객체 : href로 이동하려고 할 때
		}
		function writeForm(){
			location.href='<%=NoForm%>boInsert';
		}
		
		$(document).ready(function(){
			
		});
	</script>
	<style type="text/css">
		.badge{background: orange; color: red}
	</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>상세검색</h4>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>제목</th>
							<th>감독</th>
							<th>개봉연도</th>							
							<th>국가</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center" colspan="11">
								<form action="" class="form-inline" role="form" name="myform" method="get"> 
									<div class="form-group">
										<select id="mode" name="mode" class="form-control">
											<option value="film_title" selected="selected">-- 선택하세요.
											<option value="film_title">영화
											<option value="lists">리스트
											<option value="members">회원명
										</select>
									</div>									
									<div class="form-group">
										<input type="text" class="form-control" name="keyword" id="keyword"> 
									</div>									
									&nbsp;&nbsp;
									<button class="btn btn-default" type="button" onclick="search();">검색</button>										
									&nbsp;&nbsp;
									${pageInfo.pagingStatus}					
								</form>
							</td>
						</tr>		
						<c:forEach var="bean" items="${requestScope.lists }">
							<tr>
								
								<td>
									${bean.film_title}
									<%--글제목 하이퍼링크 만들기 일반적으로 넘겨줘야 할 파라미터 목록은 다음과 같다. primarykey, pagenumber, mode, keyword--%>
									<%-- <a href="<%=NoForm%>boDetailView&no=${bean.no}&${requestScope.parameters}">${bean.title}</a>--%>
								</td>
								<td>${bean.director}</td>	
								<td>${bean.year}</td>
								<td>${bean.country}</td>
							</tr>
						</c:forEach>												
					</tbody>
				</table>
			</div>
			<div align="center">
				<footer>${pageInfo.pagingHtml}</footer>
			</div>
		</div>		
	</div>
	<br><br><br><br>
	<script type="text/javascript">
		//필드 검색 상태 보존하기 위해
		$('#mode option').each(function(){
			if($(this).val()=='${pageInfo.mode}'){
				$(this).attr('selected','selected'); //selected 속성을 부여
			}
		});
		
		$('#keyword').val('${pageInfo.keyword}');
	</script>
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>