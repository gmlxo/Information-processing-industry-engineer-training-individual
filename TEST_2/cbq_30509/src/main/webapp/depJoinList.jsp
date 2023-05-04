<%@page import="vo.depListVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<% ArrayList<depListVO> list = (ArrayList<depListVO>)request.getAttribute("joinList_det"); %>
	<main>
		<table border="1">
			<tr>
				<th>부서코드</th>
				<th>부서명</th>
				<th>부서위치</th>
				<th>부서별 사원수</th>
				<th>부서별 급여합</th>
				<th>부서별 수당합</th>
				<th>부서별 총급여합(급여 + 수당)</th>
			</tr>
			<% for(depListVO vo: list) { %>
			<tr>
				<td><%= vo.getDept_code() %></td>
				<td><%= vo.getDept_name() %></td>
				<td><%= vo.getLocation() %></td>
				<td><%= vo.getSum() %>명</td>
				<td>\<%= vo.getSalary() %></td>
				<td>\<%= vo.getSubang() %></td>
				<td>\<%= vo.getAllSUM()%></td>
			</tr>
			<% } %>
		</table>
	</main>
<%@ include file="/footer.jsp" %>