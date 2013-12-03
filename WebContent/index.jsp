<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";

%>
<base href=<%=basePath%>>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<style>
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
small{
font-size:11px;
color:gray;
}
#pro{
background:url("images/pro.gif");
height:9px;
width:500px;
}
</style>
<title>Internal监控服务</title>
</head>
<body>
<div class="content">
<h3>PassPort监控正在Running......</h3>
<div id="pro"></div>
<small>Sohu@CopyRight20131125</small>
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