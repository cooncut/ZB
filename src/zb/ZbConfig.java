package zb;

import zb.controllers.UserC;
import zb.controllers.ViewC;
import zb.interceptors.LoginInterceptor;
import zb.models._MappingKit;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.i18n.I18nInterceptor;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;

/**
 * 项目配置
 * 
 * @author wenjizou
 * 
 */
public class ZbConfig extends JFinalConfig {
	// 配置常量
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("app.cfg");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setBaseViewPath("/WEB-INF/views/");
		me.setViewType(ViewType.JSP);
		me.setI18nDefaultBaseName("i18n");
	}

	// 配置路由
	public void configRoute(Routes me) {
		me.add("/", ViewC.class);
		me.add("/user", UserC.class);
	}

	private static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.username"), PropKit.get("jdbc.password"));
	}

	// 配置插件
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		me.add(arp);
		// 所有配置在 MappingKit 中搞定
		_MappingKit.mapping(arp);
	}

	// 配置拦截器
	public void configInterceptor(Interceptors me) {
		// 全局拦截器
		me.addGlobalActionInterceptor(new LoginInterceptor());
		me.addGlobalActionInterceptor(new I18nInterceptor());
	}

	// 配置处理器
	public void configHandler(Handlers me) {
	}

	public static void main(String[] args) {

	}
}
