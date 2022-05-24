var timer = null;
var isRunning = false;
var isCertification = false;	
var radio1 = document.getElementById('btnradio1');
var radio2 = document.getElementById('btnradio2');
$('#certiJoinForm').validate({
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
			birthdayCk: true
		},
		memId:{
			required: true,
			idCk: true
		}
	},
	//유효성 검사 실패 시 나타날 메세지 설정
	messages: {
		memName:{
			required: "한글 2 ~ 4자를 입력해주세요.",
			nameCk: "한글 2 ~ 4자를 입력해주세요."
		},
		memBirthday:{
			required: "생년월일을 입력해주세요.(예:19900101)",
			birthdayCk: "생년월일을 입력해주세요.(예:19900101)"
		},
		memId: { 
			required: "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.",
			idCk: "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다."
		}
	},
	//유효성 실패 시 추가할 태그(default:lable)
	focusInvalid: false,
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
		var id = document.getElementById('memId').value + '@' + document.getElementById('memEmail').value;
		$.ajax({
			url: '/member/selectId', //요청경로
			type: 'post',
			data: {'memId':id}, //필요한 데이터 '데이터이름':값
			success: function(result) {
				//ajax 실행 성공 후 실행할 코드 작성
        		$('#alertModal').modal('show');
				if(result){
					document.getElementById('modalBody').innerText = '중복된 이메일(아이디)입니다. 다른 이메일(아이디)을 입력하세요.';
				}
				else{
					document.getElementById('modalBody').innerText = '회원가입 가능한 이메일(아이디)입니다.';
					$("#sendNum").attr("disabled", false);
				}
					
			},
			error: function() {
				//ajax 실행 실패 시 실행되는 구간
				alert('실패');
			}
		});
	}
});

$('#certiJoinForm2').validate({
	//true : 유효성 검사 성공 시에도 submit이 되지 않음.
	debug: false,
	
	//유효성 검사 대상 설정
	rules: {
		memCertiNum:{
			required: true,
			certiNum: true
		}
	},
	//유효성 검사 실패 시 나타날 메세지 설정
	messages: {
		
		memCertiNum:{
			required: "인증번호(공백없이 8자리 영문대소문자, 숫자)를 입력하세요.",
			certiNum: "인증번호(공백없이 8자리 영문대소문자, 숫자)를 입력하세요."
		}
	},
	//유효성 실패 시 추가할 태그(default:lable)
	errorElement: 'div',
	//유효성 검사 실패 시 메세지 출력 방식
	errorPlacement: function(error, element) {
		//element:유효성 검사 실패한 태그(input)
		//error:검사 실패 시 자동 추가되는 태그
		error.insertAfter($(element).closest("div").next());
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
		var memCertiNum = document.getElementById('memCertiNum').value;
		$.ajax({
		    url: '/member/certification', //요청경로
		    type: 'post',
		    data:{'memCertiNum':memCertiNum}, //필요한 데이터 '데이터이름':값
		    success: function(result) {
		      //ajax 실행 성공 후 실행할 코드 작성
        	$('#alertModal').modal('show');
		    if(result){
		    	document.getElementById('modalBody').innerText = '이메일 인증이 완료되었습니다.';
		    	$('#btnChk').attr("disabled",true);
		    	$('#sendNum').attr("disabled",true);
		    	$('#idChkBtn').attr("disabled",true);
		    	$('#memCertiNum').attr("readonly",true);
		    	$('#timer').html("");
		    	isRunning = false;
		    	isCertification = true;
		    	clearInterval(timer);
			}
			else{
				document.getElementById('modalBody').innerText = '인증번호가 일치하지 않습니다. 다시 입력해주세요.';
			}
		    },
		    error: function(){
		      //ajax 실행 실패 시 실행되는 구간
		       alert('실패');
		    }
		});
	
	}
});

function startTimer(count, display) {
    		var minutes, seconds;
            timer = setInterval(function () {
            minutes = parseInt(count / 60, 10);
            seconds = parseInt(count % 60, 10);
     
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;
     
            display.html("남은시간 " + minutes + ":" + seconds);
            // 타이머 끝
            if (--count < 0) {
    		 $('#alertModal').modal('show');
    	     clearInterval(timer);
    	     display.html("시간초과");
    	     document.getElementById('modalBody').innerText = "인증번호 입력시간이 초과되었습니다. 인증요청을 다시 해주세요.";
    	     $('#sendNum').html("인증번호 요청하기");
    	     $('#btnChk').attr("disabled",true);
    	     isRunning = false;
            }
      		  }, 1000);
             isRunning = true;
}

function certiJoin() {
	if(isCertification){
		$('.removeParent').unwrap();
		var str = '<form action="/member/joinForm" method="post" id="test">';
		$('.removeParent').wrap(str);
		$('#test').submit();
		
		
	}else{
		$('#alertModal').modal('show');
		document.getElementById('modalBody').innerText = "인증을 받지 못했습니다. 인증을 해주세요.";
	}
}

$('#selectEmail').change(function(){
	 $("#selectEmail option:selected").each(function () {
		 if($(this).val()== '1'){
			 	$("#memEmail").val('');
			 	$("#memEmail").attr("readonly",false);
		 }else{ 
				$("#memEmail").val($(this).text());
				$("#memEmail").attr("readonly",true);
		 }
  }); 
});

function sendNum1() {
		var memId = document.getElementById('memId').value + "@" + document.getElementById('memEmail').value;
		var memName = document.getElementById('memName').value;
		var display = $('#timer');
		var leftSec = 180;
		if($('#sendNum').html() == "재요청"){
			$('#btnChk').attr("disabled",true);
			$('#memId').attr("readonly",false);
			$('#memBirthday').attr("readonly",false);
			$('#memName').attr("readonly",false);
			$("#selectEmail option").not(":selected").attr("disabled", false);
			radio1.setAttribute('onClick', 'return(true);');
			radio2.setAttribute('onClick', 'return(true);');
			clearInterval(timer);
			display.html("");
			$('#sendNum').html("인증번호 요청하기");
		}
		else{
		$('#sendNum').html("재요청");
		$('#btnChk').attr("disabled",false);
		$('#memId').attr("readonly",true);
		$('#memBirthday').attr("readonly",true);
		$('#memName').attr("readonly",true);
		$("#selectEmail option").not(":selected").attr("disabled", true);
		radio1.setAttribute('onClick', 'return(false);');
		radio2.setAttribute('onClick', 'return(false);');
		// 남은 시간
		// 이미 타이머가 작동중이면 중지
		if (isRunning){
			clearInterval(timer);
			display.html("");
			startTimer(leftSec, display);
		}else{
		startTimer(leftSec, display);
			
		}
		$('#btnChk').attr("disabled",false);
		
		
		$.ajax({
		    url: '/member/joinSendMail', //요청경로
		    type: 'post',
		    data:{'memId':memId, 'memName':memName}, //필요한 데이터 '데이터이름':값
		    success: function(result) {
		      //ajax 실행 성공 후 실행할 코드 작성
        	  $('#alertModal').modal('show');
		      document.getElementById('modalBody').innerText = '이메일로 인증번호가 전송되었습니다.';
		    },
		    error: function(){
		      //ajax 실행 실패 시 실행되는 구간
		       alert('실패');
		    }
		});
		}
		

}

function idChkReset() {
		$("#sendNum").attr("disabled", true);
}