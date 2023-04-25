

const getCarts = (mid) => {
	console.log(mid);
	$.ajax({
		type: 'post',
		url: 'http://localhost:8181/BBread/carts',
		dataType: 'text',
		data: { id: mid },
		success: function(data) {
			if(data.length === 0 || data == null){
				cart_list.innerHTML = '<li id="cart_item_none">장바구니에 담긴 제품이 없습니다.</li>'
				return;
			}
			
			console.log(data);
			console.log(JSON.parse(data));
			addCartItem(JSON.parse(data).carts);
			createEvent();
		},
		error: function() {
			console.log("error!!");
		}
	})
}

const cart_list = document.querySelector(".cart_list");
const li = document.createElement("li");
li.classList = 'cart_item';


function addCartItem(carts) {
	
	
	for(const item of carts){
		const li = document.createElement("li");
		li.classList = 'cart_item';
		li.value = item.cseq;
		li.innerHTML =
		 `
		<div class="img_box">
			<img alt="item_image" src="upload/${item.p_url}">
		</div>
							
		<div class="product">
			<p>${item.p_name}</p>
			<p>￦ ${item.p_price}</p>
		</div>
						
		<div class="quantity_btn" >
			<button value="minus">-</button>
			<p id="quantity">${item.quantity}</p>
			<button value="plus">+</button>
		</div>
							
		<button class="delete_btn" value="delete">삭 제</button>
		`;
		cart_list.appendChild(li);
		
	}
}



const createEvent = ()=>{
	const cartList = document.querySelector(".cart_list");

	cartList && cartList.addEventListener('click', (e)=>{
	const btn = e.target;
	
	if(btn.nodeName != 'BUTTON')return;
	const element = btn.closest('li');
	const quantity = element.querySelector("#quantity")
	let quantity_value = Number(quantity.innerText);
	if(btn.value == 'minus'){
		console.log('감소');
		if( quantity_value <= 1){
			console.log("감소 불가")
			return;
		}
		quantity_value -= 1;
		$.ajax({
			type:"post",
			url : "http://localhost:8181/BBread/updateCart",
			dataType : 'text',
			data : {cseq : element.value, quantity: quantity_value},
			success : function(){
				quantity.innerText = quantity_value;
				console.log("감소 성공")
			},
			error : function(){
				console.log(error);
			}
		})

		
	}
	
	if(btn.value == 'plus'){
		console.log('증가');
		quantity_value += 1;
		$.ajax({
			type:"post",
			url : "http://localhost:8181/BBread/updateCart",
			dataType : 'text',
			data : {cseq : element.value, quantity: quantity_value},
			success : function(){
				quantity.innerText = quantity_value;
				console.log("증가 성공")
			},
			error : function(){
				console.log(error);
			}
		})
	}
	
	if(btn.value == 'delete'){
		console.log("삭제");
		$.ajax({
			type:"post",
			url : "http://localhost:8181/BBread/removeCart",
			dataType : 'text',
			data : {cseq : element.value},
			success : function(){
				element.remove();
				console.log("삭제 성공")
			},
			error : function(){
				console.log(error);
			}
		})
	}
})
	
}


