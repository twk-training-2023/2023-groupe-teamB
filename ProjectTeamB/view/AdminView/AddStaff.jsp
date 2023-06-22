<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String name = (String) session.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style="text-align: right;"><%=name%></p>
	<br>
	<div style="text-align: center;">
		<h1>社員追加</h1>
		<h3>単体用</h3>
		<form method=get name=form1 action="<%= request.getContextPath() %>/CmpAddServlet">
			<p>
				ユーザー名:&nbsp;&nbsp;&nbsp;<input type="text" name="name" size="50">
			</p>
			<p>
				Eメール:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
					name="email" size="50">
			</p>
			<p>
				パスワード:&nbsp;&nbsp;&nbsp;<input type="text" name="pass" size="50">
			</p>
			<p>
				権限レベル:&nbsp;&nbsp;&nbsp;<input type="text" name="lv" size="50">
			</p>
			<p>
				<input type="submit" value="追加">
			</p>
		</form>
		<p>---------------------------------------------------------------------------------------</p>
		<h3>複数用</h3>
		<p>ファイルの絶対パスを入力してください</p>
		<input type="text" name="fpass" size="50">
		<p>
			<input type="submit" value="追加">
		</p>
	</div>
</body>
</html>