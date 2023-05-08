<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
	<section>
		<h2>방문기록등록</h2>
		<form action="/insert" method="post" name="frm">
			<table>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="telno" id="telno">예)[010-1234-5678]</td>
				</tr>
				<tr>
					<th>방문일자</th>
					<td><input type="text" name="visitdate" id="visitdate">예)[20210301]</td>
				</tr>
				<tr>
					<th>방문시간</th>
					<td><input type="text" name="vissittime" id="vissittime">예)[1200]</td>
				</tr>
				<tr>
					<th>상호번호</th>
					<td><input type="text" name="shopno" id="shopno">상호번호를 입력하세요 예)[V001]</td>
				</tr>
				<tr>
					<td><button type="button" onclick="submitFRM()">기록저장</button><button type="reset" onclick="javascript:alert('정보를 지우고 처음부터 다시 입력합니다!')">다시쓰기</button></td>
				</tr>
			</table>
		</form>
	</section>
	<script type="text/javascript">
		function submitFRM() {
			var submit = true;
			if(document.frm.telno.value == "") { alert("전화번호가 입력되지 않았습니다!"); submit = false; }
			if(document.frm.visitdate.value == "") { alert("방문일자가 입력되지 않았습니다!"); submit = false; }
			if(document.frm.vissittime.value == "") { alert("방문시간이 입력되지 않았습니다!"); submit = false; }
			if(document.frm.shopno.value == "") { alert("상호번호가 입력되지 않았습니다!"); submit = false; }
			
			if(submit) { alert("방문기록이 정상적으로 등록 되었습니다!"); document.frm.submit(); }
		}
	</script>
<%@ include file="/footer.jsp" %>