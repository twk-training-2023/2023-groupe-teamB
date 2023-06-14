<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.*" %>
<jsp:useBean id ="sdto" scope="request" class="dto.SearchDTO" />
<%String username = (String)session.getAttribute("username") ;%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果　対象タイプ：${requestScope.typename}</title>
</head>
<body>
	<p><%=username %>さん。</p>
	<p>${requestScope.typename}</p>
	<p>${requestScope.result}</p>
</body>
</html>ここも動く