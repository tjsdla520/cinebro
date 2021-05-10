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

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="meInsert">
					
					<%--isCheck 변수. 값이 false이면 회원가입이 안된다. 아이디 중복체크를 통과했을 경우에만 true로 변경 --%>
					<input type="hidden" name="isCheck" value="false">
					
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">카드 번호</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="카드번호를 입력해주세요" >
				        		
				      		<span class="err">${errcard}</span>
				      	</div>
				      	
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">만료 날짜</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="만료 날짜를 입력해주세요" >
				        		
				      		<span class="err">${errcard}</span>
				      	</div>
				      	   	
				    </div>				    
				   <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">생년월일</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="생년월일을 입력해주세요" >
				        		
				      		<span class="err">${errcard}</span>
				      	</div>
				    </div>	  	
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">이름</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="이름을 입력해주세요" >
				        		
				      		<span class="err">${errcard}</span>
				      	</div>  
				   	  		
				    </div>		    		    
				    <div class="form-group">        
				      	<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
				        	<button type="submit" class="btn btn-default" onclick="return checkForm();" style="background-color: red">유료 멤버쉽 시작</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-default" style="background-color: red">초기화</button>				        	
				      	</div>
				    </div>
				</form>
			</div>
		</div>
	</div>	
	
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>