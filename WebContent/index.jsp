<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";

%>
<base href=<%=basePath%>>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="Shortcut Icon" href="images/logo_50x34.png"/>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<style>
body{
font:normal 16px 微软雅黑, 黑体, sans-serif;
}
.title {background-color:#21a6ff;color:white;text-align: center;}

.content {
	
	margin: auto 40px;
	
}
#log {
word-wrap:normal; 
	white-space:pre;
}
h3{
color:gray;
}

#pro{
background:url("images/pro.gif");
height:9px;
width:500px;
margin:10px auto;
}
</style>
<title>Internal Monitor</title>
</head>
<body>
<div class="title">
<h1>Internal接口自动化 Moniror is Running......</h1>
<small>Copyright @ 2014 Sohu.com Inc. All Rights Reserved. 搜狐公司 版权所有</small>
</div>
<div class="content">
<div id="pro"></div>

<div id="log">
<script type="text/javascript">
Push();
 function Push() {
 $.ajax({ type: "POST", url: encodeURI("test_RedisAction_getLog"),
success: function(data) {

	document.getElementById("log").innerHTML=data;
	}});}
 var interval=setInterval("Push()",5000);
 </script>

</div>

</div>

</body>
</html>