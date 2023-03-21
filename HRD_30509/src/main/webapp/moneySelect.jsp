<%@page import="vo.vo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<%
ArrayList<vo> moneyList = (ArrayList<vo>)request.getAttribute("moneyList"); 
%>
<section>
<h3>회원목록 조회/수정</h3>
<table border="1">
	<tr>
		<td>회원번호</td>
		<td>회원성명</td>
		<td>고객등급</td>
		<td>매출</td>
	</tr>
	
<%
	if(moneyList != null){
		for(vo vo : moneyList){
%>
	<tr>
		<td><%= vo.getCustno() %></td>
		<td><%= vo.getCustname() %></td>
		<td><%= vo.getGrade() %></td>
		<td><%= vo.getPrice() %></td>
	</tr>

<%
		}
	}
%>
</table>


</section>

<%@ include file="/footer.jsp" %>