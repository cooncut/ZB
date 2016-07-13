(function(exports, $) {

	var base = new Object();

	base.cfg = {
		'globeErrMsg' : '你的网络好像出现了问题，如果确认网络没问题，请将该问题反馈给我们，谢谢。'
	};

	// 全局ajax异常
	$.ajaxSetup({
		error : function(jqXHR, textStatus, errorThrown) {
			switch (jqXHR.status) {
			case (500)://服务器系统内部错误
				break;
			case (401)://未登录
				break;
			case (403)://无权限执行此操作
				break;
			case (408)://请求超时
				layer.alert(base.cfg.globeErrMsg, {
					icon : 2
				});
				break;
			default://未知错误
				layer.alert(base.cfg.globeErrMsg, {
					icon : 2
				});
			}
		}
	});

	// 导出base
	exports.base = base;

})(this, jQuery);