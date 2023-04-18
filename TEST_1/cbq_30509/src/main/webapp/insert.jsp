<%@page import="vo.MemberVO"%>
<%@page import="vo.TeacherVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<meta charset="UTF-8">
<title>Teacher Insert</title>
<% 
	ArrayList<TeacherVO> tList = (ArrayList<TeacherVO>)request.getAttribute("insertT");
	ArrayList<MemberVO> mList = (ArrayList<MemberVO>)request.getAttribute("insertM");
%>
	<main>
		<h2>수강 신청</h2>
		<form action="/classInsert" method="post" id="form">
			<table border="1">
				<tr>
					<td>수강월</td>
					<td><input type="text" id="date" name="date"> 2022년03월 예)202203</td>
				</tr>
				<tr>
					<td>회원명</td>
					<td>
						<select id="memberName" onchange="num_check();" name="memberName">
							<option value="">회원명</option>
<%
							if(tList != null) {
								for(MemberVO m: mList) {
%>
							<option value="<%= m.getC_name() %>"><%= m.getC_name() %></option>
<%
								}
							}
%>
						</select>
					</td>
				</tr>
				<tr>
					<td>회원번호</td>
					<td><input type="text" id="memberNum" name="memberNum" readonly> 예)100001</td>
				</tr>
				<tr>
					<td>강의장소</td>
					<td><input type="text" id="add" name="add"></td>
				</tr>
				
				<tr>
					<td>강의선택</td>
					<td>
						<select id="className" name="className" onchange="class_check()">
							<option value="">강의선택</option>
<%
							if(mList != null) {
								for(TeacherVO t: tList) {
%>
							<option value="<%= t.getClass_name() %>"><%= t.getClass_name() %></option>
<%
								}
							}
%>
						</select>
					</td>
				</tr>
				<tr>
					<td>수강료</td>
					<td><input type="text" id="price" name="price" readonly></td>
				</tr>
				<tr>
					<td colspan="2"><button type="button" onclick="test()">수강신청</button> <input type="reset" value="다시쓰기" id="reset" onclick="aa()"></td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
		
			function aa() {
				alert("정보를 지우고 처음부터 다시 입력합니다.");
			}
		
			function num_check() {
				var name = document.getElementById("memberName").value;
				switch (name) { 
					case "이혜정": document.getElementById("memberNum").value = '10001'; break;
					case "조아라": document.getElementById("memberNum").value = '10002'; break;
					case "유현주": document.getElementById("memberNum").value = '10003'; break;
					case "김미현": document.getElementById("memberNum").value = '20001'; break;
					case "박세리": document.getElementById("memberNum").value = '20002'; break;
					default: num = '';
				}
				
				class_check();
			}
			
			function class_check() {
				var name = document.getElementById("className").value;
				var num = document.getElementById("memberNum").value;
				
				if (num == "20001" || num == "20002") {
					switch (name) { 
						case "초급반": document.getElementById("price").value = 1000000/2; break;
						case "중급반": document.getElementById("price").value = 2000000/2; break;
						case "고급반": document.getElementById("price").value = 3000000/2; break;
						case "심화반": document.getElementById("price").value = 4000000/2; break;
					}
				} else if (num != "20001" || num != "20002") {
					switch (name) { 
						case "초급반": document.getElementById("price").value = '1000000'; break;
						case "중급반": document.getElementById("price").value = '2000000'; break;
						case "고급반": document.getElementById("price").value = '3000000'; break;
						case "심화반": document.getElementById("price").value = '4000000'; break;
					}
				}
			}
		
			function test() {
				var go1 = false;
				let forms = document.getElementById("form")
				var date = document.getElementById("date").value;
				var name = document.getElementById("memberName").value;
				var num = document.getElementById("memberNum").value;
				var add = document.getElementById("add").value;
				var className = document.getElementById("className").value;
				var price = document.getElementById("price").value;
				
				if(date == null || date == "") { alert("수강월이 입력되지 않았습니다."); go1 = true;}
				if(name == null || name == "") { alert("회원명이 선택되지 않았습니다."); go1 = true; }
				if(num == null || num == "") { alert("회원번호가 입력되지 않았습니다."); go1 = true; }
				if(add == null || add == "") { alert("강의장소가 입력되지 않았습니다."); go1 = true; }
				if(className == null || className == "") { alert("강의선택이 선택되지 않았습니다."); go1 = true; }
				if(price == null || price == "") { alert("수강료가 입력되지 않았습니다."); go1 = true; }

				if(!go1) { 
					forms.submit();
				}
				
				return go1;
			}
		</script>
	</main>
<%@ include file="/footer.jsp" %>