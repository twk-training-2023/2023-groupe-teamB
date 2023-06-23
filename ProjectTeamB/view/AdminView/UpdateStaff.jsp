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
		<h1>管理者レベルの更新</h1>
		<%
		StaffBean sb = stdto.get(0);
		%>
		<p>${requestScope.nema}さんの権限レベルは<%=sb.getStaff_lv()%>です
		</p>
		<br>
		<form method=get name=form1
			action="<%=request.getContextPath()%>/CmpUpdateServlet">
			<p>権限レベルを選択</p>
			<select name="lv" id="lv">
				<option value="0">0</option>
				<option value="1">1</option>

			</select> <input type="submit" value="更新を実行"> <input type="hidden"
				name="neme" value="${requestScope.nema}">
		</form>
		<br />
		<p style="text-align: center;">-----------------------------------------------------------------------------------------</p>
		<br />
		<div align="center">
			<form method="get" name="form1"
				action="<%=request.getContextPath()%>/view/AdminView/AdminMenu.jsp">
				<input type="submit" value="管理者メニュー">
			</form>
		</div>
</body>
</html>