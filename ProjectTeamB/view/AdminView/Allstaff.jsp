<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="bean.*"%>
<jsp:useBean id="stdto" scope="request" class="dto.StaffDTO" />
<%String name = (String)session.getAttribute("name") ;%>
<%Integer staff_lv = (Integer)session.getAttribute("staff_lv") ;%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/Css/Style.css">
<meta charset="UTF-8">
<title>社員一覧</title>
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
		<h1>社員一覧</h1>
		<br>
		<a href="<%= request.getContextPath() %>/view/AdminView/AddStaff.jsp">社員追加</a>
		&nbsp;&nbsp;&nbsp;
		<a href="<%= request.getContextPath() %>/DeleteServlet">社員削除</a>
		
		<form method=get name=form1 action="<%= request.getContextPath() %>/ShowServlet">
			<p>名前を検索して社員情報を表示</p>
			<input type="text" name="name" size="50"> <input
				type="submit" value="送信">
		</form>

		<table border="0" align="center">
			<tr><th width="100"></th></tr>
			<%for (int i = 0; i < stdto.size(); i++) {%>
				<%StaffBean stbe = stdto.get(i);%>
			<tr><td align="center"><a href="<%= request.getContextPath() %>/ShowServlet?name=<%=stbe.getName()%>"><%=stbe.getName()%></a></td></tr>
			<%}%>
		</table>

	</div>
</body>
</html>