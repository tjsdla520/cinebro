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
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>	
	function search(){
		var mode = $('#mode').val();
		var keyword = $('#keyword').val();
		alert(mode+'/'+keyword);
		
		if(mode=='none'){
			alert("검색 영역을 선택해 주세요");
			return false;
		}else if(keyword==""){
			alert("검색어를 입력하시오")	
			return false;
		}else{
			location.href='<%=NoForm%>search&mode='+ mode +'&keyword='+keyword;
		}		
	}
		
		$(document).ready(function(){
			
		});
	</script>
	<style type="text/css">
		.badge{background: orange; color: red}
	</style>
</head>
<body>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container">
		<div class="panel panel-white">
		 <p class="bg-danger text-white"><b>상세검색</b><p>
			<div class="panel-heading">

				<form action="" class="form-inline" role="form" name="myform"
					method="get">
					<div class="form-group">
						<select id="mode" name="mode" class="form-control">
							<option value="none" selected="selected">-- 선택하세요.
							<option value="film_title">영화
							<option value="list_title">리스트
							<option value="nickname">회원명
							<option value="name">배우명
						</select>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="keyword"
							id="keyword">
					</div>
					&nbsp;&nbsp;
					<button class="btn btn-info" type="button"
						onclick="return search();">검색</button>
					&nbsp;&nbsp; ${pageInfo.pagingStatus}
				</form>

			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>이름</th>						
						</tr>
					</thead>
					<tbody>

						<c:forEach var="bean" items="${requestScope.lists }">
							<tr>
								
								<td>
									<%--글제목 하이퍼링크 만들기 일반적으로 넘겨줘야 할 파라미터 목록은 다음과 같다. primarykey, pagenumber, mode, keyword--%>
									<a href="<%=NoForm%>actorDetail&id=${bean.id}&${requestScope.parameters}">${bean.name}</a>
								</td>
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