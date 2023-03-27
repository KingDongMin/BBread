package com.bbread.dao;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	
}
