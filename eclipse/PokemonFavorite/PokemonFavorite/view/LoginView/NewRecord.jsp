<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
	<div stype="text-align:center;">
	<h5>新規登録します<br>IDとパスワードを入力してください。</h5>
		<form method"get" name=form1 action="<%=request.getContextPath()%>/NewRecordServlet">
			<label for="username">ID</label>
				<input type="text" id="username" name="username"><br />
			<label for="password">PassWord</label>
				<input type="text" id="password" name="password"><br />
			<input type="submit" value="新規追加">
		</form>
	</div>
</body>
</html>