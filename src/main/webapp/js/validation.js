/** 유효성 검사 */

// ID관련 DOM
const ID_input = document.querySelector(".ID_input");
const ID_check = document.querySelector(".ID_check");
const ID_resultMsgBox = document.querySelector(".ID_resultMsgBox");
const ID_regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣| \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
const ID_warning = document.createElement('p');

// ID 특정문자 제한
if(ID_input && ID_resultMsgBox){
	ID_input.addEventListener('keydown', (e) => checkID_RegExp(e));
	ID_input.addEventListener('keyup', (e) => checkID_RegExp(e));
	ID_input.addEventListener('blur',(e)=>checkID_focus(e));	
}


// 아이디 특수문자 및 한글 제한
function checkID_RegExp(e){
	const input = e.target;
	if(ID_regExp.test(input.value)){
		ID_warning.textContent="아이디는 영문과 숫자만 허용합니다.";
		ID_resultMsgBox.appendChild(ID_warning);
		ID_input.style.cssText = "border:2px solid red; outline-color:red";
		input.value = input.value.substring(0, input.value.length -1);
		return;
	}	
}

// 아이디 포커스아웃 결과
function checkID_focus(e){
	let input = e.target;
	const checkID_regExp = /^[a-zA-z0-9]{4,12}$/;
	
	if(ID_regExp.test(input.value)){
		input.value = input.value.substring(0, input.value.length -1);
	}
	
	if(!checkID_regExp.test(input.value) || ID_input.length < 4){
		ID_warning.textContent="아이디는 4~12자리가 필수이며 영문과 숫자만을 허용합니다.";
		ID_resultMsgBox.appendChild(ID_warning);
		ID_input.focus();
		return;
	}
	if(!ID_check.value){
		ID_warning.textContent="아이디 중복체크가 필요합니다.";
		ID_resultMsgBox.appendChild(ID_warning);
		ID_input.style.cssText ="border:2px solid yellow; outline:none";
	}	
}

function checkID() {

	if (!ID_input.value) {
		// ID 입력하시오 메시지 전달 !
		ID_warning.textContent = "아이디를 입력해주세요."
		return ID_input.focus();
	}
	const url = "BBreadServlet?command=ID_Check&id=" + ID_input.value;

	// 아이디 중복체크 페이지 열기
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}


/** idCheck 페이지의 유효성 검사 */


// 아이디 중복 검사 후 사용 (In idCheck.jsp)
function useID() {
	const checkedID = document.querySelector(".checkedID");
	const ID_input = opener.document.querySelector(".ID_input");
	const ID_check = opener.document.querySelector(".ID_check");
	const ID_warning = opener.document.querySelector(".ID_resultMsgBox>p");
	
	ID_warning && ID_warning.remove();
	ID_input.value = checkedID.value;
	ID_check.value = checkedID.value;
	
	ID_input.style.cssText ="border:2px solid green; outline:none";

	self.close();
}


// 비밀번호 관련 ------------------------------------------------

const PW_input = document.querySelector(".PW_input");
const PW_check = document.querySelector(".PW_check");
const PW_resultMsgBox = document.querySelector(".PW_resultMsgBox");
const PW_regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣| {\}\[\]\/?.,;:|\)*~`^\-_+┼<>\%&\'\"\\\(\=]/gi;
const PW_warning = document.createElement('p');
let checkedPW = 0;


if(PW_input && PW_resultMsgBox){
	PW_input.addEventListener('keydown', (e) => checkPW_RegExp(e));
	PW_input.addEventListener('keyup', (e) => checkPW_RegExp(e));
	PW_input.addEventListener('blur',(e)=>checkPW_focus(e));
}


if(PW_check && PW_resultMsgBox){
	PW_check.addEventListener('keydown', (e) => checkPW_RegExp(e));
	PW_check.addEventListener('keyup', (e) => checkPW_RegExp(e));
	PW_check.addEventListener('blur',(e)=>checkPW_focus(e));
}


// 비번 특수문자 및 한글 제한
function checkPW_RegExp(e){
	let input = e.target;
	if(PW_regExp.test(input.value)){
		PW_warning.textContent = "비밀번호는 영문,숫자,특수문자(!@#$)만 허용합니다.";
		PW_resultMsgBox.appendChild(PW_warning);
		input.style.cssText = "border:2px solid red; outline-color:red";
		input.value = input.value.substring(0, input.value.length -1);
		return; 
	}	
}

// 비밀번호 포커스아웃 결과
function checkPW_focus(e){
	let input = e.target;
	const checkPW_regExp = /^[a-zA-z0-9]{8,20}$/;
	
	if(PW_regExp.test(input.value)){
		input.value = input.value.substring(0, input.value.length -1);
	}
	
	if(!checkPW_regExp.test(input.value)){
		PW_warning.textContent="비밀번호는 8~20자리가 필수이며 \n 영문과 숫자, 특수문자(!@#$)만을 허용합니다.";
		PW_resultMsgBox.appendChild(PW_warning);
		input.style.cssText = "border:2px solid red; outline-color:red";
		return;
	}
	if( input.value.length < 8){
		PW_warning.textContent="비밀번호는 8~20자리가 필수입니다.";
		PW_resultMsgBox.appendChild(PW_warning);
		input.style.cssText = "border:2px solid red; outline-color:red";
		return;
	}
	
	if(PW_input.value != PW_check.value){
		PW_check.style.cssText ="border:2px solid red; outline:none"
		PW_warning.textContent="비밀번호 확인을 해주세요.";
		PW_resultMsgBox.appendChild(PW_warning);
	}
	
	if(PW_input.value == PW_check.value){
		PW_warning.remove();
		checkedPW = 1;
		PW_input.style.cssText ="border:2px solid green; outline:none";
		PW_check.style.cssText ="border:2px solid green; outline:none";
	}
}

// 이름 유효성검사
const name_input = document.querySelector('.name_input');
const name_resultMsgBox = document.querySelector(".name_resultMsgBox");
const name_regExp = /[0-9 | \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
const name_warning = document.createElement('p');
const checkedName = {value:0};
name_warning.textContent="이름는 영문과 한글만 허용합니다.";

if(name_input && name_resultMsgBox){
	name_input.addEventListener('keydown', (e) => check_RegExp(e, name_regExp, name_warning, name_resultMsgBox));
	name_input.addEventListener('keyup', (e) => check_RegExp(e, name_regExp, name_warning, name_resultMsgBox));
	name_input.addEventListener('blur',(e)=>check_focus(e, name_regExp, name_warning,checkedName));	
}


// 이메일 // @ 포함 (특수문자제제) 영문 및 @앞에 아이디
const email_input = document.querySelector('.email_input');
const email_resultMsgBox = document.querySelector(".email_resultMsgBox");
const email_regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣| \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>\#$%&\'\"\\\(\=]/gi;
const email_warning = document.createElement('p');
const checkedEmail = {value:0};
email_warning.textContent ="이메일은 한글과 @을 제외한 특수문자가 제한됩니다.";


if(email_input && email_resultMsgBox){
	email_input.addEventListener('keydown', (e) => check_RegExp(e , email_regExp, email_warning, email_resultMsgBox));
	email_input.addEventListener('keyup', (e) => check_RegExp(e , email_regExp, email_warning, email_resultMsgBox));
	email_input.addEventListener('blur',(e)=>check_focus(e , email_regExp, email_warning,checkedEmail));	
}

// 주소
const address_input = document.querySelector('.address_input');
const address_resultMsgBox = document.querySelector(".address_resultMsgBox");
const address_regExp = /[| \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
const address_warning = document.createElement('p');
const checkedAddress = {value:0};
address_warning.textContent = "주소는 특수문자를 제한합니다."

if(address_input && address_resultMsgBox){
	address_input.addEventListener('keydown', (e) => check_RegExp(e , address_regExp, address_warning,address_resultMsgBox));
	address_input.addEventListener('keyup', (e) => check_RegExp(e , address_regExp, address_warning,address_resultMsgBox));
	address_input.addEventListener('blur',(e)=>check_focus(e , address_regExp, address_warning,checkedAddress));	
}

// 전화번호
const phone_input = document.querySelector('.phone_input');
const phone_resultMsgBox = document.querySelector(".phone_resultMsgBox");
const phone_regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-zA-z| \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
const phone_warning = document.createElement('p');
const checkedPhone = {value:0};
phone_warning.textContent = "전화번호는 숫자만 허용합니다."

if(phone_input && phone_resultMsgBox){
	phone_input.addEventListener('keydown', (e) => check_RegExp(e , phone_regExp, phone_warning, phone_resultMsgBox));
	phone_input.addEventListener('keyup', (e) => check_RegExp(e , phone_regExp, phone_warning, phone_resultMsgBox));
	phone_input.addEventListener('blur',(e)=>check_focus(e , phone_regExp, phone_warning, checkedPhone));	
}


// 문자 제한
function check_RegExp(e,regExp, warning, resultMsgBox){
	const input = e.target;
	if(regExp.test(input.value)){
		resultMsgBox.appendChild(warning);
		input.style.cssText = "border:2px solid red; outline-color:red";
		input.value = input.value.substring(0, input.value.length -1);
		return;
	}
}

// 포커스 처리
function check_focus(e,regExp, warning, checked){
	let input = e.target;
	checked.value = 0;
	if(regExp.test(input.value)){
		input.value = input.value.substring(0, input.value.length -1);
	}
	
	if(input.value.length <= 3 ){
		input.style.cssText = "border:2px solid red; outline-color:none";
		return;
	}
	checked.value = 1;
	input.style.cssText = "border:2px solid green; outline-color:none";
	warning.remove();
	return;
}

// 모든 유효성 검사
function checkAll(){
	const All_warning = document.querySelector(".All_warning")
	
	// 아이디 검사
	if( !ID_check.value || ID_input.value != ID_check.value){
		All_warning.textContent = "아이디 중복검사를 해주세요.";
		return false;
	}
	
	// 비밀번호 검사
	if(!checkedPW){
		All_warning.textContent = "비밀번호를 확인해주세요.";
		return false;
	}
	
	if(!checkedName.value){
		All_warning.textContent = "이름을 확인해주세요.";
		return false;
	}
	
	if(!checkedEmail.value){
		All_warning.textContent = "이메일을 확인해주세요.";
		return false;
	}
	if(!checkedAddress.value){
		All_warning.textContent = "주소를 확인해주세요.";
		return false;
	}
	if(!checkedPhone.value){
		All_warning.textContent = "전화번호를 확인해주세요.";
		return false;
	}
	
	All_warning.textContent = "";
	return true;
};
