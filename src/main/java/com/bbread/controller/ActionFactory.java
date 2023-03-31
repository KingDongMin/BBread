package com.bbread.controller;

import com.bbread.action.Action;
import com.bbread.action.AddProductAction;
import com.bbread.action.JoinAction;
import com.bbread.action.LoginAction;
import com.bbread.action.LogoutAction;
import com.bbread.action.MyUpdateAction;
import com.bbread.action.page.AddProductPageAction;
import com.bbread.action.page.JoinPageAction;
import com.bbread.action.page.LoginPageAction;
import com.bbread.action.page.MainPageAction;
import com.bbread.action.page.MyPageAction;
import com.bbread.action.page.ProductDetailPageAction;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command == null) {
			action = new MainPageAction();
		} else if ("login_page".equals(command)) {
			action = new LoginPageAction();
		} else if ("login".equals(command)) {
			action = new LoginAction();
		} else if ("join_page".equals(command)) {
			action = new JoinPageAction();
		} else if ("join".equals(command)) {
			action = new JoinAction();
		} else if("My_page".equals(command)) {
			action = new MyPageAction();
		}else if("update_member".equals(command)) {
			action = new MyUpdateAction();
		}else if("logout".equals(command)) {
			action = new LogoutAction();
		}else if("AddProduct_page".equals(command)) {
			action = new AddProductPageAction();
		}else if("add_product".equals(command)) {
			action = new AddProductAction();
		}else if("product_detail".equals(command)) {
			action = new ProductDetailPageAction();
		}

		return action;
	}
}
