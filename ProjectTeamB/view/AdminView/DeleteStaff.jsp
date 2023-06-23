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
		<h1>社員削除</h1>

		<div>
			<form method=get name=form1
				action="<%=request.getContextPath()%>/DeleteCheckServlet">
				<%
				for (int i = 0; i < stdto.size(); i++) {
					StaffBean sb = stdto.get(i);
				%>

				<span> <%=sb.getName()%></span> <span><input type="checkbox"
					name="name" value="<%=sb.getName()%>"></span> <br>
				<%
				}
				%>
				<input type="submit" value="削除">
			</form>
		</div>

	</div>
</body>
</html>