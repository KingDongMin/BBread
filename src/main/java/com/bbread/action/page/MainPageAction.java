package com.bbread.action.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.Action;
import com.bbread.dao.ProductDAO;
import com.bbread.dto.ProductVO;

public class MainPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ServletException {
		String pageURL = "index.jsp";
		
		// 모든 제품을 가져오는 비즈니스 로직 구현
		ProductDAO pdao = ProductDAO.getInstance();
		List<ProductVO> pvoList = pdao.getAllProducts();
		request.setAttribute("allProducts", pvoList);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
	}

}
