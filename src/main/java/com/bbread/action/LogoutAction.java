package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.page.MainPageAction;
import com.bbread.dao.MemberDAO;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("message", "로그아웃");
		
		response.sendRedirect("http://localhost:8181/BBread/BBreadServlet");
		

	}

}
