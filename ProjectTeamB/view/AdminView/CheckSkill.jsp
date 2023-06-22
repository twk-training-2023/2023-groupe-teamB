<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="skdto" scope="request" class="dto.SkillDTO" />
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
		<p style="text-align: right;"><%=name%>さん。
		</p>
		<h1>申請一覧</h1>
		<form method=get name=form1 action="<%=request.getContextPath()%>/ManagementServlet">
			<table align = "center" border="1" >
				<tr>
					<th width="100"></th>
					<th width="100">名前</th>
					<th width="100">スキル名</th>
					<th width="100">スキルレベル</th>
					<th width="500">スキルアピール文</th>
				</tr>
				<%
				for (int i = 0; i < skdto.size(); i++) {
					SkillBean skbe = skdto.get(i);
				%>
				<tr>
					<td align="center"><input type="checkbox" name="name" value="<%=skbe.getName()%>"></td>
					<td align="center"><%=skbe.getName()%></td>
					<td align="center"><%=skbe.getSkill_name()%></td>
					<td align="center"><%=skbe.getSkill_lv()%></td>
					<td align="center"><%=skbe.getSkill_appeal()%></td>
				</tr>
				<%
				}
				%>
			</table>
			<br>
			<input type="submit" name="ok" value="承認"> <input type="submit" name="out" value="否認">
			<br>
			</form>
	</div>

</body>
</html>