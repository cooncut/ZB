package zb.controllers;

import zb.AppConst;
import zb.models.User;

import com.jfinal.core.Controller;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;

public class BaseC extends Controller {
	// 资源信息
	protected Res res = I18n.use();

	// 得到当前登陆的用户
	public User getLoginUser() {
		return getSessionAttr(AppConst.LOGIN_USER_KEY);
	}
}
