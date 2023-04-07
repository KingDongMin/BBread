package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.OrdersPageAction;
import com.bbread.dao.OrderDAO;

public class OrderCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		OrderDAO odao = OrderDAO.getInstance();
		odao.checkOrder(oseq);
		
		new OrdersPageAction().execute(request, response, context);

	}

}
