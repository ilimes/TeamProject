<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/admin/member_detail.css" rel="stylesheet">
</head>
<body>
<div class="row">
	<div class="col-12">
		<table class="memTable">
			<tr>
				<td>이름</td>
				<td>${member.memName }</td>
				<td>생년월일</td>
				<td>${member.memBirthday }</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${member.memGender }</td>
				<td>연락처</td>
				<td>${member.memTell }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${member.memAddr } ${member.memAddrDetail }</td>
				<td>회원등급</td>
				<td>${member.memRank }</td>
			</tr>
			<tr>
				<td>회원가입일</td>
				<td>${member.joinDate }</td>
				<td>구매횟수</td>
				<td>${member.buyCnt }회</td>
			</tr>
			<tr>
				<td>총 구매금액</td>
				<td><fmt:formatNumber pattern="#,###원" value="${member.totalPrice }"/></td>
				<td>마일리지</td>
				<td><fmt:formatNumber pattern="#,###P" value="${member.memPoint }"/></td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>