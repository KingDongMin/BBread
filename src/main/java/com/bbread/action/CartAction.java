package com.bbread.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.page.ProductDetailPageAction;
import com.bbread.dao.CartDAO;
import com.bbread.dto.CartVO;
import com.bbread.dto.MemberVO;

public class CartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		
		HttpSession session = request.getSession();
		CartDAO cdao = CartDAO.getInstance();
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		MemberVO mvo = (MemberVO) session.getAttribute("Mvo");

		// 로그인 유효성 검사
		if (mvo == null) {
			request.setAttribute("message", "로그인 후 이용해주세요.");
			// 포워딩 : 실패시
			new ProductDetailPageAction().execute(request, response, context);
			return;
		}
		
		String mid = mvo.getId();
		
		if (cdao.checkCart(mid, pseq)) {
			System.out.print("업데이트: "+cdao.checkCart(mid, pseq));
			// 기존 카트 아이템 : 업데이트
			cdao.updateCart(mid, pseq, quantity);
		} else {
			// 새로운 카트 아이템 : 추가
			CartVO cvo = new CartVO();

			cvo.setPseq(pseq);
			cvo.setQuantity(quantity);
			cvo.setMid(mid);
			cdao.addCart(cvo);
			
		}

		// 포워딩 : 성공 시
		request.setAttribute("message", "카트에 담겼습니다.");
		new ProductDetailPageAction().execute(request, response, context);

	}

}
