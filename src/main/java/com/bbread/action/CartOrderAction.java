package com.bbread.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.page.CartPageAction;
import com.bbread.dao.CartDAO;
import com.bbread.dao.OrderDAO;
import com.bbread.dto.CartVO;
import com.bbread.dto.MemberVO;
import com.bbread.dto.OrdersVO;

public class CartOrderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		// 객체 생성 및 할당
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("Mvo");
		CartDAO cdao = CartDAO.getInstance();
		OrderDAO odao = OrderDAO.getInstance();
		
		// 로그인 유저ID ( in session)
		String mid = mvo.getId();
		
		// 로그인 유저의 Cart 제품들을 가져온다.
		List<CartVO> carts = cdao.getCarts(mid);
		if(carts.isEmpty()) {
			request.setAttribute("message", "주문 실패");
			new CartPageAction().execute(request, response, context);
			return;
		}
		
		// 해당 유저의 주문 인스턴스를 생성 후 주문인스턴스seq 할당
		int oseq = odao.createOrders(mid);
		
		// 해당 유저의 cart제품들을 주문상세테이블에 insert
		for(CartVO cart : carts) {
			odao.addOrderDetail(oseq, cart);
		}
		
		// 주문 완료 후 해당 유저의 카트아이템 삭제
		for(CartVO cart : carts) {
			cdao.deleteCart(cart.getCseq());
		}
		
		//비즈니스 처리 후 해당 카트페이지로 포워딩
		request.setAttribute("message", "주문이 완료되었습니다.");
		new CartPageAction().execute(request, response, context);
		
		
		

	}

}
