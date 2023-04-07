package com.bbread.dto;

import java.sql.Timestamp;

public class OrderDetailVO {
	
	private int odseq;
	private int oseq;
	private int pseq;
	private int quantity;
	private char result;
	

	//제품데이터 (이미지, 이름, 가격)
	private String p_url;
	private String p_name;
	private int p_price;
	private char p_useyn;
	
	
	
	public char getP_useyn() {
		return p_useyn;
	}
	public void setP_useyn(char p_useyn) {
		this.p_useyn = p_useyn;
	}
	public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	
	
	public int getOdseq() {
		return odseq;
	}
	public void setOdseq(int odseq) {
		this.odseq = odseq;
	}
	public int getOseq() {
		return oseq;
	}
	public void setOseq(int oseq) {
		this.oseq = oseq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public char getResult() {
		return result;
	}
	public void setResult(char result) {
		this.result = result;
	}
	
	
	
}
