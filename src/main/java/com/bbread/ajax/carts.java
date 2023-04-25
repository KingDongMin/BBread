package com.bbread.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bbread.dao.CartDAO;
import com.bbread.dto.CartVO;

/**
 * Servlet implementation class carts
 */
@WebServlet("/carts")
public class carts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public carts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();

		CartDAO dao = CartDAO.getInstance();
		List<CartVO> carts = dao.getCarts(id);
		if(carts == null) {
		
			return;
		}

		JSONObject total = new JSONObject();
		JSONArray items = new JSONArray();
		JSONObject itemInfo = null;
		for (CartVO cvo : carts) {
			itemInfo = new JSONObject();
			itemInfo.put("cseq", cvo.getCseq());
			itemInfo.put("mid", cvo.getMid());
			itemInfo.put("pseq", cvo.getPseq());
			itemInfo.put("quantity", cvo.getQuantity());
			itemInfo.put("result", String.valueOf(cvo.getResult()));
			itemInfo.put("indate", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(cvo.getIndate()));
			itemInfo.put("p_url", cvo.getP_url());
			itemInfo.put("p_name", cvo.getP_name());
			itemInfo.put("p_price", cvo.getP_price());

			items.add(itemInfo);
		}

		total.put("carts", items);

		String json = total.toJSONString(); 

		out.print(json);

	}

}
