<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 탈퇴 완료</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }
        h2 {
            color: #4CAF50;
        }
        p {
            font-size: 18px;
        }
        a {
            display: inline-block;
            margin: 20px;
            padding: 10px 20px;
            color: white;
            background-color: #4CAF50;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>카페 회원 탈퇴 완료</h2>
    <p>회원 탈퇴가 성공적으로 완료되었습니다. 그동안 이용해 주셔서 감사합니다.</p>
    <p>메인 페이지로 돌아가시려면 아래 버튼을 클릭하세요.</p>
    <a href="<%= request.getContextPath() %>/index.jsp">메인 페이지로 이동</a>
    <a href="<%= request.getContextPath() %>/Login.do">로그인 페이지로 이동</a>
</body>
</html>