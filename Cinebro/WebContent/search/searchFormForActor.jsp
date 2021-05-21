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
			var num = $('#num').val();
			alert(mode+'/'+keyword);
			
			if(mode=='none'){
				alert("검색 영역을 선택해 주세요");
				return false;
			}else if(keyword==""){
				alert("검색어를 입력하시오")	
				return false;
			}else{
				location.href='<%=NoForm%>searchforactor&mode='+ mode +'&keyword='+keyword+'&num='+num;
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

form.form-inline input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 650%;
  background: #f1f1f1;
}

form.form-inline button {
  float: left;
  width: 10%;
  padding: 5px;
  background: #138496;;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.form-inline button:hover {
  background: #0b7dda;
}

form.form-inline::after {
  content: "";
  clear: both;
  display: table;
}
button, input, optgroup, select, textarea {
    margin: 0;
    font-family: inherit;
    font-size: xx-large;
    line-height: inherit;
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
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<select id="mode" name="mode" class="form-inline" >
					<option value="name">배우명
				</select>
			</div>
			<div class="form-group" >
				<input type="text" class="form-control" name="keyword" id="keyword"  >
				<input type="hidden" class="form=control" name="num" id="num" value="${requestScope.num }">
			</div>			
			<button class="btn btn-info" type="button" onclick="return search();" >검색</button> 			
		</form>
	</div>	
</body>
</html>