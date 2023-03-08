<%@page import="vo.mem_vo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  include file="/header.jsp"%>

<% ArrayList<mem_vo> list = (ArrayList<mem_vo>)request.getAttribute("member"); %>
<h2>회원별 대여 현황</h2>

<table>
	<tr class="a">
		<td>회원번호</td>
		<td>회원이름</td>
		<td>가입일자</td>
		<td>고객등급</td>
		<td>주소</td>
		<td>기능</td>
	</tr>
<%
	if (list != null) {
		for(mem_vo vo: list) {
%>
	<tr>
		<td><%= vo.getCustno() %></td>
		<td><%= vo.getCustname() %></td>
		<td><%= vo.getJoindate() %></td>
		<td><%= vo.getGrade() %></td>
		<td><%= vo.getAddress() %></td>
		<td><a href="update.jsp">수정</a></td>
	</tr>
<%
		}
	}
%>
</table>

<%@  include file="/footer.jsp"%>