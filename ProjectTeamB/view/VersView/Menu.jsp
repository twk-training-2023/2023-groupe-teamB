<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="stbe" scope="request" class="dto.StaffDTO" />
<%String name = (String)session.getAttribute("name") ;%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラットform</title>
</head>
<body>
	<p><%=name %>さん。</p>
	<a href = "<%= request.getContextPath() %>/view/GeneralView/MyPage.jsp">マイページ</a><br/>
	<a href = "<%= request.getContextPath() %>/view/AdminView/AdminMenu.jsp">管理者ページ</a><br/>
</body>
</html>