<%@page import="vo.bshopJoinListVO2"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<% ArrayList<bshopJoinListVO2> list2 = (ArrayList<bshopJoinListVO2>)request.getAttribute("bshopJoinList2"); %>
	<section>
		<h2>빌딩별 방문건수</h2>
		<table border="1">
			<tr>
				<th>상호번호</th>
				<th>상호명</th>
				<th>방문자 건수</th>
			</tr>
			<% 
				if(list2 != null) {
					for(bshopJoinListVO2 vo : list2) {
			%>
			<tr>
				<td><%= vo.getShopno() %></td>
				<td><%= vo.getShopname() %></td>
				<td><%= vo.getNum() %></td>
			</tr>
			<% }} %>
		</table>
	</section>
<%@ include file="/footer.jsp" %>