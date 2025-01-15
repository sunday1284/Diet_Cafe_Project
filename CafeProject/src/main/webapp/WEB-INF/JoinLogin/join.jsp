<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
</head>
<body>
<h1>회원 가입</h1>

<form action="<%=request.getContextPath()%>/join.do" method="post" enctype="application/x-www-form-urlencoded" onsubmit="return validateForm()">
<ul>
    <li>아이디 : <input type="text" name="mem_id" required minlength="4" maxlength="20" placeholder="아이디를 입력하세요!"></li>
    <li>비밀번호 : <input type="password" name="mem_pw" required minlength="8" placeholder="비밀번호를 입력하세요!"></li>
    <li>이름 : <input type="text" name="mem_name" required placeholder="이름 입력"></li>
    <li>생일 : <input type="date" name="mem_bir" placeholder="생일 입력"></li>
    <li>전화번호 : <input type="tel" name="mem_tel" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="전화번호 입력"></li>
    <li>주소 : <input type="text" name="mem_addr1" required placeholder="주소 입력"></li>
    <li>상세주소 : <input type="text" name="mem_addr2" placeholder="상세주소 입력"></li>
    <li>생성일 : <input type="date" name="mem_create" placeholder="생성일 입력"></li>
    <li>
        <button type="submit">전송</button>
        <button type="reset">리셋</button>
    </li>
</ul>
</form>
<script>
    function validateForm() {
        const tel = document.querySelector('input[name="mem_tel"]').value;
        const telRegex = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
        if (!telRegex.test(tel)) {
            alert('전화번호 형식이 올바르지 않습니다. 예: 010-1234-5678');
            return false;
        }
        return true;
    }
</script>


</body>
</html>