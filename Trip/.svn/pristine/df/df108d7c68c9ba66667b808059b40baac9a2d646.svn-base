console.log(location.origin);
document.cookie = "safeCookie1=foo; SameSite=Lax"; 
document.cookie = "safeCookie2=foo";  
document.cookie = "crossCookie=bar; SameSite=None; Secure";

var IMP = window.IMP; // 생략 가능
IMP.init("imp23834522"); // 예: imp00000000
    
    function requestPay() {
      // IMP.request_pay(param, callback) 결제창 호출
      IMP.request_pay({ // param
          pg: "html5_inicis",
          pay_method: "card",
          merchant_uid: "ORD20180131-0000011",
          name: "노르웨이 회전 의자",
          amount: 64900,
          buyer_email: "gildong@gmail.com",
          buyer_name: "홍길동",
          buyer_tel: "010-4242-4242",
          buyer_addr: "서울특별시 강남구 신사동",
          buyer_postcode: "01181"
      }, function (rsp) { // callback
          if (rsp.success) {
              // 결제 성공 시 로직,
          } else {
              // 결제 실패 시 로직,
          }
      });
    }