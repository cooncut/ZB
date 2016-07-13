package zb.controllers;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import zb.AppConst;
import zb.models.User;



/**
 * 视图控制器
 * 
 * @author wenjizou
 * 
 */
public class ViewC extends BaseC {

	// 访问/的时候调用
	public void index() {
		login();
	}

	// 登陆页面login.jsp
	public void login() {
		// 设置页面标题
		setAttr(AppConst.PAGE_TITLE_KEY, res.get("ViewC_login_001"));

		User user = getSessionAttr(AppConst.LOGIN_USER_KEY);
		String cookieJmVal = getCookie(DigestUtils.md5Hex(AppConst.COOKIE_USER_KEY));
		if (user != null) {// 先从session中看是否能得到值
			setAttr("username", user.getEmail());
		} else if (StringUtils.isNotBlank(cookieJmVal)) {// 如果cookie中有值
			byte[] data = Base64.decodeBase64(cookieJmVal.getBytes(Charset.forName("utf-8")));
			try {
				String cookieVal = new String(data, "utf-8");
				String[] arr = cookieVal.split("@@");
				setAttr("username", arr[0]);
				// setAttr("password", arr[1]);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		renderJsp("login.jsp");
	}

	// 用户主页home.jsp
	public void home() {
		// 设置页面标题
		setAttr(AppConst.PAGE_TITLE_KEY, res.get("ViewC_home_001"));
		renderJsp("home.jsp");
	}

}
