<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ロール名とパスワードを入力してね</title>
</head>
<body>
	<div style="text-align:center;">
		<h1>DataBase-サインイン</h1>
        <form method"get" name=form1 action="<%= request.getContextPath() %>/UserSearchServlet">
            <label for="username">ID</label>
            <input type="text" id="username" name="username"><br/>
            <label for="password">PassWord</label>
            <input type="text" id="password" name="password"><br/>
            <input type="submit"value="送信">
        </form>
        <form action="<%= request.getContextPath() %>/view/LoginView/NewRecord.jsp">
            <input type="submit"value="新規登録">
        </form>
	</div>
</body>
</html>