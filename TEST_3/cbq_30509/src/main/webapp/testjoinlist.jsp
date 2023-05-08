<%@page import="vo.testJoinVO"%>
<%@page import="sevlet.testjoinlist"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<% ArrayList<testJoinVO> testlist = (ArrayList<testJoinVO>) request.getAttribute("testjoin"); %>
	<section>
		<h2>감염검사결과</h2>
		<table border="1">
			<tr>
				<th>검사번호</th>
				<th>성명</th>
				<th>주민번호</th>
				<th>성별</th>
				<th>거주지</th>
				<th>전화번호</th>
				<th>결과</th>
			</tr>
			<%
				if(testlist != null) {
					for(testJoinVO vo: testlist) {
			%>
			<tr>
				<td><%= vo.getTestno() %></td>
				<td><%= vo.getName() %></td>
				<td><%= vo.getJumin() %></td>
				<% 
					String man = "Good";
					switch(vo.getMan()) {
						case "1": man = "남"; break;
						case "3": man = "남"; break;
						case "5": man = "남"; break;
						case "2": man = "여"; break;
						case "4": man = "여"; break;
						case "6": man = "여"; break;
					}
				%>
				<td><%= man %></td>
				<td><%= vo.getCity() %></td>
				<td><%= vo.getTelno() %></td>
				<%
					String testresult = "Good";
					switch(vo.getTestresult()) {
						case "P": testresult = "양성"; break;
						case "N": testresult = "음성"; break;
					}
				%>
				<td><%= testresult %></td>
			</tr>
			<% }} %>
		</table>
	</section>
<%@ include file="/footer.jsp" %>