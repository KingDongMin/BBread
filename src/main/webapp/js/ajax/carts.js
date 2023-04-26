

const getCarts = (mid) => {
	$.ajax({
		type: 'post',
		url: 'http://localhost:8181/BBread/carts',
		dataType: 'text',
		data: { id: mid },
		success: function(data) {
			if (data.length === 0 || data == null) {
				cart_list.innerHTML = '<li id="cart_item_none">장바구니에 담긴 제품이 없습니다.</li>'
				return;
			}

			addCartItem(JSON.parse(data).carts);
			createEvent();
			$(".price_wrap").css("display","block");
			$(".form_box").css("display","flex");
			calPrice();
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

	for (const item of carts) {
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
			<p id="price" value=30>￦ ${item.p_price}</p>
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



const createEvent = () => {
	const cartList = document.querySelector(".cart_list");

	cartList && cartList.addEventListener('click', (e) => {
		const btn = e.target;

		if (btn.nodeName != 'BUTTON') return;
		const element = btn.closest('li');
		const quantity = element.querySelector("#quantity")
		let quantity_value = Number(quantity.innerText);


		if (btn.value == 'minus') {
			console.log('감소');
			if (quantity_value <= 1) {
				return;
			}
			quantity_value -= 1;
			$.ajax({
				type: "post",
				url: "http://localhost:8181/BBread/updateCart",
				dataType: 'text',
				data: { cseq: element.value, quantity: quantity_value },
				success: function() {
					quantity.innerText = quantity_value;
					calPrice();
				},
				error: function() {
					console.log(error);
				}
			})


		}

		if (btn.value == 'plus') {
			quantity_value += 1;
			$.ajax({
				type: "post",
				url: "http://localhost:8181/BBread/updateCart",
				dataType: 'text',
				data: { cseq: element.value, quantity: quantity_value },
				success: function() {
					quantity.innerText = quantity_value;
					calPrice();
				},
				error: function() {
					console.log(error);
				}
			})
		}

		if (btn.value == 'delete') {
			console.log("삭제");
			$.ajax({
				type: "post",
				url: "http://localhost:8181/BBread/removeCart",
				dataType: 'text',
				data: { cseq: element.value },
				success: function() {
					element.remove();
					console.log("삭제 성공")
					calPrice();
				},
				error: function() {
					console.log(error);
				}
			})
		}
		
	})

}


// 가격 렌더링
// 일단은 각 제품의 DOM요소에서 수량과 가격을 가져와야한다?
function calPrice() {
	const cart_items = document.querySelectorAll(".cart_item");
	console.log(cart_items);
	if(cart_items.length === 0){
		$(".price_wrap").css("display","none");
		$(".form_box").css("display","none");
		cart_list.innerHTML = '<li id="cart_item_none">장바구니에 담긴 제품이 없습니다.</li>'
		return;
	}
	// price부분의 ￦기호를 정규표현식으로 제거 후 숫자만 추출
	const regExp = /[^0-9]/g;
	let del_fee = 3000;
	let all_price = 0;

	for (const cart_item of cart_items) {
		const quantity = Number(cart_item.querySelector('#quantity').textContent);
		const price = Number(cart_item.querySelector('#price').textContent.replace(regExp, ""));
		all_price += quantity * price;
	}
	const total_price = del_fee + all_price;

	// 가격부분 렌더링
	$('#all_price').text(`￦ ${all_price}`);
	$('#del_fee').text(`￦ ${del_fee}`);
	$('#total_price').text(`￦ ${total_price}`);

}





