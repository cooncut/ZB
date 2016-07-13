(function(exports, $) {

	// 登陆类
	var Login = function(username, password, rememberMe) {
		this.username = username;
		this.password = password;
		this.rememberMe = rememberMe;
	};

	// 检查参数方法
	Login.prototype.checkParams = function() {
		debugger;
		if (!this.username) {// 用户名不能为空
			layer.alert('请输入用户名', {
				icon : 7
			});
			return false;
		}
		if (!this.password) {// 密码不能为空
			layer.alert('请输入密码', {
				icon : 7
			});
			return false;
		}
		return true;
	};

	// 提交登陆方法
	Login.prototype.submit = function() {
		if (this.checkParams()) {
			var params = {
				'username' : this.username,
				'password' : this.password,
				'rememberMe' : this.rememberMe
			};

			// ajax请求登陆操作
			var loading = layer.load();
			$.post('user/login', params, function(json) {
				layer.close(loading);
				if (!json)
					return;
				if (json.success) {
					location.href = 'home'; // 跳到首页
				} else {
					layer.alert(json.errMsg, {
						icon : 2
					});
				}
			}, 'json');
		}
	};

	// 导出Login类
	exports.Login = Login;

})(this, jQuery);

// 页面加载完成时候调用
$(function() {
	// 绑定登陆按钮
	var loginBtn = $("#loginBtn");
	loginBtn.click(function(){
		var username = $v("username").trim();
		var password = $v("password").trim();
		var rememberMe = $("#rememberMe").prop('checked');
		new Login(username, password, rememberMe).submit();
	});
	// 绑定enter事件
	$(document).keydown(function(event) {
		if (event.keyCode == 13) {
			loginBtn.trigger('click');
		}
	});
});