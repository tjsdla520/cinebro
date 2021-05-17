<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<style>
.embed-container {
 position: relative; 
padding-bottom: 56.25%; 
height: 0; 
overflow: hidden; 
max-width: 100%; } 
.embed-container iframe, .embed-container object, .embed-container embed { 
position: absolute; 
top: 0; 
left: 0; 
width: 100%; 
height: 100%; }
</style>

</head>
<body>

	<div class='embed-container'>
	<iframe  width="560" height="315" src="${requestScope.url}?autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</div>

</body>
</html>