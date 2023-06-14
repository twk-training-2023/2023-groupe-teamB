<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.*" %>
<jsp:useBean id ="sdto" scope="request" class="dto.SearchDTO" />
<%String username = (String)session.getAttribute("username") ;%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
	<p><%=username %>さん。</p>
	<div>
	<%for(int m = 0; m < sdto.size(); m++){%>
		<%SearchBean sbe = sdto.get(m);%>
		<span><%= sbe.getName() %> <%= sbe.gettype1() %> <%= sbe.gettype2() %></span>
	<%}%>
	</div>
	<h5>お気に入り追加をしますか？</h5>
	<form method"get" name=form1 action="<%=request.getContextPath()%>/NewRecordServlet">
		<label for="username">Reason</label>
			<input type="text" id="reason" name="reason"><br />
			<input type="hidden" id="name" name="name" value="<%= sbe.getName() %>">
			<input type="hidden" id="username" name="username" value="<%=username%>">
		<input type="submit" value="新規追加">
	</form>	
</body>
</html>