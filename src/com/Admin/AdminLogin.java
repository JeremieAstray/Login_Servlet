package com.Admin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Public.Function_Library;

public class AdminLogin {
	public static boolean Adminlogin(HttpServletRequest request, 
			HttpServletResponse response){							//管理员登陆，写入cookie
		String ps = null;
		LoginInformation LI = new LoginInformation();
		LI.adminName = request.getParameter("userName");
		ps = Function_Library.MD5(request.getParameter("password"));//md5加密
		DBconnect.DBAdminLogin(LI);									//读取数据库验证
		if(ps == null ||!ps.equals(LI.password)){
			return false; 
		}
		else if (ps.equals(LI.password)) {
			try {													//写cookie
				response.addCookie(Function_Library.NewCookie("LoginName",URLEncoder.encode(LI.adminName, "UTF-8")));
				response.addCookie(Function_Library.NewCookie("TrueName",URLEncoder.encode(LI.TrueName, "UTF-8")));
				String t = null;
				switch(LI.adminright){
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
				response.addCookie(Function_Library.NewCookie("adminRight",URLEncoder.encode(t,"UTF-8")));
			}catch (UnsupportedEncodingException e){
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}
}
