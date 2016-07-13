<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 头部开始 -->
<%@include file="include/top-begin.jsp"%>
<!-- 自定义样式开始 -->
<link href="static/css/signin.css" rel="stylesheet">
<!-- 自定义样式结束 -->
<!-- 头部结束 -->
<%@include file="include/top-end.jsp"%>
<!-- 内容开始 -->
<div class="signin">
	<div class="signin-head"><img src="static/images/test/head_120.png" alt="" class="img-circle"></div>
	<form class="form-signin" role="form" method="post" action="user/doLogin">
		<input type="text" class="form-control" id="username" value="${username }" placeholder="用户名" required autofocus />
		<input type="password" class="form-control" id="password" value="${password }" placeholder="密码" required />
		<button class="btn btn-lg btn-warning btn-block" type="button" id="loginBtn">登录</button>
		<label class="checkbox">
			<input type="checkbox" id="rememberMe"> 记住我
		</label>
	</form>
</div>
<!-- 内容结束 -->
<!-- 尾部 -->
<%@include file="include/buttom-begin.jsp"%>
<!-- 自定义js开始 -->
<script type="text/javascript" src="static/js/login.js"></script>
<!-- 自定义js结束 -->
<%@include file="include/buttom-end.jsp"%>