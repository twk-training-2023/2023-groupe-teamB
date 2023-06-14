<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.*"%>
<jsp:useBean id="usdt" scope="request" class="dto.UserSearchDTO" />
<%String username = (String)session.getAttribute("username") ;%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラットform</title>
</head>
<body>
	<p><%=username %>さん。</p>
	<form action="<%= request.getContextPath() %>/NameCheckServlet" method="post">
		<p>ポケモンの名前を入力してください</p>
		<input type="text" name="name"><br>
		<input type="submit" value="送信">
	</form>
	<a href = "<%= request.getContextPath() %>/TypeSearchServlet">タイプから調べる</a><br/>
</body>
</html>