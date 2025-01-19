<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>공지사항 등록</h3>
	<span style="color:red;">${errorMessage}</span> 
	<form name="fileForm" method="post" enctype="multipart/form-data" 
	action="<%=request.getContextPath() %>/noticeInsert.do">
		
	<select  name="notice_type" required>카테고리 선택
		<option label="일반알림" value="일반알림"/>	
		<option label="회원필독" value="회원필독"/>	
		<option label="운영자알림" value="운영자알림"/>	
		<option label="게시글추천" value="게시글추천"/>	
		<option label="이벤트" value="이벤트"/>
	</select><br><br>
	
	제목<input type="text" name="notice_title" /><br />
	
   <h4>
      <span>내용</span>
<!--       <span><input type="textarea" size=10 maxlengh=300 name="notice_content"></span> -->
		<textarea name="notice_content"></textarea>
   </h4>
	
	첨부파일 : <input type="file" name="ofile" value="파일" /> <br/>
	<input type="submit" value="등록" />
</form>



</body>
</html>