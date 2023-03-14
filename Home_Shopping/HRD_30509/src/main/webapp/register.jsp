<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% int custno = 0; %>
<body>
	<form>
		<table border="1">
			<tr>
				<td>회원번호(자동발생)</td>
				<td><input type="text" name="number" value="<%=custno%>" readonly></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>통신사[SK,KT,LG]</td>
				<td><input type="radio" name="address" value="SK">SK <input type="radio" name="address" value="KT">KT <input type="radio" name="address" value="LG">LG</td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td>고객등급[A:VIP,B:일반,C:직원]</td>
				<td><input type="text" name="grade"></td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td><input type="submit" value="등 록"> <button>조 회</button></td>
			</tr>
		</table>
	</form>
</body>
</html>