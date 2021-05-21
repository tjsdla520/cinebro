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
<!--  <title>카드 결제 내역</title>
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
    </style> -->
      <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.panel-default>.panel-heading {
    color: #333;
    font-size: xx-large;
    background-color: #f5f5f5;
    border-color: #ddd;
}

element.style {
    color: black;
    FONT-SIZE: x-large;
}

.panel-body {
    font-size: large;
    padding: 15px;
}
.panel-default {
    margin: 0 auto; 
    border-color: #ddd;
    max-width: 500px;
}
button.btn.btn-primary {
    font-size: large;
}



.panel-default>.panel-heading {
    color: black;
    font-size: x-large;
    background-color: #f5f5f5;
    border-color: #ddd;
}


input[type="button"] {
    font-size: large;
     align-items: center;
    color: #fff;
    background-color: #138496;
    border-color: #117a8b;
}


[type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
    font-size: large;
    cursor: pointer;
    color: #fff;
    background-color: #138496;
    border-color: #117a8b;
}
</style>
</head>

<body>
	<jsp:include page="./../anime-main/header.jsp"/>
<div class="container">
  <div class="panel panel-default">
    <div class="panel-heading" style="color: black;" align="center">카드 정보를 확인하세요.</div>
    <div class="panel-body" style="color: black;" align="center" >이름 : ${bean.name}</div>
    <div class="panel-body" style="color: black;" align="center">카드번호 : ${bean.cardnumber}</div>
    <div class="panel-body" style="color: black;" align="center">카드만료일 : ${bean.enddate}</div>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <div class="panel-body" style="color: black;" align="center"><button  onclick="location.href='<%=NoForm%>filmPlay'">영화보러가기</button >
        <input type="button" value="뒤로가기" onclick="history.back(-1);"></div>
  </div>   
</div>     
  <%--   <div id="wrap">
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
    </div> --%>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <jsp:include page="./../anime-main/footer.jsp"/>
</body>
</body>
</html>