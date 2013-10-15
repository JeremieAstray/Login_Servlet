<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登陆成功</title>

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
	 <!--将cookie打印出来,以后需要改-->
	<%
		Cookie cookie[] = request.getCookies();
		for (int i = 1; i < cookie.length; i++) {
			Cookie newCookie = cookie[i];
			if (cookie[i].getName().equals("superUser"))
				continue;
			if (cookie[i].getName().equals("studentNum"))
				continue;
			if (cookie[i].getName().equals("ID"))
				continue;
	%><%=newCookie.getName() + ":"
						+ URLDecoder.decode(newCookie.getValue(), "UTF-8")%><br>
	<%
		}
	%>
	<br> 管理员登陆成功。
	<br>
	<button onclick="window.location.href='/Login_Servlet/administrator/register/adminRegister.jsp'">注册新管理员</button><br>
	<button onclick="window.location.href='/Login_Servlet/logout.jsp'">退出</button>
</body>
</html>
