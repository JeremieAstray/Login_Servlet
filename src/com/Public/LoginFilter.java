package com.Public;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {	//登录界面login.jsp进入前判断是否已经登陆，是则直接跳转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie cookies[] = req.getCookies();
		Cookie login = null;
		Cookie user = null;
		Cookie admin = null;
		//1)判断cookie为空。2)cookie存在,但没有"loginName"。
	    //3)cookie存在,但有"loginName",但loginName为null或0。
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("LoginName")) {
					login = cookies[i];
				} else if (cookies[i].getName().equals("superUser")) {
					user = cookies[i];
				} else if (cookies[i].getName().equals("adminRight")) {
					admin = cookies[i];
				}
			}
		}
		if (login != null && !login.getValue().equals("")) {
			if (admin != null && !admin.getValue().equals("")) {
				res.sendRedirect("/Login_Servlet/administrator/login/success.jsp");
			} else if (user != null && !user.getValue().equals("")) {
				res.sendRedirect("/Login_Servlet/user/login/success.jsp");
			}
		}
		else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
