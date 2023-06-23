<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String name = (String)session.getAttribute("name") ;%>
       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h1>マイページ</h1>
		<br>
		<form method="get" name=form1 action="<%= request.getContextPath() %>/ChangeMySelfServlet">
			<p style="display: inline">個人情報更新画面</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form action="<%= request.getContextPath() %>/view/GeneralView/ReportStaff.jsp">
			<p style="display: inline">管理者へ連絡入力画面</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form method="get" name=form1 action="<%= request.getContextPath() %>/SelfINFServlet">
			<p style="display: inline">個人情報確認画面</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form action="<%= request.getContextPath() %>/view/LoginView/Menu.jsp">
			<p style="display: inline">プラットフォーム</p>
			<input type="submit" value="押す">
		</form>
	</div>
</body>
</html>