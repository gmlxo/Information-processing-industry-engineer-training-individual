<%@page import="vo.departmentVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.mainDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
	<% 
		mainDAO dao = new mainDAO();
		String emp_no = request.getParameter("emp_no"); 
		ArrayList<departmentVO> list = dao.depList(emp_no);
	%>
	<main>
		<form action="/update" method="post" name="updateFRM">
			<table border="1">
				<% for(departmentVO vo: list) { %>
					<tr>
						<th>사원번호</th>
						<td><input type="text" value="<%= vo.getEmp_no() %>" name="emp_no" id="emp_no" readonly></td>
					</tr>
					<tr>
						<th>결근</th>
						<td><input type="number" value="<%= vo.getAbsence() %>" name="absence" id="absence">예)(0~100)</td>
					</tr>
					<tr>
						<th>야근</th>
						<td><input type="number" value="<%= vo.getNight() %>" name="night" id="night">예)(0~100)</td>
					</tr>
					<tr>
						<th>휴일</th>
						<td><input type="number" value="<%= vo.getHoliday() %>" name="holiday" id="holiday">예)(0~100)</td>
					</tr>
					<tr>
						<th>출장</th>
						<td><input type="number" value="<%= vo.getBusiness_trip() %>" name="business_trip" id="business_trip">예)(0~100)</td>
					</tr>
				<% } %>
				<tr><td colspan="2"><button type="button" onclick="update()">수정</button></td></tr>
			</table>
		</form>
	</main>
	<script type="text/javascript">
		function update() {
			var btn = true;
			if(document.updateFRM.absence.value == "") { alert("결근이 입력되지 않았습니다!"); btn = false; }
			if(document.updateFRM.night.value == "") { alert("야근이 입력되지 않았습니다!"); btn = false; }
			if(document.updateFRM.holiday.value == "") { alert("휴일이 입력되지 않았습니다!"); btn = false; }
			if(document.updateFRM.business_trip.value == "") { alert("출장이 입력되지 않았습니다!"); btn = false; }
			
			if(btn) { alert("초과근무정보가 정상적으로 수정되었습니다!"); document.updateFRM.submit(); }
			return btn;
		}
	</script>
<%@ include file="/footer.jsp" %>