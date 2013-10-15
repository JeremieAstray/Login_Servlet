<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.Public.*"%>
<%@page import="java.sql.PreparedStatement" %>  
  

 <%			String name,email,type,stdNo;
 			boolean flag = false;
 			name=request.getParameter("name");
 			email=request.getParameter("email");
 			stdNo=request.getParameter("stdNo");
			type=request.getParameter("type");
 			JDBConnection con=new JDBConnection();
 			if(type!=null)
 			if(type.equals("user"))
 			{ 
		 				if(name!=null)
		 			{
		 				PreparedStatement psmt=con.CreatePreparedStatement("select * from YX_user where userName=?");
		 				psmt.setString(1, name);
		 				ResultSet rs=psmt.executeQuery();
		 				if(!rs.next()) //返回空，可以注册
		 				{
		 					flag=true;
		 				}
		 				
		 			}else if(email!=null)
		 			{
		 				PreparedStatement psmt=con.CreatePreparedStatement("select * from YX_user where email=?");
		 				psmt.setString(1, email);
		 				ResultSet rs=psmt.executeQuery();
		 				if(!rs.next()) //返回空，可以注册
		 				{
		 					flag=true;
		 				}
		 				
 					}else if(stdNo!=null)
 					{
 						PreparedStatement psmt=con.CreatePreparedStatement("select * from YX_user where studentNum=?");
		 				psmt.setString(1, stdNo);
		 				ResultSet rs=psmt.executeQuery();
		 				if(!rs.next()) //返回空，可以注册
		 				{
		 					flag=true;
		 				}
 					}
 			
 			}else if(type.equals("admin"))
 			{
 				if(name!=null)
	 			{
	 				PreparedStatement psmt=con.CreatePreparedStatement("select * from YX_admin where adminName=?");
	 				psmt.setString(1, name);
	 				ResultSet rs=psmt.executeQuery();
	 				if(!rs.next()) //返回空，可以注册
	 				{
	 					flag=true;
	 				}
	 				
	 			}/* else if(email!=null)
	 			{
	 				PreparedStatement psmt=con.CreatePreparedStatement("select * from YX_admin where email=?");
	 				psmt.setString(1, email);
	 				ResultSet rs=psmt.executeQuery();
	 				if(!rs.next()) //返回空，可以注册
	 				{
	 					flag=true;
	 				}
 				} */
 			}
 			
 			con.closeConnection();
 		if(flag)
 			out.print("1");
 		else
 			out.print("0");
 %>
