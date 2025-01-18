<%@page import="java.util.List"%>
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
<h1>회원 페이지</h1>
<br>
<hr>

<h2>회원 리스트</h2>
<%	
	List<MemVO> memList = (List<MemVO>)request.getAttribute("memList");
	//회원 목록이 없거나, 리스트가 비어있을 경우
	if(memList == null || memList.isEmpty()){
		
%>
	<p>등록된 회원이 없습니다</p>
<%
	} else {
%>
	<table border="1">
		<thead>
			<tr>
				<th>회원 ID</th>
				<th>회원 비밀번호</th>
				<th>회원 이름</th>
				<th>회원 전화번호</th>
				<th>회원 주소</th>
				<th>회원 상세주소</th>
				<th>생성일</th>
				<th>카페 등급</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(MemVO mem : memList ){
			%>
				<tr>
					<td><%= mem.getMem_id()%></td>
					<td><%= mem.getMem_pw() %></td>
					<td><%= mem.getMem_name()%></td>
					<td><%= mem.getMem_tel() %></td>
					<td><%= mem.getMem_addr1() %></td>
					<td><%= mem.getMem_addr2() %></td>
					<td><%= mem.getMem_create() %></td>
					<td><%= mem.getMem_grd() %></td>
				</tr>
			<%
				}
			%>
		</tbody>
	</table>
<%
	}
%>	
</body>

<br>
<a href="<%=request.getContextPath()%>/Logout.do">로그아웃</a>
</html>