package com.bbread.action.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.Action;
import com.bbread.dao.ProductDAO;
import com.bbread.dto.ProductVO;

public class ProductDetailPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		int pseq =Integer.parseInt(request.getParameter("pseq")) ;
		String pageURL = "pages/products/detail.jsp";
		
		ProductDAO pdao = ProductDAO.getInstance();
		ProductVO pvo = pdao.getProduct(pseq);
		request.setAttribute("product", pvo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);

	}

}
