package com.bbread.action.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.Action;

public class AddProductPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String pageURL = "pages/addProduct.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
		
	}

}
