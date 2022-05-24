<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/board/board_write_form.css" rel="stylesheet">
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
    window.onload = function(){
       ck = CKEDITOR.replace("content");
    };
</script>
</head>
<body>
<div class="titleDiv">
	<h3>${boardTitle }</h3>
</div>
<div class="row">
	<form action="/board/boardWrite" method="post" id="boardWriteForm">
	<input type="hidden" name="sideMenuCode" value="${sideMenuVO.sideMenuCode }">
	<input type="hidden" name="menuCode" value="${sideMenuVO.menuCode }">
	<div class="col-12">
		<table class="table regTable">
			<tr>
				<td>제목</td>
				<td colspan="3"><input class="form-control" type="text" name="title" id="title" style="width: 100%;" required></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">
					<textarea class="form-control" name="content" id="content" style="width: 100%; height: 200px;" required></textarea>
				</td>
			</tr>
			<c:if test="${sideMenuVO.sideMenuCode eq 'SIDE_MENU_001' }">
				<tr>
					<td colspan="1">
						<label for="img" class="form-label" style="padding-top: 15.5px;">메인글 여부</label>
					</td>
					<td colspan="3" style="text-align: left;">
				    	<input class="form-check-input" type="checkbox" value="N" name="isMain" id="isMain" onclick="mainCheck();" style="width: 20px; height: 20px;">
					</td>
				</tr>
			</c:if>
		</table>
	</div>
	<div class="row">
		<div class="col-12">
			<div class="btnDiv">
				<div class="btnBlack" onclick="boardWrite();" style="width: 130px;">등록하기</div>
			</div>
		</div>
	</div>
	</form>
</div>
<script src="/resources/js/board/board_write_form.js" type="text/javascript"></script>
</body>
</html>