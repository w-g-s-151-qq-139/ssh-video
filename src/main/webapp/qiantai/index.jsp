<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>视频管理系统</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/messages_zh.js"></script>
		
		<script>
			$(function(){
				$("#QAQ").validate({
					rules:{
						loginName:{
							required:true,
							minlength:2
						},
						loginPwd:{
							required:true
						}
					},
					messages:{
						loginName:{
							required:"用户名不能为空",
							minlength:"长度太小"
						},
						loginPwd:{
							required:"密码不能为空"
						}
					}
				});
			});
		</script>
	</head>

	<body>
		<div style="width: 20%; margin: auto; margin-top: 250px;">
			<img src="${pageContext.request.contextPath }/img/logo.png" width="100%"  style="margin-bottom: 10px"/>
			<form action="${pageContext.request.contextPath }/user/userlogin.action" method="post" enctype="application/x-www-form-urlencoded" id="QAQ">
				<div class="form-group">
					<input type="email" class="form-control" placeholder="用户名" name="email" value="${loginName }">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="密码" name="password">
				</div>
				<div style="text-align: center"><span style="color: red">${error}</span></div>
				<input type="submit" class="btn btn-success form-control" value="登录">
			</form>
		</div>
	</body>

</html>