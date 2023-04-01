
/* 메시지 타이머 기능*/
function messageOut(){
	setTimeout(sessionStorage.removeItem("message"),3000);
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