package com.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	//注册操作,返回到是否成功的页面
		request.setCharacterEncoding("utf-8");
		AdminFile AF = new AdminFile(request);
		int row = DBconnect.DBAdminRegister(AF);
		if(row == 0){		//插入注册表失败后,row=0,其实只有row=1或者0两种状况
			request.getSession(true).setAttribute("error", "注册失败");
			response.sendRedirect("administrator/register/fail.jsp");
		}
		else{
			request.getSession(true).setAttribute("userName", AF.getAdminName());
			request.getSession(true).setAttribute("password", AF.getPassword());
			String t = null;
			switch(AF.getAdminRight()){		//这里到时候可以改,这里只是方便前台打印出来
			case(1):
				t = "市场专员";
				break;
			case(2):
				t= "客服";
				break;
			case(3):
				t = "超级管理员";
				break;
			default:
				break;
			}
			request.getSession(true).setAttribute("adminRight", t);
			request.getSession(true).setAttribute("success", "注册成功");
			response.sendRedirect("administrator/register/success.jsp");
		} 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
