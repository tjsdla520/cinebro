<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 2 ;
	int formright = twelve - formleft ;
	int rightButton = 3 ;
%>    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">

	//이메일 중복 검사에 실패해서 다시 이메일을 치면 ischeck 변수를 false로 바꿔주는 함수
	function isCheckFalse(){
		document.myform.isCheck.value = false;
	}
	
	//이메일 중복체크
	function emailCheck(){
		var id = document.myform.id.value;
		
		<%-- 이메일관련 정규식표현생각. @가 필수로 들어가야 한다 등등
		if(id.length < 4){
			alert('아이디 최소 4자리 이상');
			document.myform.id.focus();
			return false;
		} --%>
		
		var url = "<%=noForm%>meIdcheck&id="+ id;
		window.open(url,'mywin','height=150, width=300');
	}
	
	function checkForm(){
		var isCheck = document.myform.isCheck.value;
		if(isCheck=="false"){
			alert('이메일 중복 체크를 하시오');
			return false;
		}
	}
</script>
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 align="center">회원 가입</h4>
			</div>
			<div class="panel-body">
				<form name="myform" class="form-horizontal" action="<%=yesForm%>" method="post">

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="meInsert">
					
					<%--isCheck 변수. 값이 false이면 회원가입이 안된다. 아이디 중복체크를 통과했을 경우에만 true로 변경 --%>
					<input type="hidden" name="isCheck" value="false">
					
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="email">이메일</label>
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
				      	<label class="control-label col-sm-<%=formleft%>" for="name">닉네임</label>
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" id="nickname" name="nickname" value="${bean.nickname }">
				        	<span class="err">${errnickname }</span>
				      	</div>
				      	   	<div class="col-sm-<%=rightButton%>">
				        	<input type="button" value="중복 체크" 
				        		class="btn btn-info" onclick="idCheck();"> 
				      	</div>
				    </div>				    
				    <div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="password">비밀 번호</label>
				      	<div class="col-sm-<%=formright-rightButton%>">          
				        	<input type="password" class="form-control" id="password" placeholder="비밀 번호를 넣어 주세요." name="password" >
				        	<span class="err">${errpassword }</span>
				      	</div>
				    </div>				    		    
				    <div class="form-group">        
				      	<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
				        	<button type="submit" class="btn btn-default" onclick="return checkForm();">회원 가입</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-default">초기화</button>				        	
				      	</div>
				    </div>
				</form>
			</div>
		</div>
	</div>	
</body>
</html>