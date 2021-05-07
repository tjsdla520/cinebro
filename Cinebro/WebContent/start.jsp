<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE><html><head></head>
<body> 	
<%
	String imsi = request.getContextPath() + "/Cinebro?command=" ; 	
	//response.sendRedirect( imsi ) ;
%>
	<a href="<%=imsi%>main">메인</a>
	2차
</body>
</html>