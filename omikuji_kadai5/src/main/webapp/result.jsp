<%@page import="omikuji5.Omikuji"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %><%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>


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
				今日の運勢は ${omikuji.fortuneName} です<br> 
				願い事： ${omikuji.nega/goto}<br>
				商い： ${omikuji.akinai}<br> 
				学問：${omikuji.gakumon}
			</p>

		</div>
		<p>おみくじを続けますか？</p>
		<input type="button"
			onc/ick="location.href='${pageContext.request.contextPath}/birthdayInput.do'"
			value="続ける" /><br>
		<html:link page="/statics.do">過去半年の統計を見る</html:link>
		<html:link page="list.do">誕生日の過去半年の結果を見る</html:link>
	</div>
</body>
</html>