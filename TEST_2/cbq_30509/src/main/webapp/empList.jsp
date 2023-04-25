<%@page import="vo.empListVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<% ArrayList<empListVO> voList = (ArrayList<empListVO>)request.getAttribute("empList"); %>
	<main>
		<table border="1">
			<tr>
				<td>사원번호</td>
				<td>사원이름</td>
				<td>입사일</td>
				<td>부서</td>
				<td>직급</td>
				<td>결근</td>
				<td>야근</td>
				<td>휴일</td>
				<td>출장</td>
				<td>급여</td>
			</tr>
<% 
			if(voList != null) {
				for(empListVO vo: voList) {
%>
			<tr>
				<td><a href="workUpdate.jsp?emp_no=<%= vo.getEmp_no() %>"><%= vo.getEmp_no() %></a></td>
				<td><%= vo.getEmp_name() %></td>
				<td><%= vo.getHire_date() %></td>
				<td><%= vo.getDept_name() %></td>
				<td><%= vo.getJob() %></td>
				<td><%= vo.getAbsence() %></td>
				<td><%= vo.getNight() %>일</td>
				<td><%= vo.getHoliday() %>일</td>
				<td><%= vo.getBusiness_trip() %>일</td>
				<td>&#8361;<%= vo.getSalary() %></td>
			</tr>
<%					
				}
			}
%>
		</table>
	</main>
<%@ include file="/footer.jsp" %>