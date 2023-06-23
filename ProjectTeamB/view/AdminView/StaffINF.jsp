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
		<h1>${requestScope.nama}さんの情報</h1>
		<br>
		<table border="1">
			<tr>
				<th width="100">社員番号</th>
				<th width="150">名前</th>
				<th width="150">スキル名</th>
				<th width="110">スキルレベル</th>
				<th width="480">スキルアピール文</th>
				<th width="480">自己紹介</th>
			</tr>
			<%
			for (int i = 0; i < stdto.size(); i++) {
				StaffBean sb = stdto.get(i);
			%>
			<tr>
				<td align="center"><%=sb.getId()%></td>
				<td align="center">${requestScope.nama}</td>
				<td align="center"><%=sb.getSkill_name()%></td>
				<td align="center"><%=sb.getSkill_lv()%></td>
				<td align="center"><%=sb.getSkill_appeal()%></td>
				<td align="center"><%=sb.getMyself()%></td>

			</tr>
			<%
			}
			%>
			</table>
			<br>
			<form method=get name=form1
			action="<%=request.getContextPath()%>/UpdateServlet">
	        <input type="hidden" name="neme" value="${requestScope.nama}">
			<input type="submit" value="権限レベルの更新" >
			</form>
			</div>
			
</body>
</html>