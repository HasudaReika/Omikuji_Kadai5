<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全体の過去半年と本日の占い結果の割合</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style2.css">
</head>
<body>
	<h1>過去半年・本日の運勢の割合</h1>
	<div class="field">
		<div>
			<canvas id="pastSixMonths" width="400" height="400"></canvas>
			<p><c:forEach var="entry" items="${resultPastSixMonths}">
				<li>${entry.key}:${entry.value}%</li>
			</c:forEach></p>
		</div>

		<div>
			<canvas id="today" width="400" height="400"></canvas>
			<p><c:forEach var="entry" items="${resultToday}">
				<li>${entry.key}:${entry.value}%</li>
			</c:forEach></p>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>

	<script>
const pastSixMonths={
		<c:forEach var="entry" items="${resultPastSixMonths}" varStatus="status">
		'${entry.key}': ${entry.value}
        <c:if test="${!status.last}">,</c:if>
        <c:choose>
        <c:when test="${entry.value==0.0}">0%</c:when>
        </c:choose>
    </c:forEach>
};
const today = {
        <c:forEach var="entry" items="${resultToday}" varStatus="status">
            '${entry.key}': ${entry.value}
            <c:if test="${!status.last}">,</c:if>
            <c:choose>
            <c:when test="${entry.value==0.0}">0%</c:when>
            </c:choose>
        </c:forEach>
    };


    const colors = [
      "#8ECDDD",
      "#F0A58A",
      "#C9A6FF",
      "#D2F3C0",
      "#B392AC",
      "#FFB2C8"
    ];

function createChart(ctx, chartLabels, chartData, title) {
    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: chartLabels,
            datasets: [{
                backgroundColor: colors,
                data: chartData
            }]
        },
        options: {
            title: {
                display: true,
                text: title
            }
        }
    });
}

const pastSixMonthsCtx = document.getElementById("pastSixMonths");
const pastSixMonthsLabels = Object.keys(pastSixMonths);
const pastSixMonthsData = Object.values(pastSixMonths);
createChart(pastSixMonthsCtx, pastSixMonthsLabels, pastSixMonthsData, '過去半年の運勢');

const todayCtx = document.getElementById("today");
const todayLabels = Object.keys(today);
const todayData = Object.values(today);
createChart(todayCtx, todayLabels, todayData, '本日の運勢');
  </script>

	<a href="javascript:history.back()">前のページへ</a>
	<a href="http://localhost:8080/omikuji_kadai5/birthdayInput.jsp">誕生日入力画面に戻る</a>
</body>
</html>