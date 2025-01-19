<%@page import="VO.noticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 조회</title>
</head>
<body>
    <h1>게시글 상세 조회</h1>
    
    <%
        // 서버에서 전달된 공지사항 객체를 가져오기
        noticeVO notice = (noticeVO) request.getAttribute("detailNotice");

        if (notice != null) { // 공지사항 데이터가 있는 경우
    %>
    <table border="1">
        <tr>
            <th>글번호</th>
            <td><%= notice.getNotice_no() %></td>
        </tr>
        <tr>
            <th>유형</th>
            <td><%= notice.getNotice_type() %></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><%= notice.getNotice_title() %></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><%= notice.getNotice_content() %></td>
        </tr>
        <tr>
            <th>작성일</th>
            <td><%= notice.getNotice_day() %></td>
        </tr>
        <tr>
            <th>조회수</th>
            <td><%= notice.getNotice_view() %></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
                <% if (notice.getSfile() != null) { %>
<%--                     <a href="/Upload/<%= notice.getSfile() %>" download><%= notice.getOfile() %></a> --%>
		  <a href="<%=request.getContextPath()%>/downloadFile.do?sfile=<%= notice.getSfile() %>&ofile=<%= notice.getOfile() %>">
            <%= notice.getOfile() %>
        </a>
                <% } else { %>
                    첨부파일 없음
                <% } %>
            </td>
        </tr>
    </table>
    <%
        } else { // 공지사항 데이터가 없는 경우
    %>
    <p>공지사항 데이터를 불러올 수 없습니다.</p>
    <%
        }
    %>
    
    <br>
    <a href="<%=request.getContextPath() %>/noticeList.do">목록으로</a>
</body>
</html>
