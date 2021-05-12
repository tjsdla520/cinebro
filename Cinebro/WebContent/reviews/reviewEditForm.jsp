<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
</head>
<body>
	<jsp:include page="./../anime-main/header.jsp"/>
	    <section class="login spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3></h3>
                        <form class="form-horizontal" action="<%=YesForm%>" method="post">
                        	<input type="hidden" name="command" value="meLogin">
                            <div class="input__item">
                                <input type="text" class="text-body" id="email" placeholder="Email address" 
				        		name="email" data-toggle="tooltip" title="이메일은 @를 포함하여 끝까지 적어주세요"
				        		value="${email}">
				        	<span class="icon_mail">${erremail}</span>
                            </div>
                            <div class="input__item">
                                <input type="password" class="text-body" placeholder="Password"
                                name="password"	value="${password}">
                                
                                <span class="icon_lock">${errpassword}</span>
                            </div>
                            <button type="submit" class="site-btn">Login Now</button>
                        </form>
                        
                    </div>
                </div>
            </div>
            
        </div>
    </section>
	
	<jsp:include page="./../anime-main/footer.jsp"/>
</body>
</html>