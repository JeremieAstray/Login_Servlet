<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta name="name" content="content" charset="utf-8">
<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form name="login" action="/Login_Servlet/LoginServlet" method="POST">
		<script language="JavaScript" src="login.js">
		</script>
		用户类型: <input type="radio" name="usertype" class="noborder"
			value="user" checked onclick="selecttype(this.value)">用户&nbsp; <input 

type="radio" onclick="selecttype(this.value)"
			name="usertype" class="noborder" value="admin">管理员 <br>
		<select id="userSelect" style="display:block;float:left;" name="logintype">
			<option value="name">用户名</option>
			<option value="number">学号</option>
			<option value="email">邮箱</option>
		</select> 
		<div id="adminSelect" style="display:none;float:left;width:66px;">
			<select id="userSelect" style="display:block;float:left;" name="logintype">
			<option value="name">用户名</option>
		</select> 
		</div> 
		<input type="text" name="userName" /><br/> 密 码： <input
			type="password" name="password" /><br/> <input type="submit"
			value="登陆" /> <input type="reset" value="重置" />
	</form>
</body>
</html>
