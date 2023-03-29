package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.LoginPageAction;
import com.bbread.dao.MemberDAO;
import com.bbread.dto.MemberVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		MemberVO Mvo = new MemberVO();
		Mvo.setId(request.getParameter("id"));
		Mvo.setPw(request.getParameter("pw"));
		Mvo.setName(request.getParameter("name"));
		Mvo.setEmail(request.getParameter("email"));
		Mvo.setAddress(request.getParameter("address"));
		Mvo.setPhone(request.getParameter("phone"));
		
		MemberDAO Mdao = MemberDAO.getInstance();
		Mdao.insertMember(Mvo);
		
		
		request.setAttribute("message","회원가입이 완료되었습니다. 로그인해주세요.");
		new LoginPageAction().execute(request, response);
	}

}
