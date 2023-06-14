<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.*" %>
<jsp:useBean id ="sdto" scope="request" class="dto.SearchDTO" />
<%String username = (String)session.getAttribute("username") ;%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果　対象タイプ${requestScope.typename}</title>
</head>
<body>
	<div><p><%=username %>さん。</p></div>
    <p>${requestScope.typename}</p>
	<%for(int p = 0; p < sdto.size(); p++){%>
		<%SearchBean sbe = sdto.get(p);%>
		<a href = "<%= request.getContextPath() %>/NameCheckServlet?thisname=<%= sbe.getName() %>"><%= sbe.getName() %></a><br/>
	 <%}%>
</body>
</html>これは動かない