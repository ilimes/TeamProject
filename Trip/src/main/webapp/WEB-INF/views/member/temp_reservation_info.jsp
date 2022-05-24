<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/member/join.css" rel="stylesheet">
<style type="text/css">
thead tr {
	text-align: center;
}
h4{
	font-weight: bold;
	line-height: 1.2em;
}
</style>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-9">
			<div class="titleDiv">
				<h3>비회원 예약조회</h3>
			</div>
			<div style="text-align: center; margin-top: 30px;"><h5>회원님께서 구매하신 상품 정보 및 예약 정보입니다.</h5></div>
			<div class="titleDiv">
				<h4>상품정보</h4>
			</div>
			<div class="row">
				<div class="col-6">
					<div style="text-align: center;">
						<img alt="상품 썸네일" src="/resources/images/${tempMemberBookInfo.attachedImgName }" style="width: 350px; height: 250px;">
					</div>
				</div>
				<div class="col-6">
					<div class="row">
						<div class="col-4"><label for="inputEmail4" class="form-label">예약번호</label></div>
						<div class="col-8">
							<label>${tempMemberBookInfo.bookNum }</label>
						</div>
					</div>
					<div class="row">
						<div class="col-4"><label for="inputEmail4" class="form-label">예약날짜</label></div>
				   		<div class="col-8">
				   			<label>${tempMemberBookInfo.bookDate }</label>
				    	</div>
				    </div>
					<div class="row">
						<div class="col-4"><label for="inputEmail4" class="form-label">상품명</label></div>
						<div class="col-8">
							<label>${tempMemberBookInfo.itemName }</label>
						</div>
					</div>
					<div class="row">
						<div class="col-4"><label class="form-label">상품코드</label></div>
				    	<div class="col-8">
				    		<label>${tempMemberBookInfo.itemCode }</label>
				     	</div>
					</div>
					<div class="row">
						<div class="col-4"><label for="inputEmail4" class="form-label">여행기간</label></div>
				   		<div class="col-8">
				   			<label>${tempMemberBookInfo.startDate }~${tempMemberBookInfo.endDate } <strong>(${tempMemberBookInfo.tripDate })</strong></label>
				    	</div>
				    </div>
					<div class="row">
						<div class="col-4"><label for="inputEmail4" class="form-label">상품금액(1인당)</label></div>
				   		<div class="col-8">
				   			<label><fmt:formatNumber value="${tempMemberBookInfo.originPrice }" pattern="#,###원"/></label>
				    	</div>
				    </div>
					<div class="row">
						<div class="col-4"><label for="inputEmail4" class="form-label">결제하신 금액</label></div>
				   		<div class="col-8">
				   			<label><fmt:formatNumber value="${tempMemberBookInfo.originPrice }" pattern="#,###원"/> X ${tempMemberBookInfo.travelers }명 = <fmt:formatNumber value="${tempMemberBookInfo.buyPrice }" pattern="#,###원"/></label>
				    	</div>
				    </div>
				
				</div>
			
			</div>
			<div style="height: 50px;"></div>
			<div class="titleDiv">
				<h4>예약자정보</h4>
			</div>
			<div class="row">
				<div class="col-3">
					<div><label for="inputEmail4" class="form-label">이메일 주소</label></div>
					<div>
						<label>${tempMemberInfo.tempEmail }</label>
					</div>
				</div>
				<div class="col-3">
					<div><label class="form-label">이름</label></div>
			    	<div>
			    		<label>${tempMemberInfo.tempName }</label>
				    	<label for="inputCity" class="form-label">&nbsp;</label> 
			     	</div>
				</div>
				<div class="col-3">
					<div><label for="inputEmail4" class="form-label">생년월일</label></div>
			   		<div>
			   			<label>${tempMemberInfo.tempBirthday }</label>
			    	</div>
			    </div>
				<div class="col-3">
					<div><label for="inputEmail4" class="form-label">연락처</label></div>
			   		<div>
			   			<label>${tempMemberInfo.tempTell }</label>
			    	</div>
			    </div>
			</div>
			<div style="height: 12px;"></div>
			<div class="row mb-3">
		    	<div class="col-3">
					<div><label class="form-label">성별</label></div>
						<label>${tempMemberInfo.tempGender }</label>
		     		</div>
				<div class="col-3">
				   	<label for="addr" class="form-label">우편번호</label>
				   	<div><label>${tempMemberInfo.tempZipcode }</label></div>
				</div>
				<div class="col-6">
					<label for="addr" class="form-label">주소</label>
					<div><label>${tempMemberInfo.tempAddr } ${tempMemberInfo.tempAddrDetail }</label></div>
				</div>
			</div>
			<div style="height: 12px;"></div>
			<div style="display: flex; justify-content: flex-end;">
				<!-- <button type="button" class="btn btn-secondary" style="margin-top: 30px; width: 180px; height: 50px; margin-right: 20px;" onclick="location.href='';">예약정보 수정</button> -->
				<button type="button" class="btn btn-danger" style="margin-top: 30px; width: 180px; height: 50px;" data-bs-toggle="modal" data-bs-target="#deleteModal">예약 취소</button>
			</div>
		</div>
	</div>
</div>
</body>
<!-- 삭제 Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">경고</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>취소한 예약은 되돌릴 수 없습니다.</div>
        <div>정말 취소하시겠습니까?</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btns" onclick="location.href='/buy/deleteTempBook?tempEmail=${tempMemberInfo.tempEmail }&bookNum=${tempMemberBookInfo.bookNum }';" style="display: inline-block; width: 90px; padding: 0; background: #D82148; box-shadow: 0px 1px 5px 0px #d82148, 5px 5px 15px 5px rgb(0 0 0 / 0%);">삭제</button>
        <button type="button" class="btns" data-bs-dismiss="modal" style="display: inline-block; width: 90px; padding: 0; background: #ddd; color: black; box-shadow: 0px 1px 5px 0px #333, 5px 5px 15px 5px rgb(0 0 0 / 0%);">취소</button>
      </div>
    </div>
  </div>
</div>
</html>