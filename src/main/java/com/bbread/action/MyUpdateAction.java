package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.page.MainPageAction;
import com.bbread.dao.MemberDAO;
import com.bbread.dto.MemberVO;

public class MyUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ServletException {
		HttpSession session = request.getSession();
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO beforeVO = new MemberVO();
		MemberVO afterVO = null;
		
		beforeVO.setId(request.getParameter("id"));
		beforeVO.setPw(request.getParameter("pw"));
		beforeVO.setName(request.getParameter("name"));
		beforeVO.setEmail(request.getParameter("email"));
		beforeVO.setAddress(request.getParameter("address"));
		beforeVO.setPhone(request.getParameter("phone"));
		
		boolean updateStatus = dao.updateMember(beforeVO);
		
		System.out.println("action에서 결과 : "+updateStatus);
		if(updateStatus == true) {
			afterVO = dao.selectMember(request.getParameter("id"), request.getParameter("pw"));
			session.removeAttribute("Mvo");
			session.setAttribute("Mvo", afterVO);
			request.setAttribute("message", "회원정보 수정완료");
		}else {
			request.setAttribute("message", "회원정보 수정실패");
		}
		
		
		new MainPageAction().execute(request, response, context);

	}

}
