<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ占い</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h1>おみくじ占い</h1>
	<form action="/result" method="post">
	
	<p class="error-msg">${errorMsg}</p>
	
		<p>
			誕生日を入力してください 例:20011009<br>
			 <input type="text" name="birthday"
				required /><br> <input type="submit" value="送信" />
		</p>
	</form>
	</div>
</body>
</html>