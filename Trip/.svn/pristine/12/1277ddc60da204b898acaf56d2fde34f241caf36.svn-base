<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/cart/cart_list.css" rel="stylesheet">
</head>
<body>
<div class="titleDiv">
		<h3>찜 목록</h3>
</div>
<div style="margin-bottom: 10px;">
	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16">
	  <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
	</svg> 찜 목록에 ${cartList.size() }건의 항목이 있습니다.
</div>
<table class="table table-hover">
	<thead class="table-light">
		<tr>
			<td><input type="checkbox" id="check" class="agreechkAll form-check-input" onclick="checkAll(this);" checked></td>
			<td>No</td>
			<td>상품 이미지</td>
			<td>여행 상품명</td>
			<td>가격</td>
			<td>인원수</td>
			<td>총 가격</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
	 <c:choose>
		<c:when test="${not empty cartList }">
			<c:forEach items="${cartList }" var="item" varStatus="vS">
				<tr id="cartTr">
					<td><input type="checkbox" class="chack form-check-input chk" value="${item.itemCode }" checked></td>
					<td>
						${cartList.size() - vS.index }
					</td>
					<td><img src="/resources/images/${item.attachedImgName }" width="70px;"></td>
					<td><a href="/item/itemDetail?itemCode=${item.itemCode }">${item.itemName }</a></td>
					<td><fmt:formatNumber value="${item.itemPrice }" pattern="#,###원"/></td>
					<td>
						<input type="number" id="travelers" class="form-control" value="${item.travelers }" min="1" style="width: 57px; display: inline-block;"> 
						<button type="button" class="btn btn-secondary" onclick="updateItemCnt(this, '${item.itemCode }', ${item.itemPrice });">변경</button>
					</td>
					<td class="totalPriceTd"><fmt:formatNumber value="${item.totalPrice }" pattern="#,###원"/></td>
					<td>
						<form action="/cart/deleteCart" method="post">
							<input type="hidden" name="cartCode" value="${item.cartCode }">
							<button type="button" class="btn btn-danger" onclick="deleteCart(this);">삭제</button>
							<!-- <button type="button" class="btns" style="width: 80px; padding: 0; background: #D82148; box-shadow: 0px 1px 5px 0px #D82148, 5px 5px 15px 5px rgba(0,0,0,0);" onclick="deleteCart(this);">삭제</button> -->
						</form>
					</td>
				</tr>
			 </c:forEach>
		</c:when> 
		 <c:otherwise> 
			<tr>
				<td colspan="8">
					찜 목록에 담긴 상품이 없습니다.
				</td>
			</tr> 
		 </c:otherwise>
	</c:choose> 
	</tbody>
	<tfoot>
		<tr>
			<td colspan="4"></td>
			<td colspan="2" style="text-align: right;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
  <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
</svg>&nbsp최종 결제금액</td>
			<td id="buyPriceTd" colspan="2">
				<fmt:formatNumber value="${totalPrice }" pattern="#,###원"/>
			</td>
		</tr>
	</tfoot>
</table>
<div class="btnDiv">
	<button type="button" class="btn btn-danger" onclick="deleteCarts();" style="width: 130px; height: 50px; margin-right: 10px;">선택삭제</button>
	<button type="button" class="btn btn-secondary" onclick="buyCartsCheck();" style="width: 130px; height: 50px; margin-right: 10px;">선택구매</button>
	<button type="button" class="btn btn-primary" onclick="buyAllCarts();" style="width: 130px; height: 50px;">전체구매</button>
	<form action="/buy/tripBook" method="post" id="goBuyListInfo">
		<input type="hidden" name="data" value='' id="buyListInfo">		
	</form>
</div>

<!-- 삭제 Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">경고</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>선택한 상품이 모두 삭제됩니다.</div>
        <div>정말 삭제하시겠습니까?</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btns" onclick=" deleteCheckCarts();" style="display: inline-block; width: 90px; padding: 0; background: #D82148; box-shadow: 0px 1px 5px 0px #d82148, 5px 5px 15px 5px rgb(0 0 0 / 0%);">삭제</button>
        <button type="button" class="btns" data-bs-dismiss="modal" style="display: inline-block; width: 90px; padding: 0; background: #ddd; color: black; box-shadow: 0px 1px 5px 0px #333, 5px 5px 15px 5px rgb(0 0 0 / 0%);">취소</button>
      </div>
    </div>
  </div>
</div>

<!-- 삭제 완료 Modal -->
<div class="modal fade" id="deleteEndModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">알림</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>삭제가 완료되었습니다.</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btns" data-bs-dismiss="modal" style="display: inline-block; width: 90px; padding: 0; background: #ddd; color: black; box-shadow: 0px 1px 5px 0px #333, 5px 5px 15px 5px rgb(0 0 0 / 0%);">확인</button>
      </div>
    </div>
  </div>
</div>

<!-- 수정 Modal -->
<div class="modal fade" id="deleteCheckModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">알림</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>삭제할 상품을 선택해주세요.</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btns" data-bs-dismiss="modal" style="display: inline-block; width: 90px; padding: 0; background: #ddd; color: black; box-shadow: 0px 1px 5px 0px #333, 5px 5px 15px 5px rgb(0 0 0 / 0%);">확인</button>
      </div>
    </div>
  </div>
</div>

<!-- 구매 체크 Modal -->
<div class="modal fade" id="buyCheckModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">알림</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>구매할 상품을 선택해주세요.</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btns" data-bs-dismiss="modal" style="display: inline-block; width: 90px; padding: 0; background: #ddd; color: black; box-shadow: 0px 1px 5px 0px #333, 5px 5px 15px 5px rgb(0 0 0 / 0%);">확인</button>
      </div>
    </div>
  </div>
</div>

<!-- 인원 변경 완료 Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">알림</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>인원수가 성공적으로 변경되었습니다.</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btns" data-bs-dismiss="modal" style="display: inline-block; width: 90px; padding: 0; background: #ddd; color: black; box-shadow: 0px 1px 5px 0px #333, 5px 5px 15px 5px rgb(0 0 0 / 0%);">확인</button>
      </div>
    </div>
  </div>
</div>

<script src="/resources/js/cart/cart_list.js" type="text/javascript"></script>
<script src="/resources/js/buy/buy_cart_list.js?ver=1" type="text/javascript"></script>
</body>
</html>