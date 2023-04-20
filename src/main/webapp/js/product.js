

//제품 수량 증감
const quantityBox = document.getElementById("quantity_box");
const quantity = document.getElementById("quantity");

// 제품 수량 증감 이벤트
(quantityBox && quantity) && quantityBox.addEventListener("click", (e) => {
	const value = e.target.value;

	if (value != "plus" && value != "minus") return;

	if (value == "plus") {
		quantity.value = Number(quantity.value) + 1;
	} else if (value == "minus" && Number(quantity.value) > 1) {
		quantity.value = Number(quantity.value) - 1;
	}

})

// 제품 수량 마이너스 값 확인
quantity && quantity.addEventListener('change', (e) => {
	const quantity = e.target;
	if (quantity.value < 1) {
		quantity.value = 1;
		quantity.style.cssText = "outline-color : red;";
		quantity.focus();
		return;
	}
	quantity.style.cssText = "outline-color : green;";
})

const deleteItem = (pseq) => {
	location.href = `BBreadServlet?command=product_delete&pseq=${pseq}`;
}

const updateProduct = (pseq) => {
	location.href = `BBreadServlet?command=product_update_page&pseq=${pseq}`;
}


// 제품종류 selected 
const kind  = document.querySelector('.kind');
//페이지가 로드 되면 자동으로 kind를 찾는 이벤트를 실행한다.

function setOption(value){
	if(!kind) return;
	for(let option of kind.options){
		console.log(option.value);
		if(option.value == value){
			option.selected = 'selected';
			return;
		}
	}
}



