<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/member/result_find_pw.css" rel="stylesheet">
</head>
<body>
<div class="loginForm">
	<form action="/member/changePwForm" method="post">
		<input type="hidden" name="memId" id="memId" value="${findPwInfo.memId }">
		<input type="hidden" name="memPw" id="memPw" value="${findPwInfo.memPw }">
		<h3>
			${findPwInfo.memName }님(${findPwInfo.memId})의 <br>
			비밀번호는 ${findPwInfo.memPw } 입니다.
		</h3>
		<div class="btnDiv">
			<input type="button" class="btn btn-secondary" value="로그인" onclick="location.href='/member/loginForm';" >
			<input type="submit" class="btn btn-secondary" value="비밀번호 변경" style="float: right;">
		</div>
	</form>
</div>
</body>
</html>