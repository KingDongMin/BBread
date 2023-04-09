package com.bbread.controller;

import com.bbread.action.Action;
import com.bbread.action.AddProductAction;
import com.bbread.action.CartAction;
import com.bbread.action.CartOrderAction;
import com.bbread.action.JoinAction;
import com.bbread.action.LoginAction;
import com.bbread.action.LogoutAction;
import com.bbread.action.MyUpdateAction;
import com.bbread.action.OrderCheckAction;
import com.bbread.action.OrderDetailCheckAction;
import com.bbread.action.ProductDeleteAction;
import com.bbread.action.ProductListAction;
import com.bbread.action.ProductUpdateAction;
import com.bbread.action.QnAeditAction;
import com.bbread.action.page.AddProductPageAction;
import com.bbread.action.page.CartPageAction;
import com.bbread.action.page.JoinPageAction;
import com.bbread.action.page.LoginPageAction;
import com.bbread.action.page.MainPageAction;
import com.bbread.action.page.MemberUpdatePageAction;
import com.bbread.action.page.MyPageAction;
import com.bbread.action.page.OrderDetailPageAction;
import com.bbread.action.page.OrdersPageAction;
import com.bbread.action.page.ProductDetailPageAction;
import com.bbread.action.page.ProductUpdatePageAction;
import com.bbread.action.page.QnADetailPageAction;
import com.bbread.action.page.QnAeditPageAction;
import com.bbread.action.page.QnApageAction;

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
		}else if("product_delete".equals(command)) {
			action = new ProductDeleteAction();
		}else if("product_update_page".equals(command)) {
			action = new ProductUpdatePageAction();
		}else if("update_product".equals(command)) {
			action = new ProductUpdateAction();
		}else if("product_list".equals(command)) {
			action = new ProductListAction();
		}else if("add_cart".equals(command)) {
			action = new CartAction();
		}else if("cart_page".equals(command)) {
			action = new CartPageAction();
		}else if("cart_order".equals(command)) {
			action = new CartOrderAction();
		}else if("member_update_page".equals(command)) {
			action = new MemberUpdatePageAction();
		}else if("orders_page".equals(command)) {
			action = new OrdersPageAction();
		}else if("order_detail_page".equals(command)) {
			action = new OrderDetailPageAction();
		}else if("order_detail_check".equals(command)) {
			action = new OrderDetailCheckAction();
		}else if("order_check".equals(command)) {
			action = new OrderCheckAction();
		}else if("QnA_page".equals(command)) {
			action = new QnApageAction();
		}else if("QnAedit_page".equals(command)) {
			action = new QnAeditPageAction();
		}else if("edit_QnA".equals(command)) {
			action = new QnAeditAction();
		}else if("QnA_detail_page".equals(command)) {
			action = new QnADetailPageAction();
		}

		return action;
	}
}
