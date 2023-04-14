package com.bbread.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.QnApageAction;
import com.bbread.dao.QnADAO;

public class QnADeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		System.out.print(request.getParameter("qseq"));
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		
		QnADAO qdao = QnADAO.getInstance();
		qdao.deleteQnA(qseq);
		
		new QnApageAction().execute(request, response, context);

	}

}
