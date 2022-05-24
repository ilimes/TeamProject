<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/admin/member_manage.css" rel="stylesheet">
</head>
<body>
<div class="titleDiv">
		<h3>회원목록</h3>
</div>
<div class="row">
<div class="row" style="margin: 0 auto;">
	<div class="row mt-2">
		<table class="table table-hover">
		<thead class="table-light">
			<tr>
				<td>이름</td>
				<td>생년월일</td>
				<td>연락처</td>
				<td>회원가입일</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${memberList }" var="member" >
			<tr>
				<td><a href="/admin/memberDetail?memId=${member.memId }">${member.memName }</a></td>
				<td>${member.memBirthday }</td>
				<td>${member.memTell }</td>
				<td>${member.joinDate }</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
	</div>
</div>
</div>
</body>
</html>