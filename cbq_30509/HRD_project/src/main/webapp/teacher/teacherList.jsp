<%@page import="VO.teacherVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
	<%
		ArrayList<teacherVO> list = (ArrayList<teacherVO>) request.getAttribute("teacherList");
	%>
	<section>
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
			if (list != null) {
				for (teacherVO vo : list) {
			%>
			<tr>
				<td><%=vo.getTeacher_code()%></td>
				<td><%=vo.getClass_name()%></td>
				<td><%=vo.getTeacher_name()%></td>
				<td><%=vo.getClass_price()%></td>
				<td><%=vo.getTeach_regist_date()%></td>
			</tr>
			<%
				}
			}
			%>
		</table>
	</section>
<%@ include file="/footer.jsp" %>