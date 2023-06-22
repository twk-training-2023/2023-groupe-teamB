<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>連絡入力画面</title>
	</head>
	<body style="text-align:center;">
		<form action="/ProjectTeamB/CmpContactServlet" method="post">
			<h3>管理者への連絡文を入力してください</h3>
			<input type="text" name="message">
			<input type="submit" value="送信">
		</form>
	</body>
</html>