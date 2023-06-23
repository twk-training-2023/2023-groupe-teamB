<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="stdto" scope="request" class="dto.StaffDTO" />
<%@page import="bean.*"%>
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
	<div style="text-align: center;">
		<p style="text-align: right;"><%=name%></p>
		<br>
		<h1>削除確認</h1>
		<p>本当に削除しますか？</p>
		<form method=get style="display: inline" name=form1 action="<%=request.getContextPath()%>/CmpDelServlet">
		<input type="submit" value="削除">
		</form>
		
		<form method=get style="display: inline" name=form2 action="<%=request.getContextPath()%>/ManagerServlet">
		<input type="submit"  value="社員一覧へ">
		</form>
		</div>
</body>
</html>