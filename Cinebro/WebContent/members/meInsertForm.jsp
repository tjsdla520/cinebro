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
<style type="text/css">
.panel h4{color: navy}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>

	<div class="container" align="center">
		<div >
			<div >
				<h4 align="center" style="color: white">회원 가입</h4>
			</div>
			<br><br><br>
			<div >
				<form name="myform" class="form-horizontal" action="<%=YesForm%>" method="post">

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="meInsert">
					
					<%--isCheck 변수. 값이 false이면 회원가입이 안된다. 아이디 중복체크를 통과했을 경우에만 true로 변경 --%>
					<input type="hidden" name="isCheck" value="false">
					
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email" style="color: white">이메일</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="email" placeholder="이메일 입력" 
				        		name="email" onkeyup="isCheckFalse();" value="${bean.email}">
				      		<span class="err">${erremail}</span>
				      	</div>
				      	<div class="col-sm-<%=rightButton%>">
				        	<input type="button" value="중복 체크" 
				        		class="btn btn-info" onclick="idCheck();"> 
				      	</div>
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="name" style="color: white">닉네임</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="nickname" name="nickname" value="${bean.nickname }" placeholder="닉네임을 넣어 주세요.">
				        	<span class="err">${errnickname }</span>
				      	</div>
				      	   	<div class="col-sm-<%=rightButton%>">
				        	<input type="button" value="중복 체크" 
				        		class="btn btn-info" onclick="idCheck();"> 
				      	</div>
				    </div>				    
				    <div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="password" style="color: white">비밀 번호</label>
				      	<div class="col-sm-<%=formright-rightButton%>">          
				        	<input type="password" class="form-control" id="password" placeholder="비밀 번호를 넣어 주세요." name="password" >
				        	<span class="err">${errpassword }</span>
				      	</div>
				    </div>				    		    
				    <div class="form-group">        
				      	<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
				        	<button type="submit" class="btn btn-default" onclick="return checkForm();" style="background-color: white">회원 가입</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-default" style="background-color: white">초기화</button>				        	
				      	</div>
				    </div>
				</form>
			</div>
		</div>
	</div>	
	
	<br><br><br><br>
	<%--<jsp:include page="./../anime-main/footer.jsp"/> --%>
		
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>