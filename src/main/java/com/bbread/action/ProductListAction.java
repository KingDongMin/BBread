package com.bbread.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.MainPageAction;
import com.bbread.dao.ProductDAO;
import com.bbread.dto.ProductVO;

public class ProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		String kind = request.getParameter("kind");
		String pageURL = "index.jsp";
		
		ProductDAO pdao = ProductDAO.getInstance();
		List<ProductVO> plist = pdao.getList(kind);
		
		request.setAttribute("ProductList", plist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
		
		
		
	}

}
