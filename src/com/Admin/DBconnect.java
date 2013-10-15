package com.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Public.JDBConnection;

public class DBconnect extends JDBConnection {
	
	public static int DBAdminRegister(AdminFile AF){//注册信息的数据库操作
		int row = 0;
		JDBConnection con = new JDBConnection();
		String sql="insert into yx_admin(adminName,TrueName,password,qq,longNum,shortNum,address," +
					"college,major,year,email,adminRight) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.CreatePreparedStatement(sql);
		try{	//写入信息 
			ps.setString(1,AF.getAdminName());
			ps.setString(2,AF.getTrueName());
			ps.setString(3,AF.getPassword());
			ps.setString(4,AF.getQq());
			ps.setString(5,AF.getLongNum());
			ps.setString(6,AF.getShortNum());
			ps.setString(7,AF.getAddress());
			ps.setString(8,AF.getCollege());
			ps.setString(9,AF.getMajor());
			ps.setInt(10,AF.getYear());
			ps.setString(11,AF.getEmail());
			ps.setInt(12, AF.getAdminRight());
			row = ps.executeUpdate();
			if(row > 0)
				System.out.println("成功添加了" + row + "条数据");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		con.closeConnection();
		return row;
	}
	
	public static void DBAdminLogin(LoginInformation LI){	//登陆数据库读取，验证账户信息
		JDBConnection con = new JDBConnection();
		String sql = "SELECT * FROM yx_admin WHERE adminName='" + LI.adminName + "'";
		ResultSet rs = con.executeQuery(sql);
		try{
			if(rs.next()){
				LI.id = LI.adminright = rs.getInt("adminID");
				LI.password = rs.getString("password");
				LI.TrueName = rs.getString("TrueName");
				LI.adminright = rs.getInt("adminright");
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		con.closeConnection();
	}

}
