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
<p style="text-align: right;"><%=name%></p>
	<br>
	<div style="text-align: center;">
		<h1>管理者レベルの更新</h1>
		<% StaffBean sb = stdto.get(0);%>
		<p>${requestScope.nema}さんの権限レベルは<%=sb.getStaff_lv()%>です</p>
		<br>
		<form method=get name=form1 action="<%=request.getContextPath()%>/CmpUpdateServlet">
		<p>権限レベルを選択</p>
		<select name="lv" id="lv">
		<option value="0">0</option>
		<option value="1">1</option>
		
		</select>
		<input type="submit" value="更新を実行">
		<input type="hidden" name="neme" value="${requestScope.nema}">
		</form>
</body>
</html>