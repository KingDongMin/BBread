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

		String pageURL = "pages/members/cart.jsp";
		
		HttpSession session = request.getSession();
		
		MemberVO mvo = (MemberVO) session.getAttribute("Mvo");

		// 로그인 유효성 검사
		if (mvo == null) {
			request.setAttribute("message", "로그인 후 이용해주세요.");
			// 포워딩 : 실패시
			new MainPageAction().execute(request, response, context);;
			return;
		}
		
		// 로그인 후
		
		String mid = mvo.getId();
		CartDAO cdao = CartDAO.getInstance();
		
		List<CartVO> carts = cdao.getCarts(mid);
		request.setAttribute("carts", carts);

		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
	}

}
