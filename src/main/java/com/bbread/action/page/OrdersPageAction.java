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
import com.bbread.dto.OrdersVO;

public class OrdersPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		String pageURL = "pages/admin/orders.jsp";
		
		OrderDAO odao = OrderDAO.getInstance();
		List<OrdersVO> list = odao.getOrders();
		request.setAttribute("orders", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
		
	}

}
