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
.col-3 > div:nth-child(2) > label, .col-6 > div:nth-child(2) > label {
/* 	font-weight: bold;
	color: #333;
	background: linear-gradient(to top, #E0DCFE 60%, transparent 50%);
	border-top-left-radius: 20px;
	border-bottom-right-radius: 5px;
	padding: 0 5px 0 5px; */
}
.intrinsic-container {
    position: relative;
    padding: 1em 1.5em;
    margin: 1.6em auto;
    background: #DDDDDD;
}
.intrinsic-container:before {
    content: "";
    position: absolute;
    top: 0;
    right: 0;
    border-width: 0 20px 20px 0;
    border-style: solid;
    border-color: #a5a6a7 #fff;
}
</style>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-9">
			<div class="titleDiv">
				<h3>마이 페이지</h3>
			</div>
			<div class="intrinsic-container">
				<div class="row">
					<div class="col-3">
						<div><label for="inputEmail4" class="form-label">아이디</label></div>
						<div>
							<label>${memInfo.memId }</label>
						</div>
					</div>
					<div class="col-3">
						<div><label class="form-label">이름</label></div>
				    	<div>
				    		<label>${memInfo.memName }</label>
				     	</div>
					</div>
					<div class="col-3">
						<div><label for="inputEmail4" class="form-label">생년월일</label></div>
				   		<div>
				   			<label>${memInfo.memBirthday }</label>
				    	</div>
				    </div>
					<div class="col-3">
						<div><label for="inputEmail4" class="form-label">회원가입일</label></div>
				   		<div>
				   			<label>${memInfo.joinDate }</label>
				    	</div>
				    </div>
				</div>
				<div style="height: 16px;"></div>
				<div class="row mb-3">
			    	<div class="col-3">
						<div><label class="form-label">성별</label></div>
						<div>
							<label>${memInfo.memGender }</label>
						</div>
			     	</div>
					<div class="col-3">
					   	<div><label for="addr" class="form-label">우편번호</label></div>
					   	<div><label>${loginInfo.memZipcode }</label></div>
					</div>
					<div class="col-6">
						<div><label for="addr" class="form-label">주소</label></div>
						<div><label>${loginInfo.memAddr} ${loginInfo.memAddrDetail}</label></div>
					</div>
				</div>
				<div style="height: 12px;"></div>
				<div class="row">
					<div class="col-3">
						<div><label for="inputState" class="form-label">연락처</label></div>
						<div>
							<label>${loginInfo.memTell }</label>
					    	<%-- <input type="text" class="form-control" value="${loginInfo.memTell }" style="display:inline-block;"readonly> --%>
						</div>
					</div>
					<div class="col-3">
						<div><label for="inputState" class="form-label">패키지 구매횟수</label></div>
						<div>
							<label>${memInfo.buyCnt }회</label>
						</div>
					</div>
					<div class="col-3">
						<div><label for="inputState" class="form-label">총 구매금액</label></div>
						<div>
							<label><fmt:formatNumber value="${memInfo.totalPrice }" pattern="#,###원"/></label>
						</div>
					</div>
					<div class="col-3">
						<div><label for="inputState" class="form-label">보유 마일리지</label></div>
						<div>
							<label><fmt:formatNumber value="${memInfo.memPoint }" pattern="#,###P"/></label>
						</div>
					</div>
					<div style="height: 10px;"></div>
				</div>
			
			</div>
			<div class="row mt-3">
				<table class="table">
					<thead>
						<tr>
							<td>예약번호</td>
							<td>패키지명</td>
							<td>예약인원</td>
							<td>결제금액</td>
							<td>예약일</td>
							<td>여행 기간</td>
						</tr>
					</thead>
					<tbody>
					<c:if test="${empty buyList }">
						<tr>
							<td colspan="7">예약 목록이 존재하지 않습니다.</td>
						</tr>
					</c:if>
					<c:forEach items="${buyList }" var="buyInfo">
						<tr>
							<td>${buyInfo.bookNum }</td>
							<td>${buyInfo.itemName }</td>
							<td>${buyInfo.travelers }명</td>
							<td><fmt:formatNumber value="${buyInfo.buyPrice }" pattern="#,###원"/></td>
							<td>${buyInfo.bookDate }</td>
							<td>${buyInfo.startDate } ~ ${buyInfo.endDate }</td>
							<td></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div style="display: flex; justify-content: flex-end;">
				<button type="button" class="btns" style="margin-top: 30px; width: 180px; height: 50px;" onclick="location.href='/member/changeMemberInfoForm';">회원정보 수정</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>