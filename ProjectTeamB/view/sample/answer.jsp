<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>答え</title>
  </head>
  <body>
  	<h3>結果</h3>
  	<div>
  		<span>入力された値を3倍した結果は</span><span>${requestScope.num }</span>
  	</div>
  	<div>
  		<span>${requestScope.num }</span><span>は</span><span>${requestScope.Jdg }</span>
  	</div>
  </body>
</html>