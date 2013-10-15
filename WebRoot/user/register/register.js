// JavaScript Document
function creatdate(){
	date=new Date;
	year=parseInt(date.getFullYear());
	y1=document.createElement('option');
	y2=document.createElement('option');
	y3=document.createElement('option');
	y4=document.createElement('option');
	y5=document.createElement('option');
	y6=document.createElement('option'); 
	  var x=document.getElementById("year");
	  try
	  {
		  y1.text=year-5;
	    y1.value=year-5;
	    x.add(y1,null); // standards compliant
	    y2.text=year-4;
	    y2.value=year-4;
	    x.add(y2,null); // standards compliant
	    y3.text=year-3; 
	    y3.value=year-3;
	    x.add(y3,null); // standards compliant
	    y4.text=year-2;
	    y4.value=year-2;
	    x.add(y4,null); // standards compliant
	    y5.text=year-1;
	    y5.value=year-1;
	    x.add(y5,null); // standards compliant
	    y6.text=year;
	    y6.value=year;
	    x.add(y6,null); // standards compliant
	    }
	  catch(ex)
	  {
		  y1.text=year-5;
		  y1.value=year-5;
		    x.add(y1); 
		    y2.text=year-4;
		    y2.value=year-4;
		    x.add(y2); 
		    y3.text=year-3;
		    y3.value=year-3;
		    x.add(y3); 
		    y4.text=year-2;
		    y4.value=year-2;
		    x.add(y4); 
		    y5.text=year-1;
		    y5.value=year-1;
		    x.add(y5); 
		    y6.text=year;
		    y6.value=year;
		    x.add(y6); 
	    }
	 }
//===========================================华丽的分割线================================================

function ajax(url)  //get异步请求;
{
	var xmlhttp;
	var result="";
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.open("GET",url+"&t=" + Math.random(),false);
	xmlhttp.send();
	result=xmlhttp.responseText;
	return result;
}

//===========================================华丽的分割线================================================


function checkdata()
{
	flag = 1; 
	if(!checkUserName(document.form.userName.value.toLowerCase()))
		flag = 0; 
	if(!checkPassword(document.form.password.value))
		flag = 0; 
	if(!checkPasswordre(document.form.passwordre.value))
		flag = 0; 
	if(!CheckMail(document.form.email.value))
		flag = 0; 
	if(!Checkcollege(document.form.college.value))
		flag = 0; 
	if(!Checkyear(document.form.year.value))
		flag = 0; 
	if(!Checkmajor(document.form.major.value))
		flag = 0; 	
	if(!checkstudentNum(document.form.studentNum.value))
		flag = 0; 
	if(!Checklongnum(document.form.longNum.value))
		flag = 0; 
	if(!Checkshortnum(document.form.shortNum.value))
		flag = 0; 
	if(!Checkqq(document.form.qq.value))
		flag = 0; 
	if(flag == 1)
		return true;
	else 
		return false;
}

//===========================================华丽的分割线================================================
function checkUserName(ssn)
{
	if( ssn.length<3 || ssn.length>18 ) {
		document.getElementById("usernameErr").innerHTML = "<font color='red'>请输入正确的用户名,用户名长度为3-18位！</font>";
		return false;
	}
	else if (isWhiteWpace(ssn)){
		document.getElementById("usernameErr").innerHTML = "<font color='red'>请输入正确的用户名,用户名中不能包含空格！</font>";
		return false;
	}
	else if (!isSsnString(ssn)){
		document.getElementById("usernameErr").innerHTML = "<font color='red'>对不起，用户名只能是英文，数字，标点组成</font>";
		return false;
	}else if(ajax("../../checkUser.jsp?type=user&name="+ssn)==0)
		{
		document.getElementById("usernameErr").innerHTML = "<font color='red'>对不起，该用户名已被注册</font>";
		return false;
		}
	
	document.getElementById("usernameErr").innerHTML = "";
	return true;
}
//===========================================华丽的分割线================================================
function checkPassword(ssn){
	if( strlen(ssn) < 6 || strlen(ssn) > 16 ) {
		document.getElementById("passwordErr").innerHTML = "<font color='red'>正确地登录密码长度为6-16位，仅可用英文、数字、特殊字符！</font>";
		return false;
	}
	else if( strlen2(ssn) ) {
		document.getElementById("passwordErr").innerHTML = "<font color='red'>您的密码中包含了非法字符，仅可用英文、数字、特殊字符！</font>";
		return false;
	}
	else if( document.form.userName.value == ssn ) {
		document.getElementById("passwordErr").innerHTML = "<font color='red'>用户名和密码不能相同！</font>";
		return false;
	}
	document.getElementById("passwordErr").innerHTML = "";
	return true;
}

//===========================================华丽的分割线================================================
function checkPasswordre(ssn){
	if( ssn =="" ) {
		document.getElementById("passwordErrre").innerHTML = "<font color='red'>请输入密码确认！</font>";
		return false;
	}
	else if( ssn != document.form.password.value ) {
		document.getElementById("passwordErrre").innerHTML = "<font color='red'>两次密码输入不一致！</font>";
		return false;
	}
	document.getElementById("passwordErrre").innerHTML = "";
	return true;
}
//===========================================华丽的分割线================================================

function CheckMail(mail) {
	var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(mail == ""){
		document.getElementById("emailErr").innerHTML = "<font color='red'>请输入你的电子邮箱</font>";
 		return false;
	}
	if (filter.test(mail)) {
		document.getElementById("emailErr").innerHTML = "";
		 if(ajax("../../checkUser.jsp?type=user&email="+mail)==0)
		{
		document.getElementById("emailErr").innerHTML = "<font color='red'>对不起，该邮箱已被注册</font>";
		return false;
		}
		return true;
	}
 	else {
 		document.getElementById("emailErr").innerHTML = "<font color='red'>您的电子邮箱格式不正确</font>";
 		return false;
	}
}

//===========================================华丽的分割线================================================

function Checkcollege(ssn){
	if(ssn == "无"){
		document.getElementById("collegeErr").innerHTML = "<font color='red'>请选择学院</font>";
		return false;
	}
	document.getElementById("collegeErr").innerHTML = "";
	return true;	
}

//===========================================华丽的分割线================================================

function Checkyear(year){
	if(year == "无"){
		document.getElementById("yearErr").innerHTML = "<font color='red'>请选择年级</font>";
		return false;
	}
	document.getElementById("yearErr").innerHTML = "";
	return true;	
}

//===========================================华丽的分割线================================================

function Checkmajor(ssn){
	if(ssn == ""){
		document.getElementById("majorErr").innerHTML = "<font color='red'>请输入你的专业</font>";
		return false;
	}
	document.getElementById("majorErr").innerHTML = "";
	return true;	
}


//===========================================华丽的分割线================================================


function checkstudentNum(ssn){
	if(ssn.length == 0){
		document.getElementById("studentNumErr").innerHTML = "";
		return true;
	}
	if(ssn.length != 12) {
		document.getElementById("studentNumErr").innerHTML = "<font color='red'>请输入正确的学号,学号长度为12位！</font>";
		return false;
	}
	else if(isnum(ssn)){
		document.getElementById("studentNumErr").innerHTML = "<font color='red'>学号应该全为数字</font>";
		return false;
	}else if(ajax("../../checkUser.jsp?type=user&stdNo="+ssn)==0){
		document.getElementById("studentNumErr").innerHTML = "<font color='red'>对不起，该学号已被注册</font>";
		return false;
	}
	document.getElementById("studentNumErr").innerHTML = "";
	return true;
}

//===========================================华丽的分割线================================================

function  Checklongnum(num){
	if(num == ""){
		document.getElementById("longNumErr").innerHTML = "";
		return true;
	}
	else if(num.length != 11){
		document.getElementById("longNumErr").innerHTML = "<font color='red'>手机号码长度应为11位</font>";
		return false;
	}
	else if(isnum(num)){
		document.getElementById("longNumErr").innerHTML = "<font color='red'>手机号码应该为数字</font>";
		return false;
	}
	document.getElementById("longNumErr").innerHTML = "";
	return true;
}

//===========================================华丽的分割线================================================

function  Checkshortnum(num){
	if(num == ""){
		document.getElementById("shortNumErr").innerHTML = "";
		return true;
	}
	else if(isnum(num)){
		document.getElementById("shortNumErr").innerHTML = "<font color='red'>手机号码应该为数字</font>";
		return false;
	}
	document.getElementById("shortNumErr").innerHTML = "";
	return true;
}

//===========================================华丽的分割线================================================

function  Checkqq(qq){
	if(qq == ""){
		document.getElementById("qqErr").innerHTML = "";
		return true;
	}
	else if(isnum(qq)){
		document.getElementById("qqErr").innerHTML = "<font color='red'>qq号码应该为数字</font>";
		return false;
	}
	document.getElementById("qqErr").innerHTML = "";
	return true;
}


//===========================================华丽的分割线================================================

function strlen(str){
	var len;
	var i;
	len = 0;
	for (i=0;i<str.length;i++){
		if (str.charCodeAt(i)>255) len+=2; else len++;
	}
	return len;
}

function strlen2(str){
	var len;
	var i;
	len = 0;
	for (i=0;i<str.length;i++){
		if (str.charCodeAt(i)>255) return true;
	}
	return false;
}

//===========================================华丽的分割线================================================
function isWhiteWpace (s)
{
	var whitespace = " \t\n\r";
	var i;
	for (i = 0; i < s.length; i++){   
		var c = s.charAt(i);
		if (whitespace.indexOf(c) >= 0) {
		  	return true;
		}
	}
	return false;
}

function isSsnString (ssn)
{
	var re=/^[0-9a-z][\w-.]*[0-9a-z]$/i;
	return re.test(ssn);
}

//===========================================华丽的分割线================================================
function isnum(num){
	var re=/[^0-9]/;
	return re.test(num);
}
