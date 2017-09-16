<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="${BaseContext}">
<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="keywords"
	content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description"
	content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
<meta name="author" content="尚忠祥">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/base.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/forget_password.css" />
<link rel="icon" href="favicon.png"
	type="${pageContext.request.contextPath }/image/png" />
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
<!-- <script type="text/javascript">
	function sendmail(){
		var email = $('#email').val();
		
	}
</script> -->

</head>

<body>
	<header>
		<div class="container">
			<img src="${pageContext.request.contextPath }/img/logo.png" alt="智游">
		</div>
	</header>
	<main>
	<div class="container">
		<form class="ma" action="" id="mailform" method="post">
			<div class="form_header">
				<div class="form_title">
					<h2>忘记密码</h2>
					<span>通过注册邮箱重设密码</span>
				</div>
				<div class="form_back">
					<a href="${pageContext.request.contextPath }/visitor1/index.action">返回立即登录</a>
				</div>
			</div>
				<input type="hidden" name="verificationCode" value="${verificationCode}">
			<div class="form_body">
				<input type="email" placeholder="请输入登录邮箱" name="email" id="email">
				<input type="text" placeholder="请输入验证码" id="captcha" name="captcha"><input
					type="button" value="发邮件获取验证码" > <input
					type="submit" value="提交">
			</div>
			<div class="form_footer">
				<div class="FAQ">
					<span>收不到邮件？查看</span><a href="#">常见问题</a>
				</div>
			</div>
		</form>
	</div>

	</main>
	<%@include file="../include/script.html"%>
	<script type="text/javascript">
	$(function(){
		$(":button").click(function(){
			var email = $('#email').val();
			//改为ajax发送验证码
			if (email != null && email != '') {
				$.post('/video/visitor/sendmail.action', {
					email : email
				}, function(result) {
						alert(result.message);
				}, 'json');
			}
		});
		$('#mailform').validate(
				{
					submitHandler : function(form) {
						//ajax提交注册信息，并且返回注册结果
						//使用ajax的post方法提交注册信息
						$.post('/video/visitor/forgetpwd.action', $('#mailform').serialize(), function(result) {
							if (result.orsucess) {
								location.href="/video/visitor1/reset_pwd.action";
							} else {
								alert("验证码错误");
							}
						}, 'json');

					},
					rules : {//写校验规则的
						email : {
							required : true,
							email:true,
							minlength : 3
						},
						captcha : {
							required : true
						}
					},
					messages : {//写提示信息的
						email : "邮箱是必须填写的",
						captcha : '验证码是必须填写的'
					}
				});
		
	});
	</script>
</body>

</html>