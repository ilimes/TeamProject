<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.btn{
	background-image: none;
	background-color: #333;
	font-size: 14px;
	height: 40px;
}
.btn:hover{
	background-color: #000000;
}
.col-md-4 > div > div:first-child{
	margin-bottom: 1px;
}
.col-md-4 div{
	margin-bottom: 14px;
}
</style>
</head>
<body>
<div class="row">
	<div class="col-md-4">
		<div>
			<div>
				<h4>고객님,</h4>
			</div>
			<div>
				<h4>
					<strong>어떤 여행을 꿈꾸시나요?</strong>
				</h4>
			</div>
			<div class="row">
				<div class="col-md-12">
					<input name="whereTrip" type="text" class="form-control"
						placeholder="어디로 떠나세요?">
				</div>
				<div class="col-md-6">
					<input name="whereTrip" type="text" class="form-control"
						placeholder="인천/김포 출발">
				</div>
				<div class="col-md-6">
					<input name="whereTrip" type="text" class="form-control"
						placeholder="여행시작일 선택">
				</div>
				<div class="col-md-12">
					<button type="button" class="btn">검색</button>
				</div>
				<div>
					<div><a href="/item/testList">메인화면 입니다. (누르면 3분할 화면으로 이동)</a></div>
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
					  <path d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z"/>
					  <path d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
					</svg> 출발지 선택
					
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar-range" viewBox="0 0 16 16">
					  <path d="M9 7a1 1 0 0 1 1-1h5v2h-5a1 1 0 0 1-1-1zM1 9h4a1 1 0 0 1 0 2H1V9z"/>
					  <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
					</svg> 여행시작일 선택
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div>
			<img alt="테스트" src="/resources/images/test.png">
		</div>
	</div>
</div>
</body>
</html>