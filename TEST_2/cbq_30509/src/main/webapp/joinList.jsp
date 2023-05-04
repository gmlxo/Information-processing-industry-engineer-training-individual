<%@page import="vo.joinListVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<% ArrayList<joinListVO> joinList = (ArrayList<joinListVO>) request.getAttribute("joinList"); %>

	<main>
		<h2>급여 조회</h2>
		<table border="1">
			<tr>
				<th>사원번호</th>
				<th>사원이름</th>
				<th>입사일</th>
				<th>부서</th>
				<th>직급</th>
				<th>결근</th>
				<th>야근</th>
				<th>휴일</th>
				<th>출장</th>
				<th>급여</th>
			</tr>
		<% for(joinListVO vo: joinList) { %>
			<tr>
				<td><a href="update.jsp?emp_no=<%= vo.getEmp_no() %>"><%= vo.getEmp_no() %></a></td>
				<td><%= vo.getEmp_name() %></td>
				<td><%= vo.getHire_date() %></td>
				<td><%= vo.getDept_name() %></td>
				<%
				String job = "";
				switch (vo.getJob()) {
					case "1": job = "사원"; break;
					case "2": job = "주임"; break;
					case "3": job = "대리"; break;
					case "4": job = "과장"; break;
					case "5": job = "차장"; break;
					case "6": job = "부장"; break;
					case "7": job = "상무"; break;
					case "8": job = "전무"; break;
					case "9": job = "사장"; break;
			}
				%>
				<td><%= job %></td>
				<td><%= vo.getAbsence() %>일</td>
				<td><%= vo.getNight() %>일</td>
				<td><%= vo.getHoliday() %>일</td>
				<td><%= vo.getBusiness_trip() %>일</td>
				<td>\<%= vo.getSalary() %></td>
			</tr>
		<% } %>
		</table>
	</main>
<%@ include file="/footer.jsp" %>