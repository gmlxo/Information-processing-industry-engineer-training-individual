<%@page import="vo.userVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<title>member Select</title>

	<% ArrayList<userVO> list = (ArrayList<userVO>) request.getAttribute("userList"); %>
	<h2>회원별 정보 조회</h2>
	<table border="1">
		<tr>
			<td>수강월</td>
			<td>회원번호</td>
			<td>회원명</td>
			<td>강의명</td>
			<td>강사명</td>
			<td>강의장소</td>
			<td>수강료</td>
		</tr>
<%
		if(list != null) {
			for(userVO vo: list) {
%>
		<tr>
			<td><%= vo.getRegist_month() %></td>
			<td><%= vo.getC_no() %></td>
			<td><%= vo.getC_name() %></td>
			<td><%= vo.getClass_name() %></td>
			<td><%= vo.getTeacher_name() %></td>
			<td><%= vo.getClass_area() %></td>
			<td><%= vo.getTuition() %></td>
		</tr>		
<%
			}
		}
%>
	</table>
<%@ include file="/footer.jsp" %>