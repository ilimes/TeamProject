<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.txt, .btn{
	width: 500px;
}
.loginForm{
    width: 580px;
    height: 500px;
    margin: 0 auto;
    padding: 10px 40px;
    border-radius: 10px;
}
.loginForm h2{
	text-align: center;
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    margin-bottom: 50px;
}
.btns, .btn{
	padding: 0;
	font-size: 15px;
}
</style>
</head>
<body>
<div class="loginForm">
	<h2>비밀번호 변경하기</h2>
	<form action="/member/changePw" method="post" id="changePwForm" onsubmit="return false;">
		<input type="hidden" id="memNowPwChk" value="${findPwInfo.memPw }">
		<div class="col-12">
	      <label for="inputEmail4" class="form-label">아이디</label>
	      <div>
		      <input type="text" class="form-control" id="memId" name="memId" value="${findPwInfo.memId }" readonly>
	      </div>
	   </div>
	   <div class="col-12">
	      <label for="inputEmail4" class="form-label">현재 비밀번호</label>
	      <div>
      			<input type="password"class="form-control" id="memNowPw" name="memNowPw" placeholder="현재 비밀번호" onkeyup="checkCapsLock1(event)">
      			<div id='message1'style="color: red"></div>	
	      </div>
	   </div>
	   <div class="col-12">
	      <label for="inputEmail4" class="form-label">새 비밀번호</label>
	      <div>
		      <input type="password" class="form-control"id="memPw" name="memPw" placeholder="새 비밀번호" onkeyup="checkCapsLock2(event)">
	      		<div id='message2'style="color: red"></div>	
	      </div>
	   </div>
	   <div class="col-12">
	      <label for="inputEmail4" class="form-label">새 비밀번호 확인</label>
	      <div>
		      <input type="password" class="form-control"id="memPwChk" name="memPwChk" placeholder="새 비밀번호 확인" onkeyup="checkCapsLock3(event)">
	      		<div id='message3'style="color: red"></div>
	      </div>
	   </div>
		<div class="d-grid gap-2 col-12 mx-auto">
		  <button class="btns btn-primary" type="submit" id="btnLogin" style="padding: 0; margin-top: 20px;">비밀번호 변경하기</button>
		</div>
	</form>
</div>
<div class="modal fade" id="alertModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">알림</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div id="modalBody"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btns" data-bs-dismiss="modal" id="btnOk" style="display: inline-block; width: 90px; padding: 0; background: #ddd; color: black; box-shadow: 0px 1px 5px 0px #333, 5px 5px 15px 5px rgb(0 0 0 / 0%);">확인</button>
      </div>
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="/resources/js/member/validate_common.js" type="text/javascript"></script>
<script src="/resources/js/member/change_pw.js?ver=4" type="text/javascript"></script>
</body>
</html>