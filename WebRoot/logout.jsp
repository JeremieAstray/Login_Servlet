<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	try {
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				cookie.setValue(null);
				response.addCookie(cookie);
			}
		}
	} catch (Exception ex) {
		out.println("清空Cookies发生异常！");
	}
%>
 
<script type="text/javascript">
	window.location.href = "login.jsp";
</script>


