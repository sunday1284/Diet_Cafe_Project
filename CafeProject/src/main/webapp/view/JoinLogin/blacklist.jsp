<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="VO.MemVO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blacklist</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 50px 0;
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
    <h2>블랙리스트한 회원</h2>
    <a href="<%=request.getContextPath()%>/memList.do">회원 관리 리스트로 가기</a>
    <table>
        <thead>
            <tr>
                <th>블랙 리스트 회원 ID</th>
                <th>블랙 리스트 회원 이름</th>
                <th>블랙리스트 상태</th>
                <th>해제</th>
            </tr>
        </thead>
        <tbody>
            <%
                // request에서 블랙리스트 회원 리스트 가져오기
                List<MemVO> blacklist = (List<MemVO>) request.getAttribute("blacklist");
                if (blacklist != null && !blacklist.isEmpty()) {
                    for (MemVO mem : blacklist) {
            %>
            <tr>
                <td><%= mem.getMem_id() %></td>
                <td><%= mem.getMem_name() %></td>
                <td><%= mem.getIs_blacklisted() == 1 ? "블랙리스트" : "정상" %></td>
                <td>
                    <form action="<%=request.getContextPath()%>/unblacklistMember.do" method="post" onsubmit="return confirm('정말로 해제하시겠습니까?');">
                        <input type="hidden" name="mem_id" value="<%= mem.getMem_id() %>">
                        <input type="submit" value="해제">
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3">블랙한 회원 목록이 없습니다.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>