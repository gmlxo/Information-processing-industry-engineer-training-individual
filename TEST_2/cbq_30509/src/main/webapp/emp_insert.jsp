<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
	<main>
		<h2>사원등록</h2>
		<form action="/emp_insert" method="post" name="empFRM">
			<table border="1">
				<tr>
					<th>사원번호</th>
					<td><input type="text" name="emp_no" id="emp_no">예)E001</td>
				</tr>
				<tr>
					<th>사원성명</th>
					<td><input type="text" name="emp_name" id="emp_name"></td>
				</tr>
				<tr>
					<th>부서코드</th>
					<td>
						<select name="dept_code" id="dept_code">
							<option value="">부서코드</option>
							<option value="10">인사팀</option>
							<option value="20">회계팀</option>
							<option value="30">개발팀</option>
							<option value="40">홍보팀</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>입사일</th>
					<td><input type="text" name="hire_date" id="hire_date">예)20220511</td>
				</tr>
				<tr>
					<th>직급</th>
					<td>
						<select name="job" id="job">
							<option value="">부서코드</option>
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
					<th>급여</th>
					<td><input type="text" name="salary" id="salary"></td>
				</tr>
				<tr><td><button name="submit_btn" id="submit_btn" type="button" onclick="javascript:notNull()">등록</button><button type="reset" onclick="javascript:alert('정보를 지우고 처음부터 다시 입력합니다!')">다시쓰기</button></td></tr>
			</table>
		</form>
	</main>
	
	<script type="text/javascript">
		function notNull() {
			var btn = true;
			if(document.empFRM.emp_no.value == "") { alert("사원번호가 입력되지 않았습니다!"); btn = false; }
			if(document.empFRM.emp_no.value == "") { alert("사원성명이 입력되지 않았습니다!"); btn = false; }
			if(document.empFRM.emp_no.value == "") { alert("부서코드가 입력되지 않았습니다!"); btn = false; }
			if(document.empFRM.emp_no.value == "") { alert("입사일이 입력되지 않았습니다!"); btn = false; }
			if(document.empFRM.emp_no.value == "") { alert("직급이 입력되지 않았습니다!"); btn = false; }
			if(document.empFRM.emp_no.value == "") { alert("급여가 입력되지 않았습니다!"); btn = false; }
			
			if(btn) { alert("사원정보가 정상적으로 등록되었습니다!"); document.empFRM.submit(); }
			return btn;
		}
	</script>
<%@ include file="/footer.jsp" %>