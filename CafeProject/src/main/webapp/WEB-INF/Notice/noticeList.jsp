<%@page import="java.util.List"%>
<%@page import="VO.noticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<style>
#title {
	width: 200px;
}
#type {
	width: 100px;
}
#head {
	font-size: 1em;
	font-weight: bold;
}
</style>

<body>
<h1>공지사항</h1>

<table border="1">
	<tr id="head">
		<td>글번호</td>
		<td id="type">분류</td>
		<td id="title">제목</td>
		<td>조회수</td>
		<td>게시일</td>
	</tr>

	<%
		List<noticeVO> noticeList = (List<noticeVO>) request.getAttribute("noticeList");

		if (noticeList != null && !noticeList.isEmpty()) {
			for (noticeVO notice : noticeList) {
	%>
	<tr>
		<td><%= notice.getNotice_no() %></td>
		<td><%= notice.getNotice_type() %></td>
			<td>
				<a href="<%=request.getContextPath()%>/detailNotice.do?notice_no=<%=notice.getNotice_no()%>">
						 <%=notice.getNotice_title() %></a>
			</td>
		<td><%= notice.getNotice_view() %></td>
		<td><%= notice.getNotice_day() %></td>
	</tr>
	<%
			}
		} else {
	%>
	<tr>
		<td colspan="4">공지사항이 없습니다.</td>
	</tr>
	<%
		}
	%>
</table>
	<a href="<%=request.getContextPath() %>/noticeInsert.do">
		<button>글쓰기</button>
	</a>

</body>
</html>
