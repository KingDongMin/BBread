package com.bbread.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	// 인터페이스에서 추상메소드를 만드는 방법은 어떻게 했더라?
	// -> 그냥 기존 클래스의 함수를 만들듯이 하면된다.
	public  void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
