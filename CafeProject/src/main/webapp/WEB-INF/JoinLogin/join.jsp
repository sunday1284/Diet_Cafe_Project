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
    <li>
    	아이디 : 
    	<input type="text" id="mem_id" name="mem_id" required minlength="4" maxlength="20" pattern="^[a-zA-Z0-9]{4,20}$" placeholder="아이디를 입력(대소문자 4~20자 사이)">
    	<button type="button" id="checkIdBtn">중복 체크</button>
    	<span id="idCheckResult" style="margin-left: 10px; color: red;"></span>
    </li>
    <li>비밀번호 : <input type="password" id ="mem_pw" name="mem_pw" required minlength="8" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])[A-Za-z0-9!@#\$%\^&\*]{8,}$" placeholder="비밀번호 입력(8자리,대소문자,특수문자포함)"></li>
    <li>비밀번호 확인 : 
    	<input type="password" id="confirm_pw" required minlength="8" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])[A-Za-z0-9!@#\$%\^&\*]{8,}$" placeholder="비밀번호 확인">
    	<span id="pwMatchResult" style="margin-left: 10px; color: red;"></span>
    </li>
    <li>이름 : <input type="text" name="mem_name" required placeholder="이름 입력"></li>
    <li>생일 : <input type="date" name="mem_bir" placeholder="생일 입력"></li>
    <li>전화번호 : <input type="tel" name="mem_tel" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="전화번호 입력"></li>
    <li><input type="text" id="sample6_postcode" placeholder="우편번호"></li>
    <li><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></li>
    <li>주소 : <input type="text" id="mem_addr1" name="mem_addr1" required placeholder="주소 입력"></li>
    <li>상세주소 : <input type="text" id="mem_addr2" name="mem_addr2" placeholder="상세주소 입력"></li>
    <li><input type="text" id="sample6_extraAddress" placeholder="참고항목"></li>
    <li>생성일 : <input type="date" name="mem_create" placeholder="생성일 입력"></li>
    <li>
        <button type="submit">전송</button>
        <button type="reset">리셋</button>
    </li>
</ul>
</form>
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

//id 중복체크 비동기
// ID 중복 체크 버튼 클릭 이벤트
document.getElementById("checkIdBtn").addEventListener("click", function() {
    const memId = document.getElementById("mem_id").value;
    const idCheckResult = document.getElementById("idCheckResult");

    if (memId.trim() === "") {
        idCheckResult.style.color = "red";
        idCheckResult.textContent = "아이디를 입력해주세요.";
        return;
    }

    // Ajax 요청
    $.ajax({
        url: "<%=request.getContextPath()%>/CheckId.do", // 중복 체크를 위한 서버 엔드포인트
        type: "POST",
        data: { mem_id: memId },
        success: function(response) {
            if (response == "duplicate") {
                idCheckResult.style.color = "red";
                idCheckResult.textContent = "중복된 아이디입니다.";
            } else {
                idCheckResult.style.color = "green";
                idCheckResult.textContent = "사용 가능한 아이디입니다.";
            }
        },
        error: function() {
            idCheckResult.style.color = "red";
            idCheckResult.textContent = "중복 체크 중 오류가 발생했습니다.";
        }
    });
});

<!--스크립트 분리  -->

 // 현재 날짜를 'mem_create' 필드에 설정하는 함수 
 window.onload = function() { 
	 var today = new Date(); 
	 var yyyy = today.getFullYear(); 
	 var mm = String(today.getMonth() + 1).padStart(2, '0'); 
	 var dd = String(today.getDate()).padStart(2, '0'); 
	 var formattedDate = yyyy + '-' + mm + '-' + dd; 
	 document.querySelector('input[name="mem_create"]').value = formattedDate;
 }
function validateForm() {
	//비번 검증 
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
    
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            //그냥주소
            document.getElementById("mem_addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("mem_addr2").focus();
        }
    }).open();
}
</script>


</body>
</html>