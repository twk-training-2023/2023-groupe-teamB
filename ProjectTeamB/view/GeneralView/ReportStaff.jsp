<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String name = (String)session.getAttribute("name") ;%>
<%Integer staff_lv = (Integer)session.getAttribute("staff_lv") ;%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/Css/Style.css">
	<meta charset="UTF-8">
	<title>連絡入力画面</title>
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
	<div  style="text-align:center;">
	<h1>管理者愚痴送信</h1>
		<form method="post" name=form1 action="<%= request.getContextPath() %>/CmpContactServlet">
			<h3>管理者への連絡文を入力してください</h3>
			<input type="text" name="message" required/>
			<input type="submit" value="送信">
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>	
	<br>
	<br>
	<br>
	<br>
	<div style="text-align:center;">
		<form action="<%= request.getContextPath() %>/view/GeneralView/MyPage.jsp">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>