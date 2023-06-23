<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="skdto" scope="request" class="dto.SkillDTO" />
<%String name = (String) session.getAttribute("name");%>
<%Integer staff_lv = (Integer)session.getAttribute("staff_lv") ;%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/Css/Style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
    <div class="hamburger-menu">
        <input type="checkbox" id="menu-btn-check">
        <label for="menu-btn-check" class="menu-btn"><span></span></label>
        <div class="menu-content">
            <ul>
	            <li><p><%=name %>さん。</p></li>
                <li><a href="<%= request.getContextPath() %>/view/LoginView/Menu.jsp">メニュー</a></li>
                <li><a href="<%= request.getContextPath() %>/view/GeneralView/MyPage.jsp">マイページ</a></li>
                <%if(staff_lv == 1 ){ %>
                <li><a href="<%= request.getContextPath() %>/view/AdminView/AdminMenu.jsp">管理者ページ</a></li>
                <%} %>
                <li><a href="<%= request.getContextPath() %>/LogoutServlet">ログアウト</a></li>
            </ul>
        </div>
    </div>
</header>
	<br><br><br>
	<div style="text-align: center;">
		<h1>申請一覧</h1>
		<form method=get name=form1 action="<%=request.getContextPath()%>/ManagementServlet">
			<table align = "center" border="1" >
				<tr>
					<th width="100"></th>
					<th width="100">名前</th>
					<th width="100">スキル名</th>
					<th width="100">スキルレベル</th>
					<th width="500">スキルアピール文</th>
				</tr>
				<%
				for (int i = 0; i < skdto.size(); i++) {
					SkillBean skbe = skdto.get(i);
				%>
				<tr>
					<td align="center"><input type="checkbox" name="name" value="<%=skbe.getName()%>"></td>
					<td align="center"><%=skbe.getName()%></td>
					<td align="center"><%=skbe.getSkill_name()%></td>
					<td align="center"><%=skbe.getSkill_lv()%></td>
					<td align="center"><%=skbe.getSkill_appeal()%></td>
				</tr>
				<%
				}
				%>
			</table>
			<br>
			<input type="submit" name="ok" value="承認"> <input type="submit" name="out" value="否認">
			<br>
			</form>
	</div><br/>
	<p style="text-align: center;">-----------------------------------------------------------------------------------------</p>
	<br/>
	<div align = "center">
		<form method="get" name="form1" action="<%= request.getContextPath() %>/view/AdminView/AdminMenu.jsp">
			<input type="submit" value="管理者メニュー">
		</form>
	</div>
</body>
</html>