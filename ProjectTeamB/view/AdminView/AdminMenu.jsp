<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String name = (String)session.getAttribute("name") ;%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者メニュー</title>
</head>
<body>
	<p style="text-align: right;"><%=name %>さん。</p>
	<br>
	<div style="text-align: center;">
		<h1>管理者メニュー</h1>
		<br>
		<form method="get" name="form1" action="<%= request.getContextPath() %>/ManagerServlet">
			<p style="display: inline">社員一覧</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form method="get" name="form2" action="<%= request.getContextPath() %>/CheckListServlet">
			<p style="display: inline">社員からの連絡</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form method="get" name="form3" action="<%= request.getContextPath() %>/SkillServlet">
			<p style="display: inline">申請一覧</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form method="get" name="form4" action="<%= request.getContextPath() %>/view/LoginView/Menu.jsp">
			<p style="display: inline">メニューに戻る</p>
			<input type="submit" value="押す">
		</form>
	</div>
</body>
</html>