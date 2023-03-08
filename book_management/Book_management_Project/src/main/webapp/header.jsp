<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.wapper {
		width: 1200px;
	}
	
	.header {
		background-color: blue;
		display: flex;
		justify-content: space-around;
	}
	
	.header > div > a {
		color: #fff;
		text-decoration: none;
	}
	
	main {
		height: 350px;
		border: 1px solid #000;
	}
	
	.a {
		border-bottom: 1px solid #555;
	}
</style>
</head>
<body>
	<div class="wapper">
		<h1 align="center">도서 대여 관리 프로그램</h1>
			<div class="header">
				<div><a href="/index.jsp">홈으로</a></div>
				<div><a href="/book/insert.jsp">회원등록</a></div>
				<div><a href="/bookSelect">회원대여 현황</a></div>
				<div><a href="/memberSelect">회원목록 조회/수정</a></div>
			</div>