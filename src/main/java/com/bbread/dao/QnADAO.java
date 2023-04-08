package com.bbread.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbread.dto.QnAVO;

import util.DBManager;

public class QnADAO {
	private static QnADAO instance = new QnADAO();
	
	public static QnADAO getInstance() {
		return instance;
	}
	
	// 게시글 등록
	public int addQnA(QnAVO qvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = "insert into qna values( QnA_seq.nextval, ?, ?, null, ?, 'n', sysdate)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qvo.getTitle());
			pstmt.setString(2, qvo.getInquiry());
			pstmt.setString(3, qvo.getMid());
			
			rs = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return rs;
	}
	
	// 게시글 가져오기
	public List<QnAVO> getQnAList(){
		List<QnAVO> list = new ArrayList<QnAVO>();
		QnAVO qvo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from qna";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				do {
					qvo = new QnAVO();
					qvo.setQseq(rs.getInt("qseq"));
					qvo.setTitle(rs.getString("title"));
					qvo.setInquiry(rs.getString("inquiry"));
					qvo.setAnswer(rs.getString("answer"));
					qvo.setMid(rs.getString("mid"));
					qvo.setResult(rs.getString("result").charAt(0));
					qvo.setIndate(rs.getTimestamp("indate"));
					
					list.add(qvo);
					
				} while (rs.next());
				
			}
			else {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
}