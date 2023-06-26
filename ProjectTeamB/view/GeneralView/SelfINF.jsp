<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="value" scope="request" class="dto.StaffDTO" />
<%@page import="bean.*"%>
<%String name = (String) session.getAttribute("name");%>
<%
Integer staff_lv = (Integer) session.getAttribute("staff_lv");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/view/Css/Style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
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
					if (staff_lv == 1) {
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
		<h1>${requestScope.name}さんの情報</h1>
		<br>
		<table border="1">
			<tr>
				<th width="100">社員番号</th>
				<th width="150">名前</th>
				<th width="150">スキル名</th>
				<th width="110">スキルレベル</th>
				<th width="480">スキルアピール文</th>
				<th width="100">スキル申請状況</th>
				<th width="480">自己紹介</th>
			</tr>
			<%
			for (int i = 0; i < value.size(); i++) {
				StaffBean sb = value.get(i);
			%>
			<tr>
				<td align="center"><%=sb.getId()%></td>
				<td align="center">${requestScope.name}</td>
				<td align="center"><%=sb.getSkill_name()%></td>
				<td align="center"><%=sb.getSkill_lv()%></td>
				<td align="center"><%=sb.getSkill_appeal()%></td>
				<td align="center"><%=sb.getStatus()%></td>
				<td align="center"><%=sb.getMyself()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<div style="text-align: center;">
		<p>---------------------------------------------------------------------</p>
		<form
			action="<%=request.getContextPath()%>/view/GeneralView/MyPage.jsp">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>