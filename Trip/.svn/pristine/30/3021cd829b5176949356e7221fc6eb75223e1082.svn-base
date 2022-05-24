$('#findIdForm').validate({
	//true : 유효성 검사 성공 시에도 submit이 되지 않음.
	debug: false,
	
	//유효성 검사 대상 설정
	rules: {
		memName:{
			required: true,
			nameCk: true
		},
		memBirthday:{
			required: true,
			minlength: 8,
			maxlength: 8
		},
		memTell1:{
			required: true,
			tellCK: true
		},
		memTell2:{
			required: true,
			tell2CK: true
		}
	},
	//유효성 검사 실패 시 나타날 메세지 설정
	messages: {
		memName:{
			required: "이름을 입력해주세요.",
			nameCk: "한글 2~4자 입력해주세요"
		},
		memBirthday:{
			required: "생년월일을 입력해주세요.(예:19900101)",
			minlength: "생년월일을 입력해주세요.(예:19900101)",
			maxlength: "생년월일을 입력해주세요.(예:19900101)"
		},
		memTell1:{
			required: "숫자를 입력해주세요",
			tellCK: "숫자를 입력해주세요"
		},
		memTell2:{
			required: "숫자를 입력해주세요",
			tell2CK: "숫자를 입력해주세요"
		}
	},
	//유효성 실패 시 추가할 태그(default:lable)
	errorElement: 'div',
	//유효성 검사 실패 시 메세지 출력 방식
	errorPlacement: function(error, element) {
		//element:유효성 검사 실패한 태그(input)
		//error:검사 실패 시 자동 추가되는 태그
		error.insertAfter($(element).closest("div"));
		error.css('color', 'red');
		//error.css('font-size', '12px');
	},
	//유효성 검사 실패 시 디자인
	highlight: function ( element, errorClass, validClass ) {
      $(element).addClass('is-invalid').removeClass('is-valid');
   },
   //유효성 검사 성공 시 디자인
   unhighlight: function (element, errorClass, validClass) {
      $(element).addClass('is-valid').removeClass('is-invalid');
   },
	//유효성 검사 성공 시 실행
	submitHandler: function(form) {
		var memName = document.getElementById('memName').value;
		var memGender = $('input[name="memGender"]:checked').val();
		var memBirthday = document.getElementById('memBirthday').value;
		var memTell = document.getElementById('inputState').value + '-' + document.getElementById('memTell1').value + '-' + document.getElementById('memTell2').value;
		
		$.ajax({
		    url: '/member/findId', //요청경로
		    type: 'post',
		    data:{'memName':memName, 'memGender':memGender, 'memBirthday':memBirthday, 'memTell':memTell}, //필요한 데이터 '데이터이름':값
		    success: function(result) {
		      //ajax 실행 성공 후 실행할 코드 작성
		     	if(result == 'deactivate'){
			     	$('#alertModal').modal('show');
					document.getElementById('modalBody').innerText = '탈퇴한 회원입니다.';
				}else if(result == ''){
			     	$('#alertModal').modal('show');
					document.getElementById('modalBody').innerText = '입력하신 정보로 가입하신 아이디가 없습니다.';
				}else{
					location.href='/member/resultFindIdForm?memId=' + result;
				}
		    },
		    error: function(){
		      //ajax 실행 실패 시 실행되는 구간
		       alert('실패');
		    }
		});
	}
});