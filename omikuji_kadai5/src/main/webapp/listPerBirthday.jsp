<%@page import="omikuji5.OmikujiResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>誕生日ごとのリスト表示</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style2.css">
</head>
<body>
<h1>${birthday}の過去半年の占い結果</h1>

<table border="1">
<tr>
	<th>占い日</th>
	<th>運勢</th>
	<th>願い事</th>
	<th>商い</th>
	<th>学問</th>
</tr>
<c:forEach var="v" items="${results}">
<tr>
	<td>${v.fortuneTellingDate}</td>
	<td>${v.fortuneName}</td>
	<td>${v.negaigoto}</td>
	<td>${v.akinai}</td>
	<td>${v.gakumon}</td>
</tr>
</c:forEach>
</table>
<a href="javascript:history.back()">前のページへ</a>
<a href="http://localhost:8080/omikuji_kadai5/birthdayInput.jsp">誕生日入力画面に戻る</a>
</body>
</html>