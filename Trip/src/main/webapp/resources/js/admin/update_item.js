//달력 스타일 datepicker
$.datepicker.setDefaults({
  dateFormat: 'yy-mm-dd',
  prevText: '이전 달',
  nextText: '다음 달',
  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
  showMonthAfterYear: true,
  yearSuffix: '년'
});

//출발일, 도착일 이전날짜 비활성화
$(function() {
        $("#startDate").datepicker({
            minDate: 0
        });                           
});
$(function() {
        $("#endDate").datepicker({
            minDate: 1
            
        });                           
});

function updateItem(){
	
	var updateForm = document.getElementById('itemUpdateForm');
	
	var con = confirm('해당 상품을 수정하시겠습니까?');
	if(con){
		alert('수정 완료');
		updateForm.submit();
	}
}