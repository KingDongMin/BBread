// 유효성 검사

const id = document.querySelector(".id");
const re_id = document.querySelector(".re_id");
const id_warning = document.querySelector(".ID_warning");
const pw = document.querySelector(".pw");
const re_pw = document.querySelector(".re_pw");
const pw_warning = document.querySelector(".PW_warning");
const warning_message = document.querySelector(".warning_message");


// ID 리터럴 경고
(id_input&& id_warning) && id_input.addEventListener("input", (e)=>{
	const text = e.target.value;
	const reg = /^[a-zA-z0-9]{4,12}$/;
	
	if(!reg.test(text)){
		id_warning.textContent = "아이디는 4~12자리가 필수이며 영문 대소문자와 숫자만을 허용합니다.";
		return;
	}
	id_warning.textContent = "아이디 조건을 만족하였습니다."
})

// 비밀번호 유효성 검사 : 리터럴
(pw&&re_pw&&pw_warning) && pw.addEventListener("input", (e)=>{
	const text = e.target.value;
	const reg = /^[a-zA-z0-9]{8,20}$/;
	
	if(!reg.test(text)){
		pw_warning.textContent = "비밀번호는 8~20자리가 필수이며 영문 대소문자와 숫자만 허용합니다."
		return;
	}
	pw_warning.textContent="";
	return;
});

// 비밀번호 유효성 검사 : 일치
(re_pw&&pw_warning) && re_pw.addEventListener("input", (e)=>{
	const text = e.target.value;
	if(text != pw.value){
		pw_warning.textContent = "비밀번호가 일치하지 않습니다.";
		return;
	}
	pw_warning.textContent = "비밀번호가 일치합니다.";
})




//아이디 중복 검사 (IN idCheck.jsp)
function check_ID() {
	const input = document.querySelector(".ID_input");

	if (!input.value) {
		// ID 입력하시오 메시지 전달 !
		id_warning.textContent = "아이디를 입력해주세요."
		return input.focus();
	}
	const url = "BBreadServlet?command=ID_Check&id=" + input.value;

	// 아이디 중복체크 페이지 열기
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}


// 아이디 중복 검사 후 사용 (In idCheck.jsp)
function useID() {
	const checkedID = document.querySelector(".checkedID");
	const id = opener.document.querySelector(".ID_input");
	const re_id = opener.document.querySelector(".ReID_input")

	id.value = checkedID.value;
	re_id.value = checkedID.value;

	self.close();
}




// 모든 유효성 검사
function checkAll(){
	const text = warning_message.textContent;
	
	// 아이디 검사
	if(id.value != re_id.value ){
		text = "아이디 중복검사를 해주세요.";
		return false;
	}
	
	
	// 비밀번호 검사
	if(pw.value != re_pw.value){
		text="비밀번호를 확인해주세요."
		return;
	}
	text = "회원가입 완료";
	return true;
};
