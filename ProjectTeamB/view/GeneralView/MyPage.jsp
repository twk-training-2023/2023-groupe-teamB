<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String name = (String) session.getAttribute("name");%>
<%Integer staff_lv = (Integer) session.getAttribute("staff_lv");%>


<!DOCTYPE html>
<html>
<head>
	<%if(name==null){ %>
		<meta http-equiv="refresh" content="0;URL=<%= request.getContextPath() %>/view/VersView/Timeout.jsp">
	<%} %>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/view/Css/Style.css">
	<meta charset="UTF-8">
	<title>マイページ</title>
</head>
<body>
	<header>
		<div class="hamburger-menu">
			<input type="checkbox" id="menu-btn-check"> <label
				for="menu-btn-check" class="menu-btn"><span></span></label>
			<div class="menu-content">
				<ul>
					<li><p><%=name%>さん。
						</p></li>
					<li><a
						href="<%=request.getContextPath()%>/view/LoginView/Menu.jsp">メニュー</a></li>
					<li><a
						href="<%=request.getContextPath()%>/view/GeneralView/MyPage.jsp">マイページ</a></li>
					<%
					if (staff_lv != null && staff_lv == 1) {
					%>
					<li><a
						href="<%=request.getContextPath()%>/view/AdminView/AdminMenu.jsp">管理者ページ</a></li>
					<%
					}
					%>
					<li><a href="<%=request.getContextPath()%>/LogoutServlet">ログアウト</a></li>
				</ul>
			</div>
		</div>
	</header>
	<br>
	<br>
	<br>
	<div style="text-align: center;">
		<h1>マイページ</h1>
		<br>
		<form method="get" name=form1
			action="<%=request.getContextPath()%>/ChangeMySelfServlet">
			<p style="display: inline">個人情報更新画面</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form
			action="<%=request.getContextPath()%>/view/GeneralView/ReportStaff.jsp">
			<p style="display: inline">管理者へ連絡入力画面</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form
			action="<%=request.getContextPath()%>/SelfINFServlet">
			<p style="display: inline">個人情報確認画面</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form action="<%=request.getContextPath()%>/view/LoginView/Menu.jsp">
			<p style="display: inline">プラットフォーム</p>
			<input type="submit" value="押す">
		</form>
	</div>
</body>
</html>