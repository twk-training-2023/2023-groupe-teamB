<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="value" scope="request" class="dto.MessageDTO" />
<%String name = (String)session.getAttribute("name") ;%>
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