<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="stbe" scope="request" class="dto.StaffDTO" />
<%String name = (String)session.getAttribute("name") ;%>
       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center;">
<p style="text-align: right;"><%=name %>さん。</p>
	<br>
		<h1>マイページ</h1>
		<br>
		<form method="get" name="form1" action="">
			<p style="display: inline">個人情報更新画面</p>
			<input type="submit" value="押す">
		</form>
		<br>
		<form method="get" name="form2" action="/ProjectTeamB/view/AdminView/ReportStaff.jsp">
			<p style="display: inline">管理者へ連絡入力画面</p>
			<input type="submit" value="押す">
</body>
</html>