<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>

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

<%@ include file="/footer.jsp" %>