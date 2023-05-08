<%@page import="vo.bshopJoinVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<% ArrayList<bshopJoinVO> bshoplist = (ArrayList<bshopJoinVO>) request.getAttribute("bshoplist"); %>
	<section>
		<h2>확진자 추적조회</h2>
		<table border="1">
			<tr>
				<th>전화번호</th>
				<th>방문일자</th>
				<th>방문시간</th>
				<th>소재지</th>
				<th>상호명</th>
				<th>대표번호</th>
			</tr>
			<% 
				if(bshoplist != null) {
					for(bshopJoinVO vo : bshoplist) {
			%>
			<tr>
				<td><%= vo.getTelno() %></td>
				<td><%= vo.getVisitdate() %></td>
				<td><%= vo.getVissittime() %></td>
				<td><%= vo.getSite() %></td>
				<td><%= vo.getShopname() %></td>
				<td><%= vo.getShoptelno() %></td>
			</tr>
			<%
					}
				}
			%>
		</table>
	</section>
<%@ include file="/footer.jsp" %>