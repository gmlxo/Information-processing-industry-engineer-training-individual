<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* { list-style: none; text-decoration: none; color: #000; }
	footer, h1, h2 { text-align: center; }
	header, footer { background-color: #555;}
	header>div { display: flex; justify-content: space-around; background-color: #888;  height: 50px;}
	table { margin: 0 auto; }
</style>
</head>
<body>
	<div class="wrapper">
		<header>
			<h1>골프연습장 회원관리 프로그램 ver1.0</h1>
			<div>
				<div><a href="/teacherList">강사정보조회</a></div>
				<div><a href="/insertSelect">수강신청</a></div>
				<div><a href="/userList">회원정보조회</a></div>
				<div><a href="/teacherMoneyList">강사별매출통계</a></div>
				<div><a href="/index.jsp">홈으로</a></div>
			</div>
		</header>