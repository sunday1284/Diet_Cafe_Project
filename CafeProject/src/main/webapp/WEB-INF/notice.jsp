<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	request.getAttribute("notice_title");
	request.getAttribute("notice_content");
	request.getAttribute("notice_type");
%>

<body>
<h1>공지사항 등록</h1>

<form action="<%=request.getContextPath() %>/notice.do" method="post">
	
	<select id="notice_type">카테고리 선택
		<option label="일반알림"/>	
		<option label="회원필독"/>	
		<option label="운영자알림"/>	
		<option label="게시글추천"/>	
		<option label="이벤트"/>
	</select>	
	<h4>
		<span>제목</span>
		<span><input type="text" id="notice_title"></span>
	</h4>
	<h4>
		<span>내용</span>
		<span><input type="text" id="notice_content"></span>
	</h4>
	<div>
		<button type="button">목록으로</button>
		<button type="submit">등록</button>
	</div>
</form>



</body>
</html>