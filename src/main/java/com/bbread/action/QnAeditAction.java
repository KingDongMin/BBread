package com.bbread.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.QnAeditPageAction;
import com.bbread.action.page.QnApageAction;
import com.bbread.dao.QnADAO;
import com.bbread.dto.QnAVO;

public class QnAeditAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		// test
		String mid = request.getParameter("mid");
		String title = request.getParameter("title");
		String inquiry = request.getParameter("inquiry");
		
		QnAVO qvo = new QnAVO();
		qvo.setMid(mid);
		qvo.setTitle(title);
		qvo.setInquiry(inquiry);
		
		QnADAO qdao = QnADAO.getInstance();
		boolean result =  (qdao.addQnA(qvo) != 0) ;
		
		
		if(result) {
			request.setAttribute("message", "문의글이 등록되었습니다.");
			
			new QnApageAction().execute(request, response, context);
		}else {
			request.setAttribute("message", "문의글 등록이 실패하였습니다.");
			
			new QnAeditPageAction().execute(request, response, context);
		}
		
		
	}

}
