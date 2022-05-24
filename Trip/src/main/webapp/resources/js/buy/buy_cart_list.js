//선택 구매
function buyCartsCheck(){
   //선택된 체크박스
   var chk = document.querySelectorAll('.chk:checked');
   
   if(chk.length == 0){
      //모달창을 띄우기
        var modalTag = document.getElementById('buyCheckModal');   
        var myModal = new bootstrap.Modal(modalTag);
        myModal.show();
      return;
   }
   else{
      buyCarts();
   }
}

//전체 구매
function buyAllCarts(){
   var checkboxes = document.getElementsByClassName('chk');
   
   for(var i = 0 ; i < checkboxes.length ; i++){
      checkboxes[i].checked = true;
   }
   
   buyCartsCheck();
   
}

//선택 구매 실행
function buyCarts(){
   var checked = document.querySelectorAll('.chk:checked')
   
   var objArr = [];
   //체크박스에 체크된 itemCode 수량 가져오기
   for (var i = 0; i < checked.length; i++) {
         var obj = new Object();
         
         obj.itemCode = checked[i].value; //itemCode
         obj.travelers = checked[i].closest('tr').querySelector('input[type="number"]').value;
         
         objArr[i] = obj;
      }
      
   //json : json 문자열로 변환   
   
   
   
   
   $('#buyListInfo').val(JSON.stringify(objArr));
   $('#goBuyListInfo').submit();
   
   
/*   $.ajax({
      url: '/buy/tripBook', //요청경로
      type: 'post',
      data: {'data':JSON.stringify(objArr)}, //필요한 데이터 '데이터이름':값
      success: function(result) {
         //ajax 실행 성공 후 실행할 코드 작성
         alert('상품을 구매하셨습니다.');
         location.href = '/buy/buyForm2';
      },
      error: function() {
         //ajax 실행 실패 시 실행되는 구간
         alert('실패');
      }
   });*/
   
}