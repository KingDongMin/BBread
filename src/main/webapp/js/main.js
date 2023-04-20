

function selectedMenu(){
	document.querySelector(".menu").classList.remove("selected");
	const urlStr = window.location.href;
	const url = new URL(urlStr);
	const urlParams = url.searchParams;
	const kind = urlParams.get("kind");
	if(kind == null) return;
	const selected = document.querySelector(`.${kind}`);
	selected.classList.add('selected');
}

// form의 Null값 check
const datas = document.querySelectorAll('.data');
 
 function checkNull(){
	 for(const input of datas){
		if(!input.value){
			input.style.cssText = "outline-color:red;"
			input.focus();
			return false;
		}
		input.style.cssText = "outline-color:green";
	 }
	 return true;
}


