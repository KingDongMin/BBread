package com.bbread.action.QnA;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.Action;
import com.bbread.action.page.MainPageAction;
import com.bbread.action.page.QnADetailPageAction;
import com.bbread.dao.AdminDAO;
import com.bbread.dao.QnADAO;
import com.bbread.dto.AdminVO;

public class QnA_Answer_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		// 관리자 접근 제한
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
		
		// request params
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		String answer = request.getParameter("answer");
		QnADAO qdao = QnADAO.getInstance();
		boolean result = qdao.addAnswer(qseq, answer);
		String msg;
		if(result) {
			msg = "문의에 답변하셨습니다.";
		}else {
			msg = "문의에 답변하지 못하였습니다.";
		}
		request.setAttribute("message", msg);
		request.setAttribute("qseq", qseq);
		
		new QnADetailPageAction().execute(request, response, context);

	}

}
