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
	<jsp:include page="./../anime-main/header.jsp"/>

    
    <div id="wrap">
        <br><br>
        <b><font size="5" color="white">카드 정보를 확인하세요.</font></b>
        <br><br>

        <table>
            <tr>
                <td >이름</td>
                <td>${bean.name }</td>
            </tr>
                        
            <tr>
                <td >카드번호</td>
                <td>${bean.cardnumber }</td>
            </tr>
                    
            <tr>
                <td>카드 만료일</td>
                <td>${bean.enddate}</td>
            </tr>    
        </table>
        
        <br>
        <button onclick="location.href='<%=NoForm%>filmPlay'">영화보러가기</button >
        <input type="button" value="뒤로가기" onclick="history.back(-1);">
    </div>
    <jsp:include page="./../anime-main/footer.jsp"/>
</body>
</body>
</html>