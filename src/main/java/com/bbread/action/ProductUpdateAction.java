package com.bbread.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbread.action.page.MainPageAction;
import com.bbread.dao.ProductDAO;
import com.bbread.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext context)
			throws IOException, ServletException {
		
		String savePath = "upload";
		String uploadFilePath = context.getRealPath(savePath);
		int uploadFileSizeLimite = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath,
				uploadFileSizeLimite,
				encType,
				new DefaultFileRenamePolicy()
				);
		int pseq =Integer.parseInt(multi.getParameter("pseq"));
		String name = multi.getParameter("name");
		String kind = multi.getParameter("kind");
		int price = Integer.parseInt(multi.getParameter("price"));
		String content = multi.getParameter("content");
		String imageURL = multi.getFilesystemName("imageURL");
		String originImageURL = multi.getParameter("origin_imageURL");
		
		ProductVO pvo = new ProductVO();
		pvo.setPseq(pseq);
		pvo.setName(name);
		pvo.setKind(kind);
		pvo.setPrice(price);
		pvo.setContent(content);
		if(imageURL == null) {
			pvo.setImage(originImageURL);
		}else {
			pvo.setImage(imageURL);
		}
		
		ProductDAO pdao = ProductDAO.getInstance();
		pdao.updateProduct(pvo);
		
		new MainPageAction().execute(request, response, context);

	}

}
