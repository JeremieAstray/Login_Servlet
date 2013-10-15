package com.User;

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

public class UserLoginFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//进入操作界面前先验证登录信息
		request.setCharacterEncoding("utf-8");
		String error = null;
		boolean flag = false; 
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    Cookie[] cookie = req.getCookies();
	    //1)判断cookie为空。2)cookie存在,但没有"loginName"。
	    //3)cookie存在,但有"loginName",但loginName为null或0。
	    if(cookie != null){
		    for (int i = 0; i < cookie.length; i++) {
				if (cookie[i].getName().equals("LoginName")) {
					flag = true;
					if (cookie[i] == null || cookie[i].getValue().equals("")) {
						error = "请先登录";
					}
				} else if (cookie[i].getName().equals("adminRight"))
					if (cookie[i] != null && !cookie[i].getValue().equals("")) {
						error = "登录错误,请重新登录";
					}
		    }
	    }
	    else{
	    	error = "请先登录";
	    }
	    if(!flag)
	    	error = "请先登录";
	    if (error == null) {
	        chain.doFilter(request, response);
	    } else {
	    	req.getSession(true).setAttribute("error", error);
	        res.sendRedirect("/Login_Servlet/user/login/fail.jsp");
	    }
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
