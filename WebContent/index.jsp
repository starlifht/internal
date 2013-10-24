<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	out.println(request.getRealPath("/"));
%>
<base href=<%=basePath%>>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<style>
.content {
	
	margin: 0 auto;
	width: 999px;
}
#log {
word-wrap: break-word;
	white-space: pre;
}

</style>
<title>Internal监控服务</title>
</head>
<body>
<div class="content">
<div id="log">66
<script type="text/javascript">
		$.post("test_runCheck_doCheck", function(data, textStatus) {
		this;
		document.getElementById("log").innerHTML = data;});	
</script>
</div>

</div>

</body>
</html>