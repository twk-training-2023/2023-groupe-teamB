<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="beans.*" %>
<jsp:useBean id ="usdt" scope="request" class="dto.UserSearchDTO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
</head>
<body>
	<div style="text-align:center;">
		<header>
			<h6>エラー</h6>
		</header>	
		<p>${requestScope.nouser}</p>
		
		<form action="<%= request.getContextPath() %>/view/LoginView/Login.jsp">
            <input type="submit"value="再ログイン">
        </form>
        
		<form action="<%= request.getContextPath() %>/view/LoginView/NewRecord.jsp">
            <input type="submit"value="新規登録">
        </form>
	</div>
</body>
</html>