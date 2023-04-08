package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QnAeditAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		// test
		String mid = request.getParameter("mid");
		String title = request.getParameter("title");
		String inquiry = request.getParameter("inquiry");
		
	}

}
