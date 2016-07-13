package zb.interceptors;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import zb.AppConst;
import zb.models.User;



import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

/**
 * 登陆拦截器
 * 
 * @author wenjizou
 * 
 */
public class LoginInterceptor implements Interceptor {

	// 存放不需要拦截的actionkey
	private String[] excludes;

	public LoginInterceptor() {
		String urls = PropKit.get("login.noNeedCheckUrls");
		if (StringUtils.isNotBlank(urls)) {
			excludes = urls.split(",");
		} else {
			excludes = new String[1];
		}
	}

	@Override
	public void intercept(Invocation inv) {

		Controller c = inv.getController();
		String actionKey = inv.getActionKey();

		// 如果不需要拦截，则直接可以访问
		if (ArrayUtils.indexOf(excludes, actionKey) > -1) {
			inv.invoke();
			return;
		}

		// 如果需要拦截，并且发现没登陆，就到登陆页
		HttpSession session = c.getSession(false);
		if (session == null || (User) session.getAttribute(AppConst.LOGIN_USER_KEY) == null) {
			c.redirect("/");
			return;
		}

		// 说明已经登陆了
		inv.invoke();
	}
}