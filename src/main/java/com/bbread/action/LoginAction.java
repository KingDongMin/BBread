package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.page.LoginPageAction;
import com.bbread.action.page.MainPageAction;
import com.bbread.dao.MemberDAO;
import com.bbread.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO loginVo = dao.selectMember(id,pw);
		
		if(loginVo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("Mvo",loginVo);
			new MainPageAction().execute(request, response);

		}else{
			request.setAttribute("message", "로그인 실패");
			new LoginPageAction().execute(request, response);
		}
		
		
	}

}
