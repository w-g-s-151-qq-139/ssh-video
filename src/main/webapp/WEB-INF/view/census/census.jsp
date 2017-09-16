<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>视频平均播放次数统计</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#main2')[0].hidden=true;
		$('#login_open').click(function(){
			if($('#main2')[0].hidden){
				$('#main2')[0].hidden=false;
				}
			else{
				$('#main2')[0].hidden=true;
				}
				
		});
	});
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
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div style="background-color: lightgray; margin-bottom: 5px;"
			class="container">
			<h1>
				<b>统计-统计分析</b>
			</h1>
		</div>
	<div id="main" style="height:400px"></div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main')); 
        var name = '${coursename}';
		var times = '${avgtimes}';
		var coursename = name.split(",");
		var avgtimes = times.split(",");
        var option = {
        	    title : {
        	        text: '视频平均播放次数'
        	    },
        	    tooltip : {
        	        trigger: 'axis'
        	    },
        	    legend: {
        	        data:['视频平均播放次数']
        	    },
        	    toolbox: {
        	        show : true,
        	        feature : {
        	            mark : {show: true},
        	            dataView : {show: true, readOnly: false},
        	            magicType : {show: true, type: ['line', 'bar']},
        	            restore : {show: true},
        	            saveAsImage : {show: true}
        	        }
        	    },
        	    calculable : true,
        	    xAxis : [
        	        {
        	            type : 'category',
        	            data : coursename
        	        }
        	    ],
        	    yAxis : [
        	        {
        	            type : 'value'
        	        }
        	    ],
        	    series : [
        	        {
        	            name:'视频播放次数',
        	            type:'bar',
        	            data:avgtimes
        	        }
        	        
        	    ]
        	};

        // 为echarts对象加载数据 
        myChart.setOption(option); 
    </script>
    <input type="button" class="btn btn-primary" value="占比分析" id="login_open">
	<div id="main2"><div id="main1" style="height:400px"></div></div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main1')); 
        var name = '${coursename}';
		var times = '${avgtimes}';
		var coursename = name.split(",");
		var avgtimes = times.split(",");
		var data=new Array();
		for(var i=0;i<coursename.length;i++){
			data.splice(data.length,0,{value:avgtimes[i],name:coursename[i]});
		}
        var option = {
        	    title : {
        	        text: '视频平均播放次数',
        	        x:'center'
        	    },
        	    tooltip : {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
        	    },
        	    legend: {
        	        orient : 'vertical',
        	        x : 'left',
        	        data:coursename
        	    },
        	    toolbox: {
        	        show : true,
        	        feature : {
        	            mark : {show: true},
        	            dataView : {show: true, readOnly: false},
        	            magicType : {
        	                show: true, 
        	                type: ['pie', 'funnel'],
        	                option: {
        	                    funnel: {
        	                        x: '25%',
        	                        width: '50%',
        	                        funnelAlign: 'left',
        	                        max: 1548
        	                    }
        	                }
        	            },
        	            restore : {show: true},
        	            saveAsImage : {show: true}
        	        }
        	    },
        	    calculable : true,
        	    series : [
        	        {
        	            name:'点击次数',
        	            type:'pie',
        	            radius : '55%',
        	            center: ['50%', '60%'],
        	            data:data
        	        }
        	    ]
        	};

        // 为echarts对象加载数据 
        myChart.setOption(option); 
    </script>
	</div>
</body>