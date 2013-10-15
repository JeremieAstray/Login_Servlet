package com.User;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Public.Function_Library;

public class UserLogin {
	
	public static boolean UserLogin(HttpServletRequest request, HttpServletResponse response) {
		//用户登陆，写入cookie
		String ps = null;			
		LoginInformation LI = new LoginInformation();
		LI.type = request.getParameter("logintype");
		if(LI.type.equals("name"))		//判断用什么登陆
			LI.userName = request.getParameter("userName");
		else if (LI.type.equals("number"))
			LI.studentNum = request.getParameter("userName");
		else if (LI.type.equals("email"))
			LI.email = request.getParameter("userName");
		else ;
		ps = Function_Library.MD5(request.getParameter("password"));
		DBconnect.DBUserLogin(LI);
		if(ps == null ||!ps.equals(LI.password)){
			return false;
		}
		else if (ps.equals(LI.password)) {	
			try {					//写入cookie
				response.addCookie(Function_Library.NewCookie("ID",URLEncoder.encode(((Integer)LI.id).toString(), "UTF-8")));
				response.addCookie(Function_Library.NewCookie("LoginName",URLEncoder.encode(LI.userName, "UTF-8")));
				response.addCookie(Function_Library.NewCookie("studentNum",URLEncoder.encode(LI.studentNum, "UTF-8")));
				response.addCookie(Function_Library.NewCookie("TrueName",URLEncoder.encode(LI.TrueName, "UTF-8")));
				response.addCookie(Function_Library.NewCookie("superUser",URLEncoder.encode(((Integer)LI.superUser).toString(),"UTF-8")));
			}catch (UnsupportedEncodingException e){
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	} 
	
}
