package com.bbread.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bbread.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public void addNewProduct(ProductVO pvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		// 쿼리 수정 요망
		String sql = "insert into product values(product_seq.nextval,?,?,?,?,?,'n','n',sysdate)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pvo.getName());
			pstmt.setString(2, pvo.getKind());
			pstmt.setString(3, Integer.toString(pvo.getPrice()));
			pstmt.setString(4, pvo.getContent());
			pstmt.setString(5, pvo.getImage());
			
			pstmt.executeQuery();
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
	
}
