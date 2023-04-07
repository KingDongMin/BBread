package com.bbread.dto;

import java.sql.Timestamp;

public class OrdersVO {
	private int oseq;
	private String mid;
	private Timestamp indate;
	private char result;
	
	
	public char getResult() {
		return result;
	}
	public void setResult(char result) {
		this.result = result;
	}
	public int getOseq() {
		return oseq;
	}
	public void setOseq(int oseq) {
		this.oseq = oseq;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
}
