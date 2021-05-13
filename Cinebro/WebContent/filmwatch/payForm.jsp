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
 <title>카드결제하기 화면</title>
    
    <style>
        #wrap{
            width:600px;
            margin-left:auto; 
            margin-right:auto;
            text-align:center;
        }
        
        table{
            margin-left:auto; 
            margin-right:auto;
            border:3px White
        }
        
        td{
            border:1px White
        }
        
        #title{
            background-color:White
        }
    </style>

</head>
<body>
	<jsp:include page="./../anime-main/header.jsp"/><div class="container" align="center">
		<div>
			<div style="margin-top: 50px">
				<h3 align="center" style="color: white">결제 정보 입력</h3>
			</div>
			<br><br><br>
			<div >
				<form name="myform" class="form-horizontal" action="<%=YesForm%>" method="post">

					<%--command 값 지정--%>
					<input type="hidden" name="command" value="pay">
					<input type="hidden" name="email" value="${sessionScope.loginfo.email }">
					
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="name" style="color: white">이름</label>
				      	<div class="col-xs-3">
				        	<input type="text" class="form-control" id="name" placeholder="카드에 명시된 이름 입력" 
				        		name="name" value="${bean.name}">
				      	</div>
				    </div>
					<div class="form-group" style="margin-top: 20px">
				      	<label class="control-label col-sm-<%=formleft%>" for="cardnumber" style="color: white">카드번호</label>
				      	<div class="col-xs-3">
				        	<input type="text" class="form-control" id="cardnumber" name="cardnumber" value="${bean.cardnumber }" placeholder="카드번호 -제외하고 16자리 입력">
				      	</div>
				    </div>				    
				    <div class="form-group" style="margin-top: 20px">
						<label class="control-label col-sm-<%=formleft%>" for="cardpassword" style="color: white">카드비밀번호</label>
				      	<div class="col-xs-3">          
				        	<input type="password" class="form-control" id="cardpassword" placeholder="월년도 숫자만 입력" name="cardpassword" >
				      	</div>
				    </div>	
				    <div class="form-group" style="margin-top: 20px">
						<label class="control-label col-sm-<%=formleft%>" for="enddate" style="color: white">카드만료일</label>
				      	<div class="col-xs-3">          
				        	<input type="password" class="form-control" id="enddate" placeholder="카드비밀번호 입력" name="enddate" >
				      	</div>
				    </div>				    		    
				    <div class="form-group" style="margin-top: 40px">        
				      	<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
				        	<button type="submit" class="btn btn-info btn-lg" >결제하기</button>
				        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-info btn-lg" >초기화</button>				        	
				      	</div>
				    </div>
				</form>
			</div>
		</div>
	</div>	
<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>