//thead체크박스 체크, 해제시 하위 체크박스 체크, 해제
function check(){
	
	var checkAll  = document.querySelector('input[name="checkAll"]'); //thead 체크박스
	var checkboxes = document.querySelectorAll('input[name="check"]'); //forEach문 체크박스
  	
	if (checkAll.checked == true) { 
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = true;
		}
	}
	else {
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = false;
		}
	}
}

function checkSelectAll()  {
 
  // 전체 체크박스
  var checkboxes = document.querySelectorAll('input[name="check"]');
  // 선택된 체크박스
  var checked = document.querySelectorAll('input[name="check"]:checked'); //forEach문에 체크된 체크박스
  //thead 체크박스
  var selectAll = document.querySelector('input[name="checkAll"]');
  
  
  if(checkboxes.length === checked.length)  {
    selectAll.checked = true;
  }
  else {
    selectAll.checked = false;
  }

}

//상단 체크박스 선택, 해제시 목록 체크박스 체크, 해제
function selectAll(selectAll){
	var checkboxes = document.querySelectorAll('input[name="check"]');
       
	checkboxes.forEach((checkbox) => {
		checkbox.checked = selectAll.checked;
  	})
}


//체크된 회원탈퇴
function secession(){
	
	//체크된 항목이 없을때
	var checked  = document.querySelectorAll('input[name="check"]:checked');
	
	if(checked.length == 0){
		alert('선택된 항목이 없습니다.');
		return ;
	}
	
	//체크한 항목이 있을때
	var deleteConfirm = confirm('해당 회원 탈퇴를 승인하시겠습니까?')
	
	if(deleteConfirm){
		
	var memIdArr = [];
	for(var i = 0 ; i < checked.length ; i++){
		memIdArr[i] = checked[i].value;
	}
	location.href ='/admin/SelectMemberSecession?memIdArr=' + memIdArr;
	}
	
}