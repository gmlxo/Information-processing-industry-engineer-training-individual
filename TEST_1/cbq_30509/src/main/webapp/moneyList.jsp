<%@page import="vo.TeacherMoneyVO"%>
<%@page import="servlet.teacherMoneyList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<title>member Select</title>

	<% ArrayList<TeacherMoneyVO> list = (ArrayList<TeacherMoneyVO>) request.getAttribute("moneyList"); %>
	<h2>강사별 매출 통계</h2>
	<table border="1">
		<tr>
			<td>강사코드</td>
			<td>강사명</td>
			<td>강의명</td>
			<td>총매출</td>
		</tr>
<%
		if(list != null) {
			for(TeacherMoneyVO vo: list) {
%>
		<tr>
			<td><%= vo.getTeacher_code() %></td>
			<td><%= vo.getTeacher_name() %></td>
			<td><%= vo.getClass_name() %></td>
			<td><%= vo.getTuition() %></td>
		</tr>		
<%
			}
		}
%>
	</table>
<%@ include file="/footer.jsp" %>