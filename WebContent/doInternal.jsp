<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="/struts-tags" prefix="s"%>
     <!DOCTYPE >
     <!--  
<html>
<head>
<title>Internal接口</title>
<style type="text/css">
h1,h2 {
	text-align: center;
}
nav{
text-align:center;
}
[id^=hint]{
color:red;
display:inline;
}
[id^=dis]{
color:gray;
display:inline;
font-size:13px;
}
body{
font:normal 16px 微软雅黑, 黑体, sans-serif;
margin-left:111px;
margin-right:111px;
}
footer{
margin-left:111px;
margin-right:111px;
text-align: center;
padding: 111px 0 22px 0;
}
</style>
<script type="text/javascript" src="js/BrowserType.js"></script>
</head>
<body onload="BrowserType()">
<h1> <img alt="" src=" http://a1.itc.cn/sceapptest/testing/img/sohu_32.png">搜狐内部接口</h1>
<nav>
			<a href="index.jsp" target="blank">接口监控</a> 
	
			
		</nav>

<p></p>
<form action="" method="post">
(1)解绑任意手机号：<input type="text" name="phone" required="required" >
<input type="submit" name="unbind" value="解绑">
</form>
<div id="hint1">
<s:property value="#request.wapUnBindMobile"/>
</div>&nbsp;
<div id="dis1">(返回码描述：0:成功，1:参数错误，2:验证码错误，3:手机号码没有绑定帐号， 4:该用户是手机邮箱用户，5:不能进行解除绑定，6:解除绑定手机失败)</div>
<br>
<form action="" method="post"><br>
(2)通过userID查询用户已绑定的手机号：<input type="text" name="username" required="required" >
<input type="submit" name="search_mobile" value="查询">
</form>
<div id="hint2">
<s:property value="#request.wap_get_mobile"/>
</div>&nbsp;
<div id="dis2">(返回码描述：0 userID正常   ,  1 没有帐户绑定关系发生变化 , 6 数据库异常)</div>
<br><form action="" method="post"><br>
(3)绑定userID和手机号&nbsp; userID:<input type="text" name="username" required="required" >
  手机号:<input type="text" name="phone" required="required" >
<input type="submit" name="bind" value="绑定">
</form>
<div id="hint3"><s:property value="#request.wapBindMobile"/>
</div>&nbsp;
<div id="dis3">(返回码描述：0成功，1参数错误，2验证码错误，3用户不存在，4用户已经绑定了手机号码，5该手机已经绑定了用户 6绑定手机失败 7手机绑定次数超限（一个手机一天只能绑定3次）
)</div>
<br><form action="" method="post"><br>
(4)PASSPORT账户注册&nbsp; 用户名(邮箱格式):<input type="text" name="username" required="required" >
  默认密码：12345687
<input type="submit" name="reg" value="注册">
</form>
<div id="hint4"><s:property value="#request.registUser"/>
</div>&nbsp;
<div id="dis4">注册成功后请首先在passport登录(返回码描述：0成功，1参数错误，2验证错误，3非法userid，4userid已经存在，6创建用户失败 5进入黑名单 7.手机已经被绑定（wap专用） 8 非法用户名uniquename 9 用户名uniquename已存在 10 调用超限（5分钟调用超过了1000次）11 不能注册vip.sohu.com的账号
)</div>
<br><br>

</body>
<footer>
搜狐&nbsp;&copy;&nbsp;CopyRight 20140118 1013</footer>
</html>-->