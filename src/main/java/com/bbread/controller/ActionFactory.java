package com.bbread.controller;

import com.bbread.action.Action;
import com.bbread.action.JoinAction;
import com.bbread.action.LoginAction;
import com.bbread.action.MyUpdateAction;
import com.bbread.action.page.JoinPageAction;
import com.bbread.action.page.LoginPageAction;
import com.bbread.action.page.MainPageAction;
import com.bbread.action.page.MyPageAction;

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
		}

		return action;
	}
}
