<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="titleDiv">
		<h3>연월별 매출</h3>
</div>
<div class="row">
	<div class="col-6">
		<canvas id="chart1" height="450" width="600"></canvas>
	</div>
	<div class="col-6">
		<canvas id="chart2" height="450" width="600"></canvas>
	</div>
</div>
<input type="hidden" value='${month }' id="json">
<input type="hidden" value='${year }' id="json1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<script type="text/javascript" src="/resources/js/admin/date_sales.js?ver=12"></script>
</body>
</html>