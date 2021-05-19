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
<c:if test="${ empty sessionScope.loginfo}">
	<c:set var="whologin" value="0" />
</c:if>
<c:if test="${ not empty sessionScope.loginfo}">
	<c:if test="${ sessionScope.loginfo.email == 'admin'}">
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${ sessionScope.loginfo.email != 'admin'}">
		<c:set var="whologin" value="1" />
	</c:if>
</c:if>
<head>
<style type="text/css">
	tr{color: white}
	
.avatars {
  display: inline-block;
  transform: scale(-1, 1);
}
.avatar {
  position: relative;
  display: inline-block;


  overflow: hidden;
  width: 100px;
}
.avatar:not(:first-child) {
  margin-left: -60px;
}
.avatar img {
  width: 100%;
  display: block;
  transform: scale(-1, 1);
}

.column {
    padding: 40;
}	
b, strong {
    font-weight: bolder;
    font-size: x-large;
}
a {
    font-size: larger;
}
[type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
    font-size: large;
    cursor: pointer;
}
i {
    font-size: large;
        text-decoration: none;
}
:hover, a:focus {
    text-decoration: none;
    outline: none;
    color: #ffffff;
    font-size: larger;
}
</style>
</head>
<body>
	<%-- <%@ include file="header.jsp" %> --%>
	<%-- <jsp:include page="<%=contextPath%>/anime-main/header.jsp"/> --%>
	<jsp:include page="./../anime-main/header.jsp" />
	<div class="container">
		<c:if test="${whologin != 0}">
			<a href="<%=NoForm%>makefilmList&email=${loginfo.email}">
				<button class="btn-lg btn-info">나만의 FilmList 만들기</button></a>
		</c:if>
		<div class="row">
			<div class="column">
				<table>
					<p class="text-white" style="font-size: 20px">
						<b>최신 영화 리스트</b>
					</p>
					<br>
					<tbody>
						<c:forEach var="bean1" items="${requestScope.lists1}">
							<tr>
								<td>
									<c:forEach var="entry" items="${films1}" varStatus="status">
										<c:if test="${entry.key==bean1.id }">
											<div class="avatars">
												<c:forEach var="image" items="${entry.value}">
													<span class="avatar">
														<img src="upload/${image}" width="140" height="140" />
													</span>
												</c:forEach>
											</div>
										</c:if>
									</c:forEach>
									<br> 
									<a href="<%=NoForm%>filmListDetail&id=${bean1.id}&${requestScope.parameters}&email=${loginfo.email}">${bean1.list_title}</a>
									<br> 
									<small> 
									<i> 작성자 : 
										<a href="<%=NoForm%>myproFile&email=${bean1.email}&${requestScope.parameters}">${bean1.nickname}</a>
									</i>
									</small>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="column">
				<table>
					<p class="text-white" style="font-size: 20px">
						<b>인기 영화 리스트</b>
					</p>
					<br>
					<tr>
					</tr>
					<tbody>
						<c:forEach var="bean3" items="${requestScope.lists3}">
							<tr>
								<td>
									<c:forEach var="entry" items="${films3}" varStatus="status">
										<c:if test="${entry.key==bean3.id }">
											<div class="avatars">
												<c:forEach var="image" items="${entry.value}">
													<span class="avatar">
														<img src="upload/${image}" width="140" height="140" />
													</span>
												</c:forEach>
											</div>
										</c:if>
									</c:forEach>
									<br> 
									<a href="<%=NoForm%>filmListDetail&id=${bean3.id}&${requestScope.parameters}">${bean3.list_title}</a>
									<br> <small> <i>작성자 : <a
											href="<%=NoForm%>myproFile&email=${bean3.email}&${requestScope.parameters}">${bean3.nickname}</a></i>
								</small>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="column">
				<table>
					<p class="text-white" style="font-size: 20px">
						<b>내가 좋아요한 영화 리스트</b>
					</p>
					<br>
					<tr>
					</tr>
					<tbody>
						<c:forEach var="bean2" items="${requestScope.lists2}">
							<tr>
								<td>
									<c:forEach var="entry" items="${films2}" varStatus="status">
										<c:if test="${entry.key==bean2.id }">
											<div class="avatars">
												<c:forEach var="image" items="${entry.value}">
													<span class="avatar">
														<img src="upload/${image}" width="140" height="140" />
													</span>
												</c:forEach>
											</div>
										</c:if>
									</c:forEach>
									<br> 
									<a href="<%=NoForm%>filmListDetail&id=${bean2.id}&${requestScope.parameters}">${bean2.list_title}</a>
									<br> <small> <i>작성자 : <a
											href="<%=NoForm%>myproFile&email=${bean2.email}&${requestScope.parameters}">${bean2.nickname}</a></i>
								</small>
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