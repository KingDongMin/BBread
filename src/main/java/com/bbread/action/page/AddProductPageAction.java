package com.bbread.action.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.Action;
import com.bbread.dao.AdminDAO;
import com.bbread.dto.AdminVO;

public class AddProductPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("Avo");
		if(avo == null) {
			new MainPageAction().execute(request, response, context);
			return;
		}
		AdminDAO adao = AdminDAO.getInstance();
		boolean checkedAdmin = adao.checkAdmin(avo);
		if(!checkedAdmin) {
			new MainPageAction().execute(request, response, context);
			return;
		}
		
		String pageURL = "pages/products/addProduct.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
		
	}

}
