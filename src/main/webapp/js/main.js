function test(){
	console.log("메인함수 실행");
	
}

test();


/* 메시지 타이머 기능*/
function messageOut(message){
	const messageBox = document.getElementById("message_box");
	console.log("message 함수 호출");
	const messageP = document.createElement('h1');
	messageP.textContent = message;
	messageBox.appendChild(messageP);
	setTimeout(sessionStorage.removeItem("message"),3000);
	setTimeout(messageP.remove(), 3000);
}





function selectedMenu(){
	document.querySelector(".menu").classList.remove("selected");
	console.log("함수 실행");
	const urlStr = window.location.href;
	const url = new URL(urlStr);
	const urlParams = url.searchParams;
	
	const kind = urlParams.get("kind");
	if(kind == null) return;
	console.log(kind);
	const selected = document.querySelector(`.${kind}`);
	selected.classList.add('selected');
}

selectedMenu();
