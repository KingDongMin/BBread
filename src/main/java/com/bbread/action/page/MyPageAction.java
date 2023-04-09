package com.bbread.action.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.Action;
import com.bbread.dao.OrderDAO;
import com.bbread.dao.QnADAO;
import com.bbread.dto.MemberVO;
import com.bbread.dto.OrderDetailVO;
import com.bbread.dto.OrdersVO;
import com.bbread.dto.QnAVO;

public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ServletException {
		String pageURL = "pages/members/MyPage.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("Mvo");
		String mid = mvo.getId();
		
		OrderDAO odao = OrderDAO.getInstance();
		
		List<OrderDetailVO> list= odao.getOrderList(mid);
		
		request.setAttribute("order_list", list);
		
		// QnA 리스트 가져오기
		QnADAO qdao = QnADAO.getInstance();
		List<QnAVO> QnA_list = qdao.getMyQnA(mid);
		request.setAttribute("QnA_list", QnA_list);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
	}

}
