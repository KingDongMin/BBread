package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.MainPageAction;
import com.bbread.dao.ProductDAO;

public class ProductDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String pseq  = request.getParameter("pseq");
		ProductDAO pdao = ProductDAO.getInstance();
		pdao.deleteProduct(pseq);
		
		new MainPageAction().execute(request, response, context);
	}

}
