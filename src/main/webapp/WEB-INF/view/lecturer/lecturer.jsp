<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>主讲人管理</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath }/admin/video/search_search.action">视频管理系统</a>
				</div>
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath }/admin/video/search_search.action">视频管理</a>
				</div>
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath }/admin/speaker/search.action">主讲人管理</a>
				</div>
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath }/admin/course/show.action">课程管理</a>
				</div>
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath }/admin/census/show.action">统计分析</a>
				</div>
				<div class="navbar-header" style="float: right;">
					<a class="navbar-brand" href="${pageContext.request.contextPath }/houtai/index.jsp">${admin.loginName}<span
						class="glyphicon glyphicon-log-out"></span></a>
				</div>
			</div>
		</div>
	</nav>
	<div class="container">

		<div style="background-color: lightgray; margin-bottom: 5px;"
			class="container">
			<h1>
				<b>主讲人列表-主讲人管理</b>
			</h1>
		</div>
		<div class="row">
			<div style="float: left;">
				<ul class="nav nav-pills">
					<li role="presentation" class="active">
					<a href="${pageContext.request.contextPath }/admin/speaker/altspeaker.action">添加主讲人</a></li>
				</ul>
			</div>
			<div style="float: right;">
				<form
					action="${pageContext.request.contextPath }/admin/speaker/search.action"
					class="form-inline">
					<div class="form-group">
						<label>名称</label> <input type="text" class="form-control"
							placeholder="主讲人名称" name="searchspeakerName"
							value="${searchspeakerName }">
					</div>
					<div class="form-group">
						<label>职位</label> <input type="text" class="form-control"
							placeholder="主讲人职位" name="searchspeakerJob"
							value="${searchspeakerJob }">
					</div>
					<button class="btn btn-primary" type="submit">查询</button>
				</form>
			</div>
		</div>

		<table class="table table-hover table-condensed">
			<tr>
				<td>序号</td>
				<td>名称</td>
				<td>职位</td>
				<td>简介</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${Pageutil.rows }" var="l" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${l.speakerName }</td>
					<td>${l.speakerJob }</td>
					<td>${l.speakerDescr }</td>
					<td><a class="glyphicon glyphicon-edit"
						href="${pageContext.request.contextPath }/admin/speaker/altspeaker.action?id=${l.id }"></a></td>
					<td><a class="glyphicon glyphicon-trash"
						onclick="return(confirm('确认删除?'));"
						href="${pageContext.request.contextPath }/admin/speaker/deloradd_del.action?id=${l.id }"></a></td>
				</tr>
			</c:forEach>
		</table>
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<page:page
					url="${pageContext.request.contextPath }/admin/speaker/search.action"></page:page>
			</ul>
		</nav>
	</div>

</body>

</html>