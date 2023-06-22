<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="stdto" scope="request" class="dto.StaffDTO" />
<%String name = (String)session.getAttribute("name") ;%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラットform</title>
</head>
<body>
	<p style="text-align: right;"><%=name %>さん。</p>
	<br>
	<div style="text-align: right;">
		<form method="post" name=form1 action="<%= request.getContextPath() %>/LogoutServlet">
			<input type="submit" value="ログアウト">
		</form>
	</div>
	<br>
	<div style="text-align: center;">
	<h1>プラットフォーム</h1>
	<br>
	<a href = "<%= request.getContextPath() %>/view/GeneralView/MyPage.jsp" style="font-size: 15pt; color: #00ff00:">マイページ</a><br/>
	<a href = "<%= request.getContextPath() %>/view/AdminView/AdminMenu.jsp" style="font-size: 15pt; color: #00ff00:">管理者ページ</a><br/>
	</div>
</body>
</html>