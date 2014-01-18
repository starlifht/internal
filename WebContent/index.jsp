<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
     <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
body{
font:normal 16px 微软雅黑, 黑体, sans-serif;
}
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
<title>Internal Monitor</title>
</head>
<body>
<div class="content">
<h3>PassPort Moniror is Running......</h3>
<div id="pro"></div>
<a href="doInternal.jsp" target="blank">内部接口</a><small>Sohu@CopyRight20140118</small>
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