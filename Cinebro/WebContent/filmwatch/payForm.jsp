<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>

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
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	 <div id="wrap">
        <br><br>
        <b><font size="6" color="white">카드결제</font></b>
        <br><br><br>
        

        
        <form method="post" action="<%=YesForm%>">
           <input type="hidden" name="command" value="pay">
            <table>
                <tr>
                    <td id="title">이름</td>
                    <td>
                        <input type="text" name="id" maxlength="100" style="color: grey" placeholder="이름 입력"  >
                       
				        	
				       		
                      
                    </td>
                </tr>
                        
                <tr>
                    <td id="title">카드번호</td>
                    <td>
                        <input type="text" name="cardnumber" maxlength="100" style="color: grey" placeholder="카드번호 -제외하고 입력">
                    </td>
                </tr>
                
                <tr>
                    <td id="title">카드 만료날짜</td>
                    <td>
                        <input type="text" name="enddate" maxlength="100" style="color: grey" placeholder="만료 날짜 입력">
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">비밀번호</td>
                    <td>
                        <input type="password" name="password" maxlength="100" style="color: grey" placeholder="비밀번호 입력">
                    </td>
                </tr>
                    
               
            </table>
            <br>
            <input type="submit" value="결제"/>  <input type="button" value="취소">
        </form>
    </div>
<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>