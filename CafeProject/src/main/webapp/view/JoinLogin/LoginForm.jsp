<%@page import="VO.MemVO"%>
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
	MemVO loginMemberVO = (MemVO) session.getAttribute("loginMember");
	%>
	<%
	if (loginMemberVO == null) { //로그인 안 했을 때...
	%>
	<form action="<%=request.getContextPath()%>/Login.do" method="post">
		<table style="margin: 0 auto;" border="1">
			<tr>
				<td>ID :</td>
				<td><input type="text" name="mem_id" placeholder="ID를 입력하세요."></td>
			</tr>
			<tr>
				<td>PASS :</td>
				<td><input type="password" name="mem_pw"
					placeholder="PASSWORD를 입력하세요."></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
	<%
	} else { //로그인 성공했을 때...
	%>
	<%=loginMemberVO.getMem_name()%>님 반갑습니다...
	<br>
	<br>

	<a href="<%=request.getContextPath()%>/Logout.do">로그아웃</a>
	<%
	}
	%>
</body>
</html>