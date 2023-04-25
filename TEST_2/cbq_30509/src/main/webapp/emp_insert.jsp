<%@page import="dao.ALLDAO"%>
<%@page import="vo.departmentVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<title>Insert</title>

	<%
	ALLDAO dao = new ALLDAO();
	ArrayList<departmentVO> dList = dao.depList();
	%>
	<main>
		<form action="/emp_insert" method="post" name="insertFRM">
			<table border="1">
				<tr>
					<td>사원번호</td>
					<td><input type="text" name="emp_no" id="emp_no">
						예)E001</td>
				</tr>
				<tr>
					<td>사원성명</td>
					<td><input type="text" name="emp_name" id="emp_name"></td>
				</tr>
				<tr>
					<td>부서코드</td>
					<td>
						<select name="dep_code" id="dep_code">
							<option>부서코드</option>
							<%
							if (dList != null) {
								for (departmentVO dvo : dList) {
							%>
								<option value="<%= dvo.getDept_code() %>"><%= dvo.getDept_name() %></option>
							<%
								}
							}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="text" name="hire_date" id="hire_date">
						예)20220511</td>
				</tr>
				<tr>
					<td>직급</td>
					<td>
						<select name="job" id="job">
							<option>직급</option>
							<option value="1">사원</option>
							<option value="2">주임</option>
							<option value="3">대리</option>
							<option value="4">과장</option>
							<option value="5">차장</option>
							<option value="6">부장</option>
							<option value="7">상무</option>
							<option value="8">전무</option>
							<option value="9">사장</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>급여</td>
					<td><input type="text" name="salary" id="salary"></td>
				</tr>
				<tr><td colspan="2"><button type="button" onclick="abc()">등록</button><button type="reset" onclick="al()">다시쓰기</button></td></tr>
			</table>
		</form>
	</main>
	<script type="text/javascript">
		function al() {
			alert("정보를 지우고 처음부터 다시 입력합니다!");
		}
		function abc() {
			
			sub = true;
			
			var emp_no = document.getElementById("emp_no").value;
			var emp_name = document.getElementById("emp_name").value;
			var dep_code = document.getElementById("dep_code").value;
			var hire_date = document.getElementById("hire_date").value;
			var job = document.getElementById("job").value;
			var salary = document.getElementById("salary").value;
			
			if(emp_no == "") { alert("사원번호가 입력되지 않았습니다!"); sub = false; }
			if(emp_name == "") { alert("사원성명이 입력되지 않았습니다!"); sub = false; }
			if(dep_code == "") { alert("부서코드가 입력되지 않았습니다!"); sub = false; }
			if(hire_date == "") { alert("입사일이 입력되지 않았습니다!"); sub = false; }
			if(job == "") { alert("직급이 입력되지 않았습니다!"); sub = false; }
			if(salary == "") { alert("급여가 입력되지 않았습니다!"); sub = false; }

			if(sub) { document.insertFRM.submit(); }
		}
	</script>
<%@ include file="/footer.jsp" %>