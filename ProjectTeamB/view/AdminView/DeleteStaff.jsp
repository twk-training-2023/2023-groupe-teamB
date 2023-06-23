<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="stdto" scope="request" class="dto.StaffDTO" />
<%@page import="bean.*"%>
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
		<h1>社員削除</h1>

		<div>
			<form method=get name=form1
				action="<%=request.getContextPath()%>/DeleteCheckServlet">
				<%
				for (int i = 0; i < stdto.size(); i++) {
					StaffBean sb = stdto.get(i);
				%>

				<span> <%=sb.getName()%></span> <span><input type="checkbox"
					name="name" value="<%=sb.getName()%>"></span> <br>
				<%
				}
				%>
				<input type="submit" value="削除">
			</form>
		</div>
	</div>
	<br/>
	<p style="text-align: center;">-----------------------------------------------------------------------------------------</p>
	<br/>
	<div align = "center">
		<form method="get" name="form1" action="<%= request.getContextPath() %>/view/AdminView/AdminMenu.jsp">
			<input type="submit" value="管理者メニュー">
		</form>
	</div>
</body>
</html>