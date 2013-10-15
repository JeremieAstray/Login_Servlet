package com.Admin;

import javax.servlet.http.HttpServletRequest;

import com.Public.Function_Library;

public class AdminFile {							//管理员注册信息
	private String adminName;
	private String TrueName;
	private String password;
	private String qq;
	private String longNum;
	private String shortNum;
	private String address;
	private String college;
	private String major;
	private int year;
	private String email;
	private int adminRight;
	
	AdminFile(){
		super();
	}
	
	AdminFile(HttpServletRequest request){				//从request读取注册信息作为构造函数
		setAdminName(request.getParameter("adminName"));
		setTrueName(request.getParameter("TrueName"));
		setPassword(Function_Library.MD5(request.getParameter("password")));
		setQq(request.getParameter("qq"));
		setLongNum(request.getParameter("longNum"));
		setShortNum(request.getParameter("shortNum"));
		setAddress(request.getParameter("address"));
		setCollege(request.getParameter("college"));
		setMajor(request.getParameter("major"));
		setYear(Integer.parseInt(request.getParameter("year")));
		setEmail(request.getParameter("email"));
		setAdminRight(Integer.parseInt(request.getParameter("adminRight")));
	}
	
	public String getAdminName() {
		return adminName;
	} 
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getTrueName() {
		return TrueName;
	}
	public void setTrueName(String trueName) {
		TrueName = trueName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getLongNum() {
		return longNum;
	}
	public void setLongNum(String longNum) {
		this.longNum = longNum;
	}
	public String getShortNum() {
		return shortNum;
	}
	public void setShortNum(String shortNum) {
		this.shortNum = shortNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAdminRight() {
		return adminRight;
	}
	public void setAdminRight(int adminRight) {
		this.adminRight = adminRight;
	}
}
