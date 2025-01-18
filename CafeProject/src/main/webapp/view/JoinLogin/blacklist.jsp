<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
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
    <table>
        <thead>
            <tr>
                <th>블랙 리스트 회원 ID</th>
                <th>블랙리스트 상태</th>
            </tr>
        </thead>
        <tbody>
            <%
                // ServletContext에서 블랙리스트 가져오기
                Map<String, String> blacklist = (Map<String, String>) application.getAttribute("blacklist");
                if (blacklist != null && !blacklist.isEmpty()) {
                    Set<Map.Entry<String, String>> entries = blacklist.entrySet();
                    for (Map.Entry<String, String> entry : entries) {
            %>
            <tr>
                <td><%= entry.getKey() %></td>
                <td><%= entry.getValue() %></td>
                 <td>
                    <form action="<%=request.getContextPath()%>/unblacklistMember.do" method="post" onsubmit="return confirm('정말로 해제하시겠습니까?');">
                        <input type="hidden" name="mem_id" value="<%= entry.getKey() %>">
                        <input type="submit" value="해제">
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="2">블랙한 회원 목록이 없습니다..</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>