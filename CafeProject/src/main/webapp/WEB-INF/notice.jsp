<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	String notice_title  = (String)request.getAttribute("notice_title");
	String notice_content  = (String)request.getAttribute("notice_content");
	String notice_type  = (String)request.getAttribute("notice_type");
%>

<body>
<h1>공지사항 등록</h1>

<form action="<%=request.getContextPath() %>/notice.do" method="post">
	
	<select  name="notice_type" required>카테고리 선택
		<option label="일반알림" value="일반알림"/>	
		<option label="회원필독" value="회원필독"/>	
		<option label="운영자알림" value="운영자알림"/>	
		<option label="게시글추천" value="게시글추천"/>	
		<option label="이벤트" value="이벤트"/>
	</select>	
	<h4>
		<span>제목</span>
		<span><input type="text" name="notice_title"></span>
	</h4>
	<h4>
		<span>내용</span>
		<span><input type="text"  name="notice_content"></span>
	</h4>
	<div>
		<button type="button">목록으로</button>
		<button type="submit">등록</button>
	</div>
</form>



</body>
</html>