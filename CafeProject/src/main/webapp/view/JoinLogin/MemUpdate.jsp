<%@page import="VO.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 업데이트</title>
</head>
<body>
    <h1>회원 정보 업데이트 화면</h1>
    <%
        // 전달된 회원 정보를 받아오기 (백엔드에서 전달한 데이터)
        MemVO member = (MemVO) request.getAttribute("member");
        if (member != null) {
    %>
    <form action="<%=request.getContextPath() %>/memUpdate.do" method="post" onsubmit="return validateForm()">
        <!-- Hidden으로 회원 ID 전달 -->
        <input type="hidden" name="mem_id" value="<%= member.getMem_id() %>">
        <label>
            비밀번호 변경: 
            <input type="password" id="mem_pw" name="mem_pw" placeholder="비밀번호 입력 (8자리 이상, 대소문자, 특수문자 포함)">
        </label><br>

        <label>
            비밀번호 확인 : 
            <input type="password" id="confirm_pw" placeholder="비밀번호 확인">
            <span id="pwMatchResult" style="margin-left: 10px; color: red;"></span>
        </label><br>

        <label>
            이름 : 
            <input type="text" name="mem_name" value="<%= member.getMem_name() %>" placeholder="이름 입력">
        </label><br>

        <label>
            전화번호 : 
            <input type="tel" name="mem_tel" value="<%= member.getMem_tel() %>" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="010-1234-5678">
        </label><br>

        <label>
            우편번호 : 
            <input type="text" id="sample6_postcode" name="mem_postcode"  placeholder="우편번호">
            <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
        </label><br>

        <label>
            주소 : 
            <input type="text" id="mem_addr1" name="mem_addr1" value="<%= member.getMem_addr1() %>" placeholder="주소 입력">
        </label><br>

        <label>
            참고 주소 : 
            <input type="text" id="sample6_extraAddress" name="extra_addr" placeholder="참고 주소" readonly>
        </label><br>

        <label>
            상세주소 : 
            <input type="text" id="mem_addr2" name="mem_addr2" value="<%= member.getMem_addr2() %>" placeholder="상세주소 입력">
        </label><br>

        <button type="submit">업데이트</button>
        <button type="reset">리셋</button>
    </form>
    <%
        } else {
    %>
        <p>회원 정보가 없습니다.</p>
    <%
        }
    %>
</body>

<script src="<%=request.getContextPath()%>/resource/js/jquery-3.7.1.min.js"></script>
<!-- 다음 주소 api  -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
// 비밀번호 일치 여부 
document.getElementById("confirm_pw").addEventListener("input", function() {
    const pw = document.getElementById('mem_pw').value;
    const confirmPw = this.value;
    const pwMatchResult = document.getElementById('pwMatchResult');
    if(pw == confirmPw){
        pwMatchResult.style.color = 'green';
        pwMatchResult.textContent = '비밀번호가 일치합니다.';
    }else {
        pwMatchResult.style.color = 'red';
        pwMatchResult.textContent = '비밀번호가 일치하지 않습니다.';
    }
});

// 우편번호 찾기
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }

            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                document.getElementById("sample6_extraAddress").value = extraAddr;
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("mem_addr1").value = addr;
            document.getElementById("mem_addr2").focus();
        }
    }).open();
}

function validateForm() {
    const pw = document.getElementById('mem_pw').value;
    const confirmPw = document.getElementById("confirm_pw").value;
    
    if (pw != confirmPw){
        alert("비밀번호가 일치하지 않습니다.");
        document.getElementById("confirm_pw").focus(); // 비밀번호 확인 필드에 포커스
        return false;
    }
    
    const tel = document.querySelector('input[name="mem_tel"]').value;
    const telRegex = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
    if (!telRegex.test(tel)) {
        alert('전화번호 형식이 올바르지 않습니다. 예: 010-1234-5678');
        return false;
    }
    return true;
}
</script>
</html>