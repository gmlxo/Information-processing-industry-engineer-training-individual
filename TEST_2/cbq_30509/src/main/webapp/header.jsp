<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* { text-decoration: none; color: #000; }
	footer, header { background-color: #777; }
	#wrapper, table, p { margin: auto; }
	h1, h2, h3 { text-align: center; }
	.just { display: flex; justify-content: space-around; background-color: #cacaca; }
	.just a { display: block; height: 43px; line-height: 43px; }
</style>
</head>
<body>
	<div id="wrapper">
		<header>
			<h1>과정평가형 정보처리산업기사 사원급여관리 프로그램 ver 2022-05</h1>
			<div class="just">
				<div><a href="/emp_insert.jsp">사원등록</a></div>
				<div><a href="/empList">급여조회</a></div>
				<div><a href="#">부서별 급여조회</a></div>
				<div><a href="/index.jsp">홈으로</a></div>
			</div>
		</header>