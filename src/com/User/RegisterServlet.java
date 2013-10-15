package com.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		//注册操作,返回到是否成功的页面
		request.setCharacterEncoding("utf-8");
		UserFile RF = new UserFile(request);
		int row = DBconnect.DBUserRegister(RF);
		if(row == 0){	//插入注册表失败后,row=0,其实只有row=1或者0两种状况
			request.getSession(true).setAttribute("error", "注册失败");
			response.sendRedirect("user/register/fail.jsp");
		} 
		else{
			request.getSession(true).setAttribute("userName", RF.getUserName());
			request.getSession(true).setAttribute("password", RF.getPassword());
			request.getSession(true).setAttribute("success", "注册成功");
			response.sendRedirect("user/register/success.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
