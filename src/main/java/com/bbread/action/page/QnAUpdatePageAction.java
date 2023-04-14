package com.bbread.action.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.Action;
import com.bbread.dao.QnADAO;
import com.bbread.dto.QnAVO;

public class QnAUpdatePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		String pageURL = "pages/QnA/QnA_update.jsp";
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		
		QnADAO qdao = QnADAO.getInstance();
		QnAVO qvo = qdao.getQnA(qseq);
		
		request.setAttribute("QnA", qvo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);

	}

}
