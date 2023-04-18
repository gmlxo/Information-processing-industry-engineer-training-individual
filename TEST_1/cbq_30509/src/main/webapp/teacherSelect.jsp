<%@page import="vo.TeacherVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<title>Teacher Select</title>
<% ArrayList<TeacherVO> list = (ArrayList<TeacherVO>)request.getAttribute("teacherList"); %>
	<main>
	<h2>강사 정보 조회</h2>
		<table border="1">
			<tr>
				<td>강사코드</td>
				<td>강의명</td>
				<td>강사명</td>
				<td>수강료</td>
				<td>강사자격획득일</td>
			</tr>
<%
		if(list != null) {
			for(TeacherVO vo : list) {
				/* 수강료 특문이랑 천단위 , 하는 법 모름 */
%>
			<tr>
				<td><%= vo.getTeacher_code() %></td>
				<td><%= vo.getClass_name() %></td>
				<td><%= vo.getTeacher_name() %></td>
				<td><%= vo.getClass_price() %></td>
				<td><%= vo.getTeach_regist_date() %></td>
			</tr>
<%
			}
		}
%>
		</table>
	</main>
<%@ include file="/footer.jsp" %>