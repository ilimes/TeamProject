<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/admin/update_image.css" rel="stylesheet">
</head>
<body>
<div class="titleDiv">
		<h3>슬라이드 이미지 변경</h3>
</div>
<div class="updateDiv" style="display: flex; flex-wrap: wrap; justify-content: center;">
	<c:forEach items="${imageList }" var="image" varStatus="vS">
		<div style="margin-bottom: 20px; width: 43.5em; justify-content: center;">
			<div style=""><h4>▼ ${vS.index + 1 }번 이미지</h4></div>
			<form action="/admin/updateImage" method="post" enctype="multipart/form-data" id="updateImgForm${vS.index + 1}" class="needs-validation updateImgForm"  novalidate>
				<input type="image" src="/resources/images/slide/${image.attachedImgName }" alt="엑박" width="95%" disabled>
				<input type="hidden" value="${image.imgCode }" name="imgCode">
				<div>
					<input type="file" class="form-control"  name="updateImg" style="display:inline-block; width: 68.9%;">
					<button class="btn btn-primary mb-2" type="submit" style="display:inline-block; width: 25%; margin-top: 7px;">이미지 변경</button>
				</div>
			</form>
		</div>
	</c:forEach>
</div>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/admin/update_image.js?ver=4"></script>
</body>
</html>