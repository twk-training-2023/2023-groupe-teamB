<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="stdto" scope="request" class="dto.StaffDTO" />
<%String name = (String)session.getAttribute("name") ;%>
<%Integer staff_lv = (Integer)session.getAttribute("staff_lv") ;%>


<!DOCTYPE html>
<html>
<head>
<%if(staff_lv==null){ %>
	<meta http-equiv="refresh" content="0;URL=<%= request.getContextPath() %>/view/VersView/Timeout.jsp">
<%} %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/Css/Style.css">
<meta charset="UTF-8">
<title>プラットform</title>
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
                <%if(staff_lv != null && staff_lv == 1){ %>
                <li><a href="<%= request.getContextPath() %>/view/AdminView/AdminMenu.jsp">管理者ページ</a></li>
                <%} %>
                <li><a href="<%= request.getContextPath() %>/LogoutServlet">ログアウト</a></li>
            </ul>
        </div>
    </div>
</header>
	<br><br><br>
	<div style="text-align: center;">
	<h1>プラットフォーム</h1>
	<br>
	<a href = "<%= request.getContextPath() %>/view/GeneralView/MyPage.jsp" style="font-size: 15pt; color: #00ff00:">マイページ</a><br/>
	
	<%if(staff_lv != null && staff_lv == 1){ %>
	<a href = "<%= request.getContextPath() %>/view/AdminView/AdminMenu.jsp" style="font-size: 15pt; color: #00ff00:">管理者ページ</a><br/>
	<%} %>
	</div>
</body>
</html>