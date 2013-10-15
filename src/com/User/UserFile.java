package com.User;

import javax.servlet.http.HttpServletRequest;

import com.Public.Function_Library;
	
public class UserFile {								//用户注册信息
	
	private String studentNum;
	private String userName;
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
	private int superUser;
	private long regTime;
	
	UserFile(){
		super();
	}
	
	UserFile(HttpServletRequest request){				//从request读取注册信息作为构造函数
		setStudentNum(request.getParameter("studentNum"));
		setUserName(request.getParameter("userName"));
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
		setRegTime(System.currentTimeMillis());
	}
	
	public int getSuperUser() {
		return superUser;
	}
	public void setSuperUser(int superUser) {
		this.superUser = superUser;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public long getRegTime() {
		return regTime;
	}
	public void setRegTime(long regTime) {
		this.regTime = regTime;
	}
	
}
