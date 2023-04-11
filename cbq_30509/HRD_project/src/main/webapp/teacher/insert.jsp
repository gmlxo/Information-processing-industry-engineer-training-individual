<%@page import="VO.memberVO"%>
<%@page import="VO.teacherVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	ArrayList<teacherVO> tList = (ArrayList<teacherVO>)request.getAttribute("tList");
	ArrayList<memberVO> mList = (ArrayList<memberVO>)request.getAttribute("mList");
%>
	<section>
		<h2>수강 신청</h2>
		<table>
			<tr>
				<td>수강월</td>
				<td><input type="text" name="regist_month"> 2022년 3월 예)202203</td>
			</tr>
			<tr>
				<td>회원명</td>
				<td>
					<select>
						<option value="c_name">회원명</option>
						<%
							if(tList != null){}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>회원번호</td>
				<td><input type="text" name="c_no"> 예)10001</td>
			</tr>
			<tr>
				<td>강의장소</td>
				<td><input type="text" name="class_area"></td>
			</tr>
			<tr>
				<td>강의선택</td>
				<td>
					<select>
						<option value="c_name">회원명</option>
						<%
							if(mList != null){}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>수강료</td>
				<td><input type="text" name="tuition" readonly></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수강신청"> 
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</section>
</body>
</html>