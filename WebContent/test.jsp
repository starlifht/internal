<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";

%>
<style>
#daohang{
position: absolute;      /*绝对定位*/    
top: 50%;                  /* 距顶部50%*/    
left: 50%;                  /* 距左边50%*/    
  
}
</style>
<base href=<%=basePath%>>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<title>启动监控</title>
</head>
<body>
<div id ="daohang"><a href="test.jsp#" onclick="api()"><img alt="" src="images/Go.png"></a></div>
</body>
</html>