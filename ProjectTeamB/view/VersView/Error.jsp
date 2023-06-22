<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bean.*" %>
<jsp:useBean id ="stbe" scope="request" class="dto.StaffDTO" />

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
		
		<form action="<%= request.getContextPath() %>${requestScope.error}">
            <input type="submit"value="再ログイン">
        </form>
	</div>
</body>
</html>