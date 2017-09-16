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
<title>视频管理</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script>	
	$(function(){
		var delcount=0;
		$("#addvideo").click(function(){
			window.location.href = "${pageContext.request.contextPath }/admin/video/alt_altvideo.action";
		});
		$("#batch").click(function(){
			if($("#spa").text()==0){
				alert("无删除项");
				return;
			}
			if(confirm("删除提示!\n删除后不可恢复")){
			var ids=new Array();
			var $check = $("input:checked");
			//var check = document.getElementsByName("check");
			$.each($check,function(i,check){
				//splice(start,deleteCount,val1,val2,...)：从start位置开始删除deleteCount项，并从该位置起插入val1,val2,..
				if(check.id!="")
					ids.splice(ids.length,0,check.id);
			});
			var id=""+ids;
			window.location.href = "${pageContext.request.contextPath }/admin/video/deloradd_batchvideo.action?idarr="+id;
			}
		});
		$(".check").change(function(){
			if(!this.checked){
				$(".checkall")[0].checked=false;
			}
			delcount+=(this.checked?1:-1);
			$("#spa").text(delcount);
			if(delcount==10){
				$(".checkall")[0].checked=true;
			}
		});
		$(".checkall").click(function(){
			var $check=$(".check");
			var bool=this.checked;
			var length=$check.length;
			$.each($check,function(i,check){
				this.checked=bool;
			});
			delcount=(bool?length:0);
			$("#spa").text(delcount);
		});
	});
	
	
	function altvideo() {
		window.location.href = "${pageContext.request.contextPath }/admin/altvideo.action";
	}
</script>
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
				<b>视频列表-视频管理</b>
			</h1>
		</div>
		<div class="row">
			<div style="float: left;">
				<ul class="nav nav-pills">
					<li role="presentation" class="active">
						<button class="btn btn-primary" id="addvideo">添加视频</button>
					</li>
				</ul>
			</div>
			<div style="float: left;">
				<ul class="nav nav-pills">
					<li role="presentation" class="active">
						<button class="btn btn-primary" type="button" id="batch">
							Messages<span class="badge" id="spa">0</span>
						</button>
					</li>
				</ul>
			</div>
			<div style="float: right;">
				<form
					action="${pageContext.request.contextPath }/admin/video/search_search.action"
					class="form-inline">
					<div class="form-group">
						<input type="text" class="form-control" id="searchvideoTitle"
							value="${searchvideoTitle }" placeholder="视频标题"
							name="searchvideoTitle">
					</div>
					<div class="form-group">
						<select name="searchspeakerId" class="form-control"
							id="searchspeakerId">
							<option value="0">请选择主讲人</option>
							<c:forEach items="${speakerlist }" var="speaker">
								<option value="${speaker.id }"
									${searchspeakerId eq speaker.id?"selected":"" }>
									${speaker.speakerName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<select name="searchcourseId" class="form-control"
							id="searchcourseId">
							<option value="0">请选择课程</option>
							<c:forEach items="${courselist }" var="course">
								<option value="${course.id }"
									${searchcourseId eq course.id?"selected":"" }>
									${course.courseName }</option>
							</c:forEach>
						</select>
					</div>
					<input class="btn btn-primary" type="submit" value="查询">
				</form>
			</div>
		</div>

		<table class="table table-hover table-condensed">
			<tr>
				<td><input class="checkall" type="checkbox"
					onchange="javascript:checkall(this)"></td>
				<td>序号</td>
				<td>名称</td>
				<td>介绍</td>
				<td>讲师</td>
				<td>课程</td>
				<td>时长(秒)</td>
				<td>播放次数</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${Pageutil.rows}" var="v" varStatus="status">
				<tr>
					<td><input class="check" type="checkbox" id="${v.id }"></td>
					<td>${status.count }</td>
					<td>${v.videoTitle }</td>
					<td>${v.videoDescr }</td>
					<td>${v.speaker.speakerName }</td>
					<td>${v.course.courseName }</td>
					<td>${v.videoLength }</td>
					<td>${v.videoPlayTimes }</td>
					<td><a class="glyphicon glyphicon-edit"
						href="${pageContext.request.contextPath }/admin/video/alt_altvideo.action?vid=${v.id }"></a></td>
					<td><a class="glyphicon glyphicon-trash" onclick="return(confirm('确认删除?'));"
						href="${pageContext.request.contextPath }/admin/video/deloradd_delvideo.action?vid=${v.id }"></a></td>
				</tr>
			</c:forEach>
		</table>

		<nav aria-label="Page navigation">
			<ul class="pagination">
				<page:page
					url="${pageContext.request.contextPath }/admin/video/search_search.action"></page:page>
			</ul>
		</nav>
	</div>
</body>

</html>