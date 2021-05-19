<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
/* position for grid system */
int offset = 2;
int mywidth = twelve - 2 * offset;
int formleft = 3;
int formright = twelve - formleft;
int rightButton = 2;
%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style>
* {
  /* box-sizing: border-box; */
}

.column {
  float: left;
  width: 33.33%;
  padding: 45px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}



table {
  border-collapse: collapse;
  border-spacing: 0px;
  width: 100%;
 /*  border: 1px solid #ddd; */
}

th, td {
  text-align: left;
  padding: 5px;
}

.avatar {
  vertical-align: middle;
  width: 50px;
  height: 50px;
  border-radius: 50%;
}

/* tr:nth-child(even) {
  background-color: #ffffff;
} */
</style>
<style type="text/css">
   tr{color: white}
</style>
</head>
<body>
   <%-- <%@ include file="header.jsp" %> --%>
   <%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
   <jsp:include page="./../anime-main/header.jsp" />
<div class="container">
<div class="row">
   <div class="column"> 
    <table>
   <p class="text-white" style="font-size: 20px"><b>팔로워가 많은 멤버</b></p>
      <tr>
      	 <th>멤버 닉네임</th>    
        <th>팔로우수</th>     
      </tr>
      <tr>
       <tbody>
               <c:forEach var="bean1" items="${requestScope.lists1}">
                  <tr>
                     <td><img src="<%=contextPath%>/img/img.png" alt="Avatar" class="avatar"> <a href="<%=NoForm%>myproFile&email=${bean1.email}&${requestScope.parameters}">${bean1.nickname}</a> </td>
                     <td>${bean1.follower}</td>
                  </tr>
               </c:forEach>
      </tbody>
    </table>
  </div>
  <div class="column">
       <table>
    <p class="text-white" style="font-size: 20px"><b>리뷰가 많은 멤버</b></p>  
      <tr>
      
        <th></th> 
        <th>멤버 닉네임</th>
        <th>리뷰수</th>     
      </tr>
      <tr>
       <tbody>          
               <c:forEach var="bean2" items="${requestScope.lists2}">
                  <tr>
                     <td><td><img src="<%=contextPath%>/img/img.png" alt="Avatar" class="avatar"><a href="<%=NoForm%>myproFile&email=${bean2.email}&${requestScope.parameters}">${bean2.nickname}</a></td>
                     <td>${bean2.allReviews}</td>
                  </tr>
               </c:forEach>
      </tbody>
    </table>
  </div>
  <div class="column">
     <table>
    <p class="text-white" style="font-size: 20px"><b>내가 팔로잉 하고있는 멤버</b></p>   
           <tr>
           			<th></th> 
                     <th>멤버 닉네임</th>
                     <th>팔로워 수</th>
                     <th>리뷰 수</th>
                  </tr>
               </thead>
               <tbody>
               <c:forEach var="bean3" items="${requestScope.lists3}">
                  <tr>
                     <td><td><img src="<%=contextPath%>/img/img.png" alt="Avatar" class="avatar"><a href="<%=NoForm%>myproFile&email=${bean3.email}&${requestScope.parameters}">${bean3.nickname}</a></td>
                     <td>${bean3.follower}</td>
                     <td>${bean3.allReviews}</td>
                  </tr>
                  
               </c:forEach>
               </tbody>         
    </table>
   </div>
 </div>
</div>  
   <jsp:include page="./../anime-main/footer.jsp" />
</body>
</html>