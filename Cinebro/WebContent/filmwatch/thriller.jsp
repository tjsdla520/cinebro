<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.dropbtn {
  background-color: red;
  color: white;
  padding: 10px;
  font-size:20px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: red;}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp"/>
	<div class="container">							
		<div class="dropdown">
		  <button class="dropbtn"><b>장르별 보러가기</b></button>
		  <div class="dropdown-content">
		    <a href="<%=NoForm%>genrePlay">가족</a>
		    <a href="<%=NoForm%>performance">공연</a>
		    <a href="<%=NoForm%>horror">공포(호러)</a>
		    <a href="<%=NoForm%>documentary">다큐멘터리</a>
		    <a href="<%=NoForm%>drama">드라마</a>
		    <a href="<%=NoForm%>romance">멜로/로멘스</a>
		    <a href="<%=NoForm%>musical">뮤지컬</a>
		    <a href="<%=NoForm%>mystery">미스터리</a>
		    <a href="<%=NoForm%>crime">범죄</a>
		    <a href="<%=NoForm%>historical">사극</a>
		    <a href="<%=NoForm%>western">서부극(웨스턴)</a>
		    <a href="<%=NoForm%>thriller">스릴러</a>
		    <a href="<%=NoForm%>animation">애니메이션</a>
		    <a href="<%=NoForm%>action">액션</a>
		    <a href="<%=NoForm%>adventure">어드벤처</a>
		    <a href="<%=NoForm%>war">전쟁</a>
		    <a href="<%=NoForm%>comedy">코미디</a>
		    <a href="<%=NoForm%>fantasy">판타지</a>
		    <a href="<%=NoForm%>science">SF</a> 
		  </div>
		</div>
		<br><br>			
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
							<td><a href="<%=NoForm %>filmDetail">${bean1.film_title}</a></td>
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