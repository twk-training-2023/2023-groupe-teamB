<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="bean.*"%>
<jsp:useBean id="stdto" scope="request" class="dto.StaffDTO" />
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
		<h1>社員一覧</h1>
		<br>
		<a href="<%= request.getContextPath() %>/view/AdminView/AddStaff.jsp">社員追加</a>
		&nbsp;&nbsp;&nbsp;
		<a href="<%= request.getContextPath() %>/DeleteServlet">社員削除</a>
		
		<form method=get name=form1 action=>
			<p>名前を検索して社員情報を表示</p>
			<input type="text" name="name" size="50"> <input
				type="submit" value="送信">
		</form>

		<table border="0" align="center">
			<tr><th width="100"></th></tr>
			<%for (int i = 0; i < stdto.size(); i++) {%>
				<%StaffBean stbe = stdto.get(i);%>
			<tr><td align="center"><a href=""><%=stbe.getName()%></a></td></tr>
			<%}%>
		</table>

	</div>
</body>
</html>