<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>

</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container">				
					   <div class="panel-body">
			
				<table class="table table-hover">
					<thead>
						<tr>
							<th><p class="text-white"><b>영화이름</b></p></th>				
							<th><p class="text-white"><b>장르</b></p></th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach var="bean1" items="${requestScope.films}">
						<tr>
							<td><span style="color:white">${bean1.film_title}'</span> </td>
							<td><span style="color:white">${bean1.name}</span> </td>
				
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			 <br><br><br>				   
					</div>
	
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>