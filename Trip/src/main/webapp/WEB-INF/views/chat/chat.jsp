<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Chat</title>
<link href="/resources/css/chat/chat.css" rel="stylesheet">
</head>
<body>
    <div class="chatMain">
		<div class="titleDiv">
			<h3><svg xmlns="http://www.w3.org/2000/svg" width="37" height="37" fill="currentColor" class="bi bi-chat" viewBox="0 0 19 19">
			  <path d="M2.678 11.894a1 1 0 0 1 .287.801 10.97 10.97 0 0 1-.398 2c1.395-.323 2.247-.697 2.634-.893a1 1 0 0 1 .71-.074A8.06 8.06 0 0 0 8 14c3.996 0 7-2.807 7-6 0-3.192-3.004-6-7-6S1 4.808 1 8c0 1.468.617 2.83 1.678 3.894zm-.493 3.905a21.682 21.682 0 0 1-.713.129c-.2.032-.352-.176-.273-.362a9.68 9.68 0 0 0 .244-.637l.003-.01c.248-.72.45-1.548.524-2.319C.743 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.52.263-1.639.742-3.468 1.105z"></path>
			</svg> 오픈채팅</h3>
		</div>
		<div style="text-align: center; font-size: 14px; margin-top: 10px; margin-bottom: 30px;  color: #888">
			<div>오픈채팅은 누구나 이용할 수 있는 공간입니다. 매너채팅 부탁드립니다 😊</div>
		</div>
		<div style="margin-bottom: 20px;">
	        <button type="button" class="btn btn-secondary" onclick="openSocket();"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 1 16 16">
			  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
			  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
			</svg> 대화방 참여</button>
	        <button type="button" class="btn btn-warning" onclick="javascript:clearText();"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-magic" viewBox="0 1 16 16">
			  <path d="M9.5 2.672a.5.5 0 1 0 1 0V.843a.5.5 0 0 0-1 0v1.829Zm4.5.035A.5.5 0 0 0 13.293 2L12 3.293a.5.5 0 1 0 .707.707L14 2.707ZM7.293 4A.5.5 0 1 0 8 3.293L6.707 2A.5.5 0 0 0 6 2.707L7.293 4Zm-.621 2.5a.5.5 0 1 0 0-1H4.843a.5.5 0 1 0 0 1h1.829Zm8.485 0a.5.5 0 1 0 0-1h-1.829a.5.5 0 0 0 0 1h1.829ZM13.293 10A.5.5 0 1 0 14 9.293L12.707 8a.5.5 0 1 0-.707.707L13.293 10ZM9.5 11.157a.5.5 0 0 0 1 0V9.328a.5.5 0 0 0-1 0v1.829Zm1.854-5.097a.5.5 0 0 0 0-.706l-.708-.708a.5.5 0 0 0-.707 0L8.646 5.94a.5.5 0 0 0 0 .707l.708.708a.5.5 0 0 0 .707 0l1.293-1.293Zm-3 3a.5.5 0 0 0 0-.706l-.708-.708a.5.5 0 0 0-.707 0L.646 13.94a.5.5 0 0 0 0 .707l.708.708a.5.5 0 0 0 .707 0L8.354 9.06Z"/>
			</svg> 대화내용 지우기</button>
	        <button type="button" class="btn btn-danger" onclick="closeSocket();"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 1 16 16">
			  <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
			  <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
			</svg> 대화방 나가기</button>
		</div>
    <!-- Server responses get written here -->
    <div id="messages">
    </div>
    	<br>
    	<div style="margin-bottom: 10px;">
	  		<?xml version="1.0" ?><svg fill="none" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M10.75 14C11.9926 14 13 15.0074 13 16.25V17.752L12.9921 17.8604C12.6814 19.9866 10.7715 21.009 7.56679 21.009C4.37361 21.009 2.4333 19.9983 2.01446 17.8966L2 17.75V16.25C2 15.0074 3.00736 14 4.25 14H10.75ZM10.75 15.5H4.25C3.83579 15.5 3.5 15.8358 3.5 16.25V17.6704C3.77979 18.8708 5.05063 19.509 7.56679 19.509C10.0829 19.509 11.2966 18.8777 11.5 17.6932V16.25C11.5 15.8358 11.1642 15.5 10.75 15.5ZM7.5 6C9.433 6 11 7.567 11 9.5C11 11.433 9.433 13 7.5 13C5.567 13 4 11.433 4 9.5C4 7.567 5.567 6 7.5 6ZM19.75 2C20.9926 2 22 3.00736 22 4.25V7.75C22 8.99264 20.9926 10 19.75 10H18.2951L16.1286 12.1414C15.6375 12.6266 14.846 12.6219 14.3608 12.1308C14.1296 11.8968 14 11.5812 14 11.2526L13.9994 9.9862C12.8747 9.86155 12 8.90792 12 7.75V4.25C12 3.00736 13.0074 2 14.25 2H19.75ZM7.5 7.5C6.39543 7.5 5.5 8.39543 5.5 9.5C5.5 10.6046 6.39543 11.5 7.5 11.5C8.60457 11.5 9.5 10.6046 9.5 9.5C9.5 8.39543 8.60457 7.5 7.5 7.5ZM19.75 3.5H14.25C13.8358 3.5 13.5 3.83579 13.5 4.25V7.75C13.5 8.16421 13.8358 8.5 14.25 8.5H15.4986L15.4997 10.6539L17.6789 8.5H19.75C20.1642 8.5 20.5 8.16421 20.5 7.75V4.25C20.5 3.83579 20.1642 3.5 19.75 3.5Z" fill="#212121"/></svg>
	  		 <strong>${sessionScope.id}</strong> 
  		 </div>
        <input type="text" id="sender" value="${sessionScope.id}" style="display: none;">
        <input type="text" id="serverIpAddress" value="${serverIpAddress}" style="display: none;">
        <input type="text" class="form-control" id="messageinput" onkeydown="if (event.keyCode == 13) { send(); }" autofocus style="display:inline-block; margin: 0 10px 0 2px; width: 550px; height: 50px;">
        <button type="button" class="btns" onclick="send();" style="display: inline-block; width: 133px; font-size: 16px; padding: 0;">전송</button>
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

<!-- websocket javascript -->
<script type="text/javascript">
        var ws;
        var messages = document.getElementById("messages");
        var serverIpAddress = document.getElementById("serverIpAddress").value;
        
    	openSocket();
        
        function openSocket(){
            if(ws !== undefined && ws.readyState !== WebSocket.CLOSED ){
                writeResponse("이미 대화방에 접속되어 있습니다.");
                return;
            }
            //웹소켓 객체 만드는 코드
            ws = new WebSocket('ws://' + serverIpAddress + ':8081/echo.do');
            
            ws.onopen = function(event){
                if(event.data === undefined){
              		return;
                }
                writeResponse(event.data);
            };
            
            ws.onmessage = function(event){
                console.log('writeResponse');
                console.log(event.data)
                writeResponse(event.data);
                if(event.data == '대화방에 연결 되었습니다.'){
                	firstSend('★ 입장알림');
                	return;
                }
            };
            
            ws.onclose = function(event){
                writeResponse("대화 종료");
            }
            
        }
        
        function send(){
        	if(document.getElementById('messageinput').value == ''){
    			document.getElementById('modalBody').innerText = '빈 내용을 보낼 수 없습니다. \n반드시 채팅 내용을 입력해주세요.';
    			var modalTag = document.getElementById('alertModal');   
       			var myModal = new bootstrap.Modal(modalTag);
        		myModal.show();
        		return;
        	}
            var text = document.getElementById("messageinput").value+","+document.getElementById("sender").value;
            ws.send(text);
            document.getElementById("messageinput").value = "";
        }
        
        function firstSend(tell) {
			ws.send(document.getElementById("sender").value + "," + tell);
		}
        
        function lastSend(tell) {
			ws.send(document.getElementById("sender").value + "," + tell);
		}
        
        function closeSocket(){
        	lastSend('★ 퇴장알림');
            ws.close();
        }
        
        function writeResponse(text){
            /* messages.innerHTML += "<br/>"+text; */
            messages.innerHTML += "<div class='responseMessage'>" + text + "</div>";
            messages.scrollTop = messages.scrollHeight;
        }
        function clearText(){
            console.log(messages.parentNode);
            let today = new Date();
            messages.innerHTML = "대화내용이 삭제되었습니다. (삭제한 시간 : " + today.toLocaleString() + ")";
      	}
        
  </script>
</body>
</html>