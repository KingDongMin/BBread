package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.QnADetailPageAction;
import com.bbread.dao.QnADAO;
import com.bbread.dto.QnAVO;

public class QnAUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		String title = request.getParameter("title");
		String inquiry = request.getParameter("inquiry");
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		
		QnAVO qvo = new QnAVO();
		qvo.setQseq(qseq);
		qvo.setTitle(title);
		qvo.setInquiry(inquiry);
		
		QnADAO qdao = QnADAO.getInstance();
		qdao.updateQnA(qvo);
		
		request.setAttribute("qseq", qseq);
		new QnADetailPageAction().execute(request, response, context);

	}

}
