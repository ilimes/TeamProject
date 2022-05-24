<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link href="/resources/css/chat/login.css" rel="stylesheet">
<title>Home</title>
</head>
<div class="chatLogin">
	<div class="chatLogins">
	    <div class="a">
            <div style="text-align: center; font-size: 24px;"><svg xmlns="http://www.w3.org/2000/svg" width="37" height="37" fill="currentColor" class="bi bi-chat" viewBox="0 0 19 19">
			  <path d="M2.678 11.894a1 1 0 0 1 .287.801 10.97 10.97 0 0 1-.398 2c1.395-.323 2.247-.697 2.634-.893a1 1 0 0 1 .71-.074A8.06 8.06 0 0 0 8 14c3.996 0 7-2.807 7-6 0-3.192-3.004-6-7-6S1 4.808 1 8c0 1.468.617 2.83 1.678 3.894zm-.493 3.905a21.682 21.682 0 0 1-.713.129c-.2.032-.352-.176-.273-.362a9.68 9.68 0 0 0 .244-.637l.003-.01c.248-.72.45-1.548.524-2.319C.743 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.52.263-1.639.742-3.468 1.105z"/>
			</svg> <strong>오픈 채팅에 오신것을 환영합니다.</strong>
			</div>
			<div style="text-align: center; font-size: 14px; margin-top: 10px; margin-bottom: 30px;  color: #888">
				<div>닉네임을 입력하신 뒤 엔터키를 입력하시거나 입장하기 버튼을 눌러주세요 :)</div>
			</div>
            <div class="panel-body">
                <form id="loginForm" method="post" action="/chat/loginProcess">
                	<input type="hidden" name="menuCode" value="MENU_003">
                    <div>
                        <input type="text"  name="id" class="form-control" id="nickname" placeholder="닉네임을 입력해주세요." onkeydown="if (event.keyCode == 13) { loginChat(); }" autofocus>
                    	<input type="text" style="display: none;"/>
                    </div>
                    <div>
                        <div class="btnBlack" onclick="loginChat();" onkeydown="if (event.keyCode == 13) { loginChat(); }">입장하기</div>
                    </div>
                </form>
            </div>
        </div>
	</div>
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
<script type="text/javascript">
function loginChat(){
	if(document.getElementById('nickname').value == ''){
		document.getElementById('modalBody').innerText = '닉네임을 입력해주세요.';
		var modalTag = document.getElementById('alertModal');   
		var myModal = new bootstrap.Modal(modalTag);
		myModal.show();
		return;
	}
	else{
		loginForm.submit();
	}
}
</script>
</html>