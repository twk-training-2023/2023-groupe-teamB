<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String name = (String) session.getAttribute("name");%>
<%Integer staff_lv = (Integer)session.getAttribute("staff_lv") ;%>
<!DOCTYPE html>
<html>
<head>
	<%if(name==null){ %>
		<meta http-equiv="refresh" content="0;URL=<%= request.getContextPath() %>/view/VersView/Timeout.jsp">
	<%} %>
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
		<h1>社員追加</h1>
		<h3>単体用</h3>
		<form method="get" name="form1" action="<%= request.getContextPath() %>/CmpAddServlet">
			<p>
				ユーザー名:&nbsp;&nbsp;&nbsp;<input type="text" name="name" size="50" required>
			</p>
			<p>
				Eメール:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
					name="email" size="50" required>
			</p>
			<p>
				パスワード:&nbsp;&nbsp;&nbsp;<input type="text" name="pass" size="50" required>
			</p>
			<p>
				権限レベル:&nbsp;&nbsp;&nbsp;
			<select name="lv" >
			<p>権限レベルを選んでください</p>
			  <option value="0">Lv0</option>
			  <option value="1">Lv1</option>
			</select>
			</p>
			<p>
				<input type="submit" value="追加">
			</p>
		</form>
		<p>---------------------------------------------------------------------------------------</p>
		<h3>複数用</h3>
		<form method="post" name="form1"
			action="<%=request.getContextPath()%>/CmpAddServlet">
		<p>ファイルの絶対パスを入力してください</p>
		
		<input type="text" name="fpass" size="50">
		<p>
			<input type="submit" value="追加">
		</p>
		</form>
		<br/>
		<form method="post" name="form1"
			action="<%=request.getContextPath()%>/CmpFileServlet">
		<p>ファイルを指定してください</p>
		<input type="file" name="file" accept=".csv">
		<p>
		<input type="submit" value="追加">
		</p>
		</form>
		
		<p>---------------------------------------------------------------------------------------</p>
		<form method="get" name="form4" action="<%= request.getContextPath() %>/ManagerServlet">
			<p style="display: inline">社員一覧に戻る</p>
			<input type="submit" value="押す">
		</form>
	</div>
</body>
</html>