package com.bbread.action.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.Action;
import com.bbread.dao.OrderDAO;
import com.bbread.dto.OrderDetailVO;

public class OrderDetailPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String mid = request.getParameter("mid");
		String indate = request.getParameter("indate");
		
		request.setAttribute("mid", mid);
		request.setAttribute("indate", indate);
		String pageURL = "pages/admin/orderDetail.jsp";
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		
		OrderDAO odao = OrderDAO.getInstance();
		List<OrderDetailVO> list = odao.getOrderDetail(oseq);
		request.setAttribute("OD_list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
	}

}
