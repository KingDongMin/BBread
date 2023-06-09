package com.bbread.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbread.dto.CartVO;
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
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public List<ProductVO> getAllProducts() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ProductVO pvo = null;
		List<ProductVO> pvoList = new ArrayList<ProductVO>();

		String sql = "select * from product";

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				pvo = new ProductVO();

				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setKind(rs.getString("kind"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));

				pvoList.add(pvo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return pvoList;
	}
	
	//제품 선택
	public ProductVO getProduct(int pseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductVO pvo = null;
		String sql = "select * from product where pseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setKind(rs.getString("kind"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));
			}
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pvo;
	}
	
	public void deleteProduct(String pseq) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "delete from product where pseq="+pseq;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt);
		}
	}
	
	
	public void updateProduct(ProductVO pvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update product set name=?, kind=?, price=?, content=?, image=? where pseq=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pvo.getName());
			pstmt.setString(2, pvo.getKind());
			pstmt.setString(3, Integer.toString(pvo.getPrice()));
			pstmt.setString(4, pvo.getContent());
			pstmt.setString(5, pvo.getImage());
			pstmt.setString(6, Integer.toString(pvo.getPseq()));

			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<ProductVO> getList(String kind){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ProductVO pvo = null;
		List<ProductVO> plist = new ArrayList<ProductVO>();
		
		String sql = "select * from product where kind='"+kind+"'";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				pvo = new ProductVO();
				
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setKind(rs.getString("kind"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));
				
				plist.add(pvo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return plist;
	}
	
	
	
	

// ProductDAO end	
}
