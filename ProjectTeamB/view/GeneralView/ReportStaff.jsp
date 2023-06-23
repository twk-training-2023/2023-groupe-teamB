<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String name = (String)session.getAttribute("name") ;%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>連絡入力画面</title>
</head>
<body>
	<p style="text-align: right;"><%=name %>さん。</p>
	<div  style="text-align:center;">
		<form method="post" name=form1 action="<%= request.getContextPath() %>/CmpContactServlet">
			<h3>管理者への連絡文を入力してください</h3>
			<input type="text" name="message">
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