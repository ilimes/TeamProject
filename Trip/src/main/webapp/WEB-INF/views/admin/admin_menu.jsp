<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@font-face {
    font-family: 'TmoneyRoundWindExtraBold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/TmoneyRoundWindExtraBold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.topDiv{
	width: 1300px; margin: 0 auto; padding-left: 20px; padding-right: 20px;
}
.topDiv > div:first-child {
	text-align: right;
}
.logo{
	font-size: 30px;
}
.searchDiv{
	display: inline-block; margin-left: 50px; border: 1px solid black; border-radius: 48px; width: 450px; height: 45px; text-align: center;
}
.searchDiv input[type="text"]{
	width: 350px; height: 40px; vertical-align: middle; border: none; outline: 0;
}
.firstTopMenu{
	height: 53px;
}
.firstTopMenu > div:first-child{
	width: 1300px; margin: 0 auto; vertical-align: middle; font-size: 20px; font-weight: bold; padding-top: 15px; padding-left: 20px; padding-right: 20px;
}
.secondTopMenu{
	background: linear-gradient(120deg,#444,#333,#555);
	height: 85px;	
	border-top-left-radius: 20px;
	border-top-right-radius: 20px; 
	border-bottom-left-radius: 7px; 
	border-bottom-right-radius: 7px; 
}
.secondTopMenu > div:first-child{
	width: 1300px; color: white; line-height: 85px; vertical-align: middle; font-size: 25px; padding-left: 20px; padding-right: 20px;
}
.firstTopMenu ul, .secondTopMenu ul, .topDiv > div:first-child ul{
	list-style: none;
	padding: 0;
	margin: 0;
}
.firstTopMenu li, .secondTopMenu li{
	margin-right: 9px;
	display: inline-block;
}
.secondTopMenu li{
	height: 60px;
	font-size: 16.5px;
}
.secondTopMenu li:hover{
	border-bottom: 3px solid white;
}
.topDiv > div:first-child li {
	margin-right: 5px;
	font-size: 14px;
	display: inline;
}
.firstTopMenu li:hover{
	border-bottom: 4px solid #DDDDDD;	
}
</style>
<link href="/resources/css/menu/rollingNotice.css" rel="stylesheet">
</head>
<body>
<div class="secondTopMenu">
	<div>
		<span style="font-family:'TmoneyRoundWindExtraBold';">Hanvit Travel Agency</span> <span style="font-size: 18px; margin-left: 10px; color: #999999;">Administration</span>
	</div>
</div>
<script src="/resources/js/menu/menu.js" type="text/javascript"></script>
<script src="/resources/js/menu/rollingNotice.js" type="text/javascript"></script>
</body>
</html>