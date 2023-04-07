package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.OrderDetailPageAction;
import com.bbread.dao.OrderDAO;

public class OrderDetailCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		int odseq = Integer.parseInt(request.getParameter("odseq"));
		
		OrderDAO odao = OrderDAO.getInstance();
		odao.checkOrderDetail(odseq);
		
		new OrderDetailPageAction().execute(request, response, context);
		
	}

}
