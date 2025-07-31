<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ占い</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
	<div class="container">
	<h1>おみくじ占い</h1>
	<html:form action="/omikuji">
	
	<div class="error"><html:errors/></div>
		<p>
			誕生日を入力してください 例:20011009<br>
			 <html:text property="birthday"/><br>
			 <html:submit property="submit" value="送信"/>
		</p>
	</html:form>
	</div>
</body>
</html>