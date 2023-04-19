package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbread.action.page.MainPageAction;
import com.bbread.dao.AdminDAO;
import com.bbread.dao.ProductDAO;
import com.bbread.dto.AdminVO;
import com.bbread.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddProductAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {

		// 관리자 전용
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
		
		// 파일 업로드 세팅
		String savePath = "upload";
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		String uploadFilePath = context.getRealPath(savePath);
		

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
				new DefaultFileRenamePolicy());
		

		String name = multi.getParameter("name");
		String kind = multi.getParameter("kind");
		int price = Integer.parseInt(multi.getParameter("price"));
		String content = multi.getParameter("content");
		String imageURL = multi.getFilesystemName("imageURL");

		ProductVO pvo = new ProductVO();
		pvo.setName(name);
		pvo.setKind(kind);
		pvo.setPrice(price);
		pvo.setContent(content);
		pvo.setImage(imageURL);

		// 파일 업로드

		ProductDAO pdao = ProductDAO.getInstance();
		pdao.addNewProduct(pvo);
		
		new MainPageAction().execute(request, response, context);

	}

}
