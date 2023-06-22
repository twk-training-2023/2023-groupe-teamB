<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="value" scope="request" class="dto.MessageDTO" />
<%String name = (String)session.getAttribute("name") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style="text-align: right;"><%=name %>さん</p>
	<h1 style="text-align: center">社員連絡一覧</h1>
	<table align = "center" border="2" cellpadding="7" cellspacing="2">
		<tr>
			<th>名前</th>
			<th>連絡文</th>
		</tr>
		<%for(int i = 0; i < value.size(); i++){
			MessageBean sb = value.get(i);%>
		<tr>
			<td><%= sb.getName() %></td>
			<td><%= sb.getMessage() %></td>
		</tr>
		<% } %>
	</table><br>
	<div align = "center">
		<form method="get" name="form1" action="<%= request.getContextPath() %>/view/AdminView/AdminMenu.jsp">
			<input type="submit" value="管理者メニュー">
		</form>
	</div>
</body>
</html>