<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.*" %>
<jsp:useBean id ="sdto" scope="request" class="dto.SearchDTO" />
<%String username = (String)session.getAttribute("username") ;%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイプ一覧</title>
</head>
<body>
	<p><%=username %>さん。</p>
	<div>
		<%for(int m = 0; m < sdto.size(); m++){%>
			<%SearchBean sbe = sdto.get(m);%>
			<%if( (m+1) % 6 == 0){ %>
				<a href = "<%= request.getContextPath() %>/IstNmSearchServlet?typename=<%= sbe.getName() %>"><%= sbe.getName() %></a><br/>
			<%}else{%>
				<span><a href = "<%= request.getContextPath() %>/IstNmSearchServlet?typename=<%= sbe.getName() %>"><%= sbe.getName() %></a></span>
		    <%}%>
	    <%}%>
	</div>
</body>
</html>ここは動く