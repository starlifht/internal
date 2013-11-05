<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
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
	
	margin: 0 auto;
	width: 1300px;
}
#log {
word-wrap: normal|break-word;
	white-space: pre;
}

</style>
<title>Internal监控服务</title>
</head>
<body>
<div class="content">
<font color="gray">PassPort监控正在running</font><img alt="" src="images/pro.gif">
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