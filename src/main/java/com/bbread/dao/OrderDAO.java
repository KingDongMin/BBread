package com.bbread.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bbread.dto.CartVO;
import com.bbread.dto.OrdersVO;

import util.DBManager;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	
	// 주문 생성
	public int createOrders(String mid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int oseq = 0;
		
		String sql = "insert into orders values(orders_seq.nextval,?,sysdate)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql, new String[]{"oseq"});
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				oseq = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return oseq;
	}
	
	
	// 장바구니 제품들 oder_detail테이블에 추가
	public void addOrderDetail(int oseq, CartVO cvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into order_detail values(orderDetail_seq.nextval, ?, ?, ?, 'n')";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, oseq);
			pstmt.setInt(2, cvo.getPseq());
			pstmt.setInt(3, cvo.getQuantity());
			
			pstmt.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
