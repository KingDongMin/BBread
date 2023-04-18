package com.bbread.action.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.Action;
import com.bbread.dao.CartDAO;
import com.bbread.dao.ProductDAO;
import com.bbread.dto.CartVO;
import com.bbread.dto.MemberVO;
import com.bbread.dto.ProductVO;

public class CartPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("Mvo");
		CartDAO cdao = CartDAO.getInstance();
		String pageURL = "pages/members/cart.jsp";
		String mid = null;

		// 로그인 유효성 검사
		if (mvo == null) {
			request.setAttribute("message", "로그인 후 이용해주세요.");
			// 포워딩 : 실패시
			new MainPageAction().execute(request, response, context);;
			return;
		}
		
		// 로그인 후
		mid = mvo.getId();
		List<CartVO> carts = cdao.getCarts(mid);
		
		//카트 값
		if(carts != null) {
			request.setAttribute("carts", carts);
		}else {
			request.setAttribute("null_carts", "장바구니에 담긴 제품이 없습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
	}

}
