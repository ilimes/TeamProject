<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/admin/reg_image.css" rel="stylesheet">
</head>
<body>
<div class="titleDiv">
		<h3>슬라이드 이미지 등록</h3>
</div>
<div class="imageDiv">
	<form action="" method="post" id="slideImageForm" enctype="multipart/form-data">
		<div class="mb-3">
			<input class="form-control" style="height: 500px;" type="image" src="/resources/images/logo.png" id="previewImage" disabled>
		</div>
		<div class="mb-3">
			<input class="form-control" type="file" name="slideImage" id="slideImage">
		</div>
		<div class="row mb-3" >
			<div class="col-12 ">
				<button class="btn btn-primary btn" onclick="regImage();">이미지 등록</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="/resources/js/admin/reg_image.js?ver=1"></script>
</body>
</html>