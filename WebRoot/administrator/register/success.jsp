<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册成功</title>

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
 	<!--将Session打印出来,以后需要改-->
	<%=(String) request.getSession().getAttribute("userName")%><br>
	<%=(String) request.getSession().getAttribute("password")%><br>
	<%=(String) request.getSession().getAttribute("adminRight")%><br>
	<%=(String) request.getSession().getAttribute("success")%><br>
</body> 

</html>
