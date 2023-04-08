package com.bbread.action.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.Action;
import com.bbread.dao.QnADAO;
import com.bbread.dto.QnAVO;

public class QnApageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		String pageURL = "pages/QnA/QnA.jsp";
		
		QnADAO qdao = QnADAO.getInstance();
		List<QnAVO> list = qdao.getQnAList();
		
		if(list != null) {
			request.setAttribute("QnA_list", list);
		}else {
			request.setAttribute("QnA_list", "등록된 문의가 없습니다.");
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageURL);
		dispatcher.forward(request, response);
	}

}
