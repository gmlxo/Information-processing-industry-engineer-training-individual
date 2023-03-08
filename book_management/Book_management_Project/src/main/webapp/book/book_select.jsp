<%@page import="vo.mem_rent_vo"%>
<%@page import="vo.book_rent_vo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  include file="/header.jsp"%>


<% ArrayList<mem_rent_vo> memList = (ArrayList<mem_rent_vo>)request.getAttribute("bookList"); %>
<h2>회원별 대여 현황</h2>

<table>
	<tr class="a">
		<td>회원번호</td>
		<td>회원이름</td>
		<td>대여횟수</td>
	</tr>
<%
	if (memList != null) {
		for(mem_rent_vo mem: memList) {
%>
	<tr>
		<td><%= mem.getCustno() %></td>
		<td><%= mem.getCustname() %></td>
		<td><%= mem.getNum() %></td>
	</tr>
<%
		}
	}
%>
</table>


<% ArrayList<book_rent_vo> list = (ArrayList<book_rent_vo>)request.getAttribute("bookList"); %>

<h2>도서별 대여 현황</h2>

<table>
	<tr class="a">
		<td>도서번호</td>
		<td>대여횟수</td>
	</tr>
<%
	if(list != null) {
		for(book_rent_vo vo: list) {
%>
	<tr>
		<td><%= vo.getBookno() %></td>
		<td><%= vo.getNum() %></td>
	</tr>
<%
		}
	}
%>
</table>

<%@  include file="/footer.jsp"%>