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
position: absolute;      /*���Զ�λ*/    
top: 50%;                  /* �ඥ��50%*/    
left: 50%;                  /* �����50%*/    
  
}
</style>
<base href=<%=basePath%>>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<title>�������</title>
</head>
<body>
<div id ="daohang"><a href="test.jsp#" onclick="api()"><img alt="" src="images/Go.png"></a></div>
</body>
</html>