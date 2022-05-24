function mainCheck(){
	var checkbox = document.getElementById('isMain');
	
	if(checkbox.value == 'N'){
		checkbox.value = 'Y';
	}
	else{
		checkbox.value = 'N';
	}
}

function boardWrite(){
	
	var title = document.getElementById('title').value;
	
	if(title == ''){
		alert('제목은 필수입력입니다.');
		return;
	}
	
	var content = document.getElementById('content').value;
	
	if(CKEDITOR.instances.content.getData() =='' 
	        || CKEDITOR.instances.content.getData().length ==0){
		/*var modalTag = document.getElementById('contentCheckModal');   
        var myModal = new bootstrap.Modal(modalTag);
        myModal.show();
	    $("#content").focus();*/
	    alert('내용은 필수입력입니다.');
	    return false;
	}
	
	var boardWriteForm = document.getElementById('boardWriteForm');
	alert('등록 완료');
	boardWriteForm.submit();
	
}