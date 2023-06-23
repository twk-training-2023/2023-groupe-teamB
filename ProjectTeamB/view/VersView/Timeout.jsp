<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>セッションタイムアウト</title>
</head>
<body>
	<div style="text-align:center;">
		<header>
			<h6>セッション切れです</h6>
		</header>	
		 <meta http-equiv="refresh" content="3;URL=<%= request.getContextPath() %>/view/LoginView/Login.jsp">
	</div>
</body>
</html>