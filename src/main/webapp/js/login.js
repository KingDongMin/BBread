/** 로그인 유효성 검사 */

// ID관련 DOM
const ID_input = document.querySelector(".ID_input");
const ID_resultMsgBox = document.querySelector(".ID_resultMsgBox");
const msg = document.createElement('p');
msg.textContent="아이디는 영문과 숫자만 허용합니다.";

// ID 특정문자제한 정규표현식
const ID_regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;

// ID관련 DOM 이벤트 핸들링
ID_input.addEventListener('keydown', (e) => checkID_RegExp(e));
ID_input.addEventListener('keyup', (e) => checkID_RegExp(e));
ID_input.addEventListener('blur',(e)=>checkID_focus(e));


// 아이디 특수문자 및 한글 제한
function checkID_RegExp(e){
	let input = e.target;
	if(ID_regExp.test(input.value)){
		ID_resultMsgBox.appendChild(msg);
		ID_input.style.cssText = "border:2px solid red; outline-color:red";
		input.value = input.value.substring(0, input.value.length -1);
		return;
	}	
}

// 아이디 포커스아웃 결과
function checkID_focus(e){
	let input = e.target;
	if(ID_regExp.test(input.value)){
		input.value = input.value.substring(0, input.value.length -1);
	}
	if(input.value.length > 1){
		msg.remove();
		ID_input.style.cssText ="border:2px solid green; outline:none";
	}	
}

// PW관련 DOM
const PW_input = document.querySelector(".PW_input");
const PW_resultMsgBox = document.querySelector(".PW_resultMsgBox");
const PW_resultMsg = document.createElement('p');
PW_resultMsg.textContent = "비밀번호는 영문,숫자,특수문자(!@#$)만 허용합니다."

// PW 특정문자제한 정규표현식
const PW_regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|{\}\[\]\/?.,;:|\)*~`^\-_+┼<>\%&\'\"\\\(\=]/gi;

// PW관련 DOM 이벤트핸들링
PW_input.addEventListener('keydown', (e) => checkPW_RegExp(e));
PW_input.addEventListener('keyup', (e) => checkPW_RegExp(e));
PW_input.addEventListener('blur',(e)=>checkPW_focus(e));

// 비번 특수문자 및 한글 제한
function checkPW_RegExp(e){
	let input = e.target;
	if(PW_regExp.test(input.value)){
		PW_resultMsgBox.appendChild(PW_resultMsg);
		PW_input.style.cssText = "border:2px solid red; outline-color:red";
		input.value = input.value.substring(0, input.value.length -1);
		return;
	}	
}

// 비번 포커스아웃 결과
function checkPW_focus(e){
	let input = e.target;
	if(PW_regExp.test(input.value)){
		input.value = input.value.substring(0, input.value.length -1);
	}
	if(input.value.length > 1){
		PW_resultMsg.remove();
		PW_input.style.cssText ="border:2px solid green; outline:none";
	}	
}






