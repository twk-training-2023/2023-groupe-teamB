<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="bean.*"%>
<jsp:useBean id="stdto" scope="request" class="dto.StaffDTO" />
<%String name = (String)session.getAttribute("name") ;%>
<%StaffBean stbe = stdto.get(0);%>


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
		<h1>個人情報更新</h1>
	</div>
	
	
	<div style="text-align: center;">	
		<form method="post" name=form1 action="<%=request.getContextPath()%>/ChangePassServlet" required/>
			<p>新しいパスワードを入力してください</p>
			<input type="password" id= "textbox" name="password" size="50" placeholder="numnumnumnumnum">
			<input type="submit" value="変更">
		</form>
	</div>

	
	<div style="text-align: center;">
		<form method="post" name=form2 action="<%=request.getContextPath()%>/ChangeMineServlet">
			<p>新しい自己紹介文を入力してください</p>
			<input type="text" id= "textboxmy" name="myself" size="50" placeholder="hogehogehoge">
			<input type="submit" value="更新">
		</form>
	</div>
	
	
	<div style="text-align:center;">
		<form method="post" name=form3 action="<%=request.getContextPath()%>/ChangeSkillServlet">
			<p>新しいアピール文を入力してください</p>
			<input type="text" id = "textboxap" name="skill_appeal" size="100" value="<%= stbe.getSkill_appeal()%>" />
			<script type="text/javascript">
				<!--
				  var textboxap = document.getElementById( 'textboxap' );
				
				  // 入力フォーカスを得たときの処理
				  textboxap.onfocus = function()
				  {
				      if( this.value == this.defaultValue )
				      {
				          this.value = '';
				          this.style.color = '';
				      }
				  }
				
				  // 入力フォーカスを失ったときの処理
				  textboxap.onblur = function()
				  {
				      if( this.value == '' )
				      {
				          this.value = this.defaultValue;
				          this.style.color = 'gray';
				      }
				  }
				
				  // 透かし文字をdefaultValueプロパティで保持する
				  textboxap.defaultValue = textboxap.value;
				  textboxap.value = '';
			</script>
			<input type="submit" value="更新"><br/>
			
			<p>スキル名とスキルレベルを入力してください</p>
			<input type="text" id = "textboxnm" name="skill_name" size="50" value="<%= stbe.getSkill_name()%>" />
						<script type="text/javascript">
				<!--
				  var textboxnm = document.getElementById( 'textboxnm' );
				
				  // 入力フォーカスを得たときの処理
				  textboxnm.onfocus = function()
				  {
				      if( this.value == this.defaultValue )
				      {
				          this.value = '';
				          this.style.color = '';
				      }
				  }
				
				  // 入力フォーカスを失ったときの処理
				  textboxnm.onblur = function()
				  {
				      if( this.value == '' )
				      {
				          this.value = this.defaultValue;
				          this.style.color = 'gray';
				      }
				  }
				
				  // 透かし文字をdefaultValueプロパティで保持する
				  textboxnm.defaultValue = textboxnm.value;
				  textboxnm.value = '';
			</script>
			<span>&nbsp;&nbsp;&nbsp;</span>
			<select name="skill_lv" >
			<p>スキルレベルを選んでください</p>
			  <option value="0,name">Lv0</option>
			  <option value="1,name">Lv1</option>
			  <option value="2">Lv2</option>
			  <option value="3">Lv3</option>
			  <option value="4">Lv4</option>
			  <option value="5">Lv5</option>
			  <option value="6">Lv6</option>
			  <option value="7">Lv7</option>
			  <option value="8">Lv8</option>
			  <option value="9">Lv9</option>
			</select>
			<br/>
			
			1
			
			
			
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div style="text-align:center;">
		<form action="<%= request.getContextPath() %>/view/GeneralView/MyPage.jsp">
			<input type="submit" value="戻る">
		</form>
	</div>
		
</body>
</html>