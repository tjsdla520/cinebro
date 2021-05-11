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
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container" align="center">
		<div >
			<div >
				<h4 align="center" style="color: white">카드 결제</h4>
			</div>
			<br><br><br>
			<div >
				<form name="myform" class="form-horizontal" action="<%=YesForm%>" method="post">
				   <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">이름</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="이름을 입력해주세요" >
				      	</div>  			   	  		
				    </div>	
				      <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">생년월일</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="생년월일을 입력해주세요" >
				      	</div>
				    </div>				
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">카드 번호</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="카드번호는 -를 제외하고 입력해주세요" >				        						
				      	</div>			      	
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">만료 날짜</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="만료 날짜를 입력해주세요" >
				      	</div>				      	   	
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">비밀번호</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="password" class="form-control" id="email" placeholder="비밀번호를 입력해주세요" >
				      	</div>				      	   	
				    </div>					    			  				    				    	    		    
				    <div class="form-group">        
				      	<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
				        	<button type="submit" class="btn btn-default" onclick="return checkForm();" style="background-color: red"><b>유료 멤버쉽 시작</b></button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-default" style="background-color: red"><b>초기화</b></button>				        	
				      	</div>
				    </div>
				</form>
			</div>
		</div>
	</div>	
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>