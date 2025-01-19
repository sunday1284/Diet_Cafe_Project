<%@ page import="java.util.List"%>
<%@ page import="VO.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운영자 페이지</title>
<style>
table {
	width: 80%;
	border-collapse: collapse;
	margin: 20px 0;
	font-size: 18px;
	text-align: left;
}

th, td {
	padding: 12px;
	border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
	<h1>운영자 페이지</h1>
	<a href="<%=request.getContextPath()%>/Login.do">로그인 페이지로 가기</a>
	<hr>
	<!-- 비동기 처리 ->웰컴 메시지  -->
	<h2 id="welcome-message"></h2>

	<h2>회원 관리</h2>
	<%
	List<MemVO> memList = (List<MemVO>) request.getAttribute("memList");
	String userGrd = null;
	if (session.getAttribute("loginMember") != null) {
		MemVO loginMember = (MemVO) session.getAttribute("loginMember");
		userGrd = loginMember.getMem_grd();
	}
	// 회원 목록이 없거나 리스트가 비어있을 경우
	if (memList == null || memList.isEmpty()) {
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
				<th>블랙리스트 상태</th>
				<th>작업</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (MemVO mem : memList) {
			%>
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/memUpdate.do?mem_id=<%=mem.getMem_id()%>">
						<%=mem.getMem_id()%>
				</a></td>
				<td><%=mem.getMem_pw()%></td>
				<td><%=mem.getMem_name()%></td>
				<td><%=mem.getMem_tel()%></td>
				<td><%=mem.getMem_addr1()%></td>
				<td><%=mem.getMem_addr2()%></td>
				<td><%=mem.getMem_create()%></td>
				<td><%=mem.getMem_grd()%></td>
				<td><%=mem.getIs_blacklisted() == 1 ? "블랙" : "정상"%></td>
				<td>
					<form action="<%=request.getContextPath()%>/blacklistMember.do"
						method="get" onsubmit="return confirm('정말로 블랙리스트에 추가하시겠습니까?');">
						<input type="hidden" name="mem_id" value="<%=mem.getMem_id()%>">
						<input type="submit" value="블랙리스트 추가">
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	}
	%>
	<br>
	<a href="<%=request.getContextPath()%>/Logout.do">로그아웃</a>

	<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function(){
	    fetch('<%=request.getContextPath()%>/getLoginMemberInfo.do')
	        .then(response => response.json())
	        .then(data => {
	            if (data && data.mem_name){
	                document.getElementById('welcome-message').textContent="환영합니다," +data.mem_name+"님!";
	            }
	        })
	        .catch(error => console.error('회원정보를 찾을 수 없습니다..', error));
	});
	</script>
</body>
</html>