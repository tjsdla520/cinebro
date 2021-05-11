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
 <title>카드 결제 내역</title>
    <style>
        #wrap{
            margin-left:auto; 
            margin-right:auto;
            text-align:center;
        }
        
        table{
            margin-left:auto; 
            margin-right:auto;
            border:3px #080837;
        }
        
        td{
            border:1px #080837;
            color: White;
        }
        
        #title{
            background-color:#080837;
        }
    </style>
</head>

<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>


    <% 
        
        request.setCharacterEncoding("UTF-8");  
    
        String id = request.getParameter("id");
        String cardnumber = request.getParameter("cardnumber");
        String enddate = request.getParameter("enddate");
        String password = request.getParameter("password");


        
      
    %>
    
    <div id="wrap">
        <br><br>
        <b><font size="5" color="white">카드 정보를 확인하세요.</font></b>
        <br><br>
    
        
        <table>
            <tr>
                <td >아이디</td>
                <td><%=id %></td>
            </tr>
                        
            <tr>
                <td >카드번호</td>
                <td><%=cardnumber %></td>
            </tr>
                    
            <tr>
                <td>카드 만료날짜</td>
                <td><%=enddate %></td>
            </tr>
                    
            <tr>
                <td>비밀번호</td>
                <td><%=password %></td>
            </tr>
                    
            
        </table>
        
        <br>
        <input type="button" value="확인">
    </div>
    <jsp:include page="./../anime-main/footer.jsp"/>
</body>
</body>
</html>