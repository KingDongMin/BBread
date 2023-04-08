package com.bbread.action.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.Action;
import com.bbread.dto.AdminVO;
import com.bbread.dto.MemberVO;

public class QnAeditPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		MemberVO  mvo = (MemberVO)session.getAttribute("Mvo");
		AdminVO avo = (AdminVO)session.getAttribute("Avo");
		
		// 사용자 접근 제한
		if(mvo == null && avo == null) {
			request.setAttribute("message", "로그인 후 이용해주세요.");
			new LoginPageAction().execute(request, response, context);
		}
		
		
		String pageURL = "pages/QnA/edit.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);

	}

}
