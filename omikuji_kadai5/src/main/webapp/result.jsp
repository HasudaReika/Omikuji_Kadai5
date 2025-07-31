<%@page import="omikuji5.Omikuji"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ結果</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="container">
		<div class="box">
			<p>
				今日の運勢は ${omikuji.getFortuneName()} です<br> 
				願い事：${omikuji.getNegaigoto()}<br> 
				商い： ${omikuji.getAkinai()}<br>
				学問： ${omikuji.getGakumon()}
			</p>

		</div>
		<p>おみくじを続けますか？</p>
		<input type="button"
			onclick="location.href='http://localhost:8080/omikuji_kadai5/birthdayInput.jsp'"
			value="続ける" /><br>
		<html:link page="/stats.do">過去半年の統計を見る</html:link>
		<html:link page="/list.do" paramId="birthday" paramName="OmikujiForm" paramProperty="birthday">
		誕生日の過去半年の結果を見る</html:link>
	</div>
</body>
</html>