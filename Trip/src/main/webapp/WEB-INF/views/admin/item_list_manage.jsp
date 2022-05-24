<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/admin/item_list_manage.css" >
</head>
<body>
<div class="col">
<div class="titleDiv">
		<h3>상품 목록</h3>
</div>
<div class="row" style="margin: 0 auto;">
	<div class="row mt-2">
		<table class="table table-hover">
		<thead class="table-light">
			<tr>
				<td>
					<input type="checkbox" id="checkAll" name="checkAll" value='checkAll' onclick="selectAll(this);">
				</td>
				<td>패키지코드</td>
				<td>패키지명</td>
				<td>여행기간</td>
				<td>패키지가격</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${itemList }" var="item" varStatus="status">
			<tr>
				<td>
					<input type="checkbox" name="check" value="${item.itemCode }" onclick="checkSelectAll();">
				</td>
				<td>${item.itemCode }</td>
				<td><a href="/item/itemDetail?itemCode=${item.itemCode }">${item.itemName }</a></td>
				<td>${item.tripDate }</td>
				<td><fmt:formatNumber pattern="#,###원">${item.itemPrice }</fmt:formatNumber></td>
				<td><button class="btn btn-secondary" onclick="location.href='/admin/itemUpdate?itemCode=${item.itemCode}&cateCode=${item.cateCode }';" >수정하기</button></td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
		<div class="row">
			<div class="col-12">
				<div>
					<ul class="pagination justify-content-center">
						<li class="page-item <c:if test="${!itemVO.prev }"> disabled </c:if>">
						<a class="page-link" href="javascript:pageInfo(${itemVO.beginPage - 1 })">이전</a></li>
						<c:forEach begin="${itemVO.beginPage }" end="${itemVO.endPage }" var="pageIndex">
							<li class="page-item <c:if test="${itemVO.nowPage eq pageIndex}"> active </c:if>" >
							<a class="page-link" href="javascript:pageInfo(${pageIndex });" >${pageIndex }</a></li>
						</c:forEach>
						<li class="page-item <c:if test="${!itemVO.next }"> disabled</c:if>">
						<a class="page-link" href="javascript:pageInfo(${itemVO.endPage + 1 })">다음</a></li>
					</ul>
				</div>
				<div class="btnDiv">
					<div class="btnBlack" onclick="deleteItem();" style="width: 100px;">삭제</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<script type="text/javascript" src="/resources/js/admin/item_list_manage.js?ver=9"></script>
</body>
</html>