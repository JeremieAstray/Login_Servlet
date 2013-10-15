package com.Public;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.UserLogin;
import com.Admin.AdminLogin;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String usertype;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断登陆类型然后交给admin或者user操作
		response.setContentType("text/html; charset=utf-8"); 
		usertype = request.getParameter("usertype");
		if( "user".equals(usertype)){				//user
			if(UserLogin.UserLogin(request,response)){
				request.getSession(true).setAttribute("success", "登陆成功");
				response.sendRedirect("user/login/success.jsp");
			}
			else{
				request.getSession(true).setAttribute("error", "账号或密码错误<br>登录失败");
				response.sendRedirect("user/login/fail.jsp");
			}
		}
		else if("admin".equals(usertype))			//admin
		{		
			if (AdminLogin.Adminlogin(request, response)) {
				request.getSession(true).setAttribute("userName", request.getParameter("userName"));
				response.sendRedirect("administrator/login/success.jsp");
				//request.getRequestDispatcher("success.jsp").forward(request, response);
			} else {
				request.getSession(true).setAttribute("error", "账号或密码错误\n登录失败");
				response.sendRedirect("administrator/login/fail.jsp");
				//request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
		}
	}
 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
