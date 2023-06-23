<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eメールとパスワードを入力してね</title>
</head>
<body>
	<div style="text-align:center;">
		<h1>DataBase-サインイン</h1>
        <form method"get" name=form1 action="<%= request.getContextPath() %>/LoginServlet">
            <label for="email">メールアドレス</label>
            <input type="text" id="email" name="email"><br/>
            <label for="password">パスワード</label>
            <input type="password" id="password" name="password"><br/>
            <input type="submit"value="送信">
        </form>
    </div>
</body>
</html>