<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header, footer { background-color: #888; }
	* { color: #000; text-decoration: none; margin: 0 auto; }
	header, footer, main, h1, h2, h3, table { text-align: center; margin: 0 auto; }
	nav { display: flex; justify-content: space-around;  background-color: #cacaca;}
</style>
</head>
<body>
	<div id="warpper">
		<header><h1>과정평가형 정보처리산업기사 사원급여관리 프로그램 ver 2022-05</h1></header>
		<nav>
			<a href="/emp_insert.jsp">사원등록</a>
			<a href="/empList">급여조회</a>
			<a href="/depJoinList">부서별 급여조회</a>
			<a href="/index.jsp">홈으로</a>
		</nav>