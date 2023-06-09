package com.bbread.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.Action;

/**
 * Servlet implementation class BBreadServlet
 */
@WebServlet("/BBreadServlet")
public class BBreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public BBreadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String command = request.getParameter("command");
		System.out.print(command+" --> ");
		
		ServletContext context = getServletContext();
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		if(action != null) {
			action.execute(request, response, context);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		doGet(request, response);
	}

}
