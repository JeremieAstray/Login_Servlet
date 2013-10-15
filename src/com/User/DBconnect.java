package com.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Public.JDBConnection;


public class DBconnect extends JDBConnection {
	
	public static int DBUserRegister(UserFile RF){		//注册信息的数据库操作
		int row = 0;
		JDBConnection con=new JDBConnection();
		String sql="insert into yx_user(studentNum,userName,TrueName,password,qq,longNum,shortNum," +
					"address,college,major,year,email,superUser,regTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.CreatePreparedStatement(sql);
		try{	//写入信息
			ps.setString(1,RF.getStudentNum());
			ps.setString(2,RF.getUserName());
			ps.setString(3,RF.getTrueName());
			ps.setString(4,RF.getPassword());
			ps.setString(5,RF.getQq());
			ps.setString(6,RF.getLongNum());
			ps.setString(7,RF.getShortNum());
			ps.setString(8,RF.getAddress());
			ps.setString(9,RF.getCollege());
			ps.setString(10,RF.getMajor());
			ps.setInt(11,RF.getYear());
			ps.setString(12, RF.getEmail());
			ps.setInt(13, 0);
			ps.setLong(14, RF.getRegTime());
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
	
	public static void DBUserLogin(LoginInformation LI){	//登陆数据库读取，验证账户信息
		JDBConnection con = new JDBConnection();
		String sql = null;
		if(LI.type.equals("name"))
			sql = "SELECT * FROM yx_user WHERE userName='" + LI.userName + "'";
		else if (LI.type.equals("number"))
			sql = "SELECT * FROM yx_user WHERE studentNum='" + LI.studentNum + "'";
		else if (LI.type.equals("email"))
			sql = "SELECT * FROM yx_user WHERE email='" + LI.email + "'";
		ResultSet rs = con.executeQuery(sql);
		try{
			if(rs.next()){
				LI.id =  rs.getInt("userID");
				LI.userName = rs.getString("userName");
				LI.password = rs.getString("password");
				LI.TrueName = rs.getString("TrueName");
				LI.studentNum = rs.getString("studentNum");
				LI.superUser = rs.getInt("superUser");
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		con.closeConnection();
	}
	
	public static UserFile GetUserFile(int ID){
		JDBConnection con = new JDBConnection();
		String sql = null;
		UserFile UF = null;
		sql = "SELECT * FROM yx_user WHERE userID='" + ((Integer)ID).toString() + "'";
		ResultSet rs = con.executeQuery(sql);
		try{
			if(rs.next()){
				UF = new UserFile();
				UF.setStudentNum(rs.getString("studentNum"));
				UF.setUserName(rs.getString("userName"));
				UF.setTrueName(rs.getString("TrueName"));
				UF.setQq(rs.getString("qq"));
				UF.setLongNum(rs.getString("longNum"));
				UF.setShortNum(rs.getString("shortNum"));
				UF.setAddress(rs.getString("adress"));
				UF.setCollege(rs.getString("college"));
				UF.setMajor(rs.getString("major"));
				UF.setYear(rs.getInt("year"));
				UF.setEmail(rs.getString("email"));
				UF.setSuperUser(rs.getInt("superUser"));
				UF.setRegTime(rs.getLong("regTime"));
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		con.closeConnection();
		return UF;
	}

}