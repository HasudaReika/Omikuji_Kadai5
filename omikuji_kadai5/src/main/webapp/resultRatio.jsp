<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h2>過去半年の運勢</h2>
			<canvas id="pastSixMonths" width="400" height="400"></canvas>
		</div>

		<div>
			<h2>本日の運勢</h2>
			<canvas id="today" width="400" height="400"></canvas>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
	
	<script>
const pastSixMonths={
		<c:forEach var="entry" items="${resultPastSixMonths}" varStatus="status">
		'${entry.key}': ${entry.value}
        <c:if test="${!status.last}">,</c:if>
    </c:forEach>
};
const today = {
        <c:forEach var="entry" items="${resultToday}" varStatus="status">
            '${entry.key}': ${entry.value}
            <c:if test="${!status.last}">,</c:if>
        </c:forEach>
    };


    const colors = [
      "#BB5179",
      "#FAFF67",
      "#58A27C",
      "#3C00FF",
      "#FBFF23",
      "#52B43A"
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