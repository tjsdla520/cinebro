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
#wrapper{
   width:500px;
   margin: auto;
 
}

</style>
</head>
<body>
	<div id="wrapper">
		<form action="" class="form-inline" role="form" name="myform" 
			method="get">
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<img src="<%=contextPath%>/img/logo.png" alt="">
			<div class="form-group">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<select id="mode" name="mode" class="form-control" >
					<option value="none" selected="selected">-- 선택하세요.
					<option value="film_title">영화
					<option value="list_title">리스트
					<option value="nickname">멤버
				</select>
			</div>
			<div class="form-group" >
				<input type="text" class="form-control" name="keyword" id="keyword"  maxlength = 255  >
			</div>
			&nbsp;&nbsp;
			<button class="btn btn-info" type="button" onclick="return search();" >검색</button> 
			&nbsp;&nbsp;
		</form>
	</div>	
</body>
</html>