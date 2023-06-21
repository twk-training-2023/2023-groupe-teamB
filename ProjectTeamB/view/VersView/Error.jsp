<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
		
		<form action="<%= request.getContextPath() %>${requestScope.URL}">
            <input type="submit"value="${requestScope.botton}">
        </form>
	</div>
</body>
</html>