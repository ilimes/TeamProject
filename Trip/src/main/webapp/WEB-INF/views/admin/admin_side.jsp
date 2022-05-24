<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.sideMenuDiv{
	padding: 20px 0px 20px 0px;
	border-top: 2px solid black;
	margin-bottom: 8px;
}
.sideMenuDiv div{
	font-size: 18px;
	line-height: 40px;
}
.sideMenuDiv ul{
	padding-left: 0;
	list-style-type: none;
	font-size: 18px;
	line-height: 40px;
}
.sideMenuDiv div:hover{
	font-weight: bold;
}
</style>
</head>
<body>
<div>
	<div style="text-align:center; font-size: 18px; font-weight: bold; margin-bottom: 35px;">${sessionScope.loginInfo.memName } 님 환영합니다 :)</div>
	<div><h4><strong>관리자 메뉴</strong></h4></div>
	<div class="sideMenuDiv">
		<ul>
			<c:forEach items="${adminMenuList }" var="adminMenu">
				<li>
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dot" viewBox="0 0 16 16">
			  			<path d="M8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"></path>
					</svg> 
					<div style="display: inline-block;"><a <c:if test="${selectedAdminMenu eq adminMenu.adminMenuCode }">style="font-weight: bold;"</c:if> href="/admin/${adminMenu.adminMenuUri }?adminMenuCode=${adminMenu.adminMenuCode}">${adminMenu.adminMenuName }</a></div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div><h4><strong>세부 메뉴</strong></h4></div>
	<div class="sideMenuDiv">
		<c:forEach items="${sideMenuList }" var="sideMenu">
		<div <c:if test="${sideMenu.sideMenuCode eq selectedSideMenu }">style="font-weight: bold;"</c:if>>
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dot" viewBox="0 0 16 16">
	  			<path d="M8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"></path>
			</svg> <a href="/admin/${sideMenu.sideMenuUri }?adminMenuCode=${sideMenu.adminMenuCode}&sideMenuCode=${sideMenu.sideMenuCode}">${sideMenu.sideMenuName }</a>
		</div>
		</c:forEach>
	</div>
	<div style="font-weight: bold; font-size: 18px; margin-bottom: 10px; cursor: pointer;" onclick="location.href='/item/mainPage';"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-square" viewBox="0 0 16 16">
	  <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm11.5 5.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
	</svg> 메인 페이지로 이동</div>
	<div style="font-weight: bold; font-size: 18px; cursor: pointer;" onclick="location.href='/member/logout';"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-key" viewBox="0 0 16 16">
	  <path d="M0 8a4 4 0 0 1 7.465-2H14a.5.5 0 0 1 .354.146l1.5 1.5a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0L13 9.207l-.646.647a.5.5 0 0 1-.708 0L11 9.207l-.646.647a.5.5 0 0 1-.708 0L9 9.207l-.646.647A.5.5 0 0 1 8 10h-.535A4 4 0 0 1 0 8zm4-3a3 3 0 1 0 2.712 4.285A.5.5 0 0 1 7.163 9h.63l.853-.854a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.793-.793-1-1h-6.63a.5.5 0 0 1-.451-.285A3 3 0 0 0 4 5z"/>
	  <path d="M4 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
	</svg> 로그아웃 하기</div>
</div>
</body>
</html>