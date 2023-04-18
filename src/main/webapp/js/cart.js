/** 카트  */

// 제품 수량 수정 및 삭제를 어떻게 새로고침 없이 사용할까? (보류)
const cartList = document.querySelector(".cart_list");

cartList && cartList.addEventListener('click', (e)=>{
	const btn = e.target;
	
	if(btn.nodeName != 'BUTTON')return;
	
	if(btn.value == 'minus'){
		/*const item_cseq = btn.parentNode.parentNode.value;*/
	}
	
	if(btn.value == 'plus'){
	}
	
	if(btn.value == 'delete'){
		/*const item_cseq = btn.parentNode.value;*/
	}
})

