package com.bbread.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbread.dto.CartVO;
import com.bbread.dto.OrderDetailVO;
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
		
		String sql = "insert into orders values(orders_seq.nextval,?,sysdate,'n')";
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
	
	
	// 주문제품 가져오기
	public List<OrderDetailVO> getOrderList(String mid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderDetailVO> list =  new ArrayList<OrderDetailVO>();
		OrderDetailVO odvo = null;
		
		String sql = "select P.name, P.price, P.image, O.* from product P , (select * from order_detail where oseq in (select oseq from orders where mid=?)) O where P.pseq = O.pseq";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					odvo = new OrderDetailVO();
					odvo.setOdseq(rs.getInt("odseq"));
					odvo.setOseq(rs.getInt("oseq"));
					odvo.setPseq(rs.getInt("pseq"));
					odvo.setQuantity(rs.getInt("quantity"));
					odvo.setResult(rs.getString("result").charAt(0));
					odvo.setP_name(rs.getString("name"));
					odvo.setP_price(rs.getInt("price"));
					odvo.setP_url(rs.getString("image"));
					
					list.add(odvo);
					
				} while (rs.next());
				
				
			}else {
				list = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 주문테이블 조회
	public List<OrdersVO> getOrders(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		OrdersVO ovo = null;
		List<OrdersVO> list = new ArrayList<OrdersVO>();
		
		String sql = "select * from orders";
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				do {
					ovo = new OrdersVO();
					ovo.setOseq(rs.getInt("oseq"));
					ovo.setMid(rs.getString("mid"));
					ovo.setIndate(rs.getTimestamp("indate"));
					ovo.setResult(rs.getString("result").charAt(0));
					
					list.add(ovo);
					
				} while (rs.next());
			}else {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	// 주문상세테이블 조회
	public List<OrderDetailVO> getOrderDetail(int oseq){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderDetailVO odvo = null;
		List<OrderDetailVO> list = new ArrayList<OrderDetailVO>();
		
		String sql = "select OD.* , P.name, P.useyn from (select * from order_detail where oseq=?) OD, product P where P.pseq = OD.pseq";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, oseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					odvo = new OrderDetailVO();
					odvo.setOdseq(rs.getInt("odseq"));
					odvo.setOseq(rs.getInt("oseq"));
					odvo.setQuantity(rs.getInt("quantity"));
					odvo.setResult(rs.getString("result").charAt(0));
					odvo.setPseq(rs.getInt("pseq"));
					odvo.setP_name(rs.getString("name"));
					odvo.setP_useyn(rs.getString("useyn").charAt(0));
					
					list.add(odvo);
				} while (rs.next());
			}else {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void checkOrderDetail(int odseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update order_detail set result ='y' where odseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, odseq);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 주문 상테 변경
	public void checkOrder(int oseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update orders set result ='y' where oseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
// Orders end
}
