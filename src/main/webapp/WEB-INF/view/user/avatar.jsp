<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	href="${pageContext.request.contextPath }/css/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/profile.css">
<link rel="icon" href="favicon.png"
	type="${pageContext.request.contextPath }/image/png">
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>

<body class="w100">
	<jsp:include page="uheader.jsp"></jsp:include>
	<main>
	<div class="container">
		<h2>我的资料</h2>
		<div id="profile_tab">
			<ul class="profile_tab_header f_left clearfix">
				<li><a
					href="${pageContext.request.contextPath }/user/profile.action">更改资料</a></li>
				<li class="profile_tab_line">|</li>
				<li><a
					href="${pageContext.request.contextPath }/user/avatar.action">更改头像</a></li>
				<li class="profile_tab_line">|</li>
				<li><a
					href="${pageContext.request.contextPath }/user/password.action">密码安全</a></li>
			</ul>
			<div class="proflle_tab_body">
				<div class="proflle_tab_workplace clearfix">
					<div class="profile_avatar_area">
						<c:if test="${empty _front_user.headUrl}">
							<img id="avatar"
								src="${pageContext.request.contextPath }/img/avatar_lg.png"
								alt="这是什么">
						</c:if>
							${user.headUrl}
						<c:if test="${not empty _front_user.headUrl}">
							<img id="avatar" width="200px" height="200px"
								src="/pic/${_front_user.headUrl}" alt="">
						</c:if>
						<p style="text-align: center;">当前头像</p>
					</div>
					<div class="profile_ifo_area">

						<form id="upload_form" enctype="multipart/form-data" method="post"
							action="${pageContext.request.contextPath }/user/altavatar.action">
							<p>请选择图像文件</p>
							<div>
								<input type="file" class="form-control" name="image_file"
									id="image_file" accept="image/png,image/jpeg,image/jpg" /> <input
									class="btn btn-primary" type="submit" value="上传" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<jsp:include page="ufooter.jsp"></jsp:include>
</body>
<!-- 此处必须引入低版本的jquery，引入1.12.4版本，有问题 -->
<%@include file="../include/script.html"%>

</html>