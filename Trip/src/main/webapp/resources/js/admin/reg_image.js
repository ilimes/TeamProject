function previewImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files || input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        var reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            var previewImage = document.getElementById("previewImage")
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}
// input file에 change 이벤트 부여
var inputImage = document.getElementById("slideImage")
inputImage.addEventListener("change", e => {
    previewImage(e.target)
})

function regImage(){
	
	var regForm = document.getElementById('slideImageForm');
	
	regForm.submit();
	
	location.href='/admin/regItem';
}
/*$.ajax({
   url: '/admin/regItem', //요청경로
    type: 'post',
    data:{}, //필요한 데이터 '데이터이름':값
    success: function(result) {
      //ajax 실행 성공 후 실행할 코드 작성
      alert('성공');
    },
    error: function(){
      //ajax 실행 실패 시 실행되는 구간
       alert('실패');
    }
});*/