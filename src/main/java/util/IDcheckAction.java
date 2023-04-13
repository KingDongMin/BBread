package util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.Action;
import com.bbread.dao.MemberDAO;

public class IDcheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		String id = request.getParameter("id");
		
		MemberDAO mdao = MemberDAO.getInstance();
		int result = mdao.checkID(id);
		
		request.setAttribute("userID", id);
		request.setAttribute("ID_check_result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/members/idCheck.jsp");
		dispatcher.forward(request, response);
	}

}
