
//popup message
function popupMessage(msg){
	const msgBox = document.querySelector('#message-box')
	if(!msg || !msgBox) return;
	msgBox.textContent = msg;
	msgBox.style.cssText = "top : 10%;"
	setTimeout(()=>{
		msgBox.style.cssText = "top : -10%; display:hidden;"
	},2000);
}


// 삭제 메시지 생성 함수
function createMessage(seq) {

	//삭제버튼 클릭 시 요소 생성
	const message_wrap = document.createElement('article')
	const message_box = document.createElement('div')
	const p = document.createElement('p');
	const div = document.createElement('div')
	const checkBtn = document.createElement("button");
	const cencleBtn = document.createElement("button");

	// 요소 세팅
	message_wrap.id = "message-wrap";
	message_box.id = "message-box";
	p.textContent = "삭제하시겠습니까?";
	checkBtn.textContent = "삭제";
	cencleBtn.textContent = "취소";

	//요소 할당
	message_wrap.appendChild(message_box);
	message_box.appendChild(p);
	message_box.appendChild(div);
	div.appendChild(checkBtn);
	div.appendChild(cencleBtn);

	// 버튼 클릭 이벤트 할당
	checkBtn.addEventListener('click', () => deleteItem(seq));
	cencleBtn.addEventListener('click', cancleMessage);

	// body에 요소 추가
	document.body.appendChild(message_wrap);
}



function cancleMessage(){
	const message_wrap = document.querySelector("#message-wrap")
	message_wrap.remove();
}

function checkMessage(qseq){
	console.log(`BBreadServlet?command=delete_QnA&qseq=${qseq}`);
	location.href=`BBreadServlet?command=delete_QnA&qseq=${qseq}`;
}


