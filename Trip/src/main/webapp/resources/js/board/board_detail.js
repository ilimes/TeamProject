function modifyBoardForm(isMainValue){
	var titleTd = document.getElementById('title');
	var contentTd = document.getElementById('content');
	var modifyTag = document.getElementById('modify');
	
	document.getElementById('back').style = 'width: 130px; display:none';
	document.getElementById('delete').style = 'width: 130px; display:none';
	document.getElementById('modify').innerText = '완료';
	
	var sideMenuCode = document.getElementById('sideMenuCode');
	
	if(isMainValue == 'Y'){
		var checked = 'checked';
	}
	else{
		var checked = '';
	}
	
	str = '';
	if(sideMenuCode.value == 'SIDE_MENU_001'){
		str += '<td style="padding-top: 10px; vertical-align: top;">메인글 여부</td>';
		str += '<td style="padding-left: 15px; text-align:left;"><input class="form-check-input" type="checkbox" value="'+ isMainValue +'" name="isMain" id="isMain" onclick="mainCheck();" style="width: 20px; height: 20px; text-align: left; vertical-align: middle;" '+ checked +'></td>';
	}
	else{
		str += '<td><div class="hidden" id="isMain" value="N"></div></td>'
	}
	
	document.getElementById('isMainTr').innerHTML = str;

	var titleText = titleTd.innerText;
	titleTd.innerHTML = '<input class="form-control" type="text" id="titleInput" value="' + titleText + '" style="width: 100%; height: 40px;"></input>';
	
	var contentHTML = contentTd.innerHTML;
	//contentTd.innerHTML = contentTd.innerHTML.replace(/<br>/g, '\r\n');
	contentTd.innerHTML = '<textarea class="form-control" name="contentInput" id="contentInput" style="width: 100%; height: 250px; resize: none;">' + contentHTML + '</textarea>'
	ck = CKEDITOR.replace("contentInput");
	CKEDITOR.instances.contentInput.setData(contentHTML);
	//contentTd.innerHTML = contentTd.innerHTML.replace(/(?:\r\n|\r|\n)/g, '<br>');

	//onclick 속성 변경
	modifyTag.setAttribute('onClick', 'modifyBoard();');
	
	//eventListener
	/*modifyTag.addEventListener('click', function(){
		var title = document.getElementById('titleInput').value;
		var content = document.getElementById('contentInput').value;
		modifyBoard(title, content);		
	});*/
}

/*function deleteBoard(boardNum){
	const result = confirm('정말 삭제하시겠습니까?');
	const sideMenuCode = document.getElementById('sideMenuCode').value;
	const menuCode = document.getElementById('menuCode').value;
	
	if(result){
		location.href='/board/deleteBoard?menuCode=' + menuCode + '&sideMenuCode=' + sideMenuCode + '&boardNum=' + boardNum;
	}
}*/

function deleteBoard(boardNum){
	const sideMenuCode = document.getElementById('sideMenuCode').value;
	const menuCode = document.getElementById('menuCode').value;
	
	location.href='/board/deleteBoard?menuCode=' + menuCode + '&sideMenuCode=' + sideMenuCode + '&boardNum=' + boardNum;
}

function modifyBoard(){
	var titleTd = document.getElementById('title');
	var contentTd = document.getElementById('content');
	var modifyTag = document.getElementById('modify');
	
	const boardNum = document.getElementById('boardNum').value;
	var title = document.getElementById('titleInput').value;
	//var content = document.getElementById('contentInput').value;
	var content = CKEDITOR.instances.contentInput.getData();
	var isMain = document.getElementById('isMain').value;
	
	$.ajax({
	   url: '/board/updateBoard', //요청경로
	    type: 'post',
	    data:{'boardNum':boardNum, 'title':title, 'content':content, 'isMain':isMain}, //필요한 데이터 '데이터이름':값
	    success: function(result) {
	      //ajax 실행 성공 후 실행할 코드 작성
	      titleTd.innerText = result.title;
	      contentTd.innerHTML = result.content;
	      document.getElementById('back').style = 'width: 130px; display:block';
		  document.getElementById('delete').style = 'width: 130px; display:block';
	   	  document.getElementById('modify').innerText = '수정';
	      modifyTag.setAttribute('onClick', 'modifyBoardForm();');
	      document.getElementById('isMainTr').innerHTML = '';
	      $('#modifyModal').modal('show');
	    },
	    error: function(){
	      //ajax 실행 실패 시 실행되는 구간
	       alert('실패');
	    }
	});
}

function mainCheck(){
	var checkbox = document.getElementById('isMain');
	
	if(checkbox.value == 'N'){
		checkbox.value = 'Y';
	}
	else{
		checkbox.value = 'N';
	}
}

function deleteBoardReply(selectedTag){
	var result = confirm('정말 삭제하시겠습니까?');
	if(result){
		selectedTag.closest('#replyFormTag').action = '/board/deleteBoardReply';
		selectedTag.closest('#replyFormTag').submit();
		alert('삭제가 완료되었습니다.');
	}
}

function modifyPopup(selectedTag){
	window.open('/board/popUp?boardNum=' + selectedTag.parentNode.previousElementSibling.value + '&replyNum=' + selectedTag.parentNode.previousElementSibling.previousElementSibling.value + '&content=' + selectedTag.parentNode.nextElementSibling.innerText, '댓글 수정', "width=500,height=500,toolbar=no, status=no,location=no,scrollbars=no,menubar=no,resizable=no,left=50,top=50");
	
}
