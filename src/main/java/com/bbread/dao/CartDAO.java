package com.bbread.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bbread.dto.CartVO;
import com.bbread.dto.ProductVO;

import util.DBManager;

public class CartDAO {
	
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
		return instance;
	}
	
	public boolean checkCart(String mid, int pseq) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean checked = false;
		String sql = "select * from cart where mid='"+mid+"' and pseq="+pseq;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				checked = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt);
		}
		return checked;
		
		
	}
	
	
	
	public void addCart(CartVO cvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into cart values(cart_seq.nextval,"
				+ "?,?,?,'n',sysdate )";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getMid());
			pstmt.setInt(2, cvo.getPseq());
			pstmt.setInt(3, cvo.getQuantity());
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public List<CartVO> getCarts(String mid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<CartVO> carts = new ArrayList<CartVO>();
		CartVO cvo = null;
		
		String sql = "select * from cart where mid='"+mid+"'";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				do {
					cvo = new CartVO();
					ProductDAO pdao = ProductDAO.getInstance();
					ProductVO pvo = pdao.getProduct(rs.getInt("pseq"));
					
					cvo.setCseq(rs.getInt("cseq"));
					cvo.setMid(rs.getString("mid"));
					cvo.setPseq(rs.getInt("pseq"));
					cvo.setQuantity(rs.getInt("quantity"));
					cvo.setResult(rs.getString("result").charAt(0));
					cvo.setIndate(rs.getTimestamp("indate"));
					cvo.setP_url(pvo.getImage());
					cvo.setP_name(pvo.getName());
					cvo.setP_price(pvo.getPrice());
					
					carts.add(cvo);

				} while (rs.next());
				
			}else {
				carts = null;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return carts;
	}
	
	public void updateCart(String mid, int pseq, int quantity) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "update cart set quantity=quantity+"+quantity+"where mid='"+mid+"' and pseq="+pseq;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt);
		}
	}

	//해당 유저의 카트제품 삭제
	public void deleteCart(int cseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete cart where cseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//CartDAO end
}
