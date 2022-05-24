<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/member/result_join.css" rel="stylesheet">
</head>
<body>
<div class="loginForm">
	<h1>환영합니다!</h1>
	<h5>
		${joinInfo.memName }님의 회원가입을 축하드립니다.<br>
		가입하신 아이디는 ${joinInfo.memId}입니다.
	</h5>
	<div class="btnDiv">
		<input type="button" class="btn btn-secondary" value="로그인" onclick="location.href='/member/loginForm';" >
		<input type="button" class="btn btn-secondary" value="메인" onclick="location.href='/item/mainPage';"style="float: right;">
	</div>
</div>
</body>
</html>